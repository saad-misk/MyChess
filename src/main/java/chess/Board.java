package chess;

import java.awt.Color;
import java.awt.Graphics2D;


public class Board {
    
    final int MAX_COL = 8;
    final int MAX_ROW = 8;
    
    public static final int SQUARE_SIZE = 80;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;
    
    public void draw(Graphics2D g2){
        
        boolean cnt = false; //to switch the color of the square
        //to draw the board;
        for(int ROW = 0; ROW < MAX_ROW; ROW++){
            
            for(int COL = 0; COL < MAX_COL; COL++){
                
                if( cnt == false ) g2.setColor(new Color(245, 245, 220));
                else g2.setColor(new Color(139, 69, 19));
                cnt = !cnt;//switch
                
                //we start at the top left corner of each square and fill it by SQUARE_SIZE 
                //___________X_____________Y_________________WIDTH________HEIGHT______
                g2.fillRect(COL*SQUARE_SIZE, ROW*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                
            }
            cnt = !cnt;
        }
        
    }
    
}
