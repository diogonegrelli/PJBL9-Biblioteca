package Biblioteca;

public interface ItemBibliotecaFactory {
    ItemBiblioteca  criarItemBiblioteca (int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel);

    ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String autor, int anoDePublicacao, String categoria);

    ItemBiblioteca criarItemBiblioteca(int idItem, String tituloItem, String localizacao, boolean disponivel, int qtdDisponivel);
}
