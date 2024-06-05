import models.Camera;
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

        while (true) {
            System.out.println("1 - Cadastrar Camera");
            System.out.println("2 - Listar Cameras");
            System.out.println("3 - Atualizar Camera");
            System.out.println("4 - Deletar Camera");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int optEsMenu = sc.nextInt();
            sc.nextLine();  // Consome a nova linha

            switch (optEsMenu) {
                case 1:
                    System.out.print("Digite o endereço da câmera: ");
                    String endereco = sc.nextLine();
                    
                    System.out.print("Digite o tipo da câmera (1 para CANAL, 2 para ESGOTO): ");
                    int opTipo = sc.nextInt();
                    Camera.TipoCam tipo = (opTipo == 1) ? Camera.TipoCam.Canal : Camera.TipoCam.Esgoto;
                    sc.nextLine();  // Consome a nova linha
                    
                    Camera newCamera = new Camera(endereco, tipo);
                    Camera.addCamera(newCamera);
                        
                    System.out.println("Câmera cadastrada com sucesso!");
                    newCamera.relatorioCam();
                    break;
                case 2:
                    System.out.println("Listando Câmeras:");
                    for (Camera camera : Camera.getCameras()) {
                        camera.relatorioCam();
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID da câmera a ser atualizada: ");
                    String idAtualizar = sc.nextLine();
                    Camera cameraAtualizar = encontrarCameraPorId(idAtualizar);
                    if (cameraAtualizar != null) {
                        System.out.print("Digite o novo endereço: ");
                        cameraAtualizar.setEndereco(sc.nextLine());
                        System.out.print("Digite o novo tipo da câmera (1 para CANAL, 2 para ESGOTO): ");
                        int novoTipo = sc.nextInt();
                        cameraAtualizar.setTipo((novoTipo == 1) ? Camera.TipoCam.Canal : Camera.TipoCam.Esgoto);
                        sc.nextLine();  // Consome a nova linha
                        System.out.println("Câmera atualizada com sucesso!");
                    } else {
                        System.out.println("Câmera não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID da câmera a ser deletada: ");
                    String idDeletar = sc.nextLine();
                    Camera cameraDeletar = encontrarCameraPorId(idDeletar);
                    if (cameraDeletar != null) {
                        Camera.getCameras().remove(cameraDeletar);
                        System.out.println("Câmera deletada com sucesso!");
                    } else {
                        System.out.println("Câmera não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();  // Linha em branco para melhor formatação
        }
    }

    private static Camera encontrarCameraPorId(String id) {
        for (Camera camera : Camera.getCameras()) {
            if (camera.getId().equals(id)) {
                return camera;
            }
        }
        return null;
    }
}
