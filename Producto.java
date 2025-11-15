package trabajo.practicon6;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + ", Nombre: " + nombre);
        System.out.println("Precio: $" + precio + ", Stock: " + cantidad);
        System.out.println("Categoria: " + categoria.getDescripcion());
    }
}