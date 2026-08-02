package br.com.biblioteca.model;

public class User {
    private int id;
    private String name;
    private String email;

    // Construtor atribuindo os valores
    public User(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    // Getter para leitura no Main
    public int getId() {return id;}
    public String getEmail() {return email;}
    public String getName() {return name;}

    // Setter para permitir a alteração do Email
    public void setEmail(String email) {this.email = email;}

}
