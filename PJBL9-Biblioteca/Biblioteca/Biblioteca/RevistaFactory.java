package Biblioteca;

public class RevistaFactory implements ItemBibliotecaFactory {
    private String periodico;
    private int edicao;
    private String editora;
    private Categoria categoria;

    public RevistaFactory(String periodico, int edicao, String editora, Categoria categoria) {
        this.periodico = periodico;
        this.edicao = edicao;
        this.editora = editora;
        this.categoria = categoria;
    }

    @Override
    public ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel) {
        return new Revista(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, periodico, edicao, editora, categoria);
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
