package Biblioteca;

import java.util.ArrayList;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private ArrayList<itemBiblioteca> colecaoCategoria;

    public Categoria(int idCategoria, String nomeCategoria, ArrayList<itemBiblioteca> colecaoCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.colecaoCategoria = colecaoCategoria;
    }

    //*GETTERS & SETTERS//
    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public ArrayList<itemBiblioteca> getColecaoCategoria() {
        return colecaoCategoria;
    }

    public void setColecaoCategoria(ArrayList<itemBiblioteca> colecaoCategoria) {
        this.colecaoCategoria = colecaoCategoria;
    }
}