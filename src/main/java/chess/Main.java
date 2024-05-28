package chess;

import javax.swing.JFrame;


public class Main {
    
    public static void main(String[] args){
        
        JFrame window = new JFrame("MyChess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        //add GamePanel to the Window
        GamePanel gamep = new GamePanel();
        window.add(gamep);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamep.launchGame();
        
    }
    
}
