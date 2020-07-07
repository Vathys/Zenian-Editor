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
     private int fontSize;

     public LetterRenderHandler(Color fontColor, int fontSize)
     {
          defaultRenderHints = new HashMap<Key, Object>();
          defaultRenderHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          defaultRenderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

          this.fontColor = fontColor;
          this.fontSize = fontSize;
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
          p.moveTo(x + xOff - fontSize, y);
          p.lineTo(x + xOff, y + fontSize);
          p.lineTo(x + xOff + fontSize, y);
          p.lineTo(x + xOff, y - fontSize);
          p.closePath();

          gi.fill(p);

          //Left Dot
          p.moveTo(x - xOff - fontSize, y);
          p.lineTo(x - xOff, y + fontSize);
          p.lineTo(x - xOff + fontSize, y);
          p.lineTo(x - xOff, y - fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.I.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //Y
     public int[] renderU0079(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Horizontal Line
          p.moveTo(x + xOff - (fontSize * 2), y + (fontSize / 2));
          p.lineTo(x + xOff + (fontSize * 2), y + (fontSize / 2));
          p.lineTo(x + xOff + (fontSize * 2), y - (fontSize / 2));
          p.lineTo(x + xOff - (fontSize * 2), y - (fontSize / 2));
          p.closePath();

          gi.fill(p);

          //Left Horizaontal Line
          p.moveTo(x - xOff + (fontSize * 2), y + (fontSize / 2));
          p.lineTo(x - xOff - (fontSize * 2), y + (fontSize / 2));
          p.lineTo(x - xOff - (fontSize * 2), y - (fontSize / 2));
          p.lineTo(x - xOff + (fontSize * 2), y - (fontSize / 2));
          p.closePath();

          gi.fill(p);

          //Right Dot
          p.moveTo(x + xOff + (fontSize * 3), y);
          p.lineTo(x + xOff + (fontSize * 4), y + fontSize);
          p.lineTo(x + xOff + (fontSize * 5), y);
          p.lineTo(x + xOff + (fontSize * 4), y - fontSize);
          p.closePath();

          gi.fill(p);

          //Left Dot
          p.moveTo(x - xOff - (fontSize * 3), y);
          p.lineTo(x - xOff - (fontSize * 4), y + fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y);
          p.lineTo(x - xOff - (fontSize * 4), y - fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.Y.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //E
     public int[] renderU0065(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Dot
          p.moveTo(x + xOff - fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x + xOff, y - yOff + fontSize);
          p.lineTo(x + xOff + fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x + xOff, y - yOff + (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Left Dot
          p.moveTo(x - xOff + fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x - xOff, y - yOff + fontSize);
          p.lineTo(x - xOff - fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x - xOff, y - yOff + (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y - yOff + (fontSize * 4));
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + (fontSize * 4));
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y - yOff + (fontSize * 4));
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + (fontSize * 4));
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.E.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //O_WITH_STROKE
     public int[] renderU00F8(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);
          
          //Bottom Right Horizontal Line
          p.moveTo(x + xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x + xOff - fontSize, y + yOff - (fontSize * 2));
          p.closePath();

          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y + yOff - fontSize);
          p.closePath();
          
          gi.fill(p);
          
          //Bottom Left Horizontal Line
          p.moveTo(x - xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x - xOff + fontSize, y + yOff - (fontSize * 2));
          p.closePath();
          
          gi.fill(p);
          
          int[] letterOffset = ZenianLetter.O_WITH_STROKE.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //OPEN_E
     public int[] renderU025B(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Dot
          p.moveTo(x + xOff - fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x + xOff, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x + xOff, y + yOff - (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Left Dot
          p.moveTo(x - xOff + fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x - xOff, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x - xOff, y + yOff - (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y + yOff - (fontSize * 4));
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - (fontSize * 4));
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y + yOff - (fontSize * 4));
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - (fontSize * 4));
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.OPEN_E.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //LIGATURE_OE
     public int[] renderU0153(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);
          
          //Top Right Horizontal Line
          p.moveTo(x + xOff - fontSize, y - yOff + fontSize);
          p.lineTo(x + xOff + fontSize, y - yOff + fontSize);
          p.lineTo(x + xOff + fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x + xOff - fontSize, y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y + yOff - fontSize);
          p.closePath();
          
          gi.fill(p);
          
          //Top Left Horizontal Line
          p.moveTo(x - xOff + fontSize, y - yOff + fontSize);
          p.lineTo(x - xOff - fontSize, y - yOff + fontSize);
          p.lineTo(x - xOff - fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x - xOff + fontSize, y - yOff + (fontSize * 2));
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.LIGATURE_OE.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //A
     public int[] renderU0061(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);
          
          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y + yOff - fontSize);
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.A.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //LIGATURE_CAPITAL_OE
     public int[] renderU0276(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Vertical Line
          p.moveTo(x + xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x + xOff + (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize / 2), y + yOff - fontSize);
          p.closePath();

          gi.fill(p);
          
          //Top Right Horizontal Line
          p.moveTo(x + xOff - fontSize, y - yOff + fontSize);
          p.lineTo(x + xOff + fontSize, y - yOff + fontSize);
          p.lineTo(x + xOff + fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x + xOff - fontSize, y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          //Bottom Right Horizontal Line
          p.moveTo(x + xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x + xOff - fontSize, y + yOff - (fontSize * 2));
          p.closePath();

          gi.fill(p);

          //Left Vertical Line
          p.moveTo(x - xOff + (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y - yOff + fontSize);
          p.lineTo(x - xOff - (fontSize / 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize / 2), y + yOff - fontSize);
          p.closePath();
          
          gi.fill(p);

          //Top Left Horizontal Line
          p.moveTo(x - xOff + fontSize, y - yOff + fontSize);
          p.lineTo(x - xOff - fontSize, y - yOff + fontSize);
          p.lineTo(x - xOff - fontSize, y - yOff + (fontSize * 2));
          p.lineTo(x - xOff + fontSize, y - yOff + (fontSize * 2));
          p.closePath();
          
          gi.fill(p);
          
          //Bottom Left Horizontal Line
          p.moveTo(x - xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - (fontSize * 2));
          p.lineTo(x - xOff + fontSize, y + yOff - (fontSize * 2));
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.LIGATURE_CAPITAL_OE.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //T
     public int[] renderU0074(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line
          p.moveTo(x + xOff - (fontSize * 2), y - fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y - fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 3));
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.T.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //D
     public int[] renderU0064(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line
          p.moveTo(x + xOff - (fontSize * 2), y + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.D.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //T_WITH_RETROFLEX_HOOK
     public int[] renderU0288(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line #1
          p.moveTo(x + xOff - (fontSize * 2), y - fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Right Line #2
          p.moveTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 3), y + yOff - (fontSize));
          p.lineTo(x + xOff + (fontSize * 3), y + yOff - (fontSize * 2));
          p.closePath();
          
          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y - fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 3));
          p.closePath();
          
          gi.fill(p);
          
          //Left Line #2
          p.moveTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 3), y + yOff - (fontSize));
          p.lineTo(x - xOff - (fontSize * 3), y + yOff - (fontSize * 2));
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.T_WITH_RETROFLEX_HOOK.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //D_WITH_TAIL
     public int[] renderU0256(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line #1
          p.moveTo(x + xOff - (fontSize * 2), y + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();

          gi.fill(p);
          
          //Right Line #2
          p.moveTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 3), y - yOff + (fontSize));
          p.lineTo(x + xOff + (fontSize * 3), y - yOff + (fontSize * 2));
          p.closePath();

          //Left Line #1
          p.moveTo(x - xOff + (fontSize * 2), y + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();
          
          gi.fill(p);
          
          //Left Line #2
          p.moveTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 3), y - yOff + (fontSize));
          p.lineTo(x - xOff - (fontSize * 3), y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          int[] letterOffset = ZenianLetter.D_WITH_TAIL.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //V_WITH_HOOK
     public int[] renderU028B(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y + fontSize);
          p.lineTo(x + xOff + (fontSize * 5), y);
          p.closePath();

          gi.fill(p);

          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y + fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y);
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.V_WITH_HOOK.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //J
     public int[] renderU006A(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line
          p.moveTo(x + xOff - (fontSize * 2), y + yOff - (fontSize * 2));
          p.lineTo(x + xOff - (fontSize * 2), y + yOff - (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y - fontSize);
          p.lineTo(x + xOff + (fontSize * 5), y);
          p.closePath();

          gi.fill(p);

          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y + yOff - (fontSize * 2));
          p.lineTo(x - xOff + (fontSize * 2), y + yOff - (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y - fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.J.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //TURNED_R
     public int[] renderU0279(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Line #1
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y + fontSize);
          p.lineTo(x + xOff + (fontSize * 5), y);
          p.closePath();

          gi.fill(p);
          
          //Right Line #2
          p.moveTo(x + xOff + (fontSize * 5), y);
          p.lineTo(x + xOff + (fontSize * 5), y + fontSize);
          p.lineTo(x + xOff + (fontSize * 3), y + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 3), y + fontSize);
          p.closePath();

          gi.fill(p);
          
          //Left Line
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y + fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y);
          p.closePath();
          
          gi.fill(p);
          
          //Left Line #2
          p.moveTo(x - xOff - (fontSize * 5), y);
          p.lineTo(x - xOff - (fontSize * 5), y + fontSize);
          p.lineTo(x - xOff - (fontSize * 3), y + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 3), y + fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.V_WITH_HOOK.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //THETA
     public int[] renderU03B8(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Upper Right Line #1
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y + fontSize);
          p.lineTo(x + xOff + (fontSize * 5), y);
          p.closePath();

          gi.fill(p);

          //Upper Right Line #2
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff, y - yOff + fontSize);
          p.lineTo(x + xOff, y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          //Upper Left Line #1
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y + fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y);
          p.closePath();
          
          gi.fill(p);

          //Upper Left Line #2
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff, y - yOff + (fontSize));
          p.lineTo(x - xOff, y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          //Lower Right Line
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 4));
          p.lineTo(x + xOff - (fontSize * 2), y - yOff + (fontSize * 5));
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize));
          p.lineTo(x + xOff + (fontSize * 5), y + yOff - (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          //Lower Left Line
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 4));
          p.lineTo(x - xOff + (fontSize * 2), y - yOff + (fontSize * 5));
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - fontSize);
          p.lineTo(x - xOff - (fontSize * 5), y + yOff - (fontSize * 2));
          p.closePath();

          gi.fill(p);
          
          int[] letterOffset = ZenianLetter.THETA.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //ETH
     public int[] renderU00F0(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Upper Right Line #1
          p.moveTo(x + xOff - (fontSize * 2), y + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();

          gi.fill(p);

          //Upper Right Line #2
          p.moveTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 3));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 3), y - yOff + (fontSize));
          p.lineTo(x + xOff + (fontSize * 3), y - yOff + (fontSize * 2));
          p.closePath();
          
          gi.fill(p);

          //Lower Right Line
          p.moveTo(x + xOff - (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y + yOff - (fontSize * 2));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 4));
          p.lineTo(x + xOff + (fontSize * 5), y - yOff + (fontSize * 5));
          p.closePath();

          gi.fill(p);

          //Lower Left Line #1
          p.moveTo(x - xOff + (fontSize * 2), y + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 3));
          p.closePath();
          
          gi.fill(p);

          //Lower Left Line #2
          p.moveTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 3));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 3), y - yOff + (fontSize));
          p.lineTo(x - xOff - (fontSize * 3), y - yOff + (fontSize * 2));
          p.closePath();

          gi.fill(p);

          //Lower Left Line
          p.moveTo(x - xOff + (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y + yOff - (fontSize * 2));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 4));
          p.lineTo(x - xOff - (fontSize * 5), y - yOff + (fontSize * 5));
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.ETH.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //S
     public int[] renderU0073(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();
          
          //Right Curve
          p.moveTo(x + xOff, y - yOff + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y);
          p.lineTo(x + xOff + fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff, y - yOff + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y);
          p.lineTo(x - xOff - fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);
          
          int[] letterOffset = ZenianLetter.S.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }

     //Z
     public int[] renderU007A(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Curve
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x + xOff, y);
          p.lineTo(x + xOff - (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y);
          p.lineTo(x + xOff - fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          //Left Curve
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x - xOff, y);
          p.lineTo(x - xOff + (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y);
          p.lineTo(x - xOff + fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.Z.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //ESH
     public int[] renderU0283(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Curve
          p.moveTo(x + xOff, y - yOff + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff - (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y);
          p.lineTo(x + xOff + fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff, y - yOff + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff + (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y);
          p.lineTo(x - xOff - fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);

          int[] letterOffset = ZenianLetter.ESH.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //EZH
     public int[] renderU0292(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Curve
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x + xOff, y);
          p.lineTo(x + xOff, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y);
          p.lineTo(x + xOff - fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          //Left Curve
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x - xOff, y);
          p.lineTo(x - xOff, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y);
          p.lineTo(x - xOff + fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.EZH.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //S_WITH_HOOK
     public int[] renderU0282(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Curve
          p.moveTo(x + xOff - (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x + xOff - (fontSize * 2), y);
          p.lineTo(x + xOff, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y);
          p.lineTo(x + xOff - fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);
          
          //Left Curve
          p.moveTo(x - xOff + (fontSize * 2), y - yOff + fontSize);
          p.lineTo(x - xOff + (fontSize * 2), y);
          p.lineTo(x - xOff, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y);
          p.lineTo(x - xOff + fontSize, y - yOff + fontSize);
          p.closePath();
          
          gi.fill(p);
          
          int[] letterOffset = ZenianLetter.S_WITH_HOOK.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
     
     //Z_WITH_RETROFLEX_HOOK
     public int[] renderU0290(Graphics2D gi, int x, int y, int xOff, int yOff)
     {
          gi.setRenderingHints(defaultRenderHints);

          gi.setColor(fontColor);

          GeneralPath p = new GeneralPath();

          //Right Curve
          p.moveTo(x + xOff, y - yOff + fontSize);
          p.lineTo(x + xOff, y);
          p.lineTo(x + xOff - (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x + xOff - fontSize, y + yOff - fontSize);
          p.lineTo(x + xOff + fontSize, y);
          p.lineTo(x + xOff + fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          //Left Curve
          p.moveTo(x - xOff, y - yOff + fontSize);
          p.lineTo(x - xOff, y);
          p.lineTo(x - xOff + (fontSize * 2), y + yOff - fontSize);
          p.lineTo(x - xOff + fontSize, y + yOff - fontSize);
          p.lineTo(x - xOff - fontSize, y);
          p.lineTo(x - xOff - fontSize, y - yOff + fontSize);
          p.closePath();

          gi.fill(p);

          int[] letterOffset = ZenianLetter.Z_WITH_RETROFLEX_HOOK.getLetterOffset(fontSize);

          int[] newOff = new int[] { x, y, xOff + letterOffset[0], yOff + letterOffset[1] };

          return newOff;
     }
}
