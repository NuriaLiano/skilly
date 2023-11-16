# Ejercicio Tierra Media

## Resumen del Enunciado

### 1. Guerreros

- **Tipos**:
  - Seguidores de Sauron
  - Seguidores de Ilúvatar
- **Objetivo**: Ambos buscan conquistar el poder del anillo.
- **Herramientas**: Necesitan un escudo, una espada y una daga para luchar.
  - Disponibilidad: 3 de cada una por bando.

### 2. Espera y Energía

- **En Espera**: Si no pueden combatir, descansan y ganan energía.
- **Decisión de la Batalla**: Quienes tienen más energía ganarán.
- **Juez**: Tom Bombadil decide el ganador basado en energía.

### 3. Fuentes de Energía

- **Seguidores de Sauron**:
  - Energía de una pócima hecha por orcos.
  - Producción de pócima: Orcos generan 1 litro por segundo en una vasija de 5 litros máx.
  - Consumo: Guerreros toman medio litro en 2 segundos, ganando 3 puntos de energía.
- **Seguidores de Ilúvatar**:
  - Energía de conjuros hechos por Istari.
  - Creación de conjuro: Istari toman 10 segundos para crear y escribir uno en un libro.
  - Consumo: Guerreros intentan acceder a un conjuro cada 5 segundos.
  - Energía: Un conjuro da entre 1 y 5 puntos.
  - Acceso al libro: 3 guerreros pueden leer simultáneamente, pero solo 1 Istari puede escribir a la vez.

### 4. Programación

- **Simulación**: Batallas en Java.
- **Entidades como hilos**: Cada guerrero, orco, Istari, y Tom Bombadil.
- **Cantidad de Hilos**: 10 guerreros de cada tipo, 3 Istari y 2 orcos.
- **Duración**: Los hilos corren infinitamente.
- **Sincronización**: Usar semáforos y otras herramientas de coordinación de hilos.

## Vasija

~~~java
import java.util.concurrent.Semaphore;

public class Vasija {
    private double contenido = 0;
    private static final int MAX_CAPACIDAD = 5;
    private final Semaphore semVasija = new Semaphore(1);

    public void añadirPocima() throws InterruptedException {
        semVasija.acquire();
        if (contenido < MAX_CAPACIDAD) {
            contenido++;
        }
        semVasija.release();
    }

    public boolean tomarPocima() throws InterruptedException {
        semVasija.acquire();
        if (contenido >= 0.5) {
            contenido -= 0.5;
            semVasija.release();
            return true;
        } else {
            semVasija.release();
            return false;
        }
    }
}
~~~

## Libro conjuros

~~~java
import java.util.concurrent.Semaphore;
import java.util.Random;

public class LibroDeConjuros {
    private final Semaphore semIstari = new Semaphore(1);
    private final Semaphore semCaballeros = new Semaphore(3);
    private int energiaConjuro = 0;

    public void escribirConjuro() throws InterruptedException {
        semIstari.acquire();
        Random rand = new Random();
        energiaConjuro = 1 + rand.nextInt(5);  // Entre 1 y 5
        semIstari.release();
    }

    public int leerConjuro() throws InterruptedException {
        semCaballeros.acquire();
        int energia = this.energiaConjuro;
        semCaballeros.release();
        return energia;
    }
}
~~~

## Guerrero

~~~java
import java.util.concurrent.Semaphore;

public abstract class Guerrero implements Runnable {
    protected int energia = 0;
    protected static final Semaphore semEspada = new Semaphore(3);
    protected static final Semaphore semEscudo = new Semaphore(3);
    protected static final Semaphore semDaga = new Semaphore(3);
    protected TomBombadil tomBombadil;  // Añadir el atributo TomBombadil aquí

    public abstract void obtenerEnergia();

    protected void tomarHerramientas() throws InterruptedException {
        semEspada.acquire();
        semEscudo.acquire();
        semDaga.acquire();
    }

    protected void devolverHerramientas() {
        semEspada.release();
        semEscudo.release();
        semDaga.release();
    }
    public void perder() {
        this.energia = 0;  // O cualquier otra acción que desees realizar cuando un guerrero pierde
    }

