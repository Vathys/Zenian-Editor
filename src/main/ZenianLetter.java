package main;

enum ZenianLetter
{
     NULL("\u0000", Symmetry.NULL),
     I("\u0069", Symmetry.HORIZONTAL),
     Y("\u0079", Symmetry.HORIZONTAL),
     E("\u0065", Symmetry.HORIZONTAL),
     O_WITH_STROKE("\u00f8", Symmetry.HORIZONTAL),
     OPEN_E("\u025b", Symmetry.HORIZONTAL),
     LIGATURE_OE("\u0153", Symmetry.HORIZONTAL),
     A("\u0061", Symmetry.VERTICAL),
     LIGATURE_CAPITAL_OE("\u0276", Symmetry.VERTICAL),
     T("\u0074", Symmetry.HORIZONTAL),
     D("\u0064", Symmetry.HORIZONTAL),
     T_WITH_RETROFLEX_HOOK("\u0288", Symmetry.HORIZONTAL),
     D_WITH_TAIL("\u0256", Symmetry.HORIZONTAL),
     THETA("\u03b8", Symmetry.VERTICAL),
     ETH("\u00f0", Symmetry.VERTICAL),
     S("\u0073", Symmetry.HORIZONTAL),
     Z("\u007a", Symmetry.HORIZONTAL),
     ESH("\u0283", Symmetry.HORIZONTAL),
     EZH("\u0292", Symmetry.HORIZONTAL),
     S_WITH_HOOK("\u0282", Symmetry.HORIZONTAL),
     Z_WITH_RETROFLEX_HOOK("\u0290", Symmetry.HORIZONTAL),
     V_WITH_HOOK("\u028b", Symmetry.HORIZONTAL),
     J("\u006a", Symmetry.HORIZONTAL);
     
     private String key;
     private Symmetry sym;
     
     private ZenianLetter(String key, Symmetry sym) {
         this.key = key;
         this.sym = sym;
     }
     
     public String getCharacter() {
          return this.key;
     }
     
     public Symmetry getSymmetry() {
          return this.sym;
     }
     
     public int[] getLetterOffset()
     {
          int[] offset = new int[2];
          
          switch(this)
          {
               case I: 
                    offset[0] = 20;
                    offset[1] = 5;
                    break;
               case Y: 
                    offset[0] = 40;
                    offset[1] = 5;
                    break;
               case E:
                    offset[0] = 20;
                    offset[1] = 5;
                    break;
               case O_WITH_STROKE:
                    offset[0] = 20;
                    offset[1] = 20;
                    break;
               case OPEN_E:
                    offset[0] = 20;
                    offset[1] = 5;
                    break;
               case LIGATURE_OE:
                    offset[0] = 20;
                    offset[1] = 20;
                    break;
               case A:
                    offset[0] = 5;
                    offset[1] = 20;
                    break;
               case LIGATURE_CAPITAL_OE:
                    offset[0] = 5;
                    offset[1] = 40;
                    break;
               case T:
                    offset[0] = 45;
                    offset[1] = 5;
                    break;
               case D:
                    offset[0] = 45;
                    offset[1] = 5;
                    break;
               case T_WITH_RETROFLEX_HOOK:
                    offset[0] = 55;
                    offset[1] = 5;
                    break;
               case D_WITH_TAIL:
                    offset[0] = 55;
                    offset[1] = 5;
                    break;
               case THETA:
                    offset[0] = 5;
                    offset[1] = 20;
                    break;
               case ETH:
                    offset[0] = 5;
                    offset[1] = 20;
                    break;
               case S:
                    offset[0] = 20;
                    offset[1] = 5;
                    break;
               case Z:
                    offset[0] = 20;
                    offset[1] = 5;
                    break;
               case ESH:
                    offset[0] = 15;
                    offset[1] = 15;
                    break;
               case EZH:
                    offset[0] = 15;
                    offset[1] = 15;
                    break;
               case S_WITH_HOOK:
                    offset[0] = 15;
                    offset[1] = 15;
                    break;
               case Z_WITH_RETROFLEX_HOOK:
                    offset[0] = 15;
                    offset[1] = 15;
                    break;
               case V_WITH_HOOK:
                    offset[0] = 45;
                    offset[1] = 5;
                    break;
               case J:
                    offset[0] = 45;
                    offset[1] = 5;
                    break;
               default:
                    offset[0] = 0;
                    offset[1] = 0;
                    break;
          }
          
          return offset;
     }
}
