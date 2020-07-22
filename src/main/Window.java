package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.sun.glass.events.KeyEvent;

public class Window extends JFrame
{

     public final int WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDefaultConfiguration().getBounds().width;
     public final int HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDefaultConfiguration().getBounds().height;

     private Editor e;
     private JScrollPane sp;
     private JTabbedPane tabPane;

     private static final long serialVersionUID = 1L;

     public Window(String title)
     {
          setTitle("Zenian Text Editor");
          setPreferredSize(new Dimension(WIDTH, HEIGHT));
          setMinimumSize(new Dimension(WIDTH, HEIGHT));
          setMaximumSize(new Dimension(WIDTH, HEIGHT));

          //System.out.println("(" + WIDTH + ", " + HEIGHT + ")");

          getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

          /*
           * The JPanel is just a container to hold the Canvas/Editor
           * As far as I see it doesn't provide anything extra and certainly doesn't make it work
           * */

          /*
           * The Canvas needs a preferred size to work with the Scroll Pane
           * */
          e = new Editor(this);
          e.setPreferredSize(new Dimension(3 * WIDTH, HEIGHT));
          
          setJMenuBar(prepareMenuBar());
          
          sp = new JScrollPane(e);
          sp.setPreferredSize(new Dimension(WIDTH, 2 * HEIGHT / 3));
          sp.setFocusable(false);

          tabPane = new JTabbedPane();
          tabPane.setFocusable(false);
          tabPane.addTab("New File", sp);
          if(tabPane.getTabCount() > 1)
               tabPane.setTabComponentAt(0, new ButtonTabComponent(tabPane));
          
          getContentPane().add(tabPane);

          getContentPane().add(prepareButtonPanel());

          addKeyListener(new KeyHandler(this, e));
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setResizable(false);
          setFocusable(true);
          setLocationByPlatform(true);
          setUndecorated(true);

          this.pack();
          setVisible(true);

          e.init();

          this.requestFocus();
     }

     /*
      * Prepares JPanel with buttons
      * */
     public JPanel prepareButtonPanel()
     {
          JPanel buttonPanel = new JPanel(new GridBagLayout());
          buttonPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 3));
          buttonPanel.setFocusable(false);
          GridBagConstraints g = new GridBagConstraints();
          g.fill = GridBagConstraints.BOTH;
          g.insets = new Insets(5, 5, 5, 5);

          JButton button;

          ZenianLetter[] names = ZenianLetter.values();

          Font zenian;
          try
          {
               zenian = new Font("Times New Roman", Font.TRUETYPE_FONT, 28);
               //zenian = Font.createFont(Font.TRUETYPE_FONT, new File("res/ZenianRegular.ttf"));

               //zenian = zenian.deriveFont(25f);
               for (int i = 0; i < 8; i++)
               {
                    button = new JButton(names[i + 1].getCharacter());
                    g.weightx = .5;
                    g.weighty = .5;
                    g.gridx = i;
                    g.gridy = 0;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1].getCharacter());
                    button.addActionListener(e);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
               for (int i = 0; i < 7; i++)
               {
                    button = new JButton(names[i + 1 + 8].getCharacter());
                    g.weightx = 0;
                    g.weighty = .5;
                    g.gridx = i;
                    g.gridy = 1;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1 + 8].getCharacter());
                    button.addActionListener(e);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
               for (int i = 0; i < 8; i++)
               {
                    button = new JButton(names[i + 1 + 8 + 7].getCharacter());
                    g.weightx = .5;
                    g.weighty = .5;
                    g.gridx = i;
                    g.gridy = 2;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1 + 8 + 7].getCharacter());
                    button.addActionListener(e);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
          } catch (Exception e)
          {
               e.printStackTrace();
          }

          return buttonPanel;
     }

     public JMenuBar prepareMenuBar()
     {
          // Create a menubar 
          JMenuBar mb = new JMenuBar();

          // Create a menu for menu 
          JMenu m1 = new JMenu("File");

          // Create menu items 
          JMenuItem mi1 = new JMenuItem("New");
          JMenuItem mi2 = new JMenuItem("Open");
          JMenuItem mi3 = new JMenuItem("Save");
          JMenuItem mi4 = new JMenuItem("Save As");
          JMenuItem mc = new JMenuItem("Exit");

          mi1.setMnemonic(KeyEvent.VK_N);
          mi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
          
          mi2.setMnemonic(KeyEvent.VK_O);
          mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
          
          mi3.setMnemonic(KeyEvent.VK_S);
          mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
          
          mi4.setMnemonic(KeyEvent.VK_A);
          mi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
          
          mc.setMnemonic(KeyEvent.VK_E);
          mc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
          
          
          // Add action listener 
          mi1.addActionListener(e);
          mi2.addActionListener(e);
          mi3.addActionListener(e);
          mi4.addActionListener(e);
          mc.addActionListener(e);
          m1.add(mi1);
          m1.add(mi2);
          m1.add(mi3);
          m1.add(mi4);
          m1.add(mc);

          mb.add(m1);
          
          /*
          // Create amenu for menu 
          JMenu m2 = new JMenu("Edit");

          // Create menu items 
          JMenuItem mi5 = new JMenuItem("Cut");
          JMenuItem mi6 = new JMenuItem("Copy");
          JMenuItem mi7 = new JMenuItem("Paste");

          // Add action listener 
          mi5.addActionListener(e);
          mi6.addActionListener(e);
          mi7.addActionListener(e);

          m2.add(mi5);
          m2.add(mi6);
          m2.add(mi7);

          mb.add(m2);
          */
          
          JComboBox<Integer> cbox = new JComboBox<Integer>(new Integer[] {2, 3, 4, 5, 6, 7, 8, 9, 10});
          cbox.setMaximumSize(new Dimension(100, 25));
          cbox.setEditable(true);
          cbox.setSelectedIndex(0);
          cbox.setActionCommand("fontSize");
          cbox.addActionListener(e);
          
          mb.add(cbox);
          
          return mb;
     }
     
     public JScrollPane getScrollPane()
     {
          return sp;
     }

     public static void main(String[] args)
     {
          new Window("Zenian Text Editor");
     }

}