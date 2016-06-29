import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Eduardo Ribeiro
 */
public class MainNome {
    private NomeDAO nomeDAO;
    
    public MainNome() throws Exception{
        nomeDAO = new NomeDAO();
    }
    
    public static void main(String args[]) throws Exception{
        MainNome main = new MainNome();
        int opcao;
        while (true) {
            try{
            System.out.println("Escolha uma das opções e tecle <ENTER>: ");
            System.out.println("  1 - Incluir Nome");
            System.out.println("  2 - Alterar Nome");
            System.out.println("  3 - Remover Nome");
            System.out.println("  4 - Sair");
            Scanner sc = new Scanner(System.in,"ISO-8859-1");
            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    main.inserirContato();
                    break;
                case 2:
//                    main.alterarContato();
//                    break;
                case 3:
//                    main.removerContato();
//                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            if(opcao == 4){
                break;
            }
            }catch(Exception ex){
                System.out.println("Falha na operação. Mensagem="+ ex.getMessage());
                //ex.printStackTrace();
            }
        }
    }

    private void inserirContato() {
        System.out.println("Digite o nome: ");
        Scanner scn = new Scanner(System.in,"ISO-8859-1");
        String nome = scn.nextLine();
        System.out.println("Digite a idade: ");
        int idade = scn.nextInt();
        Nome nome1 = new Nome(nome, idade);
        nomeDAO.inserirNome(nome1);
    }
}
