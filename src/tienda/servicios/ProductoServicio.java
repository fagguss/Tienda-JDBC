package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO productoDAO;

    public Collection<Producto> listarProductos() throws Exception {

        try {
            Collection<Producto> productos = productoDAO.listarProductos();
            return productos;
        }catch (Exception e){
            throw e; 
        }

    }

}
