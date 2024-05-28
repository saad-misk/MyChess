package chess;


import chess.Pieces.Piece;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 640;
    final int FBS = 60;
    //Thread to run gameloop, to use thread we implement runnable(we need to implement abstract method run())
    Thread gameThread;
    Board board = new Board();
    
    //pieces
    ArrayList<Piece> pieces = new ArrayList();
    ArrayList<Piece> pieces2 = new ArrayList();
    
    //color
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;
    
    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setPieces();
        copyPieces(pieces, pieces2);
    }
    
    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();//it calls run() method
    }
    
    public void setPieces(){
        
        //PASSING the color and position(col, row) to each piece
        //White team
        pieces.add(new Pieces.Pawn(WHITE, 0, 6));
        pieces.add(new Pieces.Pawn(WHITE, 1, 6));
        pieces.add(new Pieces.Pawn(WHITE, 2, 6));
        pieces.add(new Pieces.Pawn(WHITE, 3, 6));
        pieces.add(new Pieces.Pawn(WHITE, 4, 6));
        pieces.add(new Pieces.Pawn(WHITE, 5, 6));
        pieces.add(new Pieces.Pawn(WHITE, 6, 6));
        pieces.add(new Pieces.Pawn(WHITE, 7, 6));
        pieces.add(new Pieces.Rock(WHITE, 0, 7));
        pieces.add(new Pieces.Rock(WHITE, 7, 7));
        pieces.add(new Pieces.Knight(WHITE, 1, 7));
        pieces.add(new Pieces.Knight(WHITE, 6, 7)); 
        pieces.add(new Pieces.Bishop(WHITE, 2, 7));
        pieces.add(new Pieces.Bishop(WHITE, 5, 7));
        pieces.add(new Pieces.King(WHITE, 4, 7));
        pieces.add(new Pieces.Queen(WHITE, 3, 7));
        
        //Black team
        pieces.add(new Pieces.Pawn(BLACK, 0, 1));
        pieces.add(new Pieces.Pawn(BLACK, 1, 1));
        pieces.add(new Pieces.Pawn(BLACK, 2, 1));
        pieces.add(new Pieces.Pawn(BLACK, 3, 1));
        pieces.add(new Pieces.Pawn(BLACK, 4, 1));
        pieces.add(new Pieces.Pawn(BLACK, 5, 1));
        pieces.add(new Pieces.Pawn(BLACK, 6, 1));
        pieces.add(new Pieces.Pawn(BLACK, 7, 1));
        pieces.add(new Pieces.Rock(BLACK, 0, 0));
        pieces.add(new Pieces.Rock(BLACK, 7, 0));
        pieces.add(new Pieces.Knight(BLACK, 1, 0));
        pieces.add(new Pieces.Knight(BLACK, 6, 0)); 
        pieces.add(new Pieces.Bishop(BLACK, 2, 0));
        pieces.add(new Pieces.Bishop(BLACK, 5, 0));
        pieces.add(new Pieces.King(BLACK, 4, 0));
        pieces.add(new Pieces.Queen(BLACK, 3, 0));
    }
    
    private void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target){
        target.clear();
        for(Piece p : source){
            target.add(p);
        }
    }
    
    private void update(){
        
    }
    
    //used to draw objects(chess board, chess pieces, messeages) on the panel and it's inherited
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;//because draw takes Graphics2D not Graphics
        //draw board
        board.draw(g2);
        
        //draw pices
        for(Piece p : pieces2){
            p.draw(g2);
        }
    }

    @Override
    public void run() {
        //GameLoop
        
        double drawInterval = 1000000000/FBS;
        //the time interval in nanoseconds between each frame. It's calculated by dividing one second (in nanoseconds, which is 1,000,000,000 nanoseconds) by FPS (frames per second).
        double delta = 0;
        //a variable used to keep track of how much time has passed and to determine when to update and render the game.
        long lastTime = System.nanoTime();
        //stores the time at the start of the previous loop iteration using System.nanoTime(), which gives the current time in nanoseconds.
        long currentTime;
        //stores the time at the start of the current loop iteration.
        
        while( gameThread != null ){
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/ drawInterval;
            lastTime = currentTime;
            
            if( delta >= 1 ){//If delta is greater than or equal to 1, it means that enough time has passed to update and render the game for one frame.
                update();
                repaint();
                delta--;
            }
           
        }
        
    }
    
}
