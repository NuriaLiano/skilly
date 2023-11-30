/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cris.sincro;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Diurno
 */


public class VistaKeyListener extends JFrame {
    private JLabel etiqueta;
    private Productor p;
    
    public VistaKeyListener(Productor p){
        this();
        this.p=p;
    }
    public VistaKeyListener() {
        super("Detector de Teclas");
        etiqueta = new JLabel("Presiona una tecla");
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        add(etiqueta);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Este método se llama cuando se presiona y se libera una tecla.
                char tecla = e.getKeyChar();
                etiqueta.setText("Tecla presionada: " + tecla);
                p.putChar(tecla);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // Este método se llama cuando se presiona una tecla.
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // Este método se llama cuando se libera una tecla.
            }
        });
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaKeyListener());
    }
}
