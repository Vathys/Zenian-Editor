package main;

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
     }

     @Override
     public void keyReleased(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }
}
