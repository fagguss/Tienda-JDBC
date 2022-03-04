package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.FabricanteServicio;

public final class ProductoDAO extends DAO {
    
    private FabricanteServicio fabricanteServis; 

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' ," + producto.getFabricante().getCodigo() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el nombre del producto que desea modificar");
            }

            String sql = "UPDATE producto SET "
                    + "codigo = '" + producto.getCodigo() + "' WHERE nombre = '" + producto.getNombre() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM producto WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoXCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            //mirar referencia de codigo, porque no lo termino de entender bien 
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getFloat(3));

            }

//            Mascota mascota = null;
//            while (resultado.next()) {
//                mascota = new Mascota();
//                mascota.setId(resultado.getInt(1));
//                mascota.setApodo(resultado.getString(2));
//                mascota.setRaza(resultado.getString(3));
//                Integer idUsuario = resultado.getInt(4);
//                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
//                mascota.setUsuario(usuario);
//            }
            desconectarBase();

            return producto;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT codigo, nombre, precio, codigo_fabricamte FROM producto ";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getFloat(3));
                Integer codigo_fabricante= resultado.getInt(4);
                Fabricante fabricante=fabricanteServis.buscarFabricanteXCodigo(codigo_fabricante); 
                producto.setFabricante(fabricante); 
                
                productos.add(producto); 

            }
//REFERENCIA: 

//            Mascota mascota = null;
//            Collection<Mascota> mascotas = new ArrayList();
//            while (resultado.next()) {
//                mascota = new Mascota();
//                mascota.setId(resultado.getInt(1));
//                mascota.setApodo(resultado.getString(2));
//                mascota.setRaza(resultado.getString(3));
//                Integer idUsuario = resultado.getInt(4);
//                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
//                mascota.setUsuario(usuario);
//                mascotas.add(mascota);
//            }

            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

}
