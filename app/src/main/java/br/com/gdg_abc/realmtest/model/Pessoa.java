package br.com.gdg_abc.realmtest.model;

import io.realm.RealmObject;

/**
 * Created by ecarrara on 30/04/2016.
 */
public class Pessoa extends RealmObject{

    private String nome;
    private String email;
    private String telefone;
    private String idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone, String idade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
