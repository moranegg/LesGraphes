package grahique;

import gestionnaires.GestionGraphe;
import graphe.Graphe;

import java.awt.*;

import javax.swing.*;

import java.util.Observer;
import java.util.Observable;

/**
 * 
 */
public class Applette extends JApplet {

    public void init() {
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        GestionGraphe control = new GestionGraphe("fichierDeGraphe");
        
		int[][] matrice = {{0,1,1,0},{1,0,1,0},{0,0,0,0},{0,1,0,0}};
		String nom="Graphe simple";
		
		Graphe model = control.creationGraphe(matrice, nom);
        Vue vue = new Vue(control);
        model.addObserver(vue);
        
        
        
        
        setLayout(new GridLayout(1, 1));
        add(vue);
        
        setVisible(true);

    }
    

}