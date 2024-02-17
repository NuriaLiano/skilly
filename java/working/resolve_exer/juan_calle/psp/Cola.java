package java.working.resolve_exer.juan_calle.psp;

public class Cola {

    private char c;
    private boolean disponible = false; //inicialmente cola vacia

    public synchronized char get() {
        // Mientras la cola no esté llena, se espera a ser notificada.
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Sigue cuando está llena para devolver el número.
        disponible = false;
        // Se notifica a sí misma para despertar las peticiones dormidas.
        notify();
        return c;
    }

    public synchronized void put(char valor) {
        // Mientras la cola esté llena, se espera a ser notificada.
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Entra cuando está vacía y mete el número.
        c = valor;
        disponible = true;
        // Se notifica a sí misma para despertar las peticiones dormidas.
        notify();
    }
}
