import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Jugador extends Combatiente {
    protected List<Item> inventario = new ArrayList<>();

    public Jugador(String nombre, int hp, int ataque) {
        super(nombre, hp, ataque);
    }

    public void agregarItem(Item item) {
        inventario.add(item);
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (int i = 0; i < inventario.size(); i++) {
            Item it = inventario.get(i);
            System.out.println((i+1) + ") " + it.getNombre() + " x" + it.getCantidad());
        }
    }

    public void usarItem(int indice, Combatiente objetivo, Batalla batalla) {
        if (indice < 0 || indice >= inventario.size()) {
            System.out.println("Índice inválido de ítem.");
            return;
        }
        Item it = inventario.get(indice);
        it.aplicar(objetivo, batalla);
        if (it.getCantidad() == 0) inventario.remove(indice);
    }

    @Override
    public void tomarTurno(Batalla batalla) {
        if (!vivo) return;
        Scanner sc = new Scanner(System.in);
        System.out.println("Turno de " + nombre);
        System.out.println("1) Atacar  2) Pasar  3) Usar ítem  4) Salir de batalla");
        int opt = 1;
        try { opt = Integer.parseInt(sc.nextLine()); } catch(Exception e) {}
        switch(opt) {
            case 1:
                Combatiente enemigo = batalla.seleccionarObjetivoEnemigo();
                if (enemigo != null) {
                    atacar(enemigo);
                }
                break;
            case 2:
                System.out.println(nombre + " decide pasar el turno.");
                break;
            case 3:
                if (inventario.isEmpty()) {
                    System.out.println("No hay ítems.");
                    break;
                }
                mostrarInventario();
                System.out.println("Seleccione ítem (número):");
                int idx = 0;
                try { idx = Integer.parseInt(sc.nextLine()) - 1; } catch(Exception e) {}
                System.out.println("Seleccione objetivo (0 = auto):");
                // Para simplicidad, se usa auto o primer enemigo/aliado
                Combatiente objetivo = batalla.obtenerPrimerCombatienteVivo();
                usarItem(idx, objetivo, batalla);
                break;
            case 4:
                batalla.setSalir(true);
                break;
            default:
                System.out.println("Opción no válida, pasa turno.");
        }
    }
}
