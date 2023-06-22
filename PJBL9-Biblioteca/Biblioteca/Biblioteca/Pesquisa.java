package Biblioteca;

public class Pesquisa extends ItemBiblioteca {
    private String autor;
    private int anoDePublicacao;
    private String categoria;

    public Pesquisa(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String marca, String modelo, Categoria categoria) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;

    }
    //* Notebook não é emprestado, portanto implementa mas retorno ZERO//
    @Override
    public float calculaMulta(long diasAtraso) {
        return 0;
    }
    @Override
    public void exibeItem(){
        System.out.println("ID: " + getIdItem());
        System.out.println("Ítem: " + getTituloItem());
        System.out.println("Localização: " +getLocalizacao());
        System.out.println("Disponível: " + getDisponivel());
        System.out.println("QTD Disponível: "+ getQtdDisponivel());
        System.out.println("Autor: " + getAutor());
        System.out.println("Publição: " + getAnoDePublicacao());
        System.out.println("Categoria: "+ getCategoria());
    }


    //* GETTERS E SETTERS


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String toString(){
        return getTituloItem();
    }
}
