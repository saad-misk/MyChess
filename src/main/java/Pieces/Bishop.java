package Pieces;

import chess.Pieces.Piece;


public class Bishop extends Piece{
    
    public Bishop(int color, int col, int row) {
        super(color, col, row);
        
        if( color == chess.GamePanel.WHITE ){
            image = getImage("/images/piece/bishopw");
        }else{
            image = getImage("/images/piece/bishopb");
        }
        
    }
    
}
