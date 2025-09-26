import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos = new ArrayList<>();
    private List<String> registro = new ArrayList<>();
    private boolean salir = false;

    public Batalla(Jugador jugador) {
        this.jugador = jugador;
    }

    public void agregarEnemigo(Enemigo e) {
        enemigos.add(e);
    }

    public Jugador obtenerJugador() { return jugador; }

    public Combatiente seleccionarObjetivoEnemigo() {
        // Selecciona el primer enemigo vivo 
        for (Enemigo e : enemigos) {
            if (e.isVivo()) return e;
        }
        return null;
    }

    public Combatiente obtenerPrimerCombatienteVivo() {
        if (jugador != null && jugador.isVivo()) return jugador;
        for (Enemigo e : enemigos) if (e.isVivo()) return e;
        return null;
    }

    public void agregarRegistro(String accion) {
        registro.add(accion);
        if (registro.size() > 3) registro.remove(0);
    }

    public void mostrarEstado() {
        System.out.println("----- Estado de batalla -----");
        System.out.println(jugador.getNombre() + " HP: " + jugador.getHp() + (jugador.isVivo() ? "" : " (MUERTO)"));
        for (Enemigo e : enemigos) {
            System.out.println(e.getNombre() + " HP: " + e.getHp() + (e.isVivo() ? "" : " (MUERTO)"));
        }
        System.out.println("Últimas acciones:");
        for (String s : registro) System.out.println("- " + s);
        System.out.println("-----------------------------");
    }

    public void simular() {
        Scanner sc = new Scanner(System.in);
        jugador.mensajeInicio();
        for (Enemigo e : enemigos) e.mensajeInicio();

        while (!salir && jugador.isVivo() && enemigos.stream().anyMatch(Enemigo::isVivo)) {
            mostrarEstado();
            // Turno jugador
            jugador.tomarTurno(this);
            if (!jugador.isVivo() || salir) break;
            // Turnos enemigos
            for (Enemigo e : enemigos) {
                if (e.isVivo()) e.tomarTurno(this);
            }
            // Verificar condición de final
            if (!jugador.isVivo()) {
                System.out.println("El jugador ha sido derrotado.");
                break;
            }
            if (enemigos.stream().noneMatch(Enemigo::isVivo)) {
                System.out.println("Todos los enemigos han sido derrotados. ¡Victoria!");
                break;
            }
        }
    }

    public void setSalir(boolean salir) { this.salir = salir; }
}
