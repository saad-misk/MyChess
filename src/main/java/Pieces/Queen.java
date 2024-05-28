package Pieces;

import chess.Pieces.Piece;


public class Queen extends Piece{
    
    public Queen(int color, int col, int row) {
        super(color, col, row);
        
        if( color == chess.GamePanel.WHITE ){
            image = getImage("/images/piece/crownw");
        }else{
            image = getImage("/images/piece/crownb");
        }
        
    }
    
    
    
}
