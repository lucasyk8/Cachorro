//Direitos Autorais,PUCRS/Escola Politécnica
//Início: 2021-06-11
import java.util.Scanner;
/**
 * 
 * @author Lucas Yugi Kumagai
 * @version 1.1 (2021-06-11)
 * @version 1.2 (2021-06-14)
 * @version 1.3 (2021-06-16)
 */
public class Avaliação4
{   
    /**
     * cria o tabuleiro
     * 
     * @return void
     * 
     */
    public static void iniciar(String[][] tabuleiro){
        int l;
        int c;
        for(l = 0; l < 3; l++){
            for(c = 0; c <= 4; c++){
                if ((l == 0 && c == 0)||(l == 2 && c == 0)||
                (l == 0 && c == 4)||(l == 2 && c == 4)){
                    tabuleiro[l][c] = "  ";
                }else{
                    tabuleiro[l][c] = "00";
                }
            }
        }
    }

    /**
     * monta o tabuleiro
     * @param String[][] tabuleiro
     * @return void
     */
    public static void montaTela(String[][] tabuleiro)
    {
        int l;
        int c;
        System.out.println("================= ");
        for(l = 0; l < 3; l++){
            System.out.print(l +"|");
            for(c = 0; c < 5; c++){
                System.out.print(tabuleiro[l][c]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("================= ");
        System.out.println("  0  1  2  3  4  ");
    }

    public static void MainApp(String[] args)
    {
        //variáveis
        String dog;
        Scanner scan;
        scan = new Scanner(System.in);
        int l;
        int c;
        String player;
        String player2;
        int D1,D2,D3;
        int contarDog = 3;
        int movimentoValido = 0;
        int vencedor = 0;
        // visualização do tabuleiro 
        // 0|    00  00  D1 
        // 1| Le 00  00  00  D2
        // 2|    00  00  D3 
        //   --------------
        //   0   1   2   3   4

        String[][] tabuleiro = new String[3][5];
        iniciar(tabuleiro);
        // adição dos 3 cachorros e a lebre
        tabuleiro[1][0] = "Le";
        tabuleiro[0][3] = "D1";
        tabuleiro[1][4] = "D2";
        tabuleiro[2][3] = "D3";
        montaTela(tabuleiro);
        player = "Le";
        player2 = "Dog";
        while(vencedor == 0){
            //instruções para o player
            System.out.print("player informe coordenada (linha)");
            l = scan.nextInt();
            System.out.print("player informe coordenada (coluna)");
            c = scan.nextInt();
            if (AuxiliarL.validarMovimentoLe(tabuleiro,player,l,c) == 1) {  
                montaTela(tabuleiro);
            }else{
                System.out.println("jogada inválida, perde a vez");
            }
            //instruções para o player2
            System.out.println("qual cachorro D1,D2,D3");
            dog = scan.next();
            System.out.print("player2 informe coordenada (linha)");
            l = scan.nextInt();
            System.out.print("player2 informe coordenada (coluna)");
            c = scan.nextInt();
            if (AuxiliarC.validaMovimentoDogs(tabuleiro,dog,player2,l,c) > 0){  
                montaTela(tabuleiro);
            }else{
                System.out.println("jogada inválida, perdeu a vez");
            }
            //verfica se a lebre ganhou
            if ("Le".equals(tabuleiro[1][4])){
                System.out.print("lebre ganhou!");
                vencedor = 1;
            }
            //verfica se os cachorros ganharam
            for (l = 0; l <= 2; l++){
                if (!tabuleiro[l][1].equals("00")){
                    contarDog = contarDog - 1;
                    if (contarDog == 0 && tabuleiro[1][0].equals("Le")){
                        System.out.print("cachorros ganharam!");
                        vencedor = 1;
                    }
                }
            }
            contarDog = 3;
        }
        scan.close();
    }
}

