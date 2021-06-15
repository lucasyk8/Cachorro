
/**
 * O auxliar procura o cahorro informado no tabuleiro, valida e executa o movimento que 
 * o jogador informou
 * 
 * @author Lucas Yugi Kumagai
 * @version 1.0 2021-06-15
 */
public class AuxiliarC
{
    /**
     * 
     * @paran String[][] tabuleiro,String dog,String player2, int lMovimento,int cMovimento
     * @return movimentoValido
     */
    public static int validaMovimentoDogs(String[][] tabuleiro,String dog,String player2, int lMovimento,int cMovimento)
    {
        int movimentoValido = 0;
        int linhaDog = 0;
        int colunaDog = 0;
        int l,c;
        //procura cachorro
        for (l = 0; l <= 2;l++){
            for (c = 0; c <= 4;c++){
                if (tabuleiro[l][c].equals(dog)){
                    linhaDog = l;
                    colunaDog = c;

                }
            }
        }
        //valida movimento e movimenta
        for (l = 0; l <= 2;l++){
            for (c = colunaDog; c >= colunaDog - 1 ; c--){ 
                if (tabuleiro[l][c].equals("00")){
                    if(lMovimento == l && cMovimento == c){ 
                        tabuleiro[l][c] = dog;
                        tabuleiro[linhaDog][colunaDog] = "00";
                        movimentoValido = 1;
                    }
                }
            }
        }
        return movimentoValido;
    }
}
