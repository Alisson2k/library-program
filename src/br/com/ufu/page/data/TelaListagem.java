package br.com.ufu.page.data;

import br.com.ufu.model.Livro;
import br.com.ufu.model.Revista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaListagem {

    private List<Object> objects = new ArrayList<>();

    public TelaListagem(List<Livro> livros, List<Revista> revistas) {
        this.objects = this.setListagem(livros, revistas);
        this.start();
    }

    private List<Object> setListagem(List<Livro> livros, List<Revista> revistas) {
        objects.addAll(livros);
        objects.addAll(revistas);

        return objects;
    }

    private void start() {
        JFrame frame = new JFrame("Listagem");
        frame.setSize(500, 40 + (20 * objects.size()));

        JLabel label = new JLabel();
        String tudo = "";
        int i = 0;
        for (Object object : this.objects) {
            tudo = tudo + "<html>" + object.toString() + "<br/><html/>";
        }

        label.setText(tudo);
        frame.getContentPane().add(BorderLayout.NORTH, label);

        frame.setVisible(true);
    }
}
