package com.example.appcorrida;

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private Boolean professor;


    // Criando todos os Getters e Setters.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getProfessor() {
        return professor;
    }

    public void setProfessor(Boolean professor) {
        this.professor = professor;
    }
}
