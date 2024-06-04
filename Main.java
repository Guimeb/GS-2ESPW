import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        opMenu();
        opMenuCamera();
    }

    private static void opMenu() {
        //System.out.println("");
        System.out.println("====================================");
        System.out.println("-------- Projeto Onda Limpa --------");
        System.out.println("====================================");
    }

    private static void opMenuCamera() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Cadastrar Camera");
        System.out.println("2 - Listar Cameras");
        System.out.println("3 - Atualizar Camera");
        System.out.println("4 - Deletar Camera");
        System.out.println("5 - Sair");
        // User input scanner
        int optEsMenu = sc.nextInt();

        switch (optEsMenu) {
            case 1:
            System.out.println("Digite o endereço da câmera: ");
            String endereco = sc.nextLine();
            
            System.out.println("Digite o tipo da câmera (1 para CANAL, 2 para ESGOTO): ");
            int opTipo = sc.nextInt();
            Camera.TipoCam tipo = (opTipo == 1) ? Camera.TipoCam.Canal : Camera.TipoCam.Esgoto;
            
            Camera newCamera = new Camera(endereco, tipo);
            newCamera.addCamera(newCamera);
                
            System.out.println("Câmera cadastrada com sucesso!");
            newCamera.relatorioCam();
            break;
        
            default:
                break;
        }
    }
}
