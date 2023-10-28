<!-- 3 - Batalla por la Tierra Media
La Tierra Media tiene dos tipos de guerreros: los seguidores de Sauron y los seguidores de Ilúvatar. Ambos
luchan para conquistar el poder del anillo. Para luchar necesitan hacer uso de un escudo, una espada y una
daga al mismo tiempo, habiendo inicialmente 3 de cada uno disponibles por cada bando.
Los guerreros que esperan entrar en combate estarán mientras descansando y tomando fuerzas
(incrementando su energía) en intervalos de tiempo, tras los cuales volverán a comprobar si ya pueden
tomar parte en la batalla. La manera de determinar cuándo un guerrero de un bando ha ganado al del otro
es en base a la comparación de energía que tienen ambos. Esta comprobación la hará Tom Bombadil.
La manera en la que cada uno de los guerreros obtiene la energía es distinta según el bando en que se
encuentre. En este sentido, por una parte los seguidores de Sauron incrementan sus fuerzas en base a una
pócima que generan los orcos de Mordor despellejando a sus víctimas.
Dichos orcos generarán un litro de pócima cada segundo depositándola en una única vasija mientras que los
guerreros necesitan dos segundos para llegar hasta la vasija y tomar medio litro, lo que les proporciona una
cantidad de energía fija con valor 3. La vasija que se utiliza para almacenar la pócima es de 5 litros.
Por su parte, los seguidores de Ilúvatar consiguen su energía de unos conjuros que generan los Istari (o
magos que hacen cosas) y que ellos sólo tienen que memorizar para que les dé fuerza. Para hacerlo cada 5
segundos intentarán acceder a un conjuro que está escrito en un libro para memorizarlo, pudiendo acceder
varias veces al mismo conjuro (la única restricción es que al menos haya un conjuro ya escrito en el libro),
mientras que los Istari necesitan 10 segundos para generar un nuevo conjuro y escribirlo en el libro. Cada
conjuro tiene asociada una cantidad de energía entre 1 y 5 que se generará de manera aleatoria cuando se
crea por parte de los Istari. Una vez generado un conjuro, éste permanece escrito en el libro de conjuros
para siempre. En el libro de conjuros podrán leer tres caballeros de Ilúvatar simultáneamente, pero sólo un
Istari podrá escribir en un mismo instante de tiempo sin que nadie pueda usar el libro durante la escritura.
Escribe un programa en Java que simule las batallas de La Tierra Media, de modo que cada caballero esté
representado por un hilo al igual que Tom Bombadil. Usa un hilo también para simular a cada Istari y a cada
orco. Lanza al menos 10 caballeros de cada tipo, tres Istari y 2 orcos. Todos los hilos se ejecutan de forma
infinita. Puedes definir y usar cualquier otra entidad activa que consideres necesaria para garantizar las
condiciones descritas en el apartado anterior. La sincronización se debe llevar a cabo mediante el uso de
semáforos y otras herramientas de coordinación de hilos vistas en clase. Se valorará el uso de varios
mecanismos para resolver las distintas partes del problema. -->

-sauron
-iluvatar

necesitan 3 por banda:
-escudo
-espada
-daga

guerros wait incrementan energia en intervalos de tiempo
comprobar si pueden luchar

ganan el que mas energia tenga comparando la energia.
clase tomombadil para comprobar

obtienen energia:
- sauron pocimas
orcos generan un 1l de pocima/segundo y llenan el array
guerreros tardan 2 seg en vaciar 0,5l el array. cantidad de energia fija = 3
el array es de 5 posicion

- iluvatar consigue energia de conjuros de Istari. cad 5seg acceden al conjuro, pueden acceder varias veces al mismo conjuro(mientras haya 1 escrito)
conjuro = energia entre 1 y 5 que aleatorio
generar conjuro permanece en el libro para siempre
el libro solo lo pueden leer 3 de iluvatar al tiempo pero 1 de istari puuede escribri al tiempo. NADIE USAR EL LIBRO DURANTE ESCRITURA

- Guerreros: Son hilos que pertenecen a uno de los dos bandos: seguidores de Sauron o seguidores de Ilúvatar. Tienen una energía que varía dependiendo del recurso que consumen.
- ¿EN DUDA? Armas: Cada guerrero necesita un escudo, una espada y una daga para luchar. Se dispone de 3 de cada una de estas por bando.
- Tom Bombadil: Es un hilo que determina qué guerrero ha ganado en función de la energía de los dos contrincantes.
- Orcos: Son hilos que producen pócima para los seguidores de Sauron. Añaden pócima a una vasija.
- (igual que almacen) Vasija: Recurso compartido entre los orcos y los seguidores de Sauron. Tiene una capacidad máxima.
- Istari: Son hilos que generan conjuros para los seguidores de Ilúvatar. Escriben los conjuros en un libro.
- Libro de Conjuros: Recurso compartido entre los Istari y los seguidores de Ilúvatar. Permite a los guerreros memorizar conjuros y a los Istari escribir nuevos conjuros.
- Conjuros: objetos????

