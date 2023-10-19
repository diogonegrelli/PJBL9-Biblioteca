package Biblioteca;

public class Livro extends ItemBiblioteca {

    private String autor;
    private int anoDePublicacao;
    private String categoria;

    public Livro(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String autor, int anoDePublicacao, String categoria) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.categoria = categoria;
    }

    @Override
    public float calculaMulta(long diasAtraso) {
        float taxaDiaria = (float) 1;
        float multaLivro = diasAtraso * taxaDiaria;
        return multaLivro;

    }

    @Override
    public void exibeItem(){
        System.out.println("ID: " + getIdItem());
        System.out.println("Ítem: " + getTituloItem());
        System.out.println("Localização: " +getLocalizacao());
        System.out.println("Disponível: " + getDisponivel());
        System.out.println("QTD Disponível: "+ getQtdDisponivel());
        System.out.println("Autor" + getAutor());
        System.out.println("Ano de Publicação" + getAnoDePublicacao());
        System.out.println("Categoria" + getCategoria());
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return getTituloItem();
    }

    public static LivroFactory factory(String autor, int anoDePublicacao, String categoria) {
        return new LivroFactory(autor, anoDePublicacao, categoria);
    }
}
