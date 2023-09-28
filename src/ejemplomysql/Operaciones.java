
package ejemplomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;


public class Operaciones {
    
    final String  tabla = "Inventario";
    
    public void guardar(Connection conexion){
        try {
 
        PreparedStatement consulta;
        
        consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                "(MARCA, NOMBRE, TIPOPRODUCTO, STOCK) VALUES(?,?,?,?)");
        
        Scanner scann = new Scanner(System.in);
        
        for (int i =0;i<4;i++)
            if (i ==3) {
                System.out.println("Ingresar stock disponible");
                int valor=scann.nextInt();
                consulta.setInt((i+1), valor);    
            } else {
                switch(i){
                    case 0:
                        System.out.println("Ingresar Marca del producto");
                        break;
                    case 1:
                        System.out.println("Ingresar Nombre del producto");
                        break;
                    case 2:
                        System.out.println("Ingresar Tipo de producto");
                        break;
                }
                String texto=scann.nextLine();
                consulta.setString((i+1), texto);
            }
            
        consulta.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void mostrar(Connection conexion){
        try {
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE MARCA='Lego'");

            ResultSet result = consulta.executeQuery();

            while (result.next()) {

                String columnValue = result.getString("NOMBRE");
                
                System.out.println("Productos: " + columnValue);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
