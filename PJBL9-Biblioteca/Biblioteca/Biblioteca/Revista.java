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
    //*MÉTODO ABSTRATO IMPLEMENTADO NAS CLASSES FILHAS: LIVRO, REVISTA E NOTEBOOK//
    @Override
    public float calculaMulta(int diasAtraso) {
        float taxaDiaria = (float) 0.75;
        float multaRevista = diasAtraso * taxaDiaria;
        return multaRevista;
    }
    @Override
    public void exibeItem(){
        System.out.println("ID: " + getIdItem());
        System.out.println("Ítem: " + getTituloItem());
        System.out.println("Localização: " +getLocalizacao());
        System.out.println("Disponível: " + getDisponivel());
        System.out.println("QTD Disponível: "+ getQtdDisponivel());
        System.out.println("Periódico" + getPeriodico());
        System.out.println("Edição" + getEdicao());
        System.out.println("Editora" + getEditora());
        System.out.println("Categoria"+ getCategoria());
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

    @Override
    public String toString() {
        return getTituloItem();
    }


}
