package br.com.ufu.page.data;

import br.com.ufu.model.Livro;
import br.com.ufu.model.Revista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// @CODE SMELL (Lexicon)
// Adicionei um lexicon bad smell, os identificadores de livros, revistas e objetos foram codificados para:
// Livros -> x
// Revistas -> y
// Objects -> z
public class TelaListagem {

    private List<Object> z = new ArrayList<>();

    public TelaListagem(List<Livro> x, List<Revista> y) {
        this.z = this.setListagem(x, y);
        this.start();
    }

    private List<Object> setListagem(List<Livro> x, List<Revista> y) {
        z.addAll(x);
        z.addAll(y);

        return z;
    }

    private void start() {
        JFrame frame = new JFrame("Listagem");
        frame.setSize(500, 40 + (20 * z.size()));

        JLabel label = new JLabel();
        String tudo = "";
        int i = 0;
        for (Object object : this.z) {
            tudo = tudo + "<html>" + object.toString() + "<br/><html/>";
        }

        label.setText(tudo);
        frame.getContentPane().add(BorderLayout.NORTH, label);

        frame.setVisible(true);
    }
}
