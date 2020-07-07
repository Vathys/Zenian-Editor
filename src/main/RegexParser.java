package main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser
{
     public static ArrayList<String> matches(String pattern, String text)
     {
          ArrayList<String> match = new ArrayList<String>();
          Pattern p = Pattern.compile(pattern);
          Matcher matcher = p.matcher(text);
          while (matcher.find())
          {
               //System.out.println("match found");
               for (int i = 1; i <= matcher.groupCount(); i++)
               {
                    match.add(matcher.group(i));
               }
          }

          return match;

     }
}
