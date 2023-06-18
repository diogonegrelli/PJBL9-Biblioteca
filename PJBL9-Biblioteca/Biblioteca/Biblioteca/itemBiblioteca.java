package Biblioteca;

public abstract class itemBiblioteca {
    private int idItem;
    private String tituloItem;
    private String localizacao;
    private Boolean disponivel;
    private int qtdDisponivel;


    public itemBiblioteca (int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel){
        this.idItem = idItem;
        this.tituloItem = tituloItem;
        this.localizacao = localizacao;
        this.disponivel = disponivel;
        this.qtdDisponivel = qtdDisponivel;
    }


    public abstract float calculaMulta(int diasAtraso);

    public void exibeItem(){
        System.out.println("ID: " + getIdItem());
        System.out.println("Ítem: " + getTituloItem());
        System.out.println("Localização: " +getLocalizacao());
        System.out.println("Disponível: " + getDisponivel());
        System.out.println("QTD Disponível: "+ getQtdDisponivel());
    }


    //* GETTERS E SETTERS
    public String getTituloItem() {
        return tituloItem;
    }

    public void setTituloItem(String tituloItem) {
        this.tituloItem = tituloItem;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public int getIdItem() {   return idItem;
    }

    public abstract String toString();
}
