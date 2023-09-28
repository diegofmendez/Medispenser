
package ejemplomysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class UserOperation {
    final String  tabla = "usuario";
    
    public void registrar(Connection conexion){
        try {
 
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                    "(NAME, TYPE, PASSWORD, CELLPHONE) VALUES(?,?,?,?)");

            Scanner scann = new Scanner(System.in);

            for (int i =0;i<3;i++){
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
}
