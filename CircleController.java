import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class CircleController {
    private CircleModel model;
    private CircleView vista;
    public CircleController(CircleModel model, CircleView vista) {
        this.model = model;
        this.vista = vista;
        vista.setMyMouseListener(new CircleMouseListener());
    }
    class CircleMouseListener implements MouseListener {
        @Override
        public void mouseReleased(MouseEvent me) {
            model.setX(me.getX());
            model.setY(me.getY());
            vista.getCirclePanel().repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }
} 