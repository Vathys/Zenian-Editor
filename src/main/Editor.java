package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class Editor extends JPanel implements ActionListener
{
     private static final long serialVersionUID = 1L;
     
     private Window container;
     
     private ArrayList<GlyphColumn> grid;
     private int currentColumn;
     private int fontSize;
     
     private Image buffImage;
     private Graphics offscreen;
     boolean initDone = false;
     
     private static boolean newGlyph;
     private static boolean runover;
     private static boolean newColumn;
     private static boolean backspace;
     
     public Editor(Window container)
     {
          super();
          this.container = container;
          this.setBackground(Color.BLACK);
     }
     
     /*
      * Initialize variables
      * */
     public void init()
     {
          fontSize = 5;
          grid = new ArrayList<GlyphColumn>();
          grid.add(new GlyphColumn(container, fontSize * 10, fontSize * 10, fontSize * 8, fontSize, this.getSize().height));
          currentColumn = 0;
          newGlyph = false;
          runover = false;
          newColumn = false;
          backspace = false;
          
          tick();
     }
     
     /*
      * Prepares JPanel with buttons
      * */
     public JPanel prepareButtonPanel()
     {
          JPanel buttonPanel = new JPanel(new GridBagLayout());
          buttonPanel.setPreferredSize(new Dimension(container.WIDTH, container.HEIGHT / 3));
          buttonPanel.setFocusable(false);
          GridBagConstraints g = new GridBagConstraints();
          g.fill = GridBagConstraints.BOTH;
          g.insets = new Insets(5, 5, 5, 5);
          
          JButton button;
          
          ZenianLetter[] names = ZenianLetter.values();
          
          Font zenian;
          try
          {
               zenian = Font.createFont(Font.TRUETYPE_FONT, new File("res/ZenianRegular.ttf"));
               
               zenian = zenian.deriveFont(25f);
               
               for(int i = 0; i < 8; i++)
               {
                    button = new JButton(names[i + 1].getCharacter());
                    g.weightx = .5;
                    g.weighty = .5;
                    g.gridx = i;
                    g.gridy = 0;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1].getCharacter());
                    button.addActionListener(this);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
               for(int i = 0; i < 4; i++)
               {
                    button = new JButton(names[i + 1 + 8].getCharacter());
                    g.weightx = 0;
                    g.weighty = .5;
                    g.gridx = i + 2;
                    g.gridy = 1;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1 + 8].getCharacter());
                    button.addActionListener(this);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
               for(int i = 0; i < 8; i++)
               {
                    button = new JButton(names[i + 1 + 8 + 4].getCharacter());
                    g.weightx = .5;
                    g.weighty = .5;
                    g.gridx = i;
                    g.gridy = 2;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1 + 8 + 4].getCharacter());
                    button.addActionListener(this);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
               for(int i = 0; i < 2; i++)
               {
                    button = new JButton(names[i + 1 + 8 + 4 + 8].getCharacter());
                    g.weightx = 0;
                    g.weighty = .5;
                    g.gridx = i + 3;
                    g.gridy = 3;
                    button.setFont(zenian);
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setActionCommand(names[i + 1 + 8 + 4 + 8].getCharacter());
                    button.addActionListener(this);
                    button.setFocusable(false);
                    buttonPanel.add(button, g);
               }
          } catch (Exception e)
          {
               e.printStackTrace();
          }
          
          return buttonPanel;
     }
     
     /*
      * Handles button presses and adds letters accordingly
      * */
     @Override
     public void actionPerformed(ActionEvent e)
     {     
          if(ZenianLetter.I.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.I);
          if(ZenianLetter.Y.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Y);
          if(ZenianLetter.E.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.E);
          if(ZenianLetter.O_WITH_STROKE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.O_WITH_STROKE);
          if(ZenianLetter.OPEN_E.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.OPEN_E);
          if(ZenianLetter.LIGATURE_OE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_OE);
          if(ZenianLetter.A.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.A);
          if(ZenianLetter.LIGATURE_CAPITAL_OE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_CAPITAL_OE);
          if(ZenianLetter.T.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.T);
          if(ZenianLetter.D.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.D);
          if(ZenianLetter.T_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.T_WITH_RETROFLEX_HOOK);
          if(ZenianLetter.D_WITH_TAIL.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.D_WITH_TAIL);
          if(ZenianLetter.THETA.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.THETA);
          if(ZenianLetter.ETH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.ETH);
          if(ZenianLetter.S.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.S);
          if(ZenianLetter.Z.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Z);
          if(ZenianLetter.ESH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.ESH);
          if(ZenianLetter.EZH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.EZH);
          if(ZenianLetter.S_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.S_WITH_HOOK);
          if(ZenianLetter.Z_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Z_WITH_RETROFLEX_HOOK);
          if(ZenianLetter.V_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.V_WITH_HOOK);
          if(ZenianLetter.J.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.J);
          
          tick();
     }
     
     /*
      * Gets called after every change made
      * Calls repaint
      * */
     public void tick()
     {
          if(newGlyph)
          {
               grid.get(currentColumn).addGlyph();
               newGlyph = false;
          }
          if(runover)
          {
               int newX = 50;
               for(int i = 0; i < grid.size(); i++)
               {
                    newX += grid.get(i).cellWidth + fontSize * 10;
               }
               grid.add(new GlyphColumn(container, newX, fontSize * 10, fontSize * 8, 5, this.getSize().height, grid.get(currentColumn).removeLastGlyph()));
               currentColumn += 1;
               
               runover = false;
          }
          if(newColumn)
          {
               int newX = fontSize * 10;
               for(int i = 0; i < grid.size(); i++)
               {
                    newX += grid.get(i).cellWidth + (fontSize * 10);
               }
               grid.add(new GlyphColumn(container, newX, fontSize * 10, fontSize * 8, fontSize, this.getSize().height));
               currentColumn += 1;
               
               Rectangle viewRect = container.getScrollPane().getViewport().getViewRect();
               JScrollBar horSB = container.getScrollPane().getHorizontalScrollBar();
               
               if(viewRect.getX() + viewRect.getWidth() < newX)
               {
                    horSB.setValue(horSB.getValue() + (fontSize * 18));
               }
               
               newColumn = false;
          }
          if(backspace)
          {
               try {
                    if(!grid.get(currentColumn).removeLastLetter())
                    {
                         grid.get(currentColumn).removeLastGlyph();
                         if(grid.get(currentColumn).columnSize() == 0)
                         {
                              grid.remove(currentColumn);
                              currentColumn -= 1;
                              if(grid.size() == 0)
                              {
                                   newColumn = true;
                              }
                         }
                    }
               } catch (Exception e1)
               {}
               backspace = false;
               tick();
          }
          
          
          repaint();
     }
     
     /*
      * Initial paint instructions on Canvas
      * */
     @Override
     public void paint(Graphics g)
     {
          if(!initDone)
          {
               initPaint(g);
          }
          else
          {
               offscreen = buffImage.getGraphics();
               offscreen.setColor(Color.BLACK);
               offscreen.fillRect(0, 0, this.getSize().width, this.getSize().height);
               
               for(GlyphColumn a : grid)
               {
                    a.preRender();
                    a.render(offscreen);
               }
               
               offscreen.dispose();
               
               g.drawImage(buffImage, 0, 0, Color.BLACK, this);
          }
     }
     
     public void initPaint(Graphics g)
     {
          try
          {
               buffImage = this.createImage(this.getSize().width, this.getSize().height);
               offscreen = buffImage.getGraphics();
               offscreen.setColor(Color.BLACK);
               offscreen.fillRect(0, 0, this.getSize().width, this.getSize().height);
               
               for(GlyphColumn a : grid)
               {
                    a.preRender();
                    a.render(offscreen);
               }
               
               initDone = true;
               
               offscreen.dispose();
               
               g.drawImage(buffImage, 0, 0, this);
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
     }
     
     public static void toggleElement(String element, boolean value)
     {
          if(element.equals("newGlyph"))
          {
               newGlyph = value;
          }
          if(element.equals("runover"))
          {
               runover = value;
          }
          if(element.equals("newColumn"))
          {
               newColumn = value;
          }
          if(element.equals("backspace"))
          {
               backspace = value;
          }
     }

     public static boolean getValue(String element)
     {
          if(element.equals("newGlyph"))
          {
               return newGlyph;
          }
          else if(element.equals("runover"))
          {
               return runover;
          }
          else if(element.equals("newColumn"))
          {
               return newColumn;
          }
          else if(element.equals("backspace"))
          {
               return backspace;
          }
          else
          {
               return false;
          }
     }
}
