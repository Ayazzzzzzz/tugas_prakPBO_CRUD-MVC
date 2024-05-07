/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOmovie;
import DAOImplement.movieimplement;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.connector;
import model.*;

/**
 *
 * @author Ayas
 */
public class movieDAO implements movieimplement{
    Connection connection;
    double nilai;
    
    final String select = "SELECT * FROM `movie`";
    final String insert = "INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES (?, ?, ?, ?, ?);";
    final String update = "update movie set alur=?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "delete from movie where judul = ?";
    public movieDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(movie m) {
        PreparedStatement statement = null;
       try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            double nilai = (m.getAlur() + m.getAkting() + m.getPenokohan()) / 3;
            m.setNilai(nilai);
            statement.setDouble(5, m.getNilai()); 
            statement.executeUpdate();
            
       }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(movie m) {
        PreparedStatement statement = null;
       try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            double nilai = (m.getAlur() + m.getAkting() + m.getPenokohan()) / 3;
            m.setNilai(nilai);
            statement.setDouble(4, m.getNilai());
            statement.setString(5, m.getJudul()); 
            statement.executeUpdate();
            
           // ResultSet rs = statement.getGeneratedKeys();
          
            
       }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
         PreparedStatement statement = null;
         try{
             statement = connection.prepareStatement(delete);
             statement.setString(1, judul);
             statement.executeUpdate();
         }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<movie> getAll() {
        List<movie> dm = null;
        try{
           dm = new ArrayList<movie>();
           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery(select);
           while(rs.next()){
                movie m= new movie();
                m.setJudul(rs.getString("judul"));
                m.setAlur(rs.getDouble("alur"));
                m.setPenokohan(rs.getDouble("penokohan"));
                m.setAkting(rs.getDouble("akting"));
                m.setNilai(rs.getDouble("nilai"));
                dm.add(m);
           }
           
        }catch (SQLException ex) {
            Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dm;
        
        }
}
