package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class GlyphColumn
{
     private ArrayList<Glyph> column;
     private int startX;
     private int currentHeight;
     public int cellWidth;
     private int heightLimit;
     private int fontSize;
     
     public GlyphColumn(int startX, int startY, int cellWidth, int fontSize, int maximumHeight)
     {
          this.startX = startX;
          this.currentHeight = startY + cellWidth;
          this.cellWidth = cellWidth;
          this.heightLimit = maximumHeight;
          this.fontSize = fontSize;
          
          this.column = new ArrayList<Glyph>();
          column.add(new Glyph(this));
     }
     
     public GlyphColumn(int startX, int startY, int cellWidth, int fontSize, int maximumHeight, Glyph startGlyph)
     {
          this.startX = startX;
          this.currentHeight = startY + cellWidth;
          this.cellWidth = cellWidth;
          this.heightLimit = maximumHeight;
          this.fontSize = fontSize;
          
          this.column = new ArrayList<Glyph>();
          startGlyph.updateGC(this);
          column.add(startGlyph);
          this.currentHeight = getTotalHeight();
     }

     public void preRender()
     {
          for(int i = column.size() - 1; i >= 0; i--)
          {
               column.get(i).preRender();
          }
     }
     
     public void render(Graphics g)
     {
          for(Glyph gl : column)
          {
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
     
     public int getCurrentHeight()
     {
          return currentHeight;
     }
     
     public int getFontSize()
     {
          return fontSize;
     }
     
     public void updateHeight(int update)
     {
          currentHeight += update;
     }

     private int getTotalHeight()
     {
          int totalHeight = 0;
          for(Glyph gl : column)
          {
               totalHeight += gl.getHeight();
          }
          
          return totalHeight;
     }
     
     public void checkHeight()
     {
          if(currentHeight > heightLimit)
          {
               Editor.toggleValue("runover");
          }
     }
     
     public void addGlyph()
     {
          updateHeight(fontSize * 18);
          column.add(new Glyph(this));
          checkHeight();
     }
     
     public void addGlyph(Glyph g)
     {
          g.updateGC(this);
          updateHeight(fontSize * 18);
          column.add(g);
          checkHeight();
     }
     
     public void addLetterToLast(ZenianLetter z)
     {
          column.get(column.size() - 1).addLetter(z);
     }
     
     public boolean removeLastLetter()
     {
          try
          {
               column.get(column.size() - 1).removeLastLetter();
               return true;
          } catch(ArrayIndexOutOfBoundsException e)
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
}
