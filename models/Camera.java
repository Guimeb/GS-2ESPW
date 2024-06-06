package models;

import java.util.ArrayList;
import java.util.UUID;

public class Camera {
    // Atributos da classe Camera
    private String id; // Identificador único da câmera
    private TipoCam tipo; // Tipo de câmera: Canal ou Esgoto
    private Canal canal; // Objeto Canal associado à câmera (se tipo for Canal)
    private Esgoto esgoto; // Objeto Esgoto associado à câmera (se tipo for Esgoto)
    private static ArrayList<Camera> cameras = new ArrayList<>(); // Lista estática de todas as câmeras criadas

    // Enumeração que define os tipos de câmeras possíveis
    public enum TipoCam {
        Canal,
        Esgoto
    }

    // Construtor que inicializa a câmera com um tipo e gera um id único
    public Camera(TipoCam tipo) {
        this.id = generateRandomId(); // Gera um identificador único
        this.tipo = tipo; // Define o tipo da câmera
        this.canal = null; // Inicializa o canal como null
        this.esgoto = null; // Inicializa o esgoto como null
    }

    // Método estático para adicionar uma câmera à lista de câmeras
    public static void addCamera(Camera camera) {
        cameras.add(camera);
    }

    // Método estático para remover uma câmera da lista de câmeras
    public static void removeCamera(Camera camera) {
        cameras.remove(camera);
    }

    // Método privado que gera um identificador único usando UUID
    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    // Método que imprime o relatório da câmera
    public void relatorioCam() {
        System.out.println("ID: " + this.id);
        System.out.println("Tipo de câmera: " + this.tipo);
        if (this.canal != null) { // Se a câmera estiver associada a um canal
            System.out.println("Endereço: " + this.canal.getEndereco());
            System.out.println("Status: " + this.canal.getStatus());
        } else if (this.esgoto != null) { // Se a câmera estiver associada a um esgoto
            System.out.println("Endereço: " + this.esgoto.getEndereco());
            System.out.println("Status: " + this.esgoto.getStatus());
        }
    }

    // Getters e Setters para os atributos da classe
    public String getId() {
        return id;
    }

    public TipoCam getTipo() {
        return tipo;
    }

    public static ArrayList<Camera> getCameras() {
        return cameras;
    }

    public Canal getCanal() {
        return canal;
    }

    // Método para definir o canal da câmera, com validação do tipo
    public void setCanal(Canal canal) {
        if (this.tipo == TipoCam.Canal) { // Verifica se o tipo da câmera é Canal
            this.canal = canal;
            if (canal != null) { // Se um canal for associado, o esgoto é definido como null
                this.esgoto = null;
            }
        } else {
            System.out.println("Erro: Câmera de esgoto não pode ser vinculada a um canal.");
        }
    }

    public Esgoto getEsgoto() {
        return esgoto;
    }

    // Método para definir o esgoto da câmera, com validação do tipo
    public void setEsgoto(Esgoto esgoto) {
        if (this.tipo == TipoCam.Esgoto) { // Verifica se o tipo da câmera é Esgoto
            this.esgoto = esgoto;
            if (esgoto != null) { // Se um esgoto for associado, o canal é definido como null
                this.canal = null;
            }
        } else {
            System.out.println("Erro: Câmera de canal não pode ser vinculada a um esgoto.");
        }
    }
}
