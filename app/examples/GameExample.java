package examples;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class GameExample extends JPanel {
   private InputHandler inputHandler;

   public GameExample() {
      setFocusable(true);
      requestFocus();
      requestFocusInWindow();
      getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "pressed");
      getActionMap().put("pressed", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("Space is pressed");
         }
      });
      this.inputHandler = new InputHandler();	
      addKeyListener(this.inputHandler);
      setPreferredSize(new Dimension(500, 500));
   }

   class InputHandler extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent e) {
    	  if(e.getKeyChar() == 's'){
    		  System.out.println("key " + e.getKeyChar() +" pressed");
    	  }
      }

      @Override
      public void keyReleased(KeyEvent e) {
         //System.out.println("key released");
      }
   }

   private static void createAndShowGui() {
      GameExample mainPanel = new GameExample();

      JFrame frame = new JFrame("Game");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}