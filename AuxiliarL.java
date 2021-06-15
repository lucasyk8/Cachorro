
/**
 * O auxliar procura a lebre no tabuleiro, valida e executa o movimento que 
 * o jogador informou
 * 
 * @author Lucas Yugi Kumagai 
 * @version 1.0 2021-06-15
 */
class AuxiliarL
{
    /**
     * @paran String[][] tabuleiro,String player,int lMovimento,int cMovimento
     * @return movimentoValido
     */
    public static int validarMovimentoLe(String[][] tabuleiro,String player,int lMovimento,int cMovimento){
        int movimentoValido = 0;
        int linhaLebre = 0;
        int colunaLebre = 0;
        int l,c;
        if(player.equals("Le")){
            //procura lebre
            for (l = 0; l <= 2;l++){
                for (c = 0; c <= 4;c++){
                    if (tabuleiro[l][c].equals("Le")){
                        linhaLebre = l;
                        colunaLebre = c;
                    }
                }
            }
            //valida movimento e movimenta
            for (l = 0; l <= 2;l++){
                if(cMovimento > colunaLebre){
                    for (c = colunaLebre; c <= colunaLebre + 1; c++){  
                        if (tabuleiro[l][c].equals("00")){
                            if(lMovimento == l && cMovimento == c){ 
                                tabuleiro[l][c] = "Le";
                                tabuleiro[linhaLebre][colunaLebre] = "00";
                                movimentoValido = 1;
                            }
                        }
                    }
                }else{
                    for (c = colunaLebre; c >= colunaLebre - 1 ; c--){
                        if (tabuleiro[l][c].equals("00")){
                            if(lMovimento == l && cMovimento == c){ 
                                tabuleiro[l][c] = "Le";
                                tabuleiro[linhaLebre][colunaLebre] = "00";
                                movimentoValido = 1;
                            }
                        }
                    }
                }
            } 
        }
        return movimentoValido;
    }
}
