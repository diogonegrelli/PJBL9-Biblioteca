package Biblioteca;

import Biblioteca.itemBiblioteca;

public class Notebook extends itemBiblioteca {
    private String marca;
    private String modelo;

    public Notebook(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String marca, String modelo) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void calculaMulta() {


    }
    @Override
    public void exibeItem(){
        System.out.println("ID: " + getIdItem());
        System.out.println("Ítem: " + getTituloItem());
        System.out.println("Localização: " +getLocalizacao());
        System.out.println("Disponível: " + getDisponivel());
        System.out.println("QTD Disponível: "+ getQtdDisponivel());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
    }


    //* GETTERS E SETTERS
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
