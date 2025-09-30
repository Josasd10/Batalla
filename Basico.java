public class Basico extends Enemigo {
    public Basico(String nombre) { super(nombre, 70, 12); }

    @Override public void turno(Combatiente[] enemigos, Combatiente[] aliados) {
        for (Combatiente c : aliados) if (c.estaVivo()) { atacar(c); break; }
    }
    @Override public void habilidadEspecial(Combatiente objetivo) {
        System.out.println(nombre + " lanza veneno a " + objetivo.getNombre());
        objetivo.recibirDanio(5);
    }
    @Override public String mensajeInicio() { return nombre + " (Básico) aparece."; }
    @Override public String mensajeMuerte() { return nombre + " ha muerto."; }
}
