# Carrera de hilos

## Clase MainFrame - JFrame Principal

~~~java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JProgressBar progressBar1, progressBar2, progressBar3;
    private JLabel label1, label2, label3, timeLabel;
    private JButton startButton, pauseButton;
    private ProgressThread progressThread1, progressThread2, progressThread3;
    private TimerThread timerThread;
    private MonitorThread monitorThread;

    public MainFrame() {
        // Inicializar componentes de la GUI
        progressBar1 = new JProgressBar(0, 100);
        progressBar2 = new JProgressBar(0, 100);
        progressBar3 = new JProgressBar(0, 100);
        label1 = new JLabel("0%");
        label2 = new JLabel("0%");
        label3 = new JLabel("0%");
        timeLabel = new JLabel("Tiempo: 0s");
        startButton = new JButton("Iniciar");
        pauseButton = new JButton("Pausa");

        // Layout y agregación de componentes
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(progressBar1);
        add(label1);
        add(progressBar2);
        add(label2);
        add(progressBar3);
        add(label3);
        add(timeLabel);
        add(startButton);
        add(pauseButton);

        // Inicializar y configurar hilos
        progressThread1 = new ProgressThread(progressBar1, label1);
        progressThread2 = new ProgressThread(progressBar2, label2);
        progressThread3 = new ProgressThread(progressBar3, label3);
        timerThread = new TimerThread(timeLabel);
        monitorThread = new MonitorThread(new JProgressBar[]{progressBar1, progressBar2, progressBar3}, new JLabel[]{label1, label2, label3});

        // Agregar oyentes a botones
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressThread1.start();
                progressThread2.start();
                progressThread3.start();
                timerThread.start();
                monitorThread.start();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressThread1.pauseThread();
                progressThread2.pauseThread();
                progressThread3.pauseThread();
                timerThread.pauseThread();
                monitorThread.pauseThread();
            }
        });

        // Configuración del JFrame
        setTitle("Competición de Barras de Progreso");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
~~~

## Clase ProgressThread - Thread para el Progreso de las Barras

~~~java
public class ProgressThread extends Thread {
    private JProgressBar progressBar;
    private JLabel label;
    private boolean isPaused;

    public ProgressThread(JProgressBar progressBar, JLabel label) {
        this.progressBar = progressBar;
        this.label = label;
        this.isPaused = false;
    }

    @Override
    public void run() {
        while (progressBar.getValue() < progressBar.getMaximum()) {
            try {
                if (!isPaused) {
                    progressBar.setValue(progressBar.getValue() + 1);
                    label.setText(progressBar.getValue() + "%");
                    Thread.sleep((long) (Math.random() * 1000)); // Espera aleatoria
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pauseThread() {
        isPaused = true;
    }

    public synchronized void resumeThread() {
        isPaused = false;
        notify();
    }
}
~~~

## Clase TimerThread - Thread para el Tiempo Transcurrido

~~~java
public class TimerThread extends Thread {
    private JLabel timeLabel;
    private int timeElapsed;
    private boolean isPaused;

    public TimerThread(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        this.timeElapsed = 0;
        this.isPaused = false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!isPaused) {
                    timeLabel.setText("Tiempo: " + timeElapsed + "s");
                    timeElapsed++;
                    Thread.sleep(1000);
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pauseThread() {
        isPaused = true;
    }

    public synchronized void resumeThread() {
        isPaused = false;
        notify();
    }
}
~~~

## Clase MonitorThread - Thread para Monitorizar el Progreso

~~~java
public class MonitorThread extends Thread {
    private JProgressBar[] progressBars;
    private JLabel[] labels;

    public MonitorThread(JProgressBar[] progressBars, JLabel[] labels) {
        this.progressBars = progressBars;
        this.labels = labels;
    }

    @Override
    public void run() {
        while (true) {
            // Aquí va la lógica para monitorizar y actualizar las etiquetas
        }
    }
}
~~~