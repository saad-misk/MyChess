package Pieces;

import chess.GamePanel;
import chess.Pieces.Piece;
import chess.Pieces.Piece;


public class Pawn extends Piece{
    
    public Pawn(int color, int col, int row) {
        super(color, col, row);
        
        if( color == GamePanel.WHITE ){
            image = getImage("/images/piece/pawnw");
        }else{
            image = getImage("/images/piece/pawnb");
        }
        
    }
    
}
