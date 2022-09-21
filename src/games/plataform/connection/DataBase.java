
package games.plataform.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {
    private String url;
    private String userName;
    private String password;
    private Connection connection;
    
    // banco de dados padrão
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/games_platform";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public DataBase(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        setConnection();
    }

    public DataBase() {
        this.url = DATABASE_URL;
        this.userName = USERNAME;
        this.password = PASSWORD;
        setConnection();
    }
    
    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private void setConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar o Banco de Dados. " + ex.getMessage());
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public Connection getConnection(){
      return connection;
    } 
    
    public void close () throws SQLException{
        connection.close();
    }
    
}
