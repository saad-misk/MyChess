package Pieces;

import chess.Pieces.Piece;
import chess.GamePanel;


public class Rock extends Piece{
    
    public Rock(int color, int col, int row) {
        super(color, col, row);
        
        if( color == GamePanel.WHITE ){
            image = getImage("/images/piece/rookw");
        }else{
            image = getImage("/images/piece/rookb");
        }
        
    }
    
}
