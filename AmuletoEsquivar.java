public class AmuletoEsquivar extends Item {
    private double chance;

    public AmuletoEsquivar(int cantidad, double chance) {
        super("Amuleto de Esquivar", cantidad);
        this.chance = chance;
    }

    @Override
    public void aplicar(Combatiente objetivo, Batalla batalla) {
        if (!consumir()) {
            System.out.println("No quedan amuletos de esquivar.");
            return;
        }
        objetivo.setProbabilidadEsquivar(chance);
        System.out.println(objetivo.getNombre() + " gana +" + chance + " probabilidad de esquivar por 1 turno.");
    }
}
