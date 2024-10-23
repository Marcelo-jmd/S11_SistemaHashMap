package SistemaHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestorProductos {
    private HashMap<String, Producto> productos;

    public GestorProductos() {
        productos = new HashMap<>();
    }

    public void agregarProducto(String nombre, double precio) {
        if (precio < 0) {
            System.out.println("El precio no puede ser negativo.");
            return;
        }
        if (productos.containsKey(nombre)) {
            System.out.println("El producto ya existe. Intenta actualizar su precio en lugar de agregarlo.");
        } else {
            productos.put(nombre, new Producto(nombre, precio));
            System.out.println("Producto agregado exitosamente.");
        }
    }

    public void buscarPrecio(String nombre) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            System.out.println("Precio de " + nombre + ": " + producto.getPrecio());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void eliminarProducto(String nombre) {
        if (productos.remove(nombre) != null) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void cargarProductosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    double precio = Double.parseDouble(partes[1].trim());
                    agregarProducto(nombre, precio);
                }
            }
            System.out.println("Productos cargados desde el archivo exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del precio: " + e.getMessage());
        }
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos en el sistema:");
            for (Map.Entry<String, Producto> entry : productos.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}

