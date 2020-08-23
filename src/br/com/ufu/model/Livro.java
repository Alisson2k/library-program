package br.com.ufu.model;

public class Livro extends Info {

    private String autor;

    public Livro() {

    }

    public Livro(String autor, String titulo, int ano) {
        super(titulo, ano);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                "titulo='" + getTitulo() + '\'' +
                "ano='" + getAno() + '\'' +
                '}';
    }
}
