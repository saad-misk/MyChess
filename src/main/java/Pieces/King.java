package Pieces;

import chess.Pieces.Piece;
import chess.Pieces.Piece;
import chess.Pieces.Piece;
import chess.Pieces.Piece;


public class King extends Piece{
    
    public King(int color, int col, int row) {
        super(color, col, row);
        
        if( color == chess.GamePanel.WHITE ){
            image = getImage("/images/piece/white_horse");
        }else{
            image = getImage("/images/piece/black_horse");
        }
        
    }
    
}
