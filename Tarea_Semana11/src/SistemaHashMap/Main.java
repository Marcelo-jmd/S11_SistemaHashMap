package SistemaHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Objeto de la clase gestor productos
        GestorProductos gestor = new GestorProductos();
        gestor.cargarProductosDesdeArchivo("productos.txt");
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSistema de Gestión de Productos");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Precio");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = lector.nextInt();
            lector.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = lector.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = lector.nextDouble();
                    gestor.agregarProducto(nombre, precio);
                    break;
                case 2:
                    System.out.print("Nombre del producto a buscar: ");
                    nombre = lector.nextLine();
                    gestor.buscarPrecio(nombre);
                    break;
                case 3:
                    System.out.print("Nombre del producto a eliminar: ");
                    nombre = lector.nextLine();
                    gestor.eliminarProducto(nombre);
                    break;
                case 4:
                    gestor.listarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        lector.close();
    }
}
