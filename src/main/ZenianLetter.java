package main;

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
     THETA("\u03b8"),
     ETH("\u00f0"),
     S("\u0073"),
     Z("\u007a"),
     ESH("\u0283"),
     EZH("\u0292"),
     S_WITH_HOOK("\u0282"),
     Z_WITH_RETROFLEX_HOOK("\u0290"),
     V_WITH_HOOK("\u028b"),
     J("\u006a");
     
     private String key;
     
     private ZenianLetter(String key) {
         this.key = key;
     }
     
     public String getCharacter() {
          return this.key;
     }
     
     public int[] getLetterOffset(int fontSize)
     {
          int[] offset = new int[2];
          
          switch(this)
          {
               case I: 
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize;//5;
                    break;
               case Y: 
                    offset[0] = fontSize * 8;//40;
                    offset[1] = fontSize;//5;
                    break;
               case E:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize;//5;
                    break;
               case O_WITH_STROKE:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize * 4;//20;
                    break;
               case OPEN_E:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize;//5;
                    break;
               case LIGATURE_OE:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize * 4;//20;
                    break;
               case A:
                    offset[0] = fontSize;//5;
                    offset[1] = fontSize * 4;//20;
                    break;
               case LIGATURE_CAPITAL_OE:
                    offset[0] = fontSize;//5;
                    offset[1] = fontSize * 8;//40;
                    break;
               case T:
                    offset[0] = fontSize * 9;//45;
                    offset[1] = fontSize;//5;
                    break;
               case D:
                    offset[0] = fontSize * 9;//45;
                    offset[1] = fontSize;//5;
                    break;
               case T_WITH_RETROFLEX_HOOK:
                    offset[0] = fontSize * 11;//55;
                    offset[1] = fontSize;//5;
                    break;
               case D_WITH_TAIL:
                    offset[0] = fontSize * 11;//55;
                    offset[1] = fontSize;//5;
                    break;
               case THETA:
                    offset[0] = fontSize;//5;
                    offset[1] = fontSize * 4;//20;
                    break;
               case ETH:
                    offset[0] = fontSize;//5;
                    offset[1] = fontSize * 4;//20;
                    break;
               case S:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize;//5;
                    break;
               case Z:
                    offset[0] = fontSize * 4;//20;
                    offset[1] = fontSize;//5;
                    break;
               case ESH:
                    offset[0] = fontSize * 3;//15;
                    offset[1] = fontSize * 3;//15;
                    break;
               case EZH:
                    offset[0] = fontSize * 3;//15;
                    offset[1] = fontSize * 3;//15;
                    break;
               case S_WITH_HOOK:
                    offset[0] = fontSize * 3;//15;
                    offset[1] = fontSize * 3;//15;
                    break;
               case Z_WITH_RETROFLEX_HOOK:
                    offset[0] = fontSize * 3;//15;
                    offset[1] = fontSize * 3;//15;
                    break;
               case V_WITH_HOOK:
                    offset[0] = fontSize * 9;//45;
                    offset[1] = fontSize;//5;
                    break;
               case J:
                    offset[0] = fontSize * 9;//45;
                    offset[1] = fontSize;//5;
                    break;
               default:
                    offset[0] = 0;
                    offset[1] = 0;
                    break;
          }
          
          return offset;
     }
}
