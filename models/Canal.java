package models;

import java.util.ArrayList;

public class Canal {
    private String nome;
    private String endereco;
    private String status;
    private ArrayList<Camera> cameras;
    private static ArrayList<Canal> canais = new ArrayList<>();

    public Canal(String nome, String endereco, String status) {
        this.nome = nome;
        this.endereco = endereco;
        this.status = status;
        this.cameras = new ArrayList<>();
    }

    public static void addCanal(Canal canal) {
        canais.add(canal);
    }

    public static void removeCanal(Canal canal) {
        canais.remove(canal);
        for (Camera camera : canal.getCameras()) {
            camera.setCanal(null);
        }
    }

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

    public void addCamera(Camera camera) {
        camera.setCanal(this); // Vincula a câmera ao canal
        this.cameras.add(camera);
    }

    public void removeCamera(Camera camera) {
        camera.setCanal(null); // Desvincula a câmera do canal
        this.cameras.remove(camera);
    }
}
