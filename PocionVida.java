public class PocionVida extends Item {
    private int cura;

    public PocionVida(int cantidad, int cura) {
        super("Poción de Vida", cantidad);
        this.cura = cura;
    }

    @Override
    public void aplicar(Combatiente objetivo, Batalla batalla) {
        if (!consumir()) {
            System.out.println("No quedan pociones de vida.");
            return;
        }
        if (!objetivo.isVivo()) {
            System.out.println("No se puede usar sobre un objetivo muerto.");
            return;
        }
        objetivo.hp += cura;
        System.out.println(objetivo.getNombre() + " recupera " + cura + " HP.");
    }
}
