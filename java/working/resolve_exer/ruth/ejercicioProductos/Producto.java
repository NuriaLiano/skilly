package java.working.resolve_exer.ruth.ejercicioProductos;
public class Producto{

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public Producto (Producto producto){
        this(producto.getNombre(), producto.getPrecio(), 0);
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio (double precio){
        this.precio = precio;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public double getPrecioTotal(){
        return precio * cantidad;
    }

    @Override
    public String toString(){
        return String.format("%s %8.2f %d", nombre, precio,cantidad, getPrecioTotal());
    }
    
}