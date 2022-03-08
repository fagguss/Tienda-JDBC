package tienda.menu;

import java.util.Scanner;
import tienda.servicios.ProductoServicio;

public class MenuTienda {

    private ProductoServicio productoServicio; 

    public MenuTienda() {
        this.productoServicio=new ProductoServicio(); 
    }
    
    
    public ProductoServicio MenuTienda() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        try {
            int opc;

            do {
                System.out.println("********MENU*******");
                System.out.println("1.Lista el nombre de todos los productos que hay en la tabla producto. \n"
                        + "2.Lista los nombres y los precios de todos los productos de la tabla producto. \n"
                        + "3.Listar aquellos productos que su precio esté entre 120 y 202. \n"
                        + "4.Buscar y listar todos los Portátiles de la tabla producto. \n"
                        + "5.Listar el nombre y el precio del producto más barato. \n"
                        + "6.Ingresar un producto a la base de datos. \n"
                        + "7.Ingresar un fabricante a la base de datos. \n"
                        + "8.Editar un producto con datos a elección. \n"
                        + "9.Finalizar.");
                System.out.print("Elige una opcion que desea realizar: ");
                opc = leer.nextInt();

//                ProductoServicio productoServicio = null;

                switch (opc) {
                    case 1:
//                        productoServicio = new ProductoServicio();
                        productoServicio.listarProductos();
                        break;
                    case 2:
//                        productoServicio = new ProductoServicio();
                        productoServicio.listarProductosPorNombreYPrecio();
                        break;
                    case 3:
//                        productoServicio = new ProductoServicio();
                        productoServicio.buscarProductosXPrecioEntre();
                        break;
                    case 4:
//                        productoServicio = new ProductoServicio();
                        productoServicio.buscarProductoXNommbre();
                        break;
                    case 5:
//                        productoServicio = new ProductoServicio();
                        productoServicio.buscarProductosXPrecioMenor();
                        break;
                    case 6:
//                        productoServicio = new ProductoServicio();
                        productoServicio.ingresarProducto();
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                }
                return productoServicio;
            } while (opc > 9);

        } catch (Exception e) {
            throw e;

        }

    }

}
