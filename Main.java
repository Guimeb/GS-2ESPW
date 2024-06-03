import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        opMenu();
        opMenuEsgoto();
        Esgoto esgoto = new Esgoto("Esgoto 1", "1", "Rua 1", "Ativo");
        esgotoPrint(esgoto);
    }

    private static void opMenu() {
        //System.out.println("");
        System.out.println("====================================");
        System.out.println("-------- Projeto Onda Limpa --------");
        System.out.println("====================================");
    }

    private static void opMenuEsgoto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Cadastrar Esgoto");
        System.out.println("2 - Listar Esgoto");
        System.out.println("3 - Atualizar Esgoto");
        System.out.println("4 - Deletar Esgoto");
        System.out.println("5 - Sair");
        // User input scanner
        int optEsMenu = sc.nextInt();

        switch (optEsMenu) {
            case 1:
                opMenu();
                break;
        
            default:
                break;
        }
    }

    private static void esgotoPrint(Esgoto esgoto) {
        System.out.println("Nome: " + esgoto.getNome());
        System.out.println("ID: " + esgoto.getId());
        System.out.println("Endereço: " + esgoto.getEndereco());
        System.out.println("Status: " + esgoto.getStatus());
    }
}
