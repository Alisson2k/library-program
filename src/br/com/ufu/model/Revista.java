package br.com.ufu.model;

public class Revista extends Info {
    private String org;
    private int vol;
    private int nro;

    public Revista() {

    }

    public Revista(String org, int vol, int nro, String titulo, int ano) {
        super(titulo, ano);
        this.org = org;
        this.vol = vol;
        this.nro = nro;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "org='" + org + '\'' +
                ", vol=" + vol +
                ", nro=" + nro +
                ", titulo=" + getTitulo() +
                ", ano=" + getAno() +
                '}';
    }
}
