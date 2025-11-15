package trabajo.practicon6;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto p) {
        if (p != null) {
            for (Producto producto : productos) {
                if (producto.getId().equals(p.getId())) {
                    System.out.println("Error: Ya existe un producto con el ID " + p.getId());
                    return;
                }
            }
            productos.add(p);
            System.out.println("Producto " + p.getNombre() + " agregado.");
        }
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacio.");
            return;
        }
        System.out.println("--- LISTADO COMPLETO ---");
        for (Producto p : productos) {
            p.mostrarInfo();
            System.out.println("------");
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(String id) {
        Producto productoAEliminar = buscarProductoPorId(id);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto " + productoAEliminar.getNombre() + " eliminado.");
        } else {
            System.out.println("Error: ID no encontrado.");
        }
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null && nuevaCantidad >= 0) {
            p.setCantidad(nuevaCantidad);
            System.out.println("Stock de " + p.getNombre() + " actualizado a " + nuevaCantidad);
        } else {
            System.out.println("Error: No se pudo actualizar el stock o la cantidad es invalida.");
        }
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total = total + p.getCantidad();
        }
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }
        Producto mayorStock = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > mayorStock.getCantidad()) {
                mayorStock = p;
            }
        }
        return mayorStock;
    }
    
    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.println("--- PRODUCTOS ENTRE $" + min + " y $" + max + " ---");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos en ese rango.");
        }
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.println("--- PRODUCTOS DE CATEGORIA: " + categoria.name() + " ---");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) { 
                p.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos de esa categoria.");
        }
    }

    public void mostrarCategoriasDisponibles() {
        System.out.println("--- CATEGORIAS DISPONIBLES ---");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println(cat.name() + ": " + cat.getDescripcion());
        }
    }
}