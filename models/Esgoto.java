package models;


public class Esgoto {
    private String nome;
    private String id;
    private String endereco;
    private String status;

    public Esgoto(String nome, String id, String endereco, String status) {
        this.nome = nome;
        this.id = id;
        this.endereco = endereco;
        this.status = status;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
