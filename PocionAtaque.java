public class PocionAtaque extends Item {
    private int incremento;

    public PocionAtaque(int cantidad, int incremento) {
        super("Poción de Ataque", cantidad);
        this.incremento = incremento;
    }

    @Override
    public void aplicar(Combatiente objetivo, Batalla batalla) {
        if (!consumir()) {
            System.out.println("No quedan pociones de ataque.");
            return;
        }
        if (!objetivo.isVivo()) {
            System.out.println("No se puede usar sobre un objetivo muerto.");
            return;
        }
        objetivo.ataque += incremento;
        System.out.println(objetivo.getNombre() + " gana +" + incremento + " ataque por 1 turno .");
        
    }
}
