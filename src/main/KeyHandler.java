package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class KeyHandler implements KeyListener
{
     private Window wind;
     private Editor edit;
     
     KeyHandler(Window w, Editor e)
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
          if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
          {
               wind.dispatchEvent(new WindowEvent(wind, WindowEvent.WINDOW_CLOSING));
          }
          if(e.getKeyCode() == KeyEvent.VK_SPACE)
          {
               Editor.toggleElement("newGlyph", true);
          }
          if(e.getKeyCode() == KeyEvent.VK_ENTER)
          {
               Editor.toggleElement("newColumn", true);
          }
          if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
          {
               Editor.toggleElement("backspace", true);
          }
          
          edit.tick();
     }

     @Override
     public void keyReleased(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }

}
