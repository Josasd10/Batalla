public class Jefe extends Enemigo {
    public Jefe(String nombre) { super(nombre, 120, 20); }

    @Override public void turno(Combatiente[] enemigos, Combatiente[] aliados) {
        for (Combatiente c : aliados) if (c.estaVivo()) { atacar(c); break; }
    }
    @Override public void habilidadEspecial(Combatiente objetivo) {
        System.out.println(nombre + " usa un golpe crítico sobre " + objetivo.getNombre());
        objetivo.recibirDanio(15);
    }
    @Override public String mensajeInicio() { return nombre + " (Jefe) aparece imponente."; }
    @Override public String mensajeMuerte() { return nombre + " ha sido derrotado."; }
}
