package br.com.ufu.page.data;

import br.com.ufu.exceptions.EmptyValueException;
import br.com.ufu.model.Livro;
import br.com.ufu.model.Revista;
import br.com.ufu.page.Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TelaLivro extends Tela {

    private List<Livro> livros = new ArrayList<>();
    private TelaRevista telaRevista;

    public TelaLivro() {
        super("Livro", Livro.class);
        this.telaRevista = new TelaRevista(this);
        this.addButtons();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setVisible(Boolean visible) {
        frame.setVisible(visible);
    }

    public void actionPerformed(ActionEvent arg0) {
        for (Map.Entry<String, JTextField> entry : getAttributtes().entrySet()) {
            if (entry.getValue().getText().isEmpty()) {
                try {
                    throw new EmptyValueException("Preencha todos os campos");
                } catch (EmptyValueException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    return;
                }
            }
        }

        Livro livro = new Livro();
        for (Map.Entry<String, JTextField> entry : getAttributtes().entrySet()) {
            if (entry.getKey().equals("autor")) {
                livro.setAutor(entry.getValue().getText());
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("titulo")) {
                livro.setTitulo(entry.getValue().getText());
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("ano")) {
                livro.setAno(Integer.parseInt(entry.getValue().getText()));
                entry.getValue().setText("");
            }
        }

        livros.add(livro);
        JOptionPane.showMessageDialog(null, "Objeto incluido na listagem");
    }

    private void addButtons() {
        submit.addActionListener(this::actionPerformed);

        JButton revista = new JButton("Revistas");
        revista.setBounds(170, 50 + (30 * getAttr()), 100, 28);
        frame.getContentPane().add(revista);

        revista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                telaRevista.frame.setVisible(true);
            }
        });

        JButton listagem = new JButton("Listagem");
        listagem.setBounds(287, 50 + (30 * getAttr()), 100, 28);
        frame.getContentPane().add(listagem);

        listagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaListagem listagem = new TelaListagem(livros, telaRevista.getRevistas());
            }
        });
    }

}
