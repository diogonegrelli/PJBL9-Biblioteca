package Biblioteca;

public class Revista extends itemBiblioteca {
    private String periodico;
    private int edicao;
    private String editora;
    private Categoria categoria;

    public Revista(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String periodico, int edicao , String editora , Categoria categoria) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.periodico = periodico;
        this.edicao = edicao;
        this.editora = editora;
        this.categoria = categoria;

    }

    @Override
    public void calculaMulta() {

    }

    //GETTERS E SETTERS*//

    public String getPeriodico() {
        return periodico;
    }

    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
