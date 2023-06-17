package Biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private itemBiblioteca itemEmprestado;
    private int idEmprestimo;
    private Usuario usuario;
    private int prazoDevolucao;
    private boolean pendente;

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
       return "Hoje Não é o Último dia";
    } else {
        return "Atrasado";
    }
}


public void devolverItem() {
    if (!pendente) {
        System.out.println("O item está disponível para empréstimo.");
    } else if (prazoDevolucao < 0) {
        System.out.println("O prazoDevolucao de devolução está atrasado.");
    } else {
        System.out.println("O item está indisponível no momento.");
     }
}
public void realizarRenovacao() {
    System.out.println("Renovação realizada com sucesso. Novo prazo de devolução: " + calcularNovaDataDevolucao());
}

private LocalDate calcularNovaDataDevolucao() {
        getItemEmprestado();
        LocalDate dataAtual = LocalDate.now();

        int prazoDevolucao;
         /* variável ou get correspondente ao item*/
        if (itemEmprestado instanceof Livro) {
            prazoDevolucao = 15;
        }
        /* variável ou get correspondente ao item*/
        else if (itemEmprestado instanceof Revista) {
            prazoDevolucao = 7;
        } else {
            return null;
        }

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
