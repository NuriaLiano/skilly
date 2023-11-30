package cris.sincro;



public class Consumidor extends Thread {

    private Cola cola;
    private char car;

    public Consumidor(Cola c) {
        cola = c;
    }

    public void run() {
        VistaTexto vistaTexto = new  VistaTexto();
        vistaTexto.setVisible(true);
        Checker ck = new Checker(vistaTexto);
        ck.start();
        
        char valor;
        while(true){
            valor = cola.get(); 
            vistaTexto.jTextArea1.setText(vistaTexto.jTextArea1.getText()+valor);
        }
        
    }
}
