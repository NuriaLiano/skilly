package java.working.resolve_exer.ruth.ejercicioProductos;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class ProductoTest {
    private static int contadorLimpiar = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //contador para limpiar la entrada por teclado
        

        Producto pro1 = new Producto("Naranjas", 1.6, 5);
        System.out.println(pro1);
        Producto pro2 = new Producto("Chocolate", 2.35);
        System.out.println(pro2);

        //actualizar cantidad y mostrar por pantalla
        pro2.setCantidad(2);
        System.out.println(pro2);

        //pedir los datos para un tercer producto
        System.out.println("Pidiendo datos para el tercer producto");
        Producto pro3 = pedirProducto(sc);
        System.out.println(pro3);

        //crear arraylist de productos utilizando el metodo pedirproducto
        System.out.println("Pidiendo datos para el arrayslist de productos");
        ArrayList<Producto> productos = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            productos.add(pedirProducto(sc));
        }

        System.out.println(Arrays.toString(productos.toArray())); //TODO:ver si funciona por que le pasamos un arraylist


        //mostrar datos concretos
        System.out.println("El nombre del primer producto es: " + productos.get(0).getNombre());
        System.out.println("El precio del segundo producto es: " + productos.get(1).getPrecio());
        System.out.println("La cantidad del tercer producto es: " + productos.get(2).getCantidad());
        System.out.println("El precio total del primer producto es: " + productos.get(0).getPrecioTotal());

        //mostrar el precio total de cada uno y la suma de todos
        double suma = 0;
        for(int i = 0; i < productos.size(); i++){
            
            System.out.println("El precio total del producto " + (i+1) + " es: " + productos.get(i).getPrecioTotal());
            suma += productos.get(i).getPrecioTotal();
        }
        System.out.println("La suma de todos los precios es: " + suma);
    }

    public static Producto pedirProducto(Scanner sc){
        if(contadorLimpiar >= 1){
            //nextLine para limpiar la entrada por teclado. Bug de java
            sc.nextLine();
        }
        
        System.out.println("Introduce el nombre del producto");
        String nombre = sc.nextLine();
        System.out.println("Introduce el precio");
        double precio = sc.nextDouble();
        System.out.println("Introduce la cantidad");
        int cantidad = sc.nextInt();
        contadorLimpiar++;
        return new Producto(nombre, precio,cantidad);
    }
}
