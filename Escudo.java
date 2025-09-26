public class Escudo extends Item {
    public Escudo(int cantidad) {
        super("Escudo", cantidad);
    }

    @Override
    public void aplicar(Combatiente objetivo, Batalla batalla) {
        if (!consumir()) {
            System.out.println("No quedan escudos.");
            return;
        }
        
        System.out.println(objetivo.getNombre() + " recibe protección de escudo por 1 turno.");
        
    }
}
