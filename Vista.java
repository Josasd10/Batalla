import javax.swing.*;

public class Vista {
    public static void mostrarEstado(Jugador[] jugadores, Combatiente[] enemigos) {
        StringBuilder sb = new StringBuilder();
        for (Jugador jugador : jugadores) {
            sb.append("Jugador: ").append(jugador.getNombre()).append(" (Vida: ").append(jugador.getVida()).append(")\n");
        }
        for (Combatiente e : enemigos) {
            sb.append(e.getNombre()).append(" (Vida: ").append(e.getVida()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Estado", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void menuTurnoJugador(Jugador jugador, Combatiente[] enemigos) {
        String[] opciones = {"Atacar", "Usar Ítem", "Pasar"};
        int eleccion = JOptionPane.showOptionDialog(null, "Turno de " + jugador.getNombre(),
                "Acción", 0, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (eleccion) {
            case 0: // Atacar
                Combatiente objetivo = seleccionarObjetivo(enemigos);
                if (objetivo != null) jugador.atacar(objetivo);
                break;
            case 1: // Usar ítem
                if (!jugador.getInventario().isEmpty()) {
                    Item item = (Item) JOptionPane.showInputDialog(null, "Selecciona ítem",
                            "Ítems", JOptionPane.PLAIN_MESSAGE, null,
                            jugador.getInventario().toArray(), jugador.getInventario().get(0));
                    Combatiente obj;
                    if (item instanceof PocionVida) {
                        obj = seleccionarAliado(jugador);
                    } else {
                        obj = seleccionarObjetivo(enemigos);
                    }
                    if (obj != null) jugador.usarItem(item, obj);
                } else {
                    JOptionPane.showMessageDialog(null, "No tienes ítems!");
                }
                break;
            default: // Pasar
                JOptionPane.showMessageDialog(null, jugador.getNombre() + " pasa el turno.");
        }
    }

    // Permite seleccionar un aliado o a sí mismo para la poción de vida
    public static Combatiente seleccionarAliado(Jugador jugador) {
        Jugador[] aliados = Batalla.equipoActual;
        String[] nombres = java.util.Arrays.stream(aliados)
                .filter(Combatiente::estaVivo)
                .map(Combatiente::getNombre)
                .toArray(String[]::new);
        if (nombres.length == 0) return null;
        String elegido = (String) JOptionPane.showInputDialog(null, "Elige aliado para curar",
                "Aliado", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);
        for (Jugador a : aliados) if (a.getNombre().equals(elegido)) return a;
        return null;
    }

    public static Combatiente seleccionarObjetivo(Combatiente[] enemigos) {
        String[] nombres = java.util.Arrays.stream(enemigos).filter(Combatiente::estaVivo)
                .map(Combatiente::getNombre).toArray(String[]::new);
        if (nombres.length == 0) return null;
        String elegido = (String) JOptionPane.showInputDialog(null, "Elige objetivo",
                "Objetivo", JOptionPane.PLAIN_MESSAGE, null, nombres, nombres[0]);
        for (Combatiente e : enemigos) if (e.getNombre().equals(elegido)) return e;
        return null;
    }
}