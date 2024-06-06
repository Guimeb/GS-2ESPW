package models;

import java.util.ArrayList;

public class Esgoto {
    // Atributos da classe Esgoto
    private String nome; // Nome do esgoto
    private String endereco; // Endereço do esgoto
    private String status; // Status do esgoto
    private ArrayList<Camera> cameras; // Lista de câmeras associadas ao esgoto
    private static ArrayList<Esgoto> esgotos = new ArrayList<>(); // Lista estática de todos os esgotos criados

    // Construtor que inicializa o esgoto com nome, endereço e status
    public Esgoto(String nome, String endereco, String status) {
        this.nome = nome; // Define o nome do esgoto
        this.endereco = endereco; // Define o endereço do esgoto
        this.status = status; // Define o status do esgoto
        this.cameras = new ArrayList<>(); // Inicializa a lista de câmeras
    }

    // Método estático para adicionar um esgoto à lista de esgotos
    public static void addEsgoto(Esgoto esgoto) {
        esgotos.add(esgoto);
    }

    // Método estático para remover um esgoto da lista de esgotos
    public static void removeEsgoto(Esgoto esgoto) {
        esgotos.remove(esgoto); // Remove o esgoto da lista
        for (Camera camera : esgoto.getCameras()) { // Para cada câmera associada ao esgoto
            camera.setEsgoto(null); // Desvincula a câmera do esgoto
        }
    }

    // Getters e Setters para os atributos da classe
    public static ArrayList<Esgoto> getEsgotos() {
        return esgotos;
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

    // Método para adicionar uma câmera ao esgoto
    public void addCamera(Camera camera) {
        camera.setEsgoto(this); // Vincula a câmera ao esgoto
        this.cameras.add(camera); // Adiciona a câmera à lista de câmeras do esgoto
    }

    // Método para remover uma câmera do esgoto
    public void removeCamera(Camera camera) {
        camera.setEsgoto(null); // Desvincula a câmera do esgoto
        this.cameras.remove(camera); // Remove a câmera da lista de câmeras do esgoto
    }
}
