package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JScrollBar;

public class GlyphColumn implements Cloneable
{
     private Editor editor;
     private ArrayList<Glyph> column;
     private int startX;
     private int startY;
     private int currentHeight;
     public int cellWidth;
     private int heightLimit;
     private int fontSize;
     private Color fontColor;

     public GlyphColumn(Editor container, int startX, int startY, int cellWidth, int fontSize, Color fontColor, int maximumHeight)
     {
          this.editor = container;
          this.startX = startX;
          this.startY = startY;
          this.currentHeight = startY + cellWidth;
          this.cellWidth = cellWidth;
          this.heightLimit = maximumHeight;
          this.fontSize = fontSize;
          this.fontColor = fontColor;

          this.column = new ArrayList<Glyph>();
          column.add(new Glyph(this));
     }

     public GlyphColumn(Editor container, int startX, int startY, int cellWidth, int fontSize, Color fontColor, int maximumHeight, Glyph startGlyph)
     {
          this.editor = container;
          this.startX = startX;
          this.startY = startY;
          this.currentHeight = startY + cellWidth;
          this.cellWidth = cellWidth;
          this.heightLimit = maximumHeight;
          this.fontSize = fontSize;
          this.fontColor = fontColor;

          this.column = new ArrayList<Glyph>();
          startGlyph.updateGC(this);
          column.add(startGlyph);
          //this.addGlyph(startGlyph);
          this.checkHeight();
     }

     //TODO: problems with preRendering and backspace
     //Didn't really see the problem right now... maybe will encounter later
     public void preRender()
     {
          for (Glyph gl : column)
          {
               gl.preRender();
          }
     }

     public void render(Graphics g)
     {
          for (Glyph gl : column)
          {
               gl.preRender();
               gl.render(g);
          }
          //drawDebug(g);
     }

     @SuppressWarnings("unused")
     private void drawDebug(Graphics g)
     {
          g.setColor(Color.RED);

          int totalHeight = getTotalHeight();

          g.drawLine(startX, 0, startX, heightLimit);
          g.drawLine(startX + (cellWidth / 2), 0, startX + (cellWidth / 2), heightLimit);
          g.drawLine(cellWidth + startX, 0, cellWidth + startX, heightLimit);

          g.drawLine(0, fontSize * 10, cellWidth + startX, fontSize * 10);
          g.drawLine(0, totalHeight, cellWidth + startX, totalHeight);
          g.setColor(Color.GREEN);
          g.drawLine(0, currentHeight, cellWidth + startX, currentHeight);
     }

     public int getStartX()
     {
          return startX;
     }

     public int getStartY()
     {
          return startY;
     }

     public int getCurrentHeight()
     {
          return currentHeight;
     }

     public ArrayList<Glyph> getColumn()
     {
          return column;
     }

     public int getFontSize()
     {
          return fontSize;
     }

     public Color getFontColor()
     {
          return fontColor;
     }

     public void updateHeight(int update)
     {
          currentHeight += update;
     }

     public int getTotalHeight()
     {
          int totalHeight = 0;
          for (Glyph gl : column)
          {
               totalHeight += gl.getHeight();
          }

          return totalHeight;
     }

     public void checkHeight()
     {
          Rectangle viewRect = editor.getScrollPane().getViewport().getViewRect();
          JScrollBar vertSB = editor.getScrollPane().getVerticalScrollBar();

          if (currentHeight > heightLimit)
          {
               editor.toggleElement("runover", true);
          }
          if (viewRect.getY() + viewRect.getHeight() < currentHeight)
          {
               vertSB.setValue(vertSB.getValue() + column.get(column.size() - 1).getHeight());
          }
     }

     public void addGlyph()
     {
          updateHeight(fontSize * 18);
          column.add(new Glyph(this));
     }

     public void addGlyph(Glyph g)
     {
          g.updateGC(this);
          updateHeight(fontSize * 18);
          column.add(g);
     }

     public void addLetterToLast(ZenianLetter z)
     {
          column.get(column.size() - 1).addLetter(z);
          this.checkHeight();
     }

     public boolean removeLastLetter()
     {
          try
          {
               column.get(column.size() - 1).removeLastLetter();
               return true;
          } catch (ArrayIndexOutOfBoundsException e)
          {
               return false;
          }
     }

     public Glyph removeLastGlyph() throws ArrayIndexOutOfBoundsException
     {
          updateHeight(fontSize * -18);
          return column.remove(column.size() - 1);
     }

     public int columnSize()
     {
          return column.size();
     }

     public String[] writeColumn()
     {
          String[] id = new String[column.size() + 1];

          id[0] = "TotalGlyph: " + Integer.toString(column.size()) + ";";
          
          for (int i = 0; i < column.size(); i++)
          {
               id[i + 1] = column.get(i).writeGlyph();
          }

          return id;
     }

     @Override
     public GlyphColumn clone() throws CloneNotSupportedException
     {
          GlyphColumn clone = new GlyphColumn(editor, startX, startY, cellWidth, fontSize, fontColor, heightLimit);
          for (Glyph g : column)
          {
               clone.addGlyph(g.clone());
          }
          return clone;
     }
}
