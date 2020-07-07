package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class KeyHandler implements KeyListener
{
     private Window wind;
     private Editor edit;

     public KeyHandler(Window w, Editor e)
     {
          wind = w;
          this.edit = e;
     }

     @Override
     public void keyTyped(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }

     @Override
     public void keyPressed(KeyEvent e)
     {
          String testSavePathName = "res/Save Files/TestSave.txt";
          String imTestSavePathName = "res/Save Files/ImageTestSave.png";
          
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_ESCAPE)
          {
               wind.dispatchEvent(new WindowEvent(wind, WindowEvent.WINDOW_CLOSING));

               edit.tick();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_SPACE)
          {
               edit.toggleElement("newGlyph", true);

               edit.tick();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_ENTER)
          {
               edit.toggleElement("newColumn", true);

               edit.tick();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
          {
               edit.toggleElement("backspace", true);

               edit.tick();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_S && e.isControlDown())
          {
               GlyphWriter.writeFile(edit, testSavePathName);
               GlyphWriter.writeImage(edit.getGrid(), Color.WHITE, edit.getFontSize(), imTestSavePathName);

               edit.tick();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_C && e.isControlDown())
          {
               edit.clear();
          }
          if (!edit.paused && e.getKeyCode() == KeyEvent.VK_O && e.isControlDown())
          {
               edit.loadSave(GlyphReader.read(testSavePathName));

               edit.tick();
          }

          //edit.tick();
     }

     @Override
     public void keyReleased(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }
}