    public void competirConTom(TomBombadil tom) {
        try {
            tom.competir(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
~~~

## Guerreros SAURON

~~~java
public class GuerreroSauron extends Guerrero {
    private Vasija vasija;
    private TomBombadil tomBombadil;

    public GuerreroSauron(Vasija vasija, TomBombadil tomBombadil) {
        this.vasija = vasija;
        this.tomBombadil = tomBombadil;  // Inicializar TomBombadil
    }

    @Override
    public void obtenerEnergia() {
        try {
            if (vasija.tomarPocima()) {
                energia += 3;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                tomarHerramientas();
                Thread.sleep(2000);  // 2 segundos
                obtenerEnergia();
                competirConTom(tomBombadil);  // Suponiendo que has pasado una instancia de TomBombadil al guerrero
                devolverHerramientas();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
~~~

## Guerrrero ILUVATAR

~~~java
public class GuerreroIluvatar extends Guerrero {
    private LibroDeConjuros libro;
    private TomBombadil tomBombadil;

    public GuerreroIluvatar(LibroDeConjuros libro, TomBombadil tomBombadil) {
        this.libro = libro;
        this.tomBombadil = tomBombadil;  // Inicializar TomBombadil
    }

    @Override
    public void obtenerEnergia() {
        try {
            energia += libro.leerConjuro();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                tomarHerramientas();
                Thread.sleep(5000);  // 5 segundos
                obtenerEnergia();
                competirConTom(tomBombadil);  // Suponiendo que has pasado una instancia de TomBombadil al guerrero
                devolverHerramientas();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
~~~

## Orcos

~~~java
public class Orco implements Runnable {
    private Vasija vasija;

    public Orco(Vasija vasija) {
        this.vasija = vasija;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);  // 1 segundo
                vasija.añadirPocima();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
~~~

## Istaris

~~~java
public class Istari implements Runnable {
    private LibroDeConjuros libro;

    public Istari(LibroDeConjuros libro) {
        this.libro = libro;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);  // 10 segundos
                libro.escribirConjuro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
~~~

## Tom Bombadil

~~~java
import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;

public class TomBombadil {
    private static final Semaphore semComparacion = new Semaphore(1);  // Para asegurarse de que solo dos guerreros compiten a la vez
    private Queue<Guerrero> guerrerosSauron = new LinkedList<>();
    private Queue<Guerrero> guerrerosIluvatar = new LinkedList<>();

    public void competir(Guerrero guerrero) throws InterruptedException {
        semComparacion.acquire();

        if (guerrero instanceof GuerreroSauron) {
            guerrerosSauron.add(guerrero);
        } else {
            guerrerosIluvatar.add(guerrero);
        }

        if (guerrerosSauron.size() > 0 && guerrerosIluvatar.size() > 0) {
            Guerrero guerreroSauron = guerrerosSauron.poll();
            Guerrero guerreroIluvatar = guerrerosIluvatar.poll();

            if (guerreroSauron.energia > guerreroIluvatar.energia) {
                // Guerrero de Sauron gana
                guerreroIluvatar.perder();
            } else if (guerreroSauron.energia < guerreroIluvatar.energia) {
                // Guerrero de Ilúvatar gana
                guerreroSauron.perder();
            } else {
                // Empate, puedes definir qué hacer en este caso.
            }
        }

        semComparacion.release();
    }
}
~~~

## Main

La idea principal es que cada guerrero se recarga, luego intenta competir y, independientemente de si gana o pierde, espera un poco y vuelve a intentarlo.

~~~java
public class BatallaTierraMedia {

    public static void main(String[] args) {
        Vasija vasija = new Vasija();
        LibroConjuros libroConjuros = new LibroConjuros();
        TomBombadil tomBombadil = new TomBombadil();

        // Crear y lanzar orcos
        for (int i = 0; i < 2; i++) {
            new Thread(new Orco(vasija)).start();
        }

        // Crear y lanzar Istari
        for (int i = 0; i < 3; i++) {
            new Thread(new Istari(libroConjuros)).start();
        }

        // Crear y lanzar guerreros de Sauron
        for (int i = 0; i < 10; i++) {
            Guerrero guerrero = new GuerreroSauron(vasija, tomBombadil);
            new Thread(() -> {
                while (true) {
                    guerrero.recargarEnergia();
                    try {
                        tomBombadil.competir(guerrero);
                        Thread.sleep(1000); // Esperar un poco antes de intentar competir nuevamente
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // De manera similar, crear y lanzar guerreros de Ilúvatar
        for (int i = 0; i < 10; i++) {
            Guerrero guerrero = new GuerreroIluvatar(libroConjuros, tomBombadil);
            new Thread(() -> {
                while (true) {
                    guerrero.recargarEnergia();
                    try {
                        tomBombadil.competir(guerrero);
                        Thread.sleep(1000); // Esperar un poco antes de intentar competir nuevamente
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
~~~
