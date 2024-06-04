package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Camera {
    private String id;
    private String endereco;
    private TipoCam tipo;
    private ArrayList<Camera> cameras = new ArrayList<>();

    public enum TipoCam {
        Canal,
        Esgoto
    }

    public Camera(String endereco, TipoCam tipo) {
        this.id = generateRandomId();
        this.endereco = endereco;
        this.tipo = tipo;
        this.cameras = new ArrayList<>();
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
    }

    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    public void relatorioCam(){
        System.out.println("ID: " + this.id);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Tipo de camera: " + this.tipo);
        Random random = new Random();
        int numeroAleatorio = random.nextInt(5) + 1;
        System.out.println("Número aleatorio: " + numeroAleatorio);
        switch (numeroAleatorio) {
            case 1:
                System.out.println("Vias limpas");
                break;
            case 2:
                System.out.println("Vias com poluição baixa");
                break;
            case 3:
                System.out.println("Vias com poluição moderada");
                break;
            case 4:
                System.out.println("Vias com alta poluição");
                break;
            case 5:
                System.out.println("Vias em situação crítica");
                break;
            default:
                break;
        }
    }
    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoCam getTipo() {
        return tipo;
    }

    public void setTipo(TipoCam tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Camera> getCameras() {
        return cameras;
    }
}
