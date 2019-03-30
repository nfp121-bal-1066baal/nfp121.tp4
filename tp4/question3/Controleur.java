package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){push();}});
        boutons.add(add);   add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){add();}});
        boutons.add(sub);   sub.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){sub();}});
        boutons.add(mul);   mul.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){mul();}});
        boutons.add(div);   div.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){div();}});
        boutons.add(clear); clear.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){clear();}});
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        if(pile.taille()<2)
        {
            add.setEnabled(false);
            sub.setEnabled(false);
            div.setEnabled(false);
            mul.setEnabled(false);
        }
        if(pile.taille()>1 && pile.taille()<pile.capacite())
        {
           add.setEnabled(true);
            sub.setEnabled(true);
            div.setEnabled(true);
            mul.setEnabled(true);  
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    public void push(){
        try{
            pile.empiler(Integer.parseInt(donnee.getText().toString()));
        }
        catch(PilePleineException e){
            e.printStackTrace();
        }
        actualiserInterface();
    }
        public void add(){
        try{
            int a1=pile.depiler();
            int a2=pile.depiler();
            pile.empiler(a1+a2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        actualiserInterface();
    }
    
    public void sub(){
        try{
            int a1=pile.depiler();
            int a2=pile.depiler();
            pile.empiler(a2-a1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        actualiserInterface();
    }
    
    public void mul(){
        try{
            int a1=pile.depiler();
            int a2=pile.depiler();
            pile.empiler(a1*a2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        actualiserInterface();
    }
    
    public void div(){
        try{
            int a1=pile.depiler();
            int a2=pile.depiler();
            pile.empiler(a2/a1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        actualiserInterface();
    }
    public void clear(){
        try{
        if(pile.estVide())
        {return;}
        for(int i=pile.taille();i>0;i--)
        pile.depiler();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    actualiserInterface();
    }
  

}
