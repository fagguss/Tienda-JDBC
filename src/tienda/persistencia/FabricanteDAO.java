

package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;


public final class FabricanteDAO extends DAO {

    
//    public FabricanteDAO() {
//    }
//    
    
     public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            String sql = "INSERT INTO fabricante (nombre)"
                    + "VALUES ( '"+fabricante.getNombre()+"');";

            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     
     public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el codigo del fabricante que desea modificar");
            }

            String sql = "UPDATE Usuario SET "
                    + "nombre = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getCodigo() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
     public void eliminarFabricante(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM fabricante WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
     
     public Fabricante buscarFabricanteXNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Usuario "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            
            desconectarBase();
            
            return fabricante;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Fabricante buscarFabricanteXCodigo(Integer codigo) throws Exception {
        try {

            String sql = "SELECT codigo, nombre FROM fabricante "
                    + " WHERE codigo = '" + codigo + "';";

            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            
            desconectarBase();
            
            return fabricante;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM fabricante ";

            consultarBase(sql);

            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            
            desconectarBase();
            return fabricantes;
            
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
