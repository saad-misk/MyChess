package chess.Pieces;

import chess.Board;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public abstract class Piece {
    
    public BufferedImage image;
    public int x, y;
    public int row, col, preRow, preCol;
    public int color;
    
    public Piece(int color, int col, int row){
        
        this.color = color;
        this.row = row;
        this.col = col;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }
    
    //getting piece image
    public BufferedImage getImage(String imagePath){
        
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            
        }catch(Exception e){
            
            try{
                image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".jpg"));
            }catch(Exception e2){
                System.out.println(e.getMessage());
            }
            
        }
        
        return image;
    }
    
    public int getX(int col){
        return col * Board.SQUARE_SIZE;
    }
    public int getY(int row){
        return row * Board.SQUARE_SIZE;
    }
    
    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
    
}
