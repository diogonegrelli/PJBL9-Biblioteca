package Biblioteca;

public class LivroFactory implements ItemBibliotecaFactory {

    private String autor;
    private int anoDePublicacao;
    private String categoria;

    public LivroFactory(String autor, int anoDePublicacao, String categoria) {
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.categoria = categoria;
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel) {
        return new Livro(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, categoria);
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String autor, int anoDePublicacao, String categoria) {
        return new Livro(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, categoria);
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, boolean disponivel, int qtdDisponivel) {
        return new Livro(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, categoria);
    }
}
