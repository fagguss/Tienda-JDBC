package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO productoDAO;
    private FabricanteServicio fabricanteServicio;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ProductoServicio() {
        this.productoDAO = new ProductoDAO();
        this.fabricanteServicio = new FabricanteServicio();
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
                System.out.println("nombre= " + producto.getNombre() + ", precio=" + producto.getPrecio());
            }

            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> buscarProductosXPrecioEntre() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.buscarProductoXPrecioEntre();

            System.out.println("Los productos son: ");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }

            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<Producto> buscarProductoXNommbre() throws Exception {

        try {
            System.out.print("Ingrese nombre del producto: ");
            String nombre = leer.next();

            Collection<Producto> productos = productoDAO.buscarProductoXNombre(nombre);

            System.out.println("Los productos son: ");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> buscarProductosXPrecioMenor() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.buscarProductoXPrecioMenor();

            System.out.println("Los productos son: ");
            for (Producto producto : productos) {
                System.out.println("nombre= " + producto.getNombre() + ", precio=" + producto.getPrecio());
            }

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
            System.out.print("Ingrese codigo_fabricante del producto: ");
            Integer codigo_fabricante = leer.nextInt();
            Fabricante fabricante = fabricanteServicio.buscarFabricanteXCodigo(codigo_fabricante);
            producto.setFabricante(fabricante);

            productoDAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }

    }

    public void editarProducto() throws Exception {

        try {
            Producto producto = new Producto();
            System.out.println("*****EDITAR PRODUCTO******");
            System.out.print("Ingrese el codigo del producto que desea modificar: ");
            producto.setCodigo(leer.nextInt());
            System.out.print("Ingrese el nombre nuevo del producto: ");
            producto.setNombre(leer.next());
    
            productoDAO.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }

    }

}
