public abstract class Item {
    protected String nombre;
    protected int cantidad;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }

    // Consumir una unidad del ítem
    public boolean consumir() {
        if (cantidad > 0) {
            cantidad--;
            return true;
        }
        return false;
    }

    // Método abstracto para aplicar el efecto del ítem
    public abstract void aplicar(Combatiente objetivo, Batalla batalla);
}
