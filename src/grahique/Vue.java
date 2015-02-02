package grahique;

import gestionnaires.GestionGraphe;
import graphe.Graphe;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 */
public class Vue extends JPanel implements Observer {
	GestionGraphe graphe;
    private JButton draw, dfs, bfs, djikstra;
    
    private JTable table;
    private JTextField s11;
    private JTextField s12;
    private JTextField s13;
    private JTextField s21;
    private JTextField s22;
    private JTextField s23;
    private JTextField s31;
    private JTextField s32;
    private JTextField s33;

    public Vue(GestionGraphe g) {
        super();
        this.graphe = g;
        this.table = new JTable(3, 3); 
        add(table);
        

        
        this.draw = new JButton("draw");
        this.dfs = new JButton("dfs");
        this.bfs = new JButton("bfs");
        this.djikstra = new JButton("djikstra");


        setLayout(new GridLayout(2, 1));
        
        /*add(donnee);
        donnee.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    //Controleur.this.operande();
                }
            });
        */
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(draw);  draw.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                   //Controleur.this.push();
                   
                }
            });
        boutons.add(dfs);   dfs.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    //Controleur.this.add();
                }
            });
        boutons.add(bfs);   bfs.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    //Controleur.this.sub();
                }
            });
        boutons.add(djikstra);   djikstra.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    //Controleur.this.mul();
                }
            });
        add(boutons);
        boutons.setBackground(Color.cyan);
        actualiserInterface();
    }

    public void actualiserInterface() {
        //donnee.setText("");
    }



	@Override
	public void update(Observable obs, Object arg1) {
		// TODO Auto-generated method stub
		
	}

   

}