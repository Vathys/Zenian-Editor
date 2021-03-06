package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonTabComponent extends JPanel
{
     private static final long serialVersionUID = 1L;

     private final static MouseListener buttonMouseListener = new MouseAdapter()
     {
          public void mouseEntered(MouseEvent e)
          {
               Component comp = e.getComponent();
               if (comp instanceof AbstractButton)
               {
                    AbstractButton button = (AbstractButton) comp;
                    button.setBorderPainted(true);
               }
          }

          public void mouseExited(MouseEvent e)
          {
               Component comp = e.getComponent();
               if (comp instanceof AbstractButton)
               {
                    AbstractButton button = (AbstractButton) comp;
                    button.setBorderPainted(false);
               }
          }
     };

     private class TabButton extends JButton implements ActionListener
     {
          private static final long serialVersionUID = 1L;

          public TabButton()
          {
               super("Remove Tab");
               int size = 17;
               setPreferredSize(new Dimension(size, size));
               setToolTipText("close tab");
               setUI(new BasicButtonUI());
               setContentAreaFilled(false);
               setFocusable(false);
               setBorder(BorderFactory.createEtchedBorder());
               setBorderPainted(false);
               addMouseListener(buttonMouseListener);
               setRolloverEnabled(true);
               addActionListener(this);
          }

          @Override
          public void actionPerformed(ActionEvent e)
          {
               int i = pane.indexOfTabComponent(ButtonTabComponent.this);
               if (i != -1 && pane.getTabCount() > 1)
               {
                    pane.remove(i);
               }
          }

          public void updateUI()
          {
          }

          protected void paintComponent(Graphics g)
          {
               super.paintComponent(g);
               Graphics2D g2 = (Graphics2D) g.create();
               if (getModel().isPressed())
               {
                    g2.translate(1, 1);
               }
               g2.setStroke(new BasicStroke(2));
               g2.setColor(Color.BLACK);
               if (getModel().isRollover())
               {
                    g2.setColor(Color.MAGENTA);
               }
               int delta = 6;
               g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
               g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
               g2.dispose();
          }
     }

     private final JTabbedPane pane;

     public ButtonTabComponent(final JTabbedPane pane)
     {
          super(new FlowLayout(FlowLayout.LEFT, 0, 0));
          if (pane == null)
          {
               throw new NullPointerException("TabbedPane is null");
          }
          this.pane = pane;
          setOpaque(false);

          JLabel label = new JLabel()
          {
               private static final long serialVersionUID = 1L;

               public String getText()
               {
                    int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                    if (i != -1)
                    {
                         return pane.getTitleAt(i);
                    }
                    return null;
               }
          };

          add(label);
          label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
          JButton button = new TabButton();
          add(button);
          setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
     }
}
