    public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public boolean estaVivo() { return vida > 0; }
    public void recibirDanio(int d) { vida = Math.max(0, vida - d); }

    public void atacar(Combatiente objetivo) {
        objetivo.recibirDanio(ataque);
        System.out.println(nombre + " atacó a " + objetivo.getNombre() + " causando " + ataque + " de daño.");
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }

    public abstract void turno(Combatiente[] enemigos, Combatiente[] aliados);
    public abstract String mensajeInicio();
    public abstract String mensajeMuerte();
}
