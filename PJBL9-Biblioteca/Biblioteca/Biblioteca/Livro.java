package Biblioteca;

public class Livro extends itemBiblioteca{

    private String autor;
    private int anoDePublicacao;
    private Categoria categoria;

    public Livro(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String autor, int anoDePublicacao, Categoria categoria) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.categoria = categoria;
    }

    @Override
    public void calculaMulta(){

    }
}
