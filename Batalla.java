public class Batalla {
    public static Jugador[] equipoActual = null;
    private Jugador[] jugadores;
    private Combatiente[] enemigos;

    public Batalla(Jugador[] jugadores, Combatiente[] enemigos) {
        this.jugadores = jugadores;
        this.enemigos = enemigos;
        Batalla.equipoActual = jugadores;
    }

    public void iniciar() {
        for (Jugador j : jugadores) {
            System.out.println(j.mensajeInicio());
        }
        for (Combatiente e : enemigos) {
            System.out.println(e.mensajeInicio());
        }

        while (hayJugadoresVivos() && hayEnemigosVivos()) {
            Vista.mostrarEstado(jugadores, enemigos);
            for (Jugador j : jugadores) {
                if (j.estaVivo()) {
                    Vista.menuTurnoJugador(j, enemigos);
                }
            }
            for (Combatiente e : enemigos) {
                if (e.estaVivo()) {
                    e.turno(enemigos, jugadores);
                }
            }
        }

        if (hayJugadoresVivos()) {
            System.out.println("¡Ganaron los jugadores la batalla!");
        } else {
            for (Jugador j : jugadores) {
                if (!j.estaVivo()) System.out.println(j.mensajeMuerte());
            }
        }
        Batalla.equipoActual = null;
    }

    private boolean hayEnemigosVivos() {
        for (Combatiente e : enemigos) if (e.estaVivo()) return true;
        return false;
    }

    private boolean hayJugadoresVivos() {
        for (Jugador j : jugadores) if (j.estaVivo()) return true;
        return false;
    }
}
