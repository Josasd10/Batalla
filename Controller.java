import java.util.Random;

public class Controller {
    public static void iniciarJuego(String nombreJugador, boolean esGuerrero) {
        Jugador jugador = esGuerrero ? new Guerrero(nombreJugador) : new Explorador(nombreJugador);

        Random r = new Random();
        int n = 1 + r.nextInt(3);
        Combatiente[] enemigos = new Combatiente[n];
        for (int i = 0; i < n; i++) {
            if (r.nextBoolean()) enemigos[i] = new Basico("Enemigo" + i);
            else enemigos[i] = new Jefe("Jefe" + i);
        }

        Batalla batalla = new Batalla(jugador, enemigos);
        batalla.iniciar();
    }
}
