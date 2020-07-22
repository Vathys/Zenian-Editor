package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Editor extends JPanel
{
     private static final long serialVersionUID = 1L;

     private Window container;
     private JScrollPane scrollPane;

     private ArrayList<GlyphColumn> grid;
     private int currentColumn;
     private int regSize;
     private int fontSize;
     private Color fontColor;
     private Color backColor;

     private Image buffImage;
     private Graphics offscreen;
     private boolean initDone;

     private boolean newGlyph;
     private boolean runover;
     private boolean newColumn;
     private boolean backspace;
     public boolean paused = false;

     private File editorFile;

     public Editor(Window container)
     {
          super();
          this.container = container;
     }

     /*
      * Initialize variables
      * */
     public void init()
     {
          initDone = false;
          editorFile = null;
          regSize = 2;
          fontSize = regSize * 2;
          fontColor = Color.WHITE;
          backColor = Color.BLACK;
          grid = new ArrayList<GlyphColumn>();
          grid.add(new GlyphColumn(this, fontSize * 10, fontSize * 10, fontSize * 8, fontSize, fontColor, container.HEIGHT));
          currentColumn = 0;
          newGlyph = false;
          runover = false;
          newColumn = false;
          backspace = false;

          tick();
     }

     public void init(File editorFile, int fontSize, Color fontColor, Color backColor)
     {
          initDone = false;
          this.editorFile = editorFile;
          regSize = fontSize / 2;
          this.fontSize = fontSize;
          this.fontColor = fontColor;
          this.backColor = backColor;
          grid = new ArrayList<GlyphColumn>();
          grid.add(new GlyphColumn(this, fontSize * 10, fontSize * 10, fontSize * 8, fontSize, fontColor, container.HEIGHT));
          currentColumn = 0;
          newGlyph = false;
          runover = false;
          newColumn = false;
          backspace = false;

          tick();
     }

     /*
      * Gets called after every change made
      * Calls repaint
      * */
     public void tick()
     {
          if (newGlyph)
          {
               grid.get(currentColumn).addGlyph();
               grid.get(currentColumn).checkHeight();
               newGlyph = false;
          }
          if (runover)
          {
               int newX = fontSize * 10;
               for (int i = 0; i < grid.size(); i++)
               {
                    newX += grid.get(i).cellWidth + (fontSize * 10);
               }
               grid.add(new GlyphColumn(this, newX, fontSize * 10, fontSize * 8, fontSize, fontColor, container.HEIGHT, grid.get(currentColumn).removeLastGlyph()));
               currentColumn += 1;

               runover = false;
          }
          if (newColumn)
          {
               int newX = fontSize * 10;
               for (int i = 0; i < grid.size(); i++)
               {
                    newX += grid.get(i).cellWidth + (fontSize * 10);
               }
               grid.add(new GlyphColumn(this, newX, fontSize * 10, fontSize * 8, fontSize, fontColor, container.HEIGHT));
               currentColumn += 1;

               Rectangle viewRect = scrollPane.getViewport().getViewRect();
               JScrollBar horSB = scrollPane.getHorizontalScrollBar();

               if (viewRect.getX() + viewRect.getWidth() < newX)
               {
                    horSB.setValue(horSB.getValue() + (fontSize * 18));
               }

               newColumn = false;
          }
          if (backspace)
          {
               try
               {
                    if (!grid.get(currentColumn).removeLastLetter())
                    {
                         grid.get(currentColumn).removeLastGlyph();
                         if (grid.get(currentColumn).columnSize() == 0)
                         {
                              grid.remove(currentColumn);
                              currentColumn -= 1;
                              if (grid.size() == 0)
                              {
                                   newColumn = true;
                              }
                         }
                    }
               } catch (Exception e1)
               {
               }
               backspace = false;
               tick();
          }

          this.repaint();
     }

     /*
      * Repeating instructions/render function
      * */
     @Override
     public void paint(Graphics g)
     {
          super.paint(g);
          if (!initDone)
          {
               initPaint(g);
          } else
          {
               offscreen = buffImage.getGraphics();
               offscreen.setColor(backColor);
               offscreen.fillRect(0, 0, this.getSize().width, this.getSize().height);

               for (GlyphColumn a : grid)
               {
                    a.preRender();
                    a.render(offscreen);
               }

               offscreen.dispose();

               g.drawImage(buffImage, 0, 0, backColor, this);
          }
     }

     public void initPaint(Graphics g)
     {
          try
          {
               buffImage = this.createImage(this.getSize().width, this.getSize().height);
               offscreen = buffImage.getGraphics();
               offscreen.setColor(backColor);
               offscreen.fillRect(0, 0, this.getSize().width, this.getSize().height);

               for (GlyphColumn a : grid)
               {
                    a.preRender();
                    a.render(offscreen);
               }

               initDone = true;

               offscreen.dispose();

               g.drawImage(buffImage, 0, 0, backColor, this);
          } catch (Exception e)
          {
               e.printStackTrace();
          }
     }

     public void clear()
     {
          init();
     }

     public void loadSave(EditorSave save)
     {
          //save.printGrid();

          paused = true;

          init(save.getFile(), save.getFontSize(), save.getFontColor(), save.getBackColor());

          for (int i = 0; i < save.getGrid().size(); i++)
          {
               for (int j = 0; j < save.getGrid().get(i).size(); j++)
               {
                    for (int k = 0; k < save.getGrid().get(i).get(j).length; k++)
                    {
                         grid.get(currentColumn).addLetterToLast(save.getGrid().get(i).get(j)[k]);
                         grid.get(currentColumn).preRender();
                         tick();
                    }
                    if (j != save.getGrid().get(i).size() - 1)
                    {
                         toggleElement("newGlyph", true);
                         tick();
                    }
               }
               if (i != save.getGrid().size() - 1)
               {
                    toggleElement("newColumn", true);
                    tick();
               }
          }

          paused = false;

     }

     public Window getWindow()
     {
          return container;
     }

     public ArrayList<GlyphColumn> getGrid()
     {
          return grid;
     }

     public void addLetterToLast(ZenianLetter letter)
     {
          grid.get(currentColumn).addLetterToLast(letter);
     }

     public int getFontSize()
     {
          return fontSize;
     }

     public Color getFontColor()
     {
          return fontColor;
     }

     public Color getBackColor()
     {
          return backColor;
     }

     public File getEditorFile()
     {
          return editorFile;
     }

     public void setEditorFile(File file)
     {
          editorFile = file;
     }
     
     public void toggleElement(String element, boolean value)
     {
          if (element.equals("newGlyph"))
          {
               newGlyph = value;
          }
          if (element.equals("runover"))
          {
               runover = value;
          }
          if (element.equals("newColumn"))
          {
               newColumn = value;
          }
          if (element.equals("backspace"))
          {
               backspace = value;
          }
     }

     public boolean getValue(String element)
     {
          if (element.equals("newGlyph"))
          {
               return newGlyph;
          } else if (element.equals("runover"))
          {
               return runover;
          } else if (element.equals("newColumn"))
          {
               return newColumn;
          } else if (element.equals("backspace"))
          {
               return backspace;
          } else
          {
               return false;
          }
     }

     public void setScrollPane(JScrollPane scpane)
     {
          scrollPane = scpane;
     }

     public JScrollPane getScrollPane()
     {
          return scrollPane;
     }
}
