import java.awt.Color;
import java.util.Random;
public class CircleModel {
 private final static int RADIOMAX = 75;
 private Random generador;
 private int x;
 private int y;
 public CircleModel() {
 generador = new Random();
 }
 public int getRadio() {
 return generador.nextInt(RADIOMAX);
 }
 public Color getColor() {
 int r = generador.nextInt(256);
 int g = generador.nextInt(256);
 int b = generador.nextInt(256);
 return new Color(r,g,b);
 }
 public int getX() {
 return x;}
 public void setX(int x) {
 this.x = x;}
 public int getY() {
 return y;}
 public void setY(int y) {
 this.y = y;}
}