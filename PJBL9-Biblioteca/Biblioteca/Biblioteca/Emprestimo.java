package Biblioteca;
import java.util.Scanner;

import java.time.LocalDate;

public class Emprestimo {
    private itemBiblioteca itemEmprestado;
    private int idEmprestimo;
    private Usuario usuario;
    private int prazoDevolucao;
    private boolean pendente; //se pendente é false o item está emprestado

    public Emprestimo(itemBiblioteca itemEmprestado, int idEmprestimo, Usuario usuario, int prazoDevolucao) {
        this.itemEmprestado = itemEmprestado;
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.prazoDevolucao = prazoDevolucao;
        this.pendente = false;
    }

public String verificaStatus() {
    LocalDate dataDevolucao = LocalDate.now().plusDays(prazoDevolucao);
    LocalDate dataAtual = LocalDate.now();

    if (dataAtual.isBefore(dataDevolucao)) {
        return "Em dia";
    } else if (dataAtual.isEqual(dataDevolucao)) {
       return "Última dia para devolução";
    } else {
        return "Atrasado";
    }
}


public void devolverItem() {
    if (!pendente) {
        System.out.println("O item está disponível para empréstimo.");
    } else if (prazoDevolucao < 0) {
        System.out.println("O prazo de devolução está atrasado.");
    } else {
        System.out.println("O item está indisponível no momento.");
    }

}

public LocalDate realizarEmprestimo(itemBiblioteca X) {
        getItemEmprestado();
        LocalDate dataAtual = LocalDate.now();
        int prazoDevolucao;
        if (itemEmprestado instanceof Livro) {
            prazoDevolucao = 15;
        }
        else if (itemEmprestado instanceof Revista) {
            prazoDevolucao = 7;
        } else {
            return null;
        }
        int qtdDisponivel = itemEmprestado.getQtdDisponivel();
        itemEmprestado.setQtdDisponivel(qtdDisponivel - 1);
        System.out.println("Empréstimo realizado com sucesso!");
        return dataAtual.plusDays(prazoDevolucao);
    }



    // GETTERS E SETTERS

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getprazoDevolucao() {
        return prazoDevolucao;
    }

    public boolean isPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

    public itemBiblioteca getItemEmprestado() {
        return itemEmprestado;
    }
}
