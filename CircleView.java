
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class CircleView extends JFrame {
    private CircleModel model;
    private CirclePanel circlePanel;

    public CircleView(CircleModel model) {
        this.model = model;
        circlePanel = new CirclePanel();
        //agregar panel al frame
        this.add(circlePanel);
        //tamaño de pantalla
        this.setSize(400,400);
        
    }
    public CirclePanel getCirclePanel() {
        return circlePanel;
    }
    public void setMyMouseListener(MouseListener m) {
        circlePanel.addMouseListener(m);
    }
    public class CirclePanel extends JPanel {
        private CirclePanel() {
            super();
        }
        @Override
        public void paintComponent( Graphics g ) {
            Graphics2D g2 = (Graphics2D) g;
            Color modeloColor = model.getColor();
            g2.setColor(modeloColor);
            g2.fillOval(model.getX(), model.getY(), model.getRadio()*2, model.getRadio()*2);
        }
    }
}