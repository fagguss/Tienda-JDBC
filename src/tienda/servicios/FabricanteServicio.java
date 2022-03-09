package tienda.servicios;


import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO fabricanteDAO;

    public FabricanteServicio() {
        this.fabricanteDAO=new FabricanteDAO();
    }

    
    public Fabricante buscarFabricanteXCodigo(Integer codigo) throws Exception {

        try {
            
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            Fabricante fabricante=fabricanteDAO.buscarFabricanteXCodigo(codigo);
            
            return fabricante;
            
        } catch (Exception ex) {
            throw ex;
        }

    }
    
     public void ingresarFabricante() throws Exception {
         Scanner leer = new Scanner(System.in).useDelimiter("\n");         
        try {
            Fabricante fabricante = new Fabricante();
            System.out.println("*****NUEVO FABRICANTE******");
            System.out.print("Ingrese nombre del fabricante: ");
            fabricante.setNombre(leer.next());

            fabricanteDAO.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }

    }

}
