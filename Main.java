import models.Camera;
import models.Canal;
import models.Esgoto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        opMenu();
        opMenuPrincipal();
    }

    // Método para exibir o cabeçalho do menu
    private static void opMenu() {
        System.out.println("====================================");
        System.out.println("-------- Projeto Onda Limpa --------");
        System.out.println("====================================");
    }

    // Método para exibir e gerenciar o menu principal
    private static void opMenuPrincipal() {
        Scanner sc = new Scanner(System.in);

        // Loop infinito para exibir e manter o menu em execução até que o usuário escolha sair
        while (true) {
            System.out.println("1 - Cadastrar Canal");
            System.out.println("2 - Cadastrar Esgoto");
            System.out.println("3 - Cadastrar Camera");
            System.out.println("4 - Listar Canais");
            System.out.println("5 - Listar Esgotos");
            System.out.println("6 - Listar Cameras");
            System.out.println("7 - Vincular/Desvincular Camera a Canal/Esgoto");
            System.out.println("8 - Apagar Canal");
            System.out.println("9 - Apagar Esgoto");
            System.out.println("10 - Apagar Camera");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");
            int optEsMenu = sc.nextInt(); // Leitura da opção escolhida pelo usuário
            sc.nextLine();  // Consome a nova linha
            System.out.print("");

            // Estrutura de controle para as opções do menu
            switch (optEsMenu) {
                case 1:
                    cadastrarCanal(sc);
                    separacao();
                    break;
                case 2:
                    cadastrarEsgoto(sc);
                    separacao();
                    break;
                case 3:
                    cadastrarCamera(sc);
                    separacao();
                    break;
                case 4:
                    listarCanais();
                    separacao();
                    break;
                case 5:
                    listarEsgotos();
                    separacao();
                    break;
                case 6:
                    listarCameras();
                    separacao();
                    break;
                case 7:
                    vincularDesvincularCamera(sc);
                    separacao();
                    break;
                case 8:
                    apagarCanal(sc);
                    separacao();
                    break;
                case 9:
                    apagarEsgoto(sc);
                    separacao();
                    break;
                case 10:
                    apagarCamera(sc);
                    separacao();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    separacao();
            }
            System.out.println();  // Linha em branco para melhor formatação
        }
    }

    // Método para cadastrar um canal
    private static void cadastrarCanal(Scanner sc) {
        System.out.print("Digite o nome do canal: ");
        String nome = sc.nextLine();

        System.out.print("Digite o endereço do canal: ");
        String endereco = sc.nextLine();

        System.out.print("Digite o status do canal: ");
        String status = sc.nextLine();

        // Criação de um novo objeto Canal com os dados fornecidos pelo usuário
        Canal newCanal = new Canal(nome, endereco, status);
        Canal.addCanal(newCanal);
        System.out.println("Canal cadastrado com sucesso!");
    }

    // Método para cadastrar um esgoto
    private static void cadastrarEsgoto(Scanner sc) {
        System.out.print("Digite o nome do esgoto: ");
        String nome = sc.nextLine();

        System.out.print("Digite o endereço do esgoto: ");
        String endereco = sc.nextLine();

        System.out.print("Digite o status do esgoto: ");
        String status = sc.nextLine();

        // Criação de um novo objeto Esgoto com os dados fornecidos pelo usuário
        Esgoto newEsgoto = new Esgoto(nome, endereco, status);
        Esgoto.addEsgoto(newEsgoto); // Adição do esgoto à lista de esgotos
        System.out.println("Esgoto cadastrado com sucesso!");
    }

    // Método para cadastrar uma câmera
    private static void cadastrarCamera(Scanner sc) {
        System.out.print("Digite o tipo da câmera (1 para CANAL, 2 para ESGOTO): ");
        int opTipo = sc.nextInt();
        Camera.TipoCam tipo = (opTipo == 1) ? Camera.TipoCam.Canal : Camera.TipoCam.Esgoto; // Converte a entrada do usuário para o tipo Camera.TipoCam correspondente
        sc.nextLine();  // Consome a nova linha

        Camera newCamera = new Camera(tipo); // Criação de um novo objeto Camera com o tipo especificado pelo usuário
        Camera.addCamera(newCamera); // Adição da câmera à lista de câmeras
        System.out.println("Câmera cadastrada com sucesso!");

        newCamera.relatorioCam(); // Exibição do relatório da câmera cadastrada
    }

    // Método para vincular ou desvincular uma câmera de um canal ou esgoto
    private static void vincularDesvincularCamera(Scanner sc) {
        System.out.println("Vincular/Desvincular Câmera:");
        listarCameras();
        System.out.print("Digite o ID da câmera: ");
        String cameraId = sc.nextLine();
        Camera camera = encontrarCameraPorId(cameraId);
        if (camera != null) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Vincular a Canal");
            System.out.println("2 - Vincular a Esgoto");
            System.out.println("3 - Desvincular");
            int opcao = sc.nextInt();
            sc.nextLine(); // Consome a nova linha
            switch (opcao) {
                case 1:
                    listarCanais();
                    System.out.print("Digite o nome do canal: ");
                    String nomeCanal = sc.nextLine();
                    Canal canal = encontrarCanalPorNome(nomeCanal);
                    if (canal != null) {
                        if (camera.getTipo() == Camera.TipoCam.Canal) {
                            camera.setCanal(canal);
                            System.out.println("Câmera vinculada ao canal com sucesso!");
                        } else {
                            System.out.println("Erro: Câmera de esgoto não pode ser vinculada a um canal.");
                        }
                    } else {
                        System.out.println("Canal não encontrado.");
                    }
                    break;
                case 2:
                    listarEsgotos();
                    System.out.print("Digite o nome do esgoto: ");
                    String nomeEsgoto = sc.nextLine();
                    Esgoto esgoto = encontrarEsgotoPorNome(nomeEsgoto);
                    if (esgoto != null) {
                        if (camera.getTipo() == Camera.TipoCam.Esgoto) {
                            camera.setEsgoto(esgoto);
                            System.out.println("Câmera vinculada ao esgoto com sucesso!");
                        } else {
                            System.out.println("Erro: Câmera de canal não pode ser vinculada a um esgoto.");
                        }
                    } else {
                        System.out.println("Esgoto não encontrado.");
                    }
                    break;
                case 3:
                    camera.setCanal(null);
                    camera.setEsgoto(null);
                    System.out.println("Câmera desvinculada.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Câmera não encontrada.");
        }
    }

    // Método para apagar um canal
    private static void apagarCanal(Scanner sc) {
        System.out.println("Apagar Canal:");
        listarCanais();
        System.out.print("Digite o nome do canal a ser apagado: ");
        String nomeCanal = sc.nextLine();
        Canal canal = encontrarCanalPorNome(nomeCanal);
        if (canal != null) {
            Canal.removeCanal(canal);
            System.out.println("Canal apagado com sucesso.");
        } else {
            System.out.println("Canal não encontrado.");
        }
    }

    // Método para apagar um esgoto
    private static void apagarEsgoto(Scanner sc) {
        System.out.println("Apagar Esgoto:");
        listarEsgotos();
        System.out.print("Digite o nome do esgoto a ser apagado: ");
        String nomeEsgoto = sc.nextLine();
        Esgoto esgoto = encontrarEsgotoPorNome(nomeEsgoto);
        if (esgoto != null) {
            Esgoto.removeEsgoto(esgoto);
            System.out.println("Esgoto apagado com sucesso.");
        } else {
            System.out.println("Esgoto não encontrado.");
        }
    }

    // Método para apagar uma câmera
    private static void apagarCamera(Scanner sc) {
        System.out.println("Apagar Câmera:");
        listarCameras();
        System.out.print("Digite o ID da câmera a ser apagada: ");
        String cameraId = sc.nextLine();
        Camera camera = encontrarCameraPorId(cameraId);
        if (camera != null) {
            Camera.removeCamera(camera);
            System.out.println("Câmera apagada com sucesso.");
        } else {
            System.out.println("Câmera não encontrada.");
        }
    }

    // Método para listar todos os canais cadastrados
    private static void listarCanais() {
        System.out.println("Listando Canais:");
        for (Canal canal : Canal.getCanais()) {
            System.out.println("Nome: " + canal.getNome());
            System.out.println("Endereço: " + canal.getEndereco());
            System.out.println("Status: " + canal.getStatus());
            System.out.println();
        }
    }

    // Método para listar todos os esgotos cadastrados
    private static void listarEsgotos() {
        System.out.println("Listando Esgotos:");
        for (Esgoto esgoto : Esgoto.getEsgotos()) {
            System.out.println("Nome: " + esgoto.getNome());
            System.out.println("Endereço: " + esgoto.getEndereco());
            System.out.println("Status: " + esgoto.getStatus());
            System.out.println();
        }
    }

    // Método para listar todas as câmeras cadastradas
    private static void listarCameras() {
        System.out.println("Listando Câmeras:");
        for (Camera camera : Camera.getCameras()) {
            camera.relatorioCam();
            System.out.println();
        }
    }

    // Método para encontrar cada objeto por ID
    private static Camera encontrarCameraPorId(String id) {
        for (Camera camera : Camera.getCameras()) {
            if (camera.getId().equals(id)) {
                return camera;
            }
        }
        return null;
    }

    private static Canal encontrarCanalPorNome(String nome) {
        for (Canal canal : Canal.getCanais()) {
            if (canal.getNome().equalsIgnoreCase(nome)) {
                return canal;
            }
        }
        return null;
    }

    private static Esgoto encontrarEsgotoPorNome(String nome) {
        for (Esgoto esgoto : Esgoto.getEsgotos()) {
            if (esgoto.getNome().equalsIgnoreCase(nome)) {
                return esgoto;
            }
        }
        return null;
    }

    // Método para exibir uma linha de separação
    private static void separacao() {
        System.out.println("====================================");
    }
}