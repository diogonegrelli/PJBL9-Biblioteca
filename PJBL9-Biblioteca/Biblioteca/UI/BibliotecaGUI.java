package UI;

import Biblioteca.Livro1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaGUI extends JFrame {
    private List<Livro1> livros;
    private JTextField tituloTextField;
    private JTextField autorTextField;
    private JTextField anoTextField;
    private JTextArea listaLivrosTextArea;
    private JButton cadastrarButton;
    private JButton verificarDisponibilidadeButton;
    private JButton exibirListaButton;

    public BibliotecaGUI() {
        livros = new ArrayList<>();

        JLabel tituloLabel = new JLabel("Título:");
        tituloTextField = new JTextField(20);

        JLabel autorLabel = new JLabel("Autor:");
        autorTextField = new JTextField(20);

        JLabel anoLabel = new JLabel("Ano:");
        anoTextField = new JTextField(4);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });

        verificarDisponibilidadeButton = new JButton("Verificar Disponibilidade");
        verificarDisponibilidadeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarDisponibilidade();
            }
        });

        exibirListaButton = new JButton("Exibir Lista de Livros");
        exibirListaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListaLivros();
            }
        });

        listaLivrosTextArea = new JTextArea(10, 30);
        listaLivrosTextArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(tituloLabel);
        panel.add(tituloTextField);
        panel.add(autorLabel);
        panel.add(autorTextField);
        panel.add(anoLabel);
        panel.add(anoTextField);
        panel.add(cadastrarButton);
        panel.add(verificarDisponibilidadeButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(listaLivrosTextArea, BorderLayout.CENTER);
        container.add(exibirListaButton, BorderLayout.SOUTH);

        setTitle("Livraria");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cadastrarLivro() {
        String titulo = tituloTextField.getText();
        String autor = autorTextField.getText();
        int ano = Integer.parseInt(anoTextField.getText());

        Livro1 livro = new Livro1(titulo, autor, ano);
        livros.add(livro);

        atualizarArquivoTxt();

        JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
        limparCampos();
    }

    private void verificarDisponibilidade() {
        String titulo = JOptionPane.showInputDialog(this, "Digite o título do livro:");

        boolean encontrado = false;
        for (Livro1 livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                JOptionPane.showMessageDialog(this, "O livro está disponível!");
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "O livro não está disponível!");
        }
    }

    private void exibirListaLivros() {
        listaLivrosTextArea.setText("");
        for (Livro1 livro : livros) {
            listaLivrosTextArea.append(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAno() + ")\n");
        }
    }

    private void limparCampos() {
        tituloTextField.setText("");
        autorTextField.setText("");
        anoTextField.setText("");
    }

    private void atualizarArquivoTxt() {
        try (PrintWriter writer = new PrintWriter("livros.txt")) {
            for (Livro1 livro : livros) {
                writer.println(livro.getTitulo() + ";" + livro.getAutor() + ";" + livro.getAno());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaGUI();
            }
        });
    }
}
