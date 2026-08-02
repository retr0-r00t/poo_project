package br.com.biblioteca.model;

public abstract class ItemBiblioteca {
    private int id;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponivel = true; // item por padrão disponivel com TRUE
    }

    public abstract int calcularDiasEmprestimo();

    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    // Setter / Alteração de estado
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}