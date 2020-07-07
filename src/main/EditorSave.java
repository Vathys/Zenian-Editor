package main;

import java.awt.Color;
import java.util.ArrayList;

public class EditorSave
{
     private int fontSize;
     private Color fontColor;
     private Color backColor;
     private ArrayList<ArrayList<ZenianLetter[]>> grid;
     
     public EditorSave()
     {
          grid = new ArrayList<ArrayList<ZenianLetter[]>>();
     }
     
     /**
      * @return the fontSize
      */
     public int getFontSize()
     {
          return fontSize;
     }
     
     /**
      * @param fontSize the fontSize to set
      */
     public void setFontSize(int fontSize)
     {
          this.fontSize = fontSize;
     }
     
     /**
      * @return the fontColor
      */
     public Color getFontColor()
     {
          return fontColor;
     }
     
     /**
      * @param fontColor the fontColor to set
      */
     public void setFontColor(Color fontColor)
     {
          this.fontColor = fontColor;
     }
     
     /**
      * @return the backColor
      */
     public Color getBackColor()
     {
          return backColor;
     }
     
     /**
      * @param backColor the backColor to set
      */
     public void setBackColor(Color backColor)
     {
          this.backColor = backColor;
     }
     
     /**
      * @return the grid
      */
     public ArrayList<ArrayList<ZenianLetter[]>> getGrid()
     {
          return grid;
     }
     
     public void addColumn(ArrayList<ZenianLetter[]> col)
     {
          grid.add(col);
     }

     public void printGrid()
     {
          System.out.println("Font Size: " + fontSize);
          System.out.println("Font Color: " + "(" + fontColor.getRed() + ", " + fontColor.getGreen() + ", " + fontColor.getBlue() + ")");
          System.out.println("Background Color: " + "(" + backColor.getRed() + ", " + backColor.getGreen() + ", " + backColor.getBlue() + ")");
          
          for (int i = 0; i < grid.size(); i++)
          {
               for (int j = 0; j < grid.get(i).size(); j++)
               {
                    printGlyph(grid.get(i).get(j));
               }
               System.out.println("");
          }
     }
     
     private void printGlyph(ZenianLetter[] glyph)
     {
          System.out.print("[" + glyph[0]);
          for (int i = 1; i < glyph.length; i++)
          {
               System.out.print(", " + glyph[i]);
          }
          System.out.println("]");
     }
}
