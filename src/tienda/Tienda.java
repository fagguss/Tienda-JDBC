/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;


import tienda.servicios.ProductoServicio;

public class Tienda {

    public static void main(String[] args) throws Exception {

        try {
            
            ProductoServicio productoServis = new ProductoServicio();
            productoServis.listarProductos();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }

}
