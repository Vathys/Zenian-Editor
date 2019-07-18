package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Window extends JFrame
{

     public static int WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDefaultConfiguration().getBounds().width;
     public static final int HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDefaultConfiguration().getBounds().height;
     
     private Editor e;
     
     private static final long serialVersionUID = 1L;

     public Window(String title)
     {
          setTitle("Zenian Text Editor");
          setPreferredSize(new Dimension(WIDTH, HEIGHT));
          setMinimumSize(new Dimension(WIDTH, HEIGHT));
          setMaximumSize(new Dimension(WIDTH, HEIGHT));
          
          System.out.println("(" + WIDTH + ", " + HEIGHT + ")");
          
          getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
     
          /*
           * The Canvas needs a preferred size to work with the Scroll Pane
           * */
          e = new Editor();
          e.setPreferredSize(new Dimension(3 * WIDTH, HEIGHT));
             
          /*
           * The JPanel is just a container to hold the Canvas/Editor
           * As far as I see it doesn't provide anything extra and certainly doesn't make it work
           * */
          JPanel jp = new JPanel(new BorderLayout());
          jp.setFocusable(false);
          jp.add(e);
          
          /*
           * The current problem is that while the ScrollPane works and we can see a scrolling effect
           * When we scroll right, the symbols are not rendered at all. The only rendering we see are
           * the ones in the original screen.
           * */
          JScrollPane sp = new JScrollPane(jp);
          sp.setPreferredSize(new Dimension(WIDTH, 2 * HEIGHT / 3));
          sp.setFocusable(false);
          getContentPane().add(sp);
          
          getContentPane().add(e.prepareButtonPanel());
          
          addKeyListener(new KeyHandler(this, e));
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(false);
          setFocusable(true);
          setLocationRelativeTo(null);   
          setUndecorated(true);
     
          this.pack();
          setVisible(true); 
          
          e.init();
          
          this.requestFocus();
     }
     
     public static void main(String[] args)
     {
          new Window("Zenian Text Editor");
     }

}