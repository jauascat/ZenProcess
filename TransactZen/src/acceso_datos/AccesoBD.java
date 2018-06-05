package acceso_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoBD
{
    Connection zion;
    Statement stmt;
    
    private String userName = "usuario";
    private String pass = "1234";
    private String zionString = "jdbc:sqlserver://DESKTOP-7ECU5DP;databaseName=db_tzen;";
    private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public AccesoBD()
    {
       /*FileReader reader = null;
        try
        {
            Class.forName(driverName);
            
            reader = new FileReader("Credenciales_BDatos.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            if((userName = buffer.readLine()) != null)
            {
                userName = userName.substring(userName.lastIndexOf("Usuario:")+8).trim();

                pass = buffer.readLine();
                pass = pass.substring(pass.lastIndexOf("Clave:")+6).trim();

                zionString = buffer.readLine();
                zionString = zionString.substring(zionString.lastIndexOf("String de conexion:")+19).trim();                           
            }
            reader.close();
        }
        catch (ClassNotFoundException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
        catch (FileNotFoundException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
        catch (IOException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}*/
    }
    
    public void ejecutarSQLVoid(String sentencia)
    {	
        try
        {
            Class.forName(driverName);
            zion = DriverManager.getConnection(zionString, userName, pass);
            stmt = zion.createStatement();		
            stmt.executeUpdate(sentencia);
        }
        catch (SQLException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
        catch (ClassNotFoundException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
    }

    public ResultSet ejecutarSQL(String sentencia) throws SQLException
    {
        ResultSet datos = null;
        try
        {
            Class.forName(driverName);
            zion = DriverManager.getConnection(zionString, userName, pass);
            stmt = zion.createStatement();
            datos = stmt.executeQuery(sentencia);
            
        } catch (ClassNotFoundException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
        
        return datos;
    }
    
    public void finalizarConexion()
    {
        try
        {
            zion.close();
            stmt = null;
            
        } catch (SQLException ex) {
        	
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);}
    }
}