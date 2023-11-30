package cris.sincro;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private Cola cola;
    private char car = '2';
    private boolean teclaPulsada = false;

    public Productor(Cola c) {
        cola = c;
    }

    public  void run() {
        while (true){
            if (teclaPulsada){
                cola.put(car);
               teclaPulsada = false;
            } //pone el caracter
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void putChar(char c){
        car = c;
        teclaPulsada = true;
    }
}
