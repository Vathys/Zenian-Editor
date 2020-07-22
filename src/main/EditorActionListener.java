package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditorActionListener implements ActionListener
{
     private Window container;
     private Editor currentEditor;
     
     private FileChooser fc;
     private File currentOpenFile;

     @Override
     public void actionPerformed(ActionEvent e)
     {

          if (ZenianLetter.I.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.I);
          if (ZenianLetter.Y.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Y);
          if (ZenianLetter.E.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.E);
          if (ZenianLetter.O_WITH_STROKE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.O_WITH_STROKE);
          if (ZenianLetter.OPEN_E.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.OPEN_E);
          if (ZenianLetter.LIGATURE_OE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_OE);
          if (ZenianLetter.A.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.A);
          if (ZenianLetter.LIGATURE_CAPITAL_OE.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.LIGATURE_CAPITAL_OE);
          if (ZenianLetter.T.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.T);
          if (ZenianLetter.D.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.D);
          if (ZenianLetter.T_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.T_WITH_RETROFLEX_HOOK);
          if (ZenianLetter.D_WITH_TAIL.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.D_WITH_TAIL);
          if (ZenianLetter.V_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.V_WITH_HOOK);
          if (ZenianLetter.J.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.J);
          if (ZenianLetter.TURNED_R.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.TURNED_R);
          if (ZenianLetter.THETA.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.THETA);
          if (ZenianLetter.ETH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.ETH);
          if (ZenianLetter.S.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.S);
          if (ZenianLetter.Z.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Z);
          if (ZenianLetter.ESH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.ESH);
          if (ZenianLetter.EZH.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.EZH);
          if (ZenianLetter.S_WITH_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.S_WITH_HOOK);
          if (ZenianLetter.Z_WITH_RETROFLEX_HOOK.getCharacter().equals(e.getActionCommand()))
               grid.get(currentColumn).addLetterToLast(ZenianLetter.Z_WITH_RETROFLEX_HOOK);

          tick();
          boolean saveas = false;

          if (e.getActionCommand().equals("New"))
          {
               init();
          }
          if (e.getActionCommand().equals("Open"))
          {
               fc = new JFileChooser();

               fc.setAcceptAllFileFilterUsed(false);
               fc.setFileFilter(new FileNameExtensionFilter("Aze Files", "aze"));

               int returnVal = fc.showOpenDialog(this);

               if (returnVal == JFileChooser.APPROVE_OPTION)
               {
                    File file = fc.getSelectedFile();
                    System.out.println("Opening: " + file.getName() + ".");

                    EditorSave save = GlyphReader.read(file);

                    if (save.valid())
                    {
                         loadSave(save);
                    }
               } else
               {
                    System.out.println("Open canceled by user");
               }
          }
          if (e.getActionCommand().equals("Save"))
          {
               if (currentOpenFile != null)
               {
                    GlyphWriter.writeFile(this, currentOpenFile);
               } else
               {
                    saveas = true;
               }
          }
          if (e.getActionCommand().equals("Save As") || saveas)
          {
               fc = new JFileChooser();

               fc.setAcceptAllFileFilterUsed(false);
               fc.setFileFilter(new FileNameExtensionFilter("JPEG File", "jpg", "jpeg"));
               fc.setFileFilter(new FileNameExtensionFilter("PNG File", "png"));
               fc.setFileFilter(new FileNameExtensionFilter("Aze File", "aze"));

               int returnVal = fc.showSaveDialog(this);
               if (returnVal == JFileChooser.APPROVE_OPTION)
               {
                    File file = fc.getSelectedFile();

                    if (Utils.getExtension(file) == null)
                    {
                         String desc = fc.getFileFilter().getDescription();
                         if (desc == "JPEG File")
                         {
                              file = new File(file.getAbsolutePath() + ".jpg");
                         } else if (desc == "PNG File")
                         {
                              file = new File(file.getAbsolutePath() + ".png");
                         } else if (desc == "Aze File")
                         {
                              file = new File(file.getAbsolutePath() + ".aze");
                         }
                    } else
                    {
                         String ext = Utils.getExtension(file);
                         if (!ext.equals("jpg") || !ext.equals("jpeg") || !ext.equals("png") || !ext.equals("aze"))
                         {
                              String desc = fc.getFileFilter().getDescription();
                              System.out.println(desc);
                              if (desc == "JPEG File")
                              {
                                   file = new File(file.getAbsolutePath() + ".jpg");
                              } else if (desc == "PNG File")
                              {
                                   file = new File(file.getAbsolutePath() + ".png");
                              } else if (desc == "Aze File")
                              {
                                   file = new File(file.getAbsolutePath() + ".aze");
                              }
                         }
                    }

                    String ext = Utils.getExtension(file);

                    if (ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png"))
                    {
                         GlyphWriter.writeImage(this, file);
                    } else if (ext.equals("aze"))
                    {
                         GlyphWriter.writeFile(this, file);
                    }
               }
               saveas = false;
          }
          if (e.getActionCommand().equals("Exit"))
          {
               container.dispatchEvent(new WindowEvent(container, WindowEvent.WINDOW_CLOSING));
          }
          if (e.getActionCommand().equals("fontSize"))
          {
               JComboBox<Integer> source = (JComboBox<Integer>) e.getSource();

               try
               {
                    regSize = (int) source.getSelectedItem();
                    fontSize = regSize * 2;

                    File temp = File.createTempFile("temp", null);
                    GlyphWriter.writeFile(this, temp);

                    EditorSave save = GlyphReader.read(temp);
                    loadSave(save);

                    temp.delete();
               } catch (IOException e1)
               {
                    e1.printStackTrace();
               }

               container.requestFocus();
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
