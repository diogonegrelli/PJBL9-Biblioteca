package Biblioteca;
import java.util.ArrayList;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //*CRIA CATEGORIAS E ARRAYS DAS CATEGORIAS//
        ArrayList<ItemBiblioteca> colecaoEletronicos = new ArrayList<>();
        ArrayList<ItemBiblioteca> colecaoLivraria = new ArrayList<>();
        Categoria eletronicos = new Categoria(012023, "Eletrônicos", colecaoEletronicos);
        Categoria livraria = new Categoria(022023, "Livraria" , colecaoLivraria);
        //*CATEGORIAS CRIADAS//

        // Criando a fábrica para Pesquisa//
        ItemBibliotecaFactory pesquisaFactory = new PesquisaFactory("Autor da Pesquisa", 2023);

        // Criando a fábrica para Revista//
        ItemBibliotecaFactory revistaFactory = new RevistaFactory("Periodico", 1, "Editora", new Categoria(1, "Livraria", new ArrayList<>()));

        // Criando a fábrica para Livro//
        ItemBibliotecaFactory livroFactory = new LivroFactory("Autor do Livro", 2023, "Categoria do Livro");




        // Usando as fábricas para criar objetos
        ItemBiblioteca pesquisa1 = pesquisaFactory.criarItemBiblioteca(544, "ACER ASPIRE 5", "corredor 04", true, 3);
        ItemBiblioteca pesquisa2 = pesquisaFactory.criarItemBiblioteca(545, "DELL INSPIRON 2023", "corredor 04", true, 2);
        ItemBiblioteca revista1 = revistaFactory.criarItemBiblioteca(546, "Revista X", "corredor 03", true, 2);
        ItemBiblioteca revista2 = revistaFactory.criarItemBiblioteca(547, "Revista Y", "corredor 03", true, 1);
        ItemBiblioteca revista3 = revistaFactory.criarItemBiblioteca(548, "ISTO É", "corredor 03", true, 3);
        ItemBiblioteca livro1 = livroFactory.criarItemBiblioteca(549, "O poder da mente", "corredor 02", true, 4);
        ItemBiblioteca livro2 = livroFactory.criarItemBiblioteca(550, "The worst of Tinar", "corredor 02", true, 10);
        ItemBiblioteca livro3 = livroFactory.criarItemBiblioteca(551, "Morri para viver", "corredor 02", true, 5);


        ArrayList<Emprestimo> emprestimosUsuario = new ArrayList<>();
        Usuario gabriel = new Usuario(701, "Gabriel" , emprestimosUsuario);
        //Emprestimo emprestimo1  = new Emprestimo(livro3, 4958495, gabriel, 15);
        //System.out.println(emprestimo1.realizarEmprestimo(livro3));
        //System.out.println(livro3.getQtdDisponivel());
        //System.out.println(emprestimo1.verificaStatus());
        //emprestimo1.devolverItem(livro3);


        //Emprestimo emprestimo2  = new Emprestimo(livro3, 4958495, gabriel, 15);
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        //System.out.println(emprestimo2.realizarEmprestimo(livro3));
        
        //Emprestimo emprestimo3 = new Emprestimo(pesquisa1, 4958496, gabriel, 0);
        //System.out.println(emprestimo3.realizarEmprestimo(pesquisa1));


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