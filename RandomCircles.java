public class RandomCircles {
    public static void main(String[] args) {
    CircleModel model = new CircleModel();
    CircleView vista = new CircleView(model);
    new CircleController(model, vista);
    vista.setVisible(true);
    }}