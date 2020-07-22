package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import utils.GlyphReader;
import utils.GlyphWriter;
import utils.Utils;

public class EditorHandler implements ActionListener, KeyListener, ChangeListener
{
     private Window container;
     private Editor currentEditor;

     private JFileChooser fc;

     public EditorHandler(Window container, Editor currentEditor)
     {
          this.container = container;
          this.currentEditor = currentEditor;

          fc = new JFileChooser();
     }

     @Override
     public void actionPerformed(ActionEvent e)
     {

          if (ZenianLetter.I.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.I);
          if (ZenianLetter.Y.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.Y);
          if (ZenianLetter.E.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.E);
          if (ZenianLetter.O_WITH_STROKE.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.O_WITH_STROKE);
          if (ZenianLetter.OPEN_E.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.OPEN_E);
          if (ZenianLetter.LIGATURE_OE.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.LIGATURE_OE);
          if (ZenianLetter.A.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.A);
          if (ZenianLetter.LIGATURE_CAPITAL_OE.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.LIGATURE_CAPITAL_OE);
          if (ZenianLetter.T.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.T);
          if (ZenianLetter.D.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.D);
          if (ZenianLetter.T_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.T_WITH_RETROFLEX_HOOK);
          if (ZenianLetter.D_WITH_TAIL.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.D_WITH_TAIL);
          if (ZenianLetter.V_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.V_WITH_HOOK);
          if (ZenianLetter.J.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.J);
          if (ZenianLetter.TURNED_R.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.TURNED_R);
          if (ZenianLetter.THETA.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.THETA);
          if (ZenianLetter.ETH.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.ETH);
          if (ZenianLetter.S.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.S);
          if (ZenianLetter.Z.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.Z);
          if (ZenianLetter.ESH.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.ESH);
          if (ZenianLetter.EZH.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.EZH);
          if (ZenianLetter.S_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.S_WITH_HOOK);
          if (ZenianLetter.Z_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               currentEditor.addLetterToLast(ZenianLetter.Z_WITH_RETROFLEX_HOOK);

          boolean saveas = false;

          if (e.getActionCommand().equals("New"))
          {
               container.addEditor();
          }
          if (e.getActionCommand().equals("Open"))
          {
               fc = new JFileChooser();

               fc.setAcceptAllFileFilterUsed(false);
               fc.setFileFilter(new FileNameExtensionFilter("Aze Files", "aze"));

               int returnVal = fc.showOpenDialog(currentEditor);

               if (returnVal == JFileChooser.APPROVE_OPTION)
               {
                    File file = fc.getSelectedFile();

                    EditorSave save = GlyphReader.read(file);

                    if (save.valid())
                    {
                         container.addEditor(file, save.getFontSize(), save.getFontColor(), save.getBackColor());
                         currentEditor.loadSave(save);
                    }
               } else
               {
                    System.out.println("Open canceled by user");
               }
          }
          if (e.getActionCommand().equals("Save"))
          {
               if (currentEditor.getEditorFile() != null)
               {
                    GlyphWriter.writeFile(currentEditor, currentEditor.getEditorFile());
               } else
               {
                    saveas = true;
               }
          }
          if (e.getActionCommand().equals("Save As") || saveas)
          {
               fc = new JFileChooser();

               fc.setAcceptAllFileFilterUsed(false);
               fc.setFileFilter(new FileNameExtensionFilter("Aze File", "aze"));

               int returnVal = fc.showSaveDialog(currentEditor);
               if (returnVal == JFileChooser.APPROVE_OPTION)
               {
                    File file = fc.getSelectedFile();
                    String ext = Utils.getExtension(file);
                    
                    if (ext == null || !ext.equals("aze"))
                    {
                         file = new File(file.getAbsoluteFile() + ".aze");
                    } 

                    GlyphWriter.writeFile(currentEditor, file);
                    
                    if(currentEditor.getEditorFile() == null)
                    {
                         currentEditor.setEditorFile(file);
                         container.getTabPane().setTitleAt(container.getTabPane().getSelectedIndex(), file.getName());
                    }
               }
               
               saveas = false;
          }
          if(e.getActionCommand().equals("Export"))
          {
               fc = new JFileChooser();

               fc.setAcceptAllFileFilterUsed(false);
               fc.setFileFilter(new FileNameExtensionFilter("JPEG File", "jpg", "jpeg"));
               fc.setFileFilter(new FileNameExtensionFilter("PNG File", "png"));
               
               int returnVal = fc.showDialog(currentEditor, "Export");
               if(returnVal == JFileChooser.APPROVE_OPTION)
               {
                    File file = fc.getSelectedFile();
                    String ext = Utils.getExtension(file);
                    
                    if(ext == null)
                    {
                         String desc = fc.getDescription(file);
                         if(desc.equals("JPEG File"))
                         {
                              file = new File(file.getAbsoluteFile() + ".jpeg");
                         }
                         else if(desc.equals("PNG File"))
                         {
                              file = new File(file.getAbsoluteFile() + ".png");
                         }
                    }
                    else if(!ext.equals("jpg") || !ext.equals("jpeg") || !ext.equals("png"))
                    {
                         String desc = fc.getDescription(file);
                         if(desc.equals("JPEG File"))
                         {
                              file = new File(file.getAbsoluteFile() + ".jpeg");
                         }
                         else if(desc.equals("PNG File"))
                         {
                              file = new File(file.getAbsoluteFile() + ".png");
                         }
                    }
                    
                    GlyphWriter.writeImage(currentEditor, file);
               }
          }
          if (e.getActionCommand().equals("Exit"))
          {
               container.dispatchEvent(new WindowEvent(container, WindowEvent.WINDOW_CLOSING));
          }
          if (e.getActionCommand().equals("fontSize"))
          {
               JComboBox<?> source = null;

               if (e.getSource() instanceof JComboBox<?>)
               {
                    source = (JComboBox<?>) e.getSource();
               }

               try
               {
                    int fontSize = (int) source.getSelectedItem() * 2;

                    File temp = File.createTempFile("temp", null);
                    GlyphWriter.writeCustomFile(currentEditor, fontSize, currentEditor.getFontColor(), currentEditor.getBackColor(), temp);

                    EditorSave save = GlyphReader.read(temp);
                    currentEditor.loadSave(save);

                    temp.delete();
               } catch (IOException e1)
               {
                    e1.printStackTrace();
               }

               container.requestFocus();
          }

          currentEditor.tick();
     }

     @Override
     public void keyTyped(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }

     @Override
     public void keyPressed(KeyEvent e)
     {
          if (e.getKeyCode() == KeyEvent.VK_SPACE)
          {
               currentEditor.toggleElement("newGlyph", true);

               currentEditor.tick();
          }
          if (e.getKeyCode() == KeyEvent.VK_ENTER)
          {
               currentEditor.toggleElement("newColumn", true);

               currentEditor.tick();
          }
          if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
          {
               currentEditor.toggleElement("backspace", true);

               currentEditor.tick();
          }
     }

     @Override
     public void keyReleased(KeyEvent e)
     {
          // TODO Auto-generated method stub

     }

     @Override
     public void stateChanged(ChangeEvent e)
     {
          Editor edit;
          if((edit = container.getCurrentEditor()) != null)
          {
               currentEditor = edit;
          }
               
          if(container.getTabPane().getTabCount() < 1)
          {
               container.addEditor();
          }
          currentEditor.tick();
     }

     public Editor getCurrentEditor()
     {
          return currentEditor;
     }

     public void setCurrentEditor(Editor currentEditor)
     {
          this.currentEditor = currentEditor;
     }
}
