package main;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GlyphReader
{
     public static EditorSave read(String pathname)
     {
          return read(new File(pathname));
     }

     public static EditorSave read(File saveFile)
     {
          Scanner reader;
          EditorSave save = new EditorSave();
          ArrayList<ZenianLetter[]> column = new ArrayList<ZenianLetter[]>();

          Color tempColor = Color.BLACK;
          boolean runthrough = true;
          int tracker = 0;

          try
          {
               reader = new Scanner(saveFile);
               if(reader.hasNextLine())
               {
                    save.setFile(saveFile);
               }
               while (reader.hasNextLine())
               {
                    tracker++;
                    String dat = reader.nextLine();
                    ArrayList<String> temp;

                    if (tracker == 1)
                    {
                         temp = RegexParser.matches("fontSize: (\\d+);$", dat);
                         if (temp.size() == 1)
                         {
                              save.setFontSize(Integer.parseInt(temp.get(0)));
                         }
                    }

                    if (tracker == 2)
                    {
                         temp = RegexParser.matches("fontColor: (\\d{1,3})_(\\d{1,3})_(\\d{1,3});$", dat);
                         if (temp.size() == 3)
                         {
                              tempColor = new Color(Integer.parseInt(temp.get(0)), Integer.parseInt(temp.get(1)), Integer.parseInt(temp.get(2)));
                              save.setFontColor(tempColor);
                         }
                    }

                    if (tracker == 3)
                    {
                         temp = RegexParser.matches("backColor: (\\d{1,3})_(\\d{1,3})_(\\d{1,3});$", dat);
                         if (temp.size() == 3)
                         {
                              tempColor = new Color(Integer.parseInt(temp.get(0)), Integer.parseInt(temp.get(1)), Integer.parseInt(temp.get(2)));
                              save.setBackColor(tempColor);
                         }
                    }

                    if (tracker > 3)
                    {
                         temp = RegexParser.matches("Col (\\d*);", dat);
                         if (runthrough && temp.size() > 0)
                         {
                              runthrough = false;
                         }

                         temp = RegexParser.matches("TotalGlyph: (\\d+);$", dat);
                         if (runthrough && temp.size() > 0)
                         {
                              runthrough = false;
                         }

                         temp = RegexParser.matches("endcol (\\d)*", dat);
                         if (runthrough && temp.size() > 0)
                         {
                              save.addColumn(column);
                              column = new ArrayList<ZenianLetter[]>();
                              runthrough = false;
                         }

                         temp = RegexParser.matches("\\\\u([\\d\\w]{4})", dat);
                         if (temp.size() > 0)
                         {
                              ZenianLetter[] glyph = new ZenianLetter[temp.size()];

                              for (int i = 0; i < temp.size(); i++)
                              {
                                   glyph[i] = ZenianLetter.compare(Integer.parseInt(temp.get(i), 16));
                              }
                              column.add(glyph);

                              runthrough = false;
                         }
                    }

                    runthrough = true;
               }
          } 
          catch (Exception e)
          {
               e.printStackTrace();
               save.invalidate();
          }
          
          return save;
     }
}
