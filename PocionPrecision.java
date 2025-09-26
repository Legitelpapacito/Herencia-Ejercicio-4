public class PocionPrecision extends Item {
    private double bonus;

    public PocionPrecision(int cantidad, double bonus) {
        super("Poción de Precisión", cantidad);
        this.bonus = bonus;
    }

    @Override
    public void aplicar(Combatiente objetivo, Batalla batalla) {
        if (!consumir()) {
            System.out.println("No quedan pociones de precisión.");
            return;
        }
        objetivo.setPrecisionBonus(bonus);
        System.out.println(objetivo.getNombre() + " gana +" + bonus + " precisión por 1 turno.");
    }
}
