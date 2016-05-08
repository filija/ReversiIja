
package ija.ija2015.gui;

import ija.ija2015.homework2.board.Board;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Třída Definující konec hry
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */

public class FinishGame {
    
    Board board;
    
    public FinishGame(Board board) {
        this.board = board;
        
        JFrame frame = new JFrame("Konec hry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 350);
        frame.getContentPane().setLayout(null);
        
        JLabel label1 = new JLabel("Winner");
        
        int size = board.getSize();
        int score1 = board.countBlack();
        int score2 = board.countWhite();
        
        if ((score1 + score2) != size) {
            if (score1 > score2) {
                score1 = size - score2;
                label1.setText("Vyhrává černý hráč");
            } else {
                score2 = size - score1;
                label1.setText("Vyhrává bílý hráč");
            }
        }

        System.out.print(score1 + " " + score2);
        JLabel label2 = new JLabel("Score1");
        label2.setText("Výslední skóre černého hráče: " + score1 + "\n");
        
        JLabel label3 = new JLabel("Score1");
        label3.setText("Výslední skóre černého hráče: " + score2 + "\n");
        
        JButton ret = new JButton("Návrat do hlavního menu");
        ret.setBounds(50, 50, 150, 50);
        ret.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new MainMenu();
        });
        ret.add(frame);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
}
