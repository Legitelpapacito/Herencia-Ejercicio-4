import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al simulador de batalla.");
        System.out.println("Ingrese nombre del jugador:");
        String nombre = sc.nextLine();
        System.out.println("Seleccione rol: 1) Guerrero  2) Explorador");
        int opt = 1;
        try { opt = Integer.parseInt(sc.nextLine()); } catch(Exception e) {}
        Jugador jugador;
        if (opt == 1) jugador = new Guerrero(nombre);
        else jugador = new Explorador(nombre);

        // Agregar ítems de ejemplo
        jugador.agregarItem(new PocionVida( (opt==1?2:4), 50 ));
        jugador.agregarItem(new PocionAtaque( (opt==1?1:2), 10 ));
        jugador.agregarItem(new PocionPrecision(opt==1?1:2, 0.2));
        jugador.agregarItem(new AmuletoEsquivar(opt==1?1:2, 0.5));
        jugador.agregarItem(new Escudo(1));

        Batalla batalla = new Batalla(jugador);

        // Crear entre 1 y 3 enemigos al azar 
        for (int i = 0; i < 2; i++) {
            double r = Math.random();
            Enemigo enemigo;
            if (r < 0.25) {
                enemigo = new Orco("Orco");
            } else if (r < 0.5) {
                enemigo = new OrcoJefe("Orco Jefe");
            } else if (r < 0.75) {
                enemigo = new Dragon("Dragón");
            } else {
                enemigo = new DragonJefe("Dragón Jefe");
            }
            batalla.agregarEnemigo(enemigo);
        }

        batalla.simular();
        System.out.println("Simulación finalizada.");
    }
}
