/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cris.sincro;

/**
 *
 * @author Diurno
 */
public class Sincro {

    public static void main(String[] args) {
        Cola cola = new Cola();

        Productor p = new Productor(cola);
        Consumidor c = new Consumidor(cola);
        VistaKeyListener vk = new VistaKeyListener(p);
        vk.setVisible(true);
        

        p.start();
        c.start();
    }
}
