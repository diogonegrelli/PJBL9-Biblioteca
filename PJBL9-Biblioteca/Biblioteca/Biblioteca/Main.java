package Biblioteca;
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
        itemBiblioteca pesquisa1 = new Pesquisa(544, "ACER ASPIRE 5", "corredor 04", true, 03, "ACER" , "aspire 5" , eletronicos);
        itemBiblioteca pesquisa2 = new Pesquisa(545, "DELL INSPIRON 2023" , "corredor 04", true, 02, "DELL" , "inspiron 2023", eletronicos);
        itemBiblioteca revista1 = new Revista(546,"Revista X", "corredor 03", true , 02, "ABRIL 2010", 201, "World" , livraria);
        itemBiblioteca revista2 = new Revista(547,"Revista Y" , "corredor 03", true, 01,"JUNHO 2015" ,30,"World", livraria);
        itemBiblioteca revista3 = new Revista(548,"ISTO É", "corredor 03",  true, 03,"FEVEREIRO 2017",40 ,"World" , livraria);
        itemBiblioteca livro1 = new Livro(549,"O poder da mente", "corredor 02", true, 04,"Fulano",2020,"livraria");
        itemBiblioteca livro2 = new Livro(550,"The worst of Tinar", "corredor 02", true,10, "Beltrano",2021,"livraria");
        itemBiblioteca livro3 = new Livro(551,"Morri para viver" , "corredor 02", true, 05,"Andressa Urach",2022, "livraria");

        ArrayList<Emprestimo> emprestimosUsuario = new ArrayList<>();
        Usuario gabriel = new Usuario(701, "Gabriel" , emprestimosUsuario);
        //Emprestimo emprestimo1  = new Emprestimo(livro3, 4958495, gabriel, 15);
        //Emprestimo emprestimo2  = new Emprestimo(livro3, 4958495, gabriel, 15);
        //System.out.println(emprestimo1.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(livro3.getQtdDisponivel());
        //System.out.println(emprestimo1.verificaStatus());
        Emprestimo emprestimo3 = new Emprestimo(pesquisa1, 4958496, gabriel, 0);
        System.out.println(emprestimo3.realizarEmprestimo(pesquisa1));


        //*ADICIONA OS ITENS EM SUAS RESPECTIVAS CATEGORIAS//
        colecaoEletronicos.add(pesquisa1);
        colecaoEletronicos.add(pesquisa2);
        colecaoLivraria.add(revista1);
        colecaoLivraria.add(revista2);
        colecaoLivraria.add(revista3);
        colecaoLivraria.add(livro1);
        colecaoLivraria.add(livro2);
        colecaoLivraria.add(livro3);





    }


}