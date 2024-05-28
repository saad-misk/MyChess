package Pieces;

import chess.GamePanel;
import chess.Pieces.Piece;


public class Knight extends Piece{
    
    public Knight(int color, int col, int row) {
        super(color, col, row);
        
        if( color == GamePanel.WHITE ){
            image = getImage("/images/piece/knightw");
        }else{
            image = getImage("/images/piece/knightb");
        }
        
    }
    
}
