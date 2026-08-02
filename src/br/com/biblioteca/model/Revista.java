package br.com.biblioteca.model;

public class Revista extends ItemBiblioteca{
    private int edicao;

    // Construtor
    public Revista(int id, String titulo, int edicao){
        super(id, titulo);
        this.edicao = edicao;
    }

    // Implement do met abstrato
    @Override
    public int calcularDiasEmprestimo() {
        return 7;
    }
    @Override
    public String toString(){
        return "ID " + getId() + " Titulo " + getTitulo() + " Edicao " + getEdicao() + " | Status: " + (isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO");
    }

    // Getter
    public int getEdicao() {return edicao;}
}
