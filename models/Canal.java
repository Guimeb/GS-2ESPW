package models;

import java.util.ArrayList;

public class Canal {
    // Atributos da classe Canal
    private String nome; // Nome do canal
    private String endereco; // Endereço do canal
    private String status; // Status do canal
    private ArrayList<Camera> cameras; // Lista de câmeras associadas ao canal
    private static ArrayList<Canal> canais = new ArrayList<>(); // Lista estática de todos os canais criados

    // Construtor que inicializa o canal com nome, endereço e status
    public Canal(String nome, String endereco, String status) {
        this.nome = nome; // Define o nome do canal
        this.endereco = endereco; // Define o endereço do canal
        this.status = status; // Define o status do canal
        this.cameras = new ArrayList<>(); // Inicializa a lista de câmeras
    }

    // Método estático para adicionar um canal à lista de canais
    public static void addCanal(Canal canal) {
        canais.add(canal);
    }

    // Método estático para remover um canal da lista de canais
    public static void removeCanal(Canal canal) {
        canais.remove(canal); // Remove o canal da lista
        for (Camera camera : canal.getCameras()) { // Para cada câmera associada ao canal
            camera.setCanal(null); // Desvincula a câmera do canal
        }
    }

    // Getters e Setters para os atributos da classe
    public static ArrayList<Canal> getCanais() {
        return canais;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Camera> getCameras() {
        return cameras;
    }

    // Método para adicionar uma câmera ao canal
    public void addCamera(Camera camera) {
        camera.setCanal(this); // Vincula a câmera ao canal
        this.cameras.add(camera); // Adiciona a câmera à lista de câmeras do canal
    }

    // Método para remover uma câmera do canal
    public void removeCamera(Camera camera) {
        camera.setCanal(null); // Desvincula a câmera do canal
        this.cameras.remove(camera); // Remove a câmera da lista de câmeras do canal
    }
}
