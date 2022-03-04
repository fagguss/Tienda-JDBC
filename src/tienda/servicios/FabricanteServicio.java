package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO fabricanteDAO;

    public Fabricante buscarFabricanteXCodigo(Integer codigo) throws Exception {

        try {
            
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            
            Fabricante fabricante = fabricanteDAO.buscarFabricanteXCodigo(codigo);
            return fabricante;
            
        } catch (Exception ex) {
            throw ex;
        }

    }
}
