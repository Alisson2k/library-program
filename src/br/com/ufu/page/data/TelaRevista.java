package br.com.ufu.page.data;

import br.com.ufu.exceptions.EmptyValueException;
import br.com.ufu.model.Revista;
import br.com.ufu.page.Tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TelaRevista extends Tela {
    private List<Revista> revistas = new ArrayList<>();
    private TelaLivro telaLivro;

    public TelaRevista(TelaLivro telaLivro) {
        super("Revista", Revista.class);
        this.telaLivro = telaLivro;
        this.addButtons();
    }

    public List<Revista> getRevistas() {
        return revistas;
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

        Revista revista = new Revista();
        for (Map.Entry<String, JTextField> entry : getAttributtes().entrySet()) {
            if (entry.getKey().equals("org")) {
                revista.setOrg(entry.getValue().getText());
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("vol")) {
                revista.setVol(Integer.parseInt(entry.getValue().getText()));
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("titulo")) {
                revista.setTitulo(entry.getValue().getText());
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("ano")) {
                revista.setAno(Integer.parseInt(entry.getValue().getText()));
                entry.getValue().setText("");
            }
            else if (entry.getKey().equals("nro")) {
                revista.setNro(Integer.parseInt(entry.getValue().getText()));
                entry.getValue().setText("");
            }
        }

        revistas.add(revista);
        JOptionPane.showMessageDialog(null, "Objeto incluido na listagem");
    }

    private void addButtons() {
        submit.addActionListener(this::actionPerformed);

        JButton livro = new JButton("Livros");
        livro.setBounds(170, 50 + (30 * getAttr()), 100, 28);
        frame.getContentPane().add(livro);

        livro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                telaLivro.frame.setVisible(true);
            }
        });

        JButton listagem = new JButton("Listagem");
        listagem.setBounds(287, 50 + (30 * getAttr()), 100, 28);
        frame.getContentPane().add(listagem);

        listagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TelaListagem listagem = new TelaListagem(telaLivro.getLivros(), revistas);
            }
        });
    }
}
