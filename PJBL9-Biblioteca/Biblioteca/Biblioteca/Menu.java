import java.util.Scanner;

public class Menu {

    int opcao ;

    public Menu() {
        this.opcao = opcao =0;
    }

    public void ChmarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (opcao == 0) {

            System.out.println("digite as opcoes");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar pessoa");
                    //adicionar um metodo para adicionar pessoa
                    opcao = 0;
                    break;
                case 2:
                    System.out.println("Adicionar livro");
                    opcao = 0;
                    break;

                default: System.out.println ("Resposta inválida");
                    opcao = 0;
                    break;
            }


        }


    }


}
