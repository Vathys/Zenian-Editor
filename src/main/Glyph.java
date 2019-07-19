package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Glyph
{
     private int x;//x of Top Left
     private int y;//y of Top Left
     private int[] startOffset;
     private ArrayList<ZenianLetter> c;
     private GlyphColumn gc;
     private Color fontColor;
     private int fontSize;
     
     private int[] offset;
     
     public Glyph (GlyphColumn gc)
     {
          this.fontSize = gc.getFontSize();
          this.x = gc.getStartX();
          this.y = gc.getCurrentHeight() - (fontSize * 8);
          
          this.gc = gc;
          
          
          fontColor = Color.WHITE;
          startOffset = new int[] {fontSize * 4, fontSize * 4};
          
          c = new ArrayList<ZenianLetter>();
     }

     public void preRender()
     {
          offset = new int[] {x + (gc.cellWidth / 2), y + startOffset[1], startOffset[0], startOffset[1]};

          int widthTracker = startOffset[0] * 2;
          
          for(int i = 0; i < c.size(); i++)
          {
               widthTracker += c.get(i).getLetterOffset(fontSize)[0] * 2;
               if(widthTracker > gc.cellWidth)
               {
                    offset[0] += c.get(i).getLetterOffset(fontSize)[0];
                    gc.cellWidth = widthTracker;
               }
               offset[1] += c.get(i).getLetterOffset(fontSize)[1];
          }
     }
     
     public void render(Graphics g)
     {
          Graphics2D gi = (Graphics2D) g;
          
          LetterRenderHandler rh = new LetterRenderHandler(fontColor, fontSize);
          //drawDebug(gi, offset);
          for(int i = 0; i < c.size(); i++) {
               //eraseDebug(gi, offset);
               offset = pickRender(gi, rh, offset, c.get(i));
               //drawDebug(gi, offset);
          }
          
          gi.setColor(fontColor);
          
          GeneralPath dot = new GeneralPath();
          
          dot.moveTo(offset[0] + fontSize, offset[1]);
          dot.lineTo(offset[0], offset[1] + fontSize);
          dot.lineTo(offset[0] - fontSize, offset[1]);
          dot.lineTo(offset[0], offset[1] - fontSize);
          dot.closePath();
          
          gi.fill(dot);
     }

     private int[] pickRender(Graphics2D gi, LetterRenderHandler rh, int[] offset, ZenianLetter letter)
     {
          int[] off;
          switch(letter)
          {
               case I: 
                    off = rh.renderU0069(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case Y:
                    off = rh.renderU0079(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case E:
                    off = rh.renderU0065(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case O_WITH_STROKE:
                    off = rh.renderU00F8(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case OPEN_E:
                    off = rh.renderU025B(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case LIGATURE_OE:
                    off = rh.renderU0153(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case A:
                    off = rh.renderU0061(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case LIGATURE_CAPITAL_OE:
                    off = rh.renderU0276(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case T:
                    off = rh.renderU0074(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case D: 
                    off = rh.renderU0064(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case T_WITH_RETROFLEX_HOOK: 
                    off = rh.renderU0288(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case D_WITH_TAIL:
                    off = rh.renderU0256(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case THETA: 
                    off = rh.renderU03B8(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case ETH:
                    off = rh.renderU00F0(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case S:
                    off = rh.renderU0073(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case Z:
                    off = rh.renderU007A(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case ESH: 
                    off = rh.renderU0283(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case EZH: 
                    off = rh.renderU0292(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case S_WITH_HOOK:
                    off = rh.renderU0282(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case Z_WITH_RETROFLEX_HOOK:
                    off = rh.renderU0290(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case V_WITH_HOOK:
                    off = rh.renderU028B(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               case J:
                    off = rh.renderU006A(gi, offset[0], offset[1], offset[2], offset[3]);
                    break;
               default:
                    off = offset;
                    break;
          }
          return off;
     }
     
     public void drawDebug(Graphics2D g, int[] offset)
     {
          g.setColor(Color.BLUE);
          g.drawRect(offset[0] - offset[2], offset[1] - offset[3], offset[2] * 2, offset[3] * 2);
     }
     
     public void eraseDebug(Graphics2D g, int[] offset)
     {
          g.setColor(Color.WHITE);
          g.drawRect(offset[0] - offset[2], offset[1] - offset[3], offset[2] * 2, offset[3] * 2);
     }

     public int getHeight()
     {
          int dim = (fontSize * 10) + (2 * startOffset[1]);
          for(int i = 0;i < c.size(); i++)
          {
               dim += c.get(i).getLetterOffset(fontSize)[1] * 2;
          }
          return dim;
     }
     
     public void updateGC(GlyphColumn ngc)
     {
          this.gc = ngc;
          this.x = ngc.getStartX();
          this.y = ngc.getCurrentHeight() - (fontSize * 8);
     }
     
     public void addLetter(ZenianLetter letter)
     {
          c.add(letter);
          gc.updateHeight(c.get(c.size() - 1).getLetterOffset(fontSize)[1] * 2);
          gc.checkHeight();
     }
     
     public ZenianLetter removeLetter(ZenianLetter letter)
     {
          gc.updateHeight(c.get(c.lastIndexOf(letter)).getLetterOffset(fontSize)[1] * -2);
          gc.cellWidth -= c.get(c.lastIndexOf(letter)).getLetterOffset(fontSize)[0] * 2;
          return c.remove(c.lastIndexOf(letter));
     }
     
     public ZenianLetter removeLastLetter()
     {
          gc.updateHeight(c.get(c.size() - 1).getLetterOffset(fontSize)[1] * -2);
          gc.cellWidth -= c.get(c.size() - 1).getLetterOffset(fontSize)[0] * 2;
          return c.remove(c.size() - 1);
     }
}
