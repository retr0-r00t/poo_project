package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private User usuario;
    private ItemBiblioteca item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private boolean devolvido;

    public Emprestimo(User usuario, ItemBiblioteca item) {
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = LocalDate.now(); //Pega a data atual do sistema

        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(item.calcularDiasEmprestimo());

        this.devolvido = false;
        this.item.setDisponivel(false);
    }

    public void devolverItem() {
        this.devolvido = true;
        this.item.setDisponivel(true);
    }
    // Getters
    public User getUsuario() {return usuario;}
    public ItemBiblioteca getItem() {return item;}
    public LocalDate getDataEmprestimo() {return dataEmprestimo;}
    public LocalDate getDataDevolucaoPrevista() {return dataDevolucaoPrevista;}
    public boolean isDevolvido() {return devolvido;}
}
