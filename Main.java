package trabajo.practicon6;

public class Main {

    public static void main(String[] args) {
        
        Inventario inventario = new Inventario();

        // Tarea 1: Crear y agregar 5 productos
        Producto p1 = new Producto("ELEC001", "Monitor 24", 1500.0, 10, CategoriaProducto.ELECTRONICA);
        Producto p2 = new Producto("ROPA002", "Remera Algodon", 850.0, 50, CategoriaProducto.ROPA);
        Producto p3 = new Producto("ALIM003", "Paquete de Arroz", 400.0, 200, CategoriaProducto.ALIMENTOS);
        Producto p4 = new Producto("HOGAR004", "Juego de Sabanas", 2200.0, 5, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("ELEC005", "Mouse Inalambrico", 900.0, 30, CategoriaProducto.ELECTRONICA);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        System.out.println("---------------------------------");
        
        // Tarea 10: Mostrar categorias disponibles
        inventario.mostrarCategoriasDisponibles();
        System.out.println("---------------------------------");

        // Tarea 2: Listar todos los productos
        inventario.listarProductos();
        System.out.println("---------------------------------");

        // Tarea 3: Buscar producto por ID y mostrar
        Producto pBuscado = inventario.buscarProductoPorId("ROPA002");
        if (pBuscado != null) {
            System.out.println("Tarea 3 - Producto encontrado: " + pBuscado.getNombre());
        } else {
            System.out.println("Tarea 3 - Producto no encontrado.");
        }
        System.out.println("---------------------------------");

        // Tarea 4: Filtrar por Categoria (ELECTRONICA)
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        System.out.println("---------------------------------");

        // Tarea 9: Filtrar por Precio ($900 - $2500)
        inventario.filtrarProductosPorPrecio(900.0, 2500.0);
        System.out.println("---------------------------------");
        
        // Tarea 8: Producto con Mayor Stock
        Producto mayor = inventario.obtenerProductoConMayorStock();
        System.out.println("Tarea 8 - Producto con mayor stock: " + mayor.getNombre() + " (" + mayor.getCantidad() + ")");
        System.out.println("---------------------------------");

        // Tarea 6: Actualizar stock (ELEC001)
        inventario.actualizarStock("ELEC001", 15);
        System.out.println("---------------------------------");

        // Tarea 7: Mostrar Total Stock
        System.out.println("Tarea 7 - Stock Total en Inventario: " + inventario.obtenerTotalStock());
        System.out.println("---------------------------------");

        // Tarea 5: Eliminar producto (ROPA002)
        inventario.eliminarProducto("ROPA002");
        
        // Verificamos que se haya eliminado
        System.out.println("Stock Total (despues de eliminar): " + inventario.obtenerTotalStock());
    }
}