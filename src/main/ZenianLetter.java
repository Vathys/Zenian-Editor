package main;

import java.util.HashMap;
import java.util.Map;

enum ZenianLetter
{
          NULL("\u0000"), 
          I("\u0069"), 
          Y("\u0079"), 
          E("\u0065"), 
          O_WITH_STROKE("\u00f8"), 
          OPEN_E("\u025b"), 
          LIGATURE_OE("\u0153"), 
          A("\u0061"), 
          LIGATURE_CAPITAL_OE("\u0276"), 
          T("\u0074"), 
          D("\u0064"), 
          T_WITH_RETROFLEX_HOOK("\u0288"), 
          D_WITH_TAIL("\u0256"), 
          V_WITH_HOOK("\u028b"), 
          J("\u006a"),
          TURNED_R("\u0279"), 
          THETA("\u03b8"), 
          ETH("\u00f0"), 
          S("\u0073"), 
          Z("\u007a"), 
          ESH("\u0283"), 
          EZH("\u0292"), 
          S_WITH_HOOK("\u0282"), 
          Z_WITH_RETROFLEX_HOOK("\u0290");

     private String key;

     private ZenianLetter(String key)
     {
          this.key = key;
     }
     
     public String getCharacter()
     {
          return this.key;
     }
     
     public static ZenianLetter compare(int i)
     {
          for(ZenianLetter zl : values())
          {
               String val = zl.key;
               if(Character.codePointAt(val, 0) == i)
               {
                    return zl;
               }
          }
          return null;
     }
     
     public int[] getLetterOffset(int fontSize)
     {
          int[] offset = new int[2];

          switch (this)
          {
               case I:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;
                    break;
               case Y:
                    offset[0] = fontSize * 8;//40;
                    offset[1] = 0;
                    break;
               case E:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;
                    break;
               case O_WITH_STROKE:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;
                    break;
               case OPEN_E:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;
                    break;
               case LIGATURE_OE:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;
                    break;
               case A:
                    offset[0] = fontSize * 4;//5;
                    offset[1] = 0;
                    break;
               case LIGATURE_CAPITAL_OE:
                    offset[0] = fontSize * 4;//5;
                    offset[1] = 0;
                    break;
               case T:
                    offset[0] = fontSize * 8;//45;
                    offset[1] = 0;//5;
                    break;
               case D:
                    offset[0] = fontSize * 8;//45;
                    offset[1] = 0;//5;
                    break;
               case T_WITH_RETROFLEX_HOOK:
                    offset[0] = fontSize * 8;//55;
                    offset[1] = 0;//5;
                    break;
               case D_WITH_TAIL:
                    offset[0] = fontSize * 8;//55;
                    offset[1] = 0;//5;
                    break;
               case V_WITH_HOOK:
                    offset[0] = fontSize * 8;//45;
                    offset[1] = 0;//5;
                    break;
               case J:
                    offset[0] = fontSize * 8;//45;
                    offset[1] = 0;//5;
                    break;
               case TURNED_R:
                    offset[0] = fontSize * 8;
                    offset[1] = 0;
                    break;
               case THETA:
                    offset[0] = fontSize * 8;//5;
                    offset[1] = 0;//20;
                    break;
               case ETH:
                    offset[0] = fontSize * 8;//5;
                    offset[1] = 0;//20;
                    break;
               case S:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;//5;
                    break;
               case Z:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = 0;//5;
                    break;
               case ESH:
                    offset[0] = fontSize * 4;//15;
                    offset[1] = 0;//15;
                    break;
               case EZH:
                    offset[0] = fontSize * 4;//15;
                    offset[1] = 0;//15;
                    break;
               case S_WITH_HOOK:
                    offset[0] = fontSize * 4;//15;
                    offset[1] = 0;//15;
                    break;
               case Z_WITH_RETROFLEX_HOOK:
                    offset[0] = fontSize * 4;//15;
                    offset[1] = 0;//15;
                    break;
               default:
                    offset[0] = 0;
                    offset[1] = 0;
                    break;
          }

          return offset;
     }

     public  String getUnicodeCharacter() {
          return String.format("\\u%04x", (int) this.key.charAt(0));
      }
}
