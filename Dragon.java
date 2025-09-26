public class Dragon extends Enemigo {
    public Dragon(String nombre) {
        super(nombre, 120, 18);
    }

    @Override
    public void habilidadEspecial(Batalla batalla) {
        // Se cura una cantidad
        int cura = 20;
        this.hp += cura;
        System.out.println(this.nombre + " usa Curarse y recupera " + cura + " HP.");
    }

    @Override
    public void tomarTurno(Batalla batalla) {
        if (!vivo) return;
        if (Math.random() < 0.5) {
            habilidadEspecial(batalla);
        } else {
            Combatiente objetivo = batalla.obtenerJugador();
            if (objetivo != null) atacar(objetivo);
        }
    }
}
