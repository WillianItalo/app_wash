package com.aula.wash.it;

public class ServicosNovos {
    private String txtServico ;
    private String txtTitulo;
    private String txtPreco;
    private int imgServico;
    public ServicosNovos() {
    }

    public ServicosNovos(String txtServico, String txtTitulo, String txtPreco, int imgServico) {
        this.txtServico = txtServico;
        this.txtTitulo = txtTitulo;
        this.txtPreco = txtPreco;
        this.imgServico = imgServico;
    }

    public String getTxtServico() {
        return txtServico;
    }

    public void setTxtServico(String txtServico) {
        this.txtServico = txtServico;
    }

    public String getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(String txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public String getTxtPreco() {
        return txtPreco;
    }

    public void setTxtPreco(String txtPreco) {
        this.txtPreco = txtPreco;
    }

    public int getImgServico() {
        return imgServico;
    }

    public void setImgServico(int imgServico) {
        this.imgServico = imgServico;
    }
}
