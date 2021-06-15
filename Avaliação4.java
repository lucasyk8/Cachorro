//Direitos Autorais,PUCRS/Escola Politécnica
//Início: 2021-06-11
import java.util.Scanner;
/**
 * 
 * @author Lucas Yugi Kumagai
 * @version 1.1 (2021-06-11)
 */
public class Avaliação4
{   
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
            //   5                                  4
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

    public static void iniciar(String[][] tabuleiro){
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

    public static void montaTela(String[][] tabuleiro)
    {
        //l = linha 
        int l;
        int c;
        System.out.println("================= ");
        for(l = 0; l < 3; l = l + 1){
            System.out.print(l +"|");
            for(c = 0; c < 5; c = c + 1){
                System.out.print(tabuleiro[l][c]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("================= ");
        System.out.println("  0  1  2  3  4  ");
    }

    public static void main(String[] args)
    {
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

        // 0|    00  00  D1       
        // 1| Le 00  00  00  D2
        // 2|    00  00  D3 
        //   --------------
        //   0   1   2   3   4

        //vez Lebre,
        String[][] tabuleiro = new String[3][5];
        iniciar(tabuleiro);
        tabuleiro[1][0] = "Le";
        tabuleiro[0][3] = "D1";
        tabuleiro[1][4] = "D2";
        tabuleiro[2][3] = "D3";
        montaTela(tabuleiro);
        player = "Le";
        player2 = "Dog";
        //while(){
        System.out.print("player informe coordenada (linha)");
        l = scan.nextInt();
        System.out.print("player informe coordenada (coluna)");
        c = scan.nextInt();
        if (validarMovimentoLe(tabuleiro,player,l,c) > 0){  
            montaTela(tabuleiro);
        }else{
            System.out.println("jogada invalida");
        }
        if ("Le".equals(tabuleiro[1][4])){
            System.out.print("ganhou");
        }
        System.out.println("qual cachorro D1,D2,D3");
        dog = scan.next();
        System.out.print("player2 informe coordenada (linha)");
        l = scan.nextInt();
        System.out.print("player2 informe coordenada (coluna)");
        c = scan.nextInt();
        if (validaMovimentoDogs(tabuleiro,dog,player2,l,c) > 0){  
            montaTela(tabuleiro);
        }else{
            System.out.println("jogada invalida");
        }
        for (l = 0; l <= 2;){
            if(c == 1){
                if(tabuleiro[l][c].equals("00")){
                    contarDog = contarDog - 1;
                    if (contarDog == 0 && "Le".equals(tabuleiro[1][0])){
                        System.out.print("ganhou");
                    }
                }
            }
        }
        scan.close();
    }

}
//}