~~~java
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.Random;

public class TierraMedia {

    // Clase que representa la vasija
    public static class Vasija {
        private double pocima = 5;
        private final Semaphore sem = new Semaphore(1);

        public void tomarPocima() throws InterruptedException {
            sem.acquire();
            if (pocima >= 0.5) {
                pocima -= 0.5;
            }
            sem.release();
        }

        public void agregarPocima() throws InterruptedException {
            sem.acquire();
            if (pocima <= 4.5) {
                pocima += 1;
            }
            sem.release();
        }
    }

    // Clase que representa el libro de conjuros
    public static class LibroDeConjuros {
        private final ArrayList<Integer> conjuros = new ArrayList<>();
        private final Semaphore semEscritura = new Semaphore(1);
        private final Semaphore semLectura = new Semaphore(3);

        public void leerConjuro() throws InterruptedException {
            semLectura.acquire();
            // Simulamos la lectura
            if (!conjuros.isEmpty()) {
                // Simplemente obtenemos el último conjuro, no lo eliminamos
                conjuros.get(conjuros.size() - 1);
            }
            semLectura.release();
        }

        public void escribirConjuro(int energia) throws InterruptedException {
            semEscritura.acquire();
            conjuros.add(energia);
            semEscritura.release();
        }
    }

    public static abstract class Guerrero extends Thread {
        protected int energia = 0;

        public abstract void obtenerEnergia() throws InterruptedException;

        public int getEnergia() {
            return energia;
        }
    }

    public static class SeguidorSauron extends Guerrero {
        private Vasija vasija;

        public SeguidorSauron(Vasija vasija) {
            this.vasija = vasija;
        }

        @Override
        public void obtenerEnergia() throws InterruptedException {
            vasija.tomarPocima();
            energia += 3;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    obtenerEnergia();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SeguidorIluvatar extends Guerrero {
        private LibroDeConjuros libro;

        public SeguidorIluvatar(LibroDeConjuros libro) {
            this.libro = libro;
        }

        @Override
        public void obtenerEnergia() throws InterruptedException {
            libro.leerConjuro();
            energia += new Random().nextInt(5) + 1;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    obtenerEnergia();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Istari extends Thread {
        private LibroDeConjuros libro;

        public Istari(LibroDeConjuros libro) {
            this.libro = libro;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int energia = new Random().nextInt(5) + 1;
                    libro.escribirConjuro(energia);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Orco extends Thread {
        private Vasija vasija;

        public Orco(Vasija vasija) {
            this.vasija = vasija;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    vasija.agregarPocima();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vasija vasija = new Vasija();
        LibroDeConjuros libro = new LibroDeConjuros();

        ArrayList<SeguidorSauron> seguidoresSauron = new ArrayList<>();
        ArrayList<SeguidorIluvatar> seguidoresIluvatar = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SeguidorSauron sauron = new SeguidorSauron(vasija);
            sauron.start();
            seguidoresSauron.add(sauron);

            SeguidorIluvatar iluvatar = new SeguidorIluvatar(libro);
            iluvatar.start();
            seguidoresIluvatar.add(iluvatar);
        }

        for (int i = 0; i < 3; i++) {
            new Istari(libro).start();
        }

        for (int i = 0; i < 2; i++) {
            new Orco(vasija).start();
        }

        // Tom Bombadil (se podría mejorar su implementación para que realmente controle el enfrentamiento)
        new Thread(() -> {
            while (true) {
                try {
                    // Simulamos que Tom Bombadil verifica las energías cada 10 segundos
                    Thread.sleep(10000);
                    for (int i = 0; i < 10; i++) {
                        int energiaSauron = seguidoresSauron.get(i).getEnergia();
                        int energiaIluvatar = seguidoresIluvatar.get(i).getEnergia();

                        if (energiaSauron > energiaIluvatar) {
                            System.out.println("Seguidor de Sauron " + i + " ha ganado.");
                        } else if (energiaSauron < energiaIluvatar) {
                            System.out.println("Seguidor de Ilúvatar " + i + " ha ganado.");
                        } else {
                            System.out.println("Empate entre el seguidor de Sauron " + i + " y el de Ilúvatar " + i + ".");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

~~~