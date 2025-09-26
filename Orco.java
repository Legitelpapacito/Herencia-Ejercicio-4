public class Orco extends Enemigo {
    private int duracionVeneno = 2;

    public Orco(String nombre) {
        super(nombre, 80, 12);
    }

    @Override
    public void habilidadEspecial(Batalla batalla) {
        // Envenena al objetivo principal del jugador 
        Combatiente objetivo = batalla.obtenerJugador();
        if (objetivo != null && objetivo.isVivo()) {
            System.out.println(this.nombre + " usa Envenenar sobre " + objetivo.getNombre());
            // Aplicar daño por turno simple:
            objetivo.recibirDanho(5);
            System.out.println(objetivo.getNombre() + " recibe 5 daño por el veneno.");
        }
    }

    @Override
    public void tomarTurno(Batalla batalla) {
        if (!vivo) return;
        // Ataque simple o habilidad al azar
        if (Math.random() < 0.4) {
            habilidadEspecial(batalla);
        } else {
            Combatiente objetivo = batalla.obtenerJugador();
            if (objetivo != null) atacar(objetivo);
        }
    }
}
