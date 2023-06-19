package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    private int IdUsuario;
    private String NomeAluno;
    private ArrayList<Emprestimo> emprestimosUsuario;

    private itemBiblioteca itemEmprestado;

    public Usuario(int IdUsuario, String NomeAluno, ArrayList<Emprestimo>emprestimosUsuario) {
        this.IdUsuario = IdUsuario;
        this.NomeAluno = NomeAluno;
        this.emprestimosUsuario = emprestimosUsuario;

    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNomeAluno() {
        return NomeAluno;
    }
    public LocalDate realizarEmprestimo(itemBiblioteca itemEmprestado) {
        getItemEmprestado();
        LocalDate dataAtual = LocalDate.now();
        int prazoDevolucao;
        if (this.itemEmprestado instanceof Livro) {
            prazoDevolucao = 15;
        }
        else if (this.itemEmprestado instanceof Revista) {
            prazoDevolucao = 7;
        } else {
            return null;
        }
        int qtdDisponivel = this.itemEmprestado.getQtdDisponivel();
        this.itemEmprestado.setQtdDisponivel(qtdDisponivel - 1);
        System.out.println("Empréstimo realizado com sucesso!");
        return dataAtual.plusDays(prazoDevolucao);
    }

    public void getItemEmprestado() {
    }

    @Override
    public String toString() {
        return NomeAluno;
    }
}
