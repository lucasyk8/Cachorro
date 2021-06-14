//Direitos Autorais,PUCRS/Escola Politécnica
//Início: 2021-06-11
import java.util.Scanner;
/**
 * 
 * @author Lucas Yugi Kumagai
 * @version 1.0 (2021-06-11)
 */
public class Avaliação4
{   
    public static int validarMovimento(String[][] tabuleiro,String player, int lMovimento,int cMovimento){
        int movimentoValido = 0;
        int linhaLebre = 0;
        int colunaLebre = 0;
        int l,c;
        if(player.equals("Le")){
            //procura lebre
            for (l = 0; l < 2;l++){
                for (c = 0; c < 4;c++){
                    if (tabuleiro[l][c].equals("Le")){
                        linhaLebre = l;
                        colunaLebre = c;
                    }
                }
            }
            //valida movimento e movimenta
            for (l = 0; l < 2;l++){
                for (c = colunaLebre; c <= colunaLebre + 1; c++){ 
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
        return movimentoValido;
    } 

    public static void inicial(String[][] tabuleiro){
        //l = linha 
        int l;
        int c;

        for(l = 0; l < 3; l = l + 1){

            for(c = 0; c <= 4; c = c + 1){

                if ((l == 0 && c == 0)||(l == 2 && c == 0)||
                (l == 0 && c == 4)||(l == 2 && c == 4)){
                    tabuleiro[l][c] = "  ";
                }else{
                    tabuleiro[l][c] = "00";
                }
            }
        }
    }

    public static void montaTela(String[][] tabuleiro){
        //l = linha 
        int l;
        int c;
        for(l = 0; l < 3; l = l + 1){
            System.out.print(l + "|");
            for(c = 0; c < 5; c = c + 1){
                System.out.print(tabuleiro[l][c]  +" ");
                
            }
            System.out.println(" ");
        }
        System.out.println(" =============== ");
        System.out.println("  0  1  2  3  4  ");
    }

    public static void main(String[] args)
    {
        String cachorros;
        Scanner scan;
        scan = new Scanner(System.in);
        int l;
        int c;
        String player;
        String player2;
        int D1;
        int D2;
        int D3;

        // 0|    00  00  D1
        // 1| Le 00  00  00  D2
        // 2|    00  00  D3 
        //   --------------
        //   0   1   2   3   4

        //vez Lebre,
        String[][] tabuleiro = new String[3][5];
        inicial(tabuleiro);
        tabuleiro[1][0] = "Le";
        tabuleiro[0][3] = "D1";
        tabuleiro[1][4] = "D2";
        tabuleiro[2][3] = "D3";
        player = "Le";
        montaTela(tabuleiro);
        System.out.print("player1 informe coordenada (linha)");
        l = scan.nextInt();
        System.out.print("player1 informe coordenada (coluna)");
        c = scan.nextInt();
        //lebre
        //if (l > 0){
        if (validarMovimento(tabuleiro,player,l,c) > 0){  
            montaTela(tabuleiro);
        }else{
            System.out.print("jogada invalida");
        }
        //}
        scan.close();
    }
}