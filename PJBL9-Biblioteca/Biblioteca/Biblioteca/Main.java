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



        //* CRIAÇAO DOS ITENS DA BIBLIOTECA//
        itemBiblioteca notebook1 = new Notebook (544, "ACER ASPIRE 5", "corredor 04", true, 03, "ACER" , "aspire 5" , eletronicos);
        itemBiblioteca notebook2 = new Notebook(545, "DELL INSPIRON 2023" , "corredor 04", true, 02, "DELL" , "inspiron 2023", eletronicos);
        itemBiblioteca revista1 = new Revista(546,"")
        itemBiblioteca revista2 = new Revista(547,)
        itemBiblioteca revista3 = new Revista(548,)
        itemBiblioteca livro1 = new Livro(549,);
        itemBiblioteca livro2 = new Livro(550,);
        itemBiblioteca livro3 = new Livro(551,);

        colecaoEletronicos.add(notebook1);
        colecaoEletronicos

        Revista revista = new Revista(1, "Título da Revista", "Localização da Revista", true, 10, "Periodico da Revista", 1, "Editora da Revista", livraria);
        System.out.println(revista.calculaMulta(5));



    }


}