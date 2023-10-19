package Biblioteca;

public class PesquisaFactory implements ItemBibliotecaFactory {

    private String autor;
    private int anoDePublicacao;

    // Construtor da PesquisaFactory
    public PesquisaFactory(String autor, int anoDePublicacao) {
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }

    // Método da interface ItemBibliotecaFactory
    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel) {
        // Criando uma instância de Pesquisa sem uma Categoria (passando null)
        Pesquisa pesquisa = new Pesquisa(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, null);

        // Defina qualquer outra inicialização específica da Pesquisa, se necessário

        return pesquisa;
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String autor, int anoDePublicacao, String categoria) {
        return null;
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, boolean disponivel, int qtdDisponivel) {
        return null;
    }
}
