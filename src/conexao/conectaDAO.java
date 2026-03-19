package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        try {
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/uc11?useSSL=false", // linha de conexao
            "root", // usuario do mysql
            "LadyGa13@"// senha do mysql
                );
                return conn;
            
                    } catch (Exception e) {
                        System.out.println("Erro ao conectar: " + e.getMessage());
                        return null;
                    }
    }
    
}
