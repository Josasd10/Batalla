public class Controller {
    public static void iniciarJuego(Jugador[] jugadores, Combatiente[] enemigos) {
        Batalla batalla = new Batalla(jugadores, enemigos);
        batalla.iniciar();
    }
}
