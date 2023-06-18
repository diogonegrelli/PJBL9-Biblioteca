package Biblioteca;

import Biblioteca.itemBiblioteca;

public class Notebook extends itemBiblioteca {
    private String marca;
    private String modelo;
    private Categoria categoria;


    public Notebook(int idItem, String tituloItem, String localizacao, Boolean disponivel, int qtdDisponivel, String marca, String modelo, Categoria categoria) {
        super(idItem, tituloItem, localizacao, disponivel, qtdDisponivel);
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
    }
    //* Notebook não é emprestado, portanto implementa mas retorno ZERO//
    @Override
    public float calculaMulta(int diasAtraso) {
        return 0;
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
        System.out.println("Categoria: "+ getCategoria());
    }


    //* GETTERS E SETTERS

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public String toString(){
        return getTituloItem();
    }
}
