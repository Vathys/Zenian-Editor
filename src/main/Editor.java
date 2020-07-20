package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Editor extends JPanel implements ActionListener
{
     private static final long serialVersionUID = 1L;

     private Window container;

     private ArrayList<GlyphColumn> grid;
     private int currentColumn;
     private int regSize;
     private int fontSize;
     private ArrayList<Integer> fontSizeArr;
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

     private JFileChooser fc = new JFileChooser();
     private File currentOpenFile;

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
          currentOpenFile = null;
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

     public void init(File currentOpenFile, int fontSize, Color fontColor, Color backColor)
     {
          initDone = false;
          this.currentOpenFile = currentOpenFile;
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
      * Handles button presses and adds letters accordingly
      * */
     @Override
     public void actionPerformed(ActionEvent e)
     {
          if (!paused)
          {
               if (ZenianLetter.I.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.I);
               if (ZenianLetter.Y.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.Y);
               if (ZenianLetter.E.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.E);
               if (ZenianLetter.O_WITH_STROKE.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.O_WITH_STROKE);
               if (ZenianLetter.OPEN_E.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.OPEN_E);
               if (ZenianLetter.LIGATURE_OE.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_OE);
               if (ZenianLetter.A.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.A);
               if (ZenianLetter.LIGATURE_CAPITAL_OE.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_CAPITAL_OE);
               if (ZenianLetter.T.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.T);
               if (ZenianLetter.D.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.D);
               if (ZenianLetter.T_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.T_WITH_RETROFLEX_HOOK);
               if (ZenianLetter.D_WITH_TAIL.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.D_WITH_TAIL);
               if (ZenianLetter.V_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.V_WITH_HOOK);
               if (ZenianLetter.J.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.J);
               if (ZenianLetter.TURNED_R.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.TURNED_R);
               if (ZenianLetter.THETA.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.THETA);
               if (ZenianLetter.ETH.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.ETH);
               if (ZenianLetter.S.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.S);
               if (ZenianLetter.Z.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.Z);
               if (ZenianLetter.ESH.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.ESH);
               if (ZenianLetter.EZH.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.EZH);
               if (ZenianLetter.S_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.S_WITH_HOOK);
               if (ZenianLetter.Z_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
                    grid.get(currentColumn).addLetterToLast(ZenianLetter.Z_WITH_RETROFLEX_HOOK);

               tick();
               boolean saveas = false;

               if (e.getActionCommand().equals("New"))
               {
                    init();
               }
               if (e.getActionCommand().equals("Open"))
               {
                    fc = new JFileChooser();

                    fc.setAcceptAllFileFilterUsed(false);
                    fc.setFileFilter(new FileNameExtensionFilter("Aze Files", "aze"));

                    int returnVal = fc.showOpenDialog(this);

                    if (returnVal == JFileChooser.APPROVE_OPTION)
                    {
                         File file = fc.getSelectedFile();
                         System.out.println("Opening: " + file.getName() + ".");

                         EditorSave save = GlyphReader.read(file);

                         if (save.valid())
                         {
                              loadSave(save);
                         }
                    } else
                    {
                         System.out.println("Open canceled by user");
                    }
               }
               if (e.getActionCommand().equals("Save"))
               {
                    if (currentOpenFile != null)
                    {
                         GlyphWriter.writeFile(this, currentOpenFile.getPath());
                    } else
                    {
                         saveas = true;
                    }
               }
               if (e.getActionCommand().equals("Save As") || saveas)
               {
                    fc = new JFileChooser();

                    fc.setAcceptAllFileFilterUsed(false);
                    fc.setFileFilter(new FileNameExtensionFilter("JPEG File", "jpg", "jpeg"));
                    fc.setFileFilter(new FileNameExtensionFilter("PNG File", "png"));
                    fc.setFileFilter(new FileNameExtensionFilter("Aze File", "aze"));

                    int returnVal = fc.showSaveDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION)
                    {
                         File file = fc.getSelectedFile();
                         
                         if (Utils.getExtension(file) == null)
                         {
                              String desc = fc.getFileFilter().getDescription();
                              if (desc == "JPEG File")
                              {
                                   file = new File(file.getAbsolutePath() + ".jpg");
                              } else if (desc == "PNG File")
                              {
                                   file = new File(file.getAbsolutePath() + ".png");
                              } else if (desc == "Aze File")
                              {
                                   file = new File(file.getAbsolutePath() + ".aze");
                              }
                         }
                         else
                         {
                              String ext = Utils.getExtension(file);
                              if(!ext.equals("jpg") || !ext.equals("jpeg") || !ext.equals("png") || !ext.equals("aze"))
                              {
                                   String desc = fc.getFileFilter().getDescription();
                                   System.out.println(desc);
                                   if (desc == "JPEG File")
                                   {
                                        file = new File(file.getAbsolutePath() + ".jpg");
                                   } else if (desc == "PNG File")
                                   {
                                        file = new File(file.getAbsolutePath() + ".png");
                                   } else if (desc == "Aze File")
                                   {
                                        file = new File(file.getAbsolutePath() + ".aze");
                                   }
                              }
                         }

                         String ext = Utils.getExtension(file);
                         
                         if (ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png"))
                         {
                              GlyphWriter.writeImage(this, file);
                         } else if (ext.equals("aze"))
                         {
                              GlyphWriter.writeFile(this, file);
                         }
                    }
                    saveas = false;
               }
               if (e.getActionCommand().equals("Close"))
               {
                    container.dispose();
               }
               if (e.getActionCommand().equals("fontSize"))
               {
                    JComboBox<Integer> source = (JComboBox<Integer>) e.getSource();
                    fontSize = fontSizeArr.get(source.getSelectedIndex());
               }
          }
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

               Rectangle viewRect = container.getScrollPane().getViewport().getViewRect();
               JScrollBar horSB = container.getScrollPane().getHorizontalScrollBar();

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
}
