package Biblioteca;

import Biblioteca.Notebook;
import Biblioteca.itemBiblioteca;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        itemBiblioteca dell = new Notebook(545, "DELL INSPIRON 2023" , "corredor 04", true, 02, "dell" , "inspiron 2023");
        dell.exibeItem();
        ArrayList<itemBiblioteca> colecaoItens = new ArrayList<>();
        Categoria produtosfisicos = new Categoria(2012023, "Produtos Físicos", colecaoItens);
        produtosfisicos.setColecaoCategoria(new ArrayList<itemBiblioteca>());
        itemBiblioteca arq = new Livro(595, "ARQ","corredor 03", true, 03, "fulano", 2009, produtosfisicos);
    }


}