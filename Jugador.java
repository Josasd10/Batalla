import java.util.ArrayList;
import java.util.List;

public abstract class Jugador extends Combatiente {
    protected List<Item> inventario = new ArrayList<>();

    public Jugador(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    public void usarItem(Item item, Combatiente objetivo) {
        item.usar(this, objetivo);
        inventario.remove(item);
    }

    public List<Item> getInventario() { return inventario; }
}
