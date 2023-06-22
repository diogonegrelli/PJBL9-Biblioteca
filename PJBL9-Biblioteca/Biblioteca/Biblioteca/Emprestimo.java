package Biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private ItemBiblioteca itemEmprestado;
    private int idEmprestimo;
    private Usuario usuario;
    private int prazoDevolucao;
    private boolean pendente; //se pendente é false o item está emprestado

    public Emprestimo(ItemBiblioteca itemEmprestado, int idEmprestimo, Usuario usuario, int prazoDevolucao) {
        this.itemEmprestado = itemEmprestado;
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.prazoDevolucao = prazoDevolucao;
        this.pendente = false;
    }

public String verificaStatus() {
    //LocalDate data = LocalDate.of(2023, 6, 1); //descomentar para usar de exemplo
    //LocalDate dataDevolucao = data.plusDays(prazoDevolucao); //descomentar para usar de exemplo
    LocalDate dataDevolucao = LocalDate.now().plusDays(prazoDevolucao);
    LocalDate dataAtual = LocalDate.now();

    if (dataAtual.isBefore(dataDevolucao)) {
        return  "Em dia";
    } else if (dataAtual.isEqual(dataDevolucao)) {
       return "Última dia para devolução";
    } else {
         long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, dataAtual);
        return "Atrasado " + diasAtraso + " dias.";
    }
}


public void devolverItem(ItemBiblioteca itemEmprestado) {
    //LocalDate data = LocalDate.of(2023, 6, 1); //descomentar para usar de exemplo
    //LocalDate dataDevolucao = data.plusDays(prazoDevolucao); //descomentar para usar de exemplo
    LocalDate dataDevolucao = LocalDate.now().plusDays(prazoDevolucao);
    LocalDate dataAtual = LocalDate.now();
    long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, dataAtual);
    String status = verificaStatus();
    if (status.startsWith("Último dia para devolução") || status.startsWith("Em dia")) {
        itemEmprestado.setQtdDisponivel(itemEmprestado.getQtdDisponivel() + 1);
        this.pendente = true;
        System.out.println("O item " + "'" + itemEmprestado +"'" + " foi devolvido com sucesso.");
    } else {
        System.out.println("Item devolvido com atraso, multa aplicada.");
        itemEmprestado.setQtdDisponivel(itemEmprestado.getQtdDisponivel() + 1);
        this.pendente = true;

        if(itemEmprestado instanceof Livro) {
            Livro livro = (Livro) itemEmprestado;
            float multa = livro.calculaMulta(diasAtraso);
            System.out.println("Valor da multa R$: " + multa);
        } else {
            Revista revista = (Revista) itemEmprestado;
            float multa = revista.calculaMulta(diasAtraso);
            System.out.println("Valor da multa R$: " + multa);
        }
    }

}


public LocalDate realizarEmprestimo(ItemBiblioteca itemEmprestado) {
        //LocalDate data = LocalDate.of(2023, 6, 1); //descomentar para usar de exemplo
        LocalDate dataAtual = LocalDate.now();
        int prazoDevolucao;

        try{
            if (itemEmprestado instanceof Livro) {
                prazoDevolucao = 15;
            }
            else if (itemEmprestado instanceof Revista) {
                prazoDevolucao = 7;
            } else if(itemEmprestado instanceof Pesquisa) {
                throw new Indisponivel();
            } else {
                return null;
            }
            int qtdDisponivel = itemEmprestado.getQtdDisponivel();
            if (qtdDisponivel > 0) {
            itemEmprestado.setQtdDisponivel(qtdDisponivel - 1);
            System.out.println("Empréstimo do item " + "'" + itemEmprestado + "'" + " pelo usuário " + usuario + " realizado com sucesso! A data final de devolução é:");
        //    return data.plusDays(prazoDevolucao); //descomentar para exemplo em sala
            return dataAtual.plusDays(prazoDevolucao);
            } else {
                System.out.println("Item indisponivel para empréstimo na data de: ");
                return dataAtual;
            }
        
        } catch (Indisponivel e) {
            System.out.println(e.getMessage());
            return null;
        }
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

    public ItemBiblioteca getItemEmprestado() {
        return itemEmprestado;
    }
}
