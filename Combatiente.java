public abstract class Combatiente {
    protected String nombre;
    protected int hp;
    protected int ataque;
    protected boolean vivo = true;
    protected double probabilidadEsquivar = 0.0;
    protected double precisionBonus = 0.0;

    public Combatiente(String nombre, int hp, int ataque) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
    }

    public String getNombre() { return nombre; }
    public int getHp() { return hp; }
    public int getAtaque() { return ataque; }
    public boolean isVivo() { return vivo; }

    public void recibirDanho(int danho) {
        if (Math.random() < probabilidadEsquivar) {
            System.out.println(nombre + " esquiva el ataque!");
            probabilidadEsquivar = 0.0; // Reinicia tras esquivar
            return;
        }
        hp -= danho;
        if (hp <= 0) {
            vivo = false;
            mensajeMuerte();
        }
    }

    public void atacar(Combatiente objetivo) {
        if (!vivo) return;
        objetivo.recibirDanho(this.ataque);
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " por " + this.ataque + " puntos.");
    }

    public void mensajeInicio() {
        System.out.println(nombre + " entra a la batalla: ¡" + nombre + "!");
    }

    public void mensajeMuerte() {
        System.out.println(nombre + " ha sido derrotado.");
    }

    public void setProbabilidadEsquivar(double prob) {
        this.probabilidadEsquivar = prob;
    }

    public double getProbabilidadEsquivar() {
        return probabilidadEsquivar;
    }

    public void setPrecisionBonus(double bonus) {
        this.precisionBonus = bonus;
    }

    public double getPrecisionBonus() {
        return precisionBonus;
    }

    // Cada subclase debe implementar su turno
    public abstract void tomarTurno(Batalla batalla);
}
