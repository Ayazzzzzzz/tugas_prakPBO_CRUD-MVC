/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOmovie.movieDAO;
import DAOImplement.movieimplement;
import model.*;
import view.MainView;
/**
 *
 * @author Ayas
 */
public class moviecontroller {
    MainView frame;
    movieimplement implementmovie;
    List<movie> dm;
    
    public moviecontroller(MainView frame){
        this.frame = frame;
        implementmovie = new movieDAO();
        dm = implementmovie.getAll();
    }
    
    public void isitabel(){
        dm = implementmovie.getAll();
        modeltabelmovie mp = new modeltabelmovie(dm);
        frame.getTabelmovie().setModel(mp);
    }
    
    public void insert(){
        movie dm = new movie();
        dm.setJudul(frame.getJudul().getText());
        dm.setAlur(Double.parseDouble(frame.getAlur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getTokoh().getText()));
        dm.setAkting(Double.parseDouble(frame.getAkting().getText()));
        implementmovie.insert(dm);
    }
    
    public void update(){
        movie dm = new movie();
        dm.setJudul(frame.getJudul().getText());
        dm.setAlur(Double.parseDouble(frame.getAlur().getText()));
        dm.setPenokohan(Double.parseDouble(frame.getTokoh().getText()));
        dm.setAkting(Double.parseDouble(frame.getAkting().getText()));
        implementmovie.update(dm);
    }
    
    public void delete(){
        String judul = frame.getJudul().getText();
        implementmovie.delete(judul);
    }
    
  
}
