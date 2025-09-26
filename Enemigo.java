public abstract class Enemigo extends Combatiente {
    public Enemigo(String nombre, int hp, int ataque) {
        super(nombre, hp, ataque);
    }

    public abstract void habilidadEspecial(Batalla batalla);
}
