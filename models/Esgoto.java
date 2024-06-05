package models;

import java.util.ArrayList;

public class Esgoto {
    private String nome;
    private String endereco;
    private String status;
    private ArrayList<Camera> cameras;
    private static ArrayList<Esgoto> esgotos = new ArrayList<>();

    public Esgoto(String nome, String endereco, String status) {
        this.nome = nome;
        this.endereco = endereco;
        this.status = status;
        this.cameras = new ArrayList<>();
    }

    public static void addEsgoto(Esgoto esgoto) {
        esgotos.add(esgoto);
    }

    public static void removeEsgoto(Esgoto esgoto) {
        esgotos.remove(esgoto);
        for (Camera camera : esgoto.getCameras()) {
            camera.setEsgoto(null);
        }
    }

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

    public void addCamera(Camera camera) {
        camera.setEsgoto(this); // Vincula a câmera ao esgoto
        this.cameras.add(camera);
    }

    public void removeCamera(Camera camera) {
        camera.setEsgoto(null); // Desvincula a câmera do esgoto
        this.cameras.remove(camera);
    }
}
