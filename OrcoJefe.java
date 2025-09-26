public class OrcoJefe extends Orco {
    public OrcoJefe(String nombre) {
        super(nombre);
        this.hp = 160;
        this.ataque = 22;
    }

    @Override
    public void habilidadEspecial(Batalla batalla) {
        super.habilidadEspecial(batalla);
        // Golpe crítico adicional
        Combatiente objetivo = batalla.obtenerJugador();
        if (objetivo != null && objetivo.isVivo()) {
            System.out.println(this.nombre + " realiza un Golpe Crítico!");
            objetivo.recibirDanho(15);
        }
    }
}
