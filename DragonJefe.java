public class DragonJefe extends Dragon {
    public DragonJefe(String nombre) {
        super(nombre);
        this.hp = 220;
        this.ataque = 30;
    }

    @Override
    public void habilidadEspecial(Batalla batalla) {
        super.habilidadEspecial(batalla);
        // Aplica escudo (reducción de daño) por 1 turno
        System.out.println(this.nombre + " genera un escudo que reduce daño por 1 turno (simulado).");
    }
}
