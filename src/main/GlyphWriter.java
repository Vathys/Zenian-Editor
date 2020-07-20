package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GlyphWriter
{
     public static File writeFile(Editor edit, String pathname)
     {
          return writeFile(edit, new File(pathname));
     }
     
     public static File writeImage(Editor edit, String pathname)
     {
          return writeImage(edit, new File(pathname));
     }
     
     public static File writeFile(Editor edit, File saveFile)
     {
          ArrayList<GlyphColumn> doc = edit.getGrid();
          if (!saveFile.isFile())
          {
               try
               {
                    saveFile.createNewFile();
               } catch (IOException e)
               {
                    e.printStackTrace();
               }
          }
          if (saveFile.canWrite())
          {
               try
               {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));

                    bw.write("fontSize: " + edit.getFontSize() + ";");
                    bw.newLine();
                    bw.write("fontColor: " + writeColor(edit.getFontColor()) + ";");
                    bw.newLine();
                    bw.write("backColor: " + writeColor(edit.getBackColor()) + ";");
                    bw.newLine();
                    
                    for (int i = 0; i < doc.size(); i++)
                    {
                         bw.write("Col " + i + ";");
                         bw.newLine();
                         String[] writeCol = doc.get(i).writeColumn();
                         for (int j = 0; j < writeCol.length; j++)
                         {
                              bw.write(writeCol[j]);
                              bw.newLine();
                         }
                         bw.write("endcol " + i + ";");
                         bw.newLine();
                    }

                    bw.close();
               } catch (IOException e)
               {
                    e.printStackTrace();
               }
          }

          return saveFile;
     }

     public static File writeImage(Editor edit, File file)
     {
          int width = edit.getFontSize() * 10;
          int height = 0;

          for (GlyphColumn a : edit.getGrid())
          {
               width += a.cellWidth + edit.getFontSize() * 10;
               if (a.getTotalHeight() > height)
               {
                    height = a.getTotalHeight();
               }
          }
          height += edit.getFontSize() * 8;

          BufferedImage buffImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
          Graphics offscreen = buffImage.getGraphics();
          offscreen.setColor(edit.getBackColor());
          offscreen.fillRect(0, 0, width, height);

          for (GlyphColumn a : edit.getGrid())
          {
               a.preRender();
               a.render(offscreen);
          }

          offscreen.dispose();

          if (!file.isFile())
          {
               try
               {
                    file.createNewFile();
               } catch (IOException e)
               {
                    e.printStackTrace();
               }
          }
          try
          {
               ImageIO.write(buffImage, Utils.getExtension(file), file);
          } catch (Exception e)
          {
               e.printStackTrace();
          }

          return file;
     }

     private static String writeColor(Color col)
     {
          return col.getRed() + "_" + col.getGreen() + "_" + col.getBlue();
     }
}
