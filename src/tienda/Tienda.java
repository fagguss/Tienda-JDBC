
package tienda;


import tienda.menu.MenuTienda;


public  class Tienda  {

    public static void main(String[] args) throws Exception {

        try {
            MenuTienda menu=new MenuTienda(); 

            menu.MenuTienda();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }

}
