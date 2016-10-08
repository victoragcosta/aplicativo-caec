package examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Example6
{
    private JTextArea tarea;
    private Timer timer;
    private Color[] colours = {
                                Color.RED,
                                Color.BLUE,
                                Color.GREEN.darker(),
                                Color.DARK_GRAY,
                                Color.MAGENTA,
                                Color.YELLOW
                              };
    private int counter = 0;                          
    private ActionListener timerAction = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (counter < colours.length)
            {
                tarea.setBackground(colours[counter]);
                counter++;
            }
            else
            {
                tarea.setBackground(Color.PINK);
                counter = 0;
            }   
        }
    };

    private void displayGUI()
    {
        JFrame frame = new JFrame("Colouring JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        tarea = new JTextArea(10, 10);
        contentPane.add(tarea);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        timer = new Timer(1000, timerAction);
        timer.start();
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Example6().displayGUI();
            }
        });
    }
}