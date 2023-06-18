package Biblioteca;

import Biblioteca.Notebook;
import Biblioteca.itemBiblioteca;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //*CRIA CATEGORIAS E ARRAYS DAS CATEGORIAS//
        ArrayList<itemBiblioteca> colecaoEletronicos = new ArrayList<>();
        ArrayList<itemBiblioteca> colecaoLivraria = new ArrayList<>();
        Categoria eletronicos = new Categoria(012023, "Eletrônicos", colecaoEletronicos);
        Categoria livraria = new Categoria(022023, "Livraria" , colecaoLivraria);
        //*CATEGORIAS CRIADAS//
        itemBiblioteca dell = new Notebook(545, "DELL INSPIRON 2023" , "corredor 04", true, 02, "dell" , "inspiron 2023", eletronicos);

        Revista revista = new Revista(1, "Título da Revista", "Localização da Revista", true, 10, "Periodico da Revista", 1, "Editora da Revista", livraria);
        System.out.println(revista.calculaMulta(5));


    }


}