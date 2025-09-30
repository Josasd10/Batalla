
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Ingresar cantidad de jugadores
        int numJugadores = 1;
        try {
            numJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores participarán?"));
        } catch (Exception e) { }
        if (numJugadores < 1) numJugadores = 1;

        String[] roles = {"Guerrero", "Explorador"};
        Jugador[] jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            String nombre = JOptionPane.showInputDialog("Nombre del jugador " + (i+1) + ":");
            int rol = JOptionPane.showOptionDialog(null, "Elige rol para " + nombre, "Jugador",
                    0, JOptionPane.PLAIN_MESSAGE, null, roles, roles[0]);
            if (rol == 0)
                jugadores[i] = new Guerrero(nombre);
            else
                jugadores[i] = new Explorador(nombre);
        }

        // Ingresar cantidad de enemigos
        int numEnemigos = 1;
        try {
            numEnemigos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos enemigos habrá?"));
        } catch (Exception e) { }
        if (numEnemigos < 1) numEnemigos = 1;

        Combatiente[] enemigos = new Combatiente[numEnemigos];
        String[] tipos = {"Básico", "Jefe"};
        for (int i = 0; i < numEnemigos; i++) {
            int tipo = JOptionPane.showOptionDialog(null, "Tipo de enemigo " + (i+1), "Enemigo",
                    0, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);
            String nombre = JOptionPane.showInputDialog("Nombre del enemigo " + (i+1) + ":");
            if (tipo == 1)
                enemigos[i] = new Jefe(nombre);
            else
                enemigos[i] = new Basico(nombre);
        }

        Controller.iniciarJuego(jugadores, enemigos);
    }
}
