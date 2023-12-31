package Biblioteca;

import java.util.ArrayList;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private ArrayList<ItemBiblioteca> colecaoCategoria;

    public Categoria(int idCategoria, String nomeCategoria, ArrayList<ItemBiblioteca> colecaoCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.colecaoCategoria = colecaoCategoria;
    }

    public Categoria(String s) {
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

    public ArrayList<ItemBiblioteca> getColecaoCategoria() {
        return colecaoCategoria;
    }

    public void setColecaoCategoria(ArrayList<ItemBiblioteca> colecaoCategoria) {
        this.colecaoCategoria = colecaoCategoria;
    }

    @Override
    public String toString() {
        return nomeCategoria;
    }

    public String getNome() {
        return nomeCategoria;
    }
}