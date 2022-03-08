package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO productoDAO;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ProductoServicio() {
        this.productoDAO= new ProductoDAO();
    }
    
    
    public Collection<Producto> listarProductos() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.listarProductos();
            
            System.out.println("Los productos son: ");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
            
            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> listarProductosPorNombreYPrecio() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.listarProductosPorNombreYPrecio();
            
            System.out.println("Los productos son: ");
            for (Producto producto : productos) {
                System.out.println("nombre= " +producto.getNombre()+", precio=" +producto.getPrecio());
            }
            
            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> buscarProductosXPrecioEntre() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.buscarProductoXPrecioMenor();
            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public Producto buscarProductoXNommbre() throws Exception {

        try {
            System.out.print("Ingrese nombre del producto: ");
            String nombre = leer.next();

            Producto producto = productoDAO.buscarProductoXNombre(nombre);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> buscarProductosXPrecioMenor() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.buscarProductoXPrecioMenor();
            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

     public void ingresarProducto() throws Exception {

        try {
            Producto producto = new Producto();
            System.out.println("*****NUEVO PRODUCTO******");
            System.out.print("Ingrese nombre del producto: ");
            producto.setNombre(leer.next());
            System.out.print("Ingrese precio del producto: ");
            producto.setPrecio(leer.nextFloat());

            productoDAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }

    }
    
   

}
