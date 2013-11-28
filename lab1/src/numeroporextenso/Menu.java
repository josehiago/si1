package numeroporextenso;
import java.util.Scanner;

public class Menu {
	public final static int LIMITEMINIMO = 0;
	public final static int LIMITEMAXIMO = 1000000000;
	static Scanner entrada = new Scanner(System.in);
		
	public static void menu(){
		System.out.println("--------------------------------------------------");
		System.out.println("LEITOR DE NUMEROS: BY HIAGO SOARES");
		System.out.println("DIGITE 1 PARA LER UM NUMERO OU DIGITE 0 PARA SAIR.");
        System.out.print("QUAL SUA OPCAO: ");
    }
	
	public static int leropcao(){
		String leitor = null;
		boolean valido = false;
		int numeroinicial = 0;
		do{ 
    		leitor = entrada.nextLine();
    		try {
    			numeroinicial = Integer.parseInt(leitor);
    			valido = false;
    		} catch (Exception e) {
    			valido = true;
    			System.out.print("DIGITE 0 OU 1: ");
		    }
         }while(valido);
		return numeroinicial;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
	    int opcao;
		Scanner entrada = new Scanner(System.in);
		boolean valido = false;
        String strignum  = null;
        int  numeroinicial = 0;
        do{
        	menu();//opcao = entrada.nextInt();
        	opcao = leropcao();
        	System.out.println("--------------------------------------------------");
            switch(opcao){
            case 1:
            	do{ System.out.print("DIGITE O NUMERO: ");
            		strignum = entrada.nextLine();
            		try {
            			numeroinicial = Integer.parseInt(strignum);
            			valido = false;
            		} catch (Exception e) {
            			valido = true;
				}
            }while(valido);	
                numeroinicial = Integer.parseInt(strignum); 
            	int num = numeroinicial; //int num = entrada.nextInt();
            	System.out.println("VOCE DIGITOU: "+ num);//mostra o numero
            	if (num< LIMITEMINIMO || num > LIMITEMAXIMO){
					System.out.println("NÚMERO INVÁLIDO. DIGTE NOVAMENTE");
				} else {
					System.out.print("NUMERO LIDO: ");
					NumeroPorExtenso numero = new NumeroPorExtenso(false);
					System.out.print(numero.converteInteiro(num));
					System.out.println("\n");
				}
            	break;
            default:
            	if (opcao == 0) {
            		System.out.println("VOCE SAIU DO LEITOR, OBRIGADO.");
				} else {
					System.out.println("OPCAO INVALIDA.");
				}
            }
        } while(opcao != 0);
	}
}