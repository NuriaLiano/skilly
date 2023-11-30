package cris.sincro;

public class Checker extends Thread {

    VistaTexto vt;
    String[] palabrasGuardadas = {"hola"};

    public Checker(VistaTexto vt) {
        this.vt = vt;
    }

    public void run() {
        String texto;
        while (true) {
            System.out.println("checker");
            texto = vt.jTextArea1.getText();
            String resultado = "";
            String[] textos = texto.split(" ");
            for (String texto1 : textos) {
                for (String palabraGuardada : palabrasGuardadas) {
                    if (palabraGuardada.equals(texto1)) {
                        resultado += palabraGuardada + "\n";
                    }
                }
            }
            vt.jTextArea2.setText(resultado);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
