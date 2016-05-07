package ija.ija2015.actions;

import ija.ija2015.homework2.board.Disk;
import ija.ija2015.homework2.game.Game;
import java.util.Random;

public class AiAction {

    public static Game aiAction(Game game, int algorithm) {
        if (algorithm == 1 ) {
            for (int i = 1; i < game.getBoard().getSize(); i++) {
                for (int j = 1; j < game.getBoard().getSize(); j++) {
                    if (game.currentPlayer().canPutDisk(game.getBoard().getField(i, j))) {
                        game.currentPlayer().putDisk(game.getBoard().getField(i, j));
                        game.nextPlayer();
                        return game;
                    } 
                }
            }
        } else {
            Random ran = new Random();
            int i = ran.nextInt(game.getBoard().getSize());
            int j = ran.nextInt(game.getBoard().getSize());
            System.out.print("i je: " + i + "\n");
            System.out.print("j je: " + j + "\n");
            while (!game.currentPlayer().canPutDisk(game.getBoard().getField(i, j))) {
                i = ran.nextInt(game.getBoard().getSize());
                j = ran.nextInt(game.getBoard().getSize());
            }
            game.currentPlayer().putDisk(game.getBoard().getField(i, j));
            game.nextPlayer();
            return game;
            
        }
        return game;
    }
}
