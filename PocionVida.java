public class PocionVida extends Item {
    private int curacion;
    public PocionVida(int curacion) { super("Poción de Vida"); this.curacion = curacion; }

    // Cura automáticamente a todos los jugadores vivos del equipo
    @Override
    public void usar(Jugador usuario, Combatiente objetivo) {
        if (objetivo instanceof Jugador) {
            Jugador[] equipo = obtenerEquipo(usuario);
            for (Jugador j : equipo) {
                if (j.estaVivo()) {
                    j.vida += curacion;
                    System.out.println(usuario.getNombre() + " curó a " + j.getNombre() + " con " + nombre + " por " + curacion);
                }
            }
        } else if (usuario == objetivo && usuario.estaVivo()) {
            usuario.vida += curacion;
            System.out.println(usuario.getNombre() + " se curó a sí mismo con " + nombre + " por " + curacion);
        } else {
            System.out.println("¡No puedes curar enemigos!");
        }
    }

    // Método auxiliar para obtener el equipo del usuario
    private Jugador[] obtenerEquipo(Jugador usuario) {
        // Si el usuario tiene referencia a su equipo, úsala. Si no, solo él mismo.
        // Aquí se asume que el equipo son todos los jugadores vivos en la batalla.
        // Se puede mejorar si se tiene una referencia global al equipo.
        if (Batalla.equipoActual != null) {
            return Batalla.equipoActual;
        } else {
            return new Jugador[]{usuario};
        }
    }
}
