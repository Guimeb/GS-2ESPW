package models;

import java.util.ArrayList;
import java.util.UUID;

public class Camera {
    private String id;
    private TipoCam tipo;
    private Canal canal;
    private Esgoto esgoto;
    private static ArrayList<Camera> cameras = new ArrayList<>();

    public enum TipoCam {
        Canal,
        Esgoto
    }

    public Camera(TipoCam tipo) {
        this.id = generateRandomId();
        this.tipo = tipo;
        this.canal = null;
        this.esgoto = null;
    }

    public static void addCamera(Camera camera) {
        cameras.add(camera);
    }

    public static void removeCamera(Camera camera) {
        cameras.remove(camera);
    }

    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

    public void relatorioCam() {
        System.out.println("ID: " + this.id);
        System.out.println("Tipo de câmera: " + this.tipo);
        if (this.canal != null) {
            System.out.println("Endereço: " + this.canal.getEndereco());
            System.out.println("Status: " + this.canal.getStatus());
        } else if (this.esgoto != null) {
            System.out.println("Endereço: " + this.esgoto.getEndereco());
            System.out.println("Status: " + this.esgoto.getStatus());
        }
    }

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

    public void setCanal(Canal canal) {
        this.canal = canal;
        if (canal != null) {
            this.esgoto = null;
        }
    }

    public Esgoto getEsgoto() {
        return esgoto;
    }

    public void setEsgoto(Esgoto esgoto) {
        this.esgoto = esgoto;
        if (esgoto != null) {
            this.canal = null;
        }
    }
}
