import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Nombre del jugador:");
        String[] roles = {"Guerrero", "Explorador"};
        int rol = JOptionPane.showOptionDialog(null, "Elige rol", "Jugador",
                0, JOptionPane.PLAIN_MESSAGE, null, roles, roles[0]);

        Controller.iniciarJuego(nombre, rol == 0);
    }
}
