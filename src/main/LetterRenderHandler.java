package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.geom.GeneralPath;
import java.util.HashMap;

public class LetterRenderHandler
{
     private HashMap<Key, Object> defaultRenderHints;
     private Color fontColor;
     
     public LetterRenderHandler(Color fontColor)
     {
          defaultRenderHints = new HashMap<Key, Object>();
          defaultRenderHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          defaultRenderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
          
          this.fontColor = fontColor;
     }
     
     /*
      * Each method displays one letter
      * @param: Graphics2D g,
      *   int x: x position of the glyph
      *   int y: y position of the glyph
      *   int xOff: current x offset of the glyph
      *   int yOff: current y offset of the glyph
      * @return: 
      *   int[] :
      *        {new_x, new_y, new_xOff, new_yOff}
      * */
     
     //I
     public int[] renderU0069(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Dot
          p.moveTo(x + xOff - 5, y);
          p.lineTo(x + xOff, y + 5);
          p.lineTo(x + xOff + 5, y);
          p.lineTo(x + xOff, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff - 5, y);
          p.lineTo(x - xOff, y + 5);
          p.lineTo(x - xOff + 5, y);
          p.lineTo(x - xOff, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 5};
          
          return newOff;
     }

     //Y
     public int[] renderU0079(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Horizontal Line
          p.moveTo(x + xOff - 10, y + 2.5);
          p.lineTo(x + xOff + 10, y + 2.5);
          p.lineTo(x + xOff + 10, y - 2.5);
          p.lineTo(x + xOff - 10, y - 2.5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Horizaontal Line
          p.moveTo(x - xOff + 10, y + 2.5);
          p.lineTo(x - xOff - 10, y + 2.5);
          p.lineTo(x - xOff - 10, y - 2.5);
          p.lineTo(x - xOff + 10, y - 2.5);
          p.closePath();
          
          gi.fill(p);
          
          //Right Dot
          p.moveTo(x + xOff + 15, y);
          p.lineTo(x + xOff + 20, y + 5);
          p.lineTo(x + xOff + 25, y);
          p.lineTo(x + xOff + 20, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff - 15, y);
          p.lineTo(x - xOff - 20, y + 5);
          p.lineTo(x - xOff - 25, y);
          p.lineTo(x - xOff - 20, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 40, yOff + 5};
          
          return newOff;
     }
     
     //E
     public int[] renderU0065(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Dot
          p.moveTo(x + xOff - 5, y - yOff + 10);
          p.lineTo(x + xOff, y - yOff + 5);
          p.lineTo(x + xOff + 5, y - yOff + 10);
          p.lineTo(x + xOff, y - yOff + 15);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff + 5, y - yOff + 10);
          p.lineTo(x - xOff, y - yOff + 5);
          p.lineTo(x - xOff - 5, y - yOff + 10);
          p.lineTo(x - xOff, y - yOff + 15);
          p.closePath();
          
          gi.fill(p);
          
          //Right Vertical Line
          p.moveTo(x + xOff - 2.5, y - yOff + 20);
          p.lineTo(x + xOff + 2.5, y - yOff + 20);
          p.lineTo(x + xOff + 2.5, y + yOff - 5);
          p.lineTo(x + xOff - 2.5, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Vertical Line
          p.moveTo(x - xOff + 2.5, y - yOff + 20);
          p.lineTo(x - xOff - 2.5, y - yOff + 20);
          p.lineTo(x - xOff - 2.5, y + yOff - 5);
          p.lineTo(x - xOff + 2.5, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 5};
          
          return newOff;
     }
     
     //O_WITH_STROKE
     public int[] renderU00F8(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Dot
          p.moveTo(x + xOff - 5, y - yOff);
          p.lineTo(x + xOff, y - yOff - 5);
          p.lineTo(x + xOff + 5, y - yOff);
          p.lineTo(x + xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff + 5, y - yOff);
          p.lineTo(x - xOff, y - yOff - 5);
          p.lineTo(x - xOff - 5, y - yOff);
          p.lineTo(x - xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Long Horizontal Line
          p.moveTo(x + xOff - 10, y - yOff - 2.5);
          p.lineTo(x + xOff - 10, y - yOff + 2.5);
          p.lineTo(x - xOff + 10, y - yOff + 2.5);
          p.lineTo(x - xOff + 10, y - yOff - 2.5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 20};
          
          return newOff;
     }
     
     //OPEN_E
     public int[] renderU025B(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Dot
          p.moveTo(x + xOff - 5, y + yOff - 10);
          p.lineTo(x + xOff, y + yOff - 5);
          p.lineTo(x + xOff + 5, y + yOff - 10);
          p.lineTo(x + xOff, y + yOff - 15);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff + 5, y + yOff - 10);
          p.lineTo(x - xOff, y + yOff - 5);
          p.lineTo(x - xOff - 5, y + yOff - 10);
          p.lineTo(x - xOff, y + yOff - 15);
          p.closePath();
          
          gi.fill(p);
          
          //Right Vertical Line
          p.moveTo(x + xOff - 2.5, y + yOff - 20);
          p.lineTo(x + xOff + 2.5, y + yOff - 20);
          p.lineTo(x + xOff + 2.5, y - yOff + 5);
          p.lineTo(x + xOff - 2.5, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + 2.5, y + yOff - 20);
          p.lineTo(x - xOff - 2.5, y + yOff - 20);
          p.lineTo(x - xOff - 2.5, y - yOff + 5);
          p.lineTo(x - xOff + 2.5, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 5};
          
          return newOff;
     }
          
     //LIGATURE_OE
     public int[] renderU0153(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();

          //Right Dot
          p.moveTo(x + xOff - 5, y + yOff);
          p.lineTo(x + xOff, y + yOff + 5);
          p.lineTo(x + xOff + 5, y + yOff);
          p.lineTo(x + xOff, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Dot
          p.moveTo(x - xOff + 5, y + yOff);
          p.lineTo(x - xOff, y + yOff + 5);
          p.lineTo(x - xOff - 5, y + yOff);
          p.lineTo(x - xOff, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Long Horizontal Line
          p.moveTo(x + xOff - 10, y + yOff + 2.5);
          p.lineTo(x + xOff - 10, y + yOff - 2.5);
          p.lineTo(x - xOff + 10, y + yOff - 2.5);
          p.lineTo(x - xOff + 10, y + yOff + 2.5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 20};
          
          return newOff;
     }
     
     //A
     public int[] renderU0061(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Dot
          p.moveTo(x, y - yOff + 5);
          p.lineTo(x - 5, y - yOff);
          p.lineTo(x, y - yOff - 5);
          p.lineTo(x + 5, y - yOff);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Dot
          p.moveTo(x, y + yOff + 5);
          p.lineTo(x - 5, y + yOff);
          p.lineTo(x, y + yOff - 5);
          p.lineTo(x + 5, y + yOff);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 5, yOff + 20};
          
          return newOff;
     }
     
     //LIGATURE_CAPITAL_OE
     public int[] renderU0276(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Horizontal Line
          p.moveTo(x - 2.5, y - yOff + 10);
          p.lineTo(x - 2.5, y - yOff - 10);
          p.lineTo(x + 2.5, y - yOff - 10);
          p.lineTo(x + 2.5, y - yOff + 10);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Horizontal Line
          p.moveTo(x - 2.5, y + yOff - 10);
          p.lineTo(x - 2.5, y + yOff + 10);
          p.lineTo(x + 2.5, y + yOff + 10);
          p.lineTo(x + 2.5, y + yOff - 10);
          p.closePath();
          
          gi.fill(p);
          
          //Upper Dot
          p.moveTo(x, y - yOff - 15);
          p.lineTo(x - 5, y - yOff - 20);
          p.lineTo(x, y - yOff - 25);
          p.lineTo(x + 5, y - yOff - 20);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Dot
          p.moveTo(x, y + yOff + 15);
          p.lineTo(x - 5, y + yOff + 20);
          p.lineTo(x, y + yOff + 25);
          p.lineTo(x + 5, y + yOff + 20);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 5, yOff + 40};
          
          return newOff;
     }
     
     //T
     public int[] renderU0074(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y - 5);
          p.lineTo(x + xOff - 10, y);
          p.lineTo(x + xOff + 30, y + 15);
          p.lineTo(x + xOff + 30, y + 10);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y - 5);
          p.lineTo(x - xOff + 10, y);
          p.lineTo(x - xOff - 30, y + 15);
          p.lineTo(x - xOff - 30, y + 10);
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 45, yOff + 5};
          
          return newOff;
     }
     
     //D
     public int[] renderU0064(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y + 5);
          p.lineTo(x + xOff - 10, y);
          p.lineTo(x + xOff + 30, y - 15);
          p.lineTo(x + xOff + 30, y - 10);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y + 5);
          p.lineTo(x - xOff + 10, y);
          p.lineTo(x - xOff - 30, y - 15);
          p.lineTo(x - xOff - 30, y - 10);
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 45, yOff + 5};
          
          return newOff;
     }
     
     //T_WITH_RETROFLEX_HOOK
     public int[] renderU0288(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y);
          p.lineTo(x + xOff + 15, y + 15);
          p.lineTo(x + xOff + 40, y);
          p.lineTo(x + xOff + 40, y - 5);
          p.lineTo(x + xOff + 15, y + 10);
          p.lineTo(x + xOff - 10, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y);
          p.lineTo(x - xOff - 15, y + 15);
          p.lineTo(x - xOff - 40, y);
          p.lineTo(x - xOff - 40, y - 5);
          p.lineTo(x - xOff - 15, y + 10);
          p.lineTo(x - xOff + 10, y - 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 55, yOff + 5};
          
          return newOff;
     }
     
     //D_WITH_TAIL
     public int[] renderU0256(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y);
          p.lineTo(x + xOff + 15, y - 15);
          p.lineTo(x + xOff + 40, y);
          p.lineTo(x + xOff + 40, y + 5);
          p.lineTo(x + xOff + 15, y - 10);
          p.lineTo(x + xOff - 10, y + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y);
          p.lineTo(x - xOff - 15, y - 15);
          p.lineTo(x - xOff - 40, y);
          p.lineTo(x - xOff - 40, y + 5);
          p.lineTo(x - xOff - 15, y - 10);
          p.lineTo(x - xOff + 10, y + 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 55, yOff + 5};
          
          return newOff;
     }
     
     //THETA
     public int[] renderU03B8(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Curve
          p.moveTo(x + xOff - 5, y - yOff + 5);
          p.quadTo(x, y - yOff + 15, x - xOff + 5, y - yOff + 5);
          p.lineTo(x - xOff + 5, y - yOff);
          p.quadTo(x, y - yOff + 10, x + xOff - 5, y - yOff);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Curve
          p.moveTo(x + xOff - 5, y + yOff - 5);
          p.quadTo(x, y + yOff - 15, x - xOff + 5, y + yOff - 5);
          p.lineTo(x - xOff + 5, y + yOff);
          p.quadTo(x, y + yOff - 10, x + xOff - 5, y + yOff);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 5, yOff + 20};
          
          return newOff;
     }
     
     //ETH
     public int[] renderU00F0(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Curve
          p.moveTo(x + xOff - 5, y - yOff + 5);
          p.quadTo(x, y - yOff - 5, x - xOff + 5, y - yOff + 5);
          p.lineTo(x - xOff + 5, y - yOff);
          p.quadTo(x, y - yOff - 10, x + xOff - 5, y - yOff);
          p.closePath();
          
          gi.fill(p);
          
          p.moveTo(x + xOff - 5, y + yOff - 5);
          p.quadTo(x, y + yOff + 5, x - xOff + 5, y + yOff - 5);
          p.lineTo(x - xOff + 5, y + yOff);
          p.quadTo(x, y + yOff + 10, x + xOff - 5, y + yOff);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 5, yOff + 20};
          
          return newOff;
     }
     
     //S
     public int[] renderU0073(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Curve
          p.moveTo(x + xOff - 5, y - yOff + 5);
          p.quadTo(x + xOff - 15, y, x + xOff - 5, y + yOff - 5);
          p.lineTo(x + xOff, y + yOff - 5);
          p.quadTo(x + xOff - 10, y, x + xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Curve
          p.moveTo(x - xOff + 5, y - yOff + 5);
          p.quadTo(x - xOff + 15, y, x - xOff + 5, y + yOff - 5);
          p.lineTo(x - xOff, y + yOff - 5);
          p.quadTo(x - xOff + 10, y, x - xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 5};
          
          return newOff;
     }
     
     //Z
     public int[] renderU007A(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Upper Curve
          p.moveTo(x + xOff - 5, y - yOff + 5);
          p.quadTo(x + xOff + 5, y, x + xOff - 5, y + yOff - 5);
          p.lineTo(x + xOff, y + yOff - 5);
          p.quadTo(x + xOff + 10, y, x + xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Lower Curve
          p.moveTo(x - xOff + 5, y - yOff + 5);
          p.quadTo(x - xOff - 5, y, x - xOff + 5, y + yOff - 5);
          p.lineTo(x - xOff, y + yOff - 5);
          p.quadTo(x - xOff - 10, y, x - xOff, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 20, yOff + 5};
          
          return newOff;
     }
     
     //ESH
     public int[] renderU0283(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Curve
          p.moveTo(x + xOff - 15, y - yOff);
          p.quadTo(x + xOff - 15, y - yOff + 15, x + xOff, y - yOff + 15);
          p.lineTo(x + xOff, y - yOff + 10);
          p.quadTo(x + xOff - 10, y - yOff + 10, x + xOff - 10, y - yOff);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff + 15, y - yOff);
          p.quadTo(x - xOff + 15, y - yOff + 15, x - xOff, y - yOff + 15);
          p.lineTo(x - xOff, y - yOff + 10);
          p.quadTo(x - xOff + 10, y - yOff + 10, x - xOff + 10, y - yOff);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 15, yOff + 15};
          
          return newOff;
     }
     
     //EZH
     public int[] renderU0292(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Curve
          p.moveTo(x + xOff - 15, y - yOff);
          p.quadTo(x + xOff, y - yOff, x + xOff, y - yOff + 15);
          p.lineTo(x + xOff - 5, y - yOff + 15);
          p.quadTo(x + xOff - 5, y - yOff + 5, x + xOff - 15, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff + 15, y - yOff);
          p.quadTo(x - xOff, y - yOff, x - xOff, y - yOff + 15);
          p.lineTo(x - xOff + 5, y - yOff + 15);
          p.quadTo(x - xOff + 5, y - yOff + 5, x - xOff + 15, y - yOff + 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 15, yOff + 15};
          
          return newOff;
     }
     
     //S_WITH_HOOK
     public int[] renderU0282(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Curve
          p.moveTo(x + xOff - 15, y + yOff);
          p.quadTo(x + xOff - 15, y + yOff - 15, x + xOff, y + yOff - 15);
          p.lineTo(x + xOff, y + yOff - 10);
          p.quadTo(x + xOff - 10, y + yOff - 10, x + xOff - 10, y + yOff);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff + 15, y + yOff);
          p.quadTo(x - xOff + 15, y + yOff - 15, x - xOff, y + yOff - 15);
          p.lineTo(x - xOff, y + yOff - 10);
          p.quadTo(x - xOff + 10, y + yOff - 10, x - xOff + 10, y + yOff);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 15, yOff + 15};
          
          return newOff;
     }
     
     //Z_WITH_RETROFLEX_HOOK
     public int[] renderU0290(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Curve
          p.moveTo(x + xOff - 15, y + yOff);
          p.quadTo(x + xOff, y + yOff, x + xOff, y + yOff - 15);
          p.lineTo(x + xOff - 5, y + yOff - 15);
          p.quadTo(x + xOff - 5, y + yOff - 5, x + xOff - 15, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff + 15, y + yOff);
          p.quadTo(x - xOff, y + yOff, x - xOff, y + yOff - 15);
          p.lineTo(x - xOff + 5, y + yOff - 15);
          p.quadTo(x - xOff + 5, y + yOff - 5, x - xOff + 15, y + yOff - 5);
          p.closePath();
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 15, yOff + 15};
          
          return newOff;
     }
     
     //V_WITH_HOOK
     public int[] renderU028B(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y - yOff + 5);
          p.lineTo(x + xOff - 10, y - yOff + 10);
          p.lineTo(x + xOff + 30, y - yOff + 25);
          p.lineTo(x + xOff + 30, y - yOff + 20);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y - yOff + 5);
          p.lineTo(x - xOff + 10, y - yOff + 10);
          p.lineTo(x - xOff - 30, y - yOff + 25);
          p.lineTo(x - xOff - 30, y - yOff + 20);
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 45, yOff + 5};
          
          return newOff;
     }
     
     //J
     public int[] renderU006A(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);
          
          gi.setColor(fontColor);
          
          GeneralPath p = new GeneralPath();
          
          //Right Line
          p.moveTo(x + xOff - 10, y + yOff - 5);
          p.lineTo(x + xOff - 10, y + yOff - 10);
          p.lineTo(x + xOff + 30, y + yOff - 25);
          p.lineTo(x + xOff + 30, y + yOff - 20);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + 10, y + yOff - 5);
          p.lineTo(x - xOff + 10, y + yOff - 10);
          p.lineTo(x - xOff - 30, y + yOff - 25);
          p.lineTo(x - xOff - 30, y + yOff - 20);
          
          gi.fill(p);
          
          int[] newOff = new int[] {x, y, xOff + 45, yOff + 5};
          
          return newOff;
     }
}
