/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author Ayas
 */
public interface movieimplement {
    public void insert(movie m);
    public void update(movie m);
    public void delete(String judul);
    public List<movie> getAll();
}
