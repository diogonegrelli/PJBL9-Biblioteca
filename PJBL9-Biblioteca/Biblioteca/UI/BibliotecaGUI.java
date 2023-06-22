package UI;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Biblioteca.Livro;
import Biblioteca.Pesquisa;
import Biblioteca.Revista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JRadioButton;
public class BibliotecaGUI extends JFrame {
    private List<Livro> livros;
    private JTextField tituloItemTextField;
    private JTextField localizacaoTextField;
    private JCheckBox disponivelCheckBox;
    private JTextField qtdDisponivelTextField;
    private JTextField autorTextField;
    private JTextField anoDePublicacaoTextField;
    private JTextField categoriaTextField;
    private JTextArea listaLivrosTextArea;
    private JButton cadastrarButton;
    private JButton verificarDisponibilidadeButton;
    private JButton exibirListaButton;

    public BibliotecaGUI() {
        livros = new ArrayList<>();


        JLabel tituloItemLabel = new JLabel("Título de livro:");
        tituloItemTextField = new JTextField(20);

        JLabel localizacaoLabel = new JLabel("Localização de livro:");
        localizacaoTextField = new JTextField(10);

        JLabel disponivelLabel = new JLabel("Disponível:");
        disponivelCheckBox = new JCheckBox();

        JLabel qtdDisponivelLabel = new JLabel("Quantidade Disponível de livro:");
        qtdDisponivelTextField = new JTextField(4);

        JLabel autorLabel = new JLabel("Autor:");
        autorTextField = new JTextField(20);

        JLabel anoDePublicacaoLabel = new JLabel("Ano de Publicação de livro:");
        anoDePublicacaoTextField = new JTextField(4);

        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaTextField = new JTextField(20);

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

        exibirListaButton = new JButton("Exibir Lista de coisas disponiveis ");
        exibirListaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirListaLivros();
            }
        });

        listaLivrosTextArea = new JTextArea(10, 30);
        listaLivrosTextArea.setEditable(false);

        JButton deletarButton = new JButton("Deletar");
        deletarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletarLivro();
            }
        });

        JButton emprestarButton = new JButton("Emprestar Livro");
        emprestarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emprestarLivro();
            }
        });




        JPanel panel = new JPanel();
        JRadioButton revistaRadioButton = new JRadioButton("Revista");
        panel.add(revistaRadioButton);
        ButtonGroup tipoItemGroup = new ButtonGroup();
        tipoItemGroup.add(revistaRadioButton);
        JRadioButton livroRadioButton = new JRadioButton("Livro");
        panel.add(livroRadioButton);
        tipoItemGroup.add(livroRadioButton);
        panel.setLayout(new GridLayout(11, 2));
        panel.add(tituloItemLabel);
        panel.add(tituloItemTextField);
        panel.add(localizacaoLabel);
        panel.add(localizacaoTextField);
        panel.add(disponivelLabel);
        panel.add(disponivelCheckBox);
        panel.add(qtdDisponivelLabel);
        panel.add(qtdDisponivelTextField);
        panel.add(autorLabel);
        panel.add(autorTextField);
        panel.add(anoDePublicacaoLabel);
        panel.add(anoDePublicacaoTextField);
        panel.add(categoriaLabel);
        panel.add(categoriaTextField);
        panel.add(cadastrarButton);
        panel.add(verificarDisponibilidadeButton);
        panel.add(deletarButton);
        panel.add(emprestarButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(listaLivrosTextArea, BorderLayout.CENTER);
        container.add(exibirListaButton, BorderLayout.SOUTH);

        setTitle("Biblioteca");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarLivrosDoArquivo();
    }

    private void cadastrarLivro() {
       try {
            String tituloItem = tituloItemTextField.getText();
            String localizacao = localizacaoTextField.getText();
            boolean disponivel = disponivelCheckBox.isSelected();
            int qtdDisponivel = Integer.parseInt(qtdDisponivelTextField.getText());
            String autor = autorTextField.getText();
            int anoDePublicacao = Integer.parseInt(anoDePublicacaoTextField.getText());
            String categoria = categoriaTextField.getText();

            int idItem = gerarIdItem();
            for (int i = 0; i < qtdDisponivel; i++) {
                Livro livro = new Livro(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, categoria);
                livros.add(livro);
            }

            limparCampos();
            atualizarArquivoTxt();
            JOptionPane.showMessageDialog(this, "Livro(s) cadastrado(s) com sucesso!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Entrada invalida");


       }
    }

    private void verificarDisponibilidade() {
        String tituloItem = JOptionPane.showInputDialog(this, "Digite o título do livro:");

        boolean disponivel = false;

        for (Livro livro : livros) {
            String titulo = normalizeString(livro.getTituloItem());
            if (titulo.equalsIgnoreCase(tituloItem) && livro.getDisponivel()) {
                disponivel = true;
                break;
            }
        }

        if (disponivel) {
            JOptionPane.showMessageDialog(this, "O livro está disponível!");
        } else {
            JOptionPane.showMessageDialog(this, "O livro não está disponível!");
        }
    }

    private void deletarLivro() {
        String tituloItem = JOptionPane.showInputDialog(this, "Digite o título do livro:");

        Iterator<Livro> iterator = livros.iterator();
        while (iterator.hasNext()) {
            Livro livro = iterator.next();
            if (livro.getTituloItem().equalsIgnoreCase(tituloItem)) {
                iterator.remove();
                JOptionPane.showMessageDialog(this, "Livro removido com sucesso!");
                atualizarArquivoTxt();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Livro não encontrado!");
    }

    private void emprestarLivro() {
        String tituloItem = JOptionPane.showInputDialog(this, "Digite o título do livro:");

        for (Livro livro : livros) {
            if (livro.getTituloItem().equalsIgnoreCase(tituloItem)) {
                if (livro.getDisponivel()) {
                    livro.setDisponivel(false);
                    JOptionPane.showMessageDialog(this, "Livro emprestado com sucesso!");
                    JOptionPane.showMessageDialog(this, "Na data " + LocalDate.now() );
                    atualizarArquivoTxt();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "O livro não está disponível para empréstimo!");
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Livro não encontrado!");
    }

    private void exibirListaLivros() {
        listaLivrosTextArea.setText("");
        for (Livro livro : livros) {
            listaLivrosTextArea.append(livro.getTituloItem() + " - " + livro.getAutor() + " (" + livro.getAnoDePublicacao() + ")\n");
        }
    }

    private void limparCampos() {
        tituloItemTextField.setText("");
        localizacaoTextField.setText("");
        disponivelCheckBox.setSelected(false);
        qtdDisponivelTextField.setText("");
        autorTextField.setText("");
        anoDePublicacaoTextField.setText("");
        categoriaTextField.setText("");
    }

    private void carregarLivrosDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("livros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int idItem = Integer.parseInt(data[0]);
                String tituloItem = data[1];
                String localizacao = data[2];
                boolean disponivel = Boolean.parseBoolean(data[3]);
                int qtdDisponivel = Integer.parseInt(data[4]);
                String autor = data[5];
                int anoDePublicacao = Integer.parseInt(data[6]);
                String categoria = data[7];
                Livro livro = new Livro(idItem, tituloItem, localizacao, disponivel, qtdDisponivel, autor, anoDePublicacao, categoria);
                livros.add(livro);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os livros do arquivo!");
        }
    }

    private void atualizarArquivoTxt() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("livros.txt"))) {
            for (Livro livro : livros) {
                bw.write(livro.getIdItem() + ";" + livro.getTituloItem() + ";" + livro.getLocalizacao() + ";" + livro.getDisponivel() + ";" + livro.getQtdDisponivel() + ";" + livro.getAutor() + ";" + livro.getAnoDePublicacao() + ";" + livro.getCategoria() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar o arquivo de livros!");
        }
    }

    private int gerarIdItem() {
        int maxIdItem = 0;
        for (Livro livro : livros) {
            if (livro.getIdItem() > maxIdItem) {
                maxIdItem = livro.getIdItem();
            }
        }
        return maxIdItem + 1;
    }

    private String normalizeString(String str) {
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BibliotecaGUI();
            }
        });
    }
}
