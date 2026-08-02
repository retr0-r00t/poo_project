package br.com.biblioteca.model;

public class Livro extends ItemBiblioteca{
    private String autor;
    private int numeroPaginas;

    public Livro(int id, String titulo, String autor, int numeroPaginas) {
        super(id, titulo);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    // Implement do metodo abstrato
    @Override
    public int calcularDiasEmprestimo() {
        return 14;
    }
    @Override
    public String toString(){
        return "ID " + getId() + " | Livro: " + getTitulo() + " | Autor: " + autor + " | Status: " + (isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO");
    }
    // Getters
    public int getNumeroPaginas() {return numeroPaginas;}
    public String getAutor() {return autor;}
}
