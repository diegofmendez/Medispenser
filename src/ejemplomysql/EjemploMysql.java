
package ejemplomysql;

import gui.FormularioUI;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class EjemploMysql {
    
    
    
    
    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/usuario";
    
    public static void main(String[] args) throws SQLException{
        
        FormularioUI screen1 = new FormularioUI();
        screen1.setVisible(true);
        screen1.setLocationRelativeTo(null);
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }
           
        Operaciones operacion = new Operaciones();
        
        UserOperation userop = new UserOperation();
        
        System.out.println("Seleccione:");
        System.out.println("1 para mostrar los productos");
        System.out.println("2 para añadir una entrada");
        System.out.println("Presione cualquier otro número para salir");
        Scanner sc = new Scanner(System.in);
        
        boolean verify = true; 
        while (verify){
            int entrada = sc.nextInt();
            switch(entrada){
                case 1:
                    operacion.mostrar(con);
                    break;
                case 2:
                    userop.registrar(con);
                    break;
                default:
                    verify=false;
                    break;
            } 
        }

        
        
        
    }
    
}
