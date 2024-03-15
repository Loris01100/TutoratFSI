package com.example.tutoratfsi.Model.BO;

public class Etudiant {
    private int idEtu;
    private String login;
    private String mdp;
    private String nomEtu;
    private String preEtu;
    private String mail;
    private String tel;
    private String nomTut;
    private String nomMai;
    private String nomEts;

    public Etudiant(int idEtu, String login, String mdp, String nomEtu, String preEtu, String mail, String tel, String nomTut, String nomMai, String nomEts) {
        this.idEtu = idEtu;
        this.login = login;
        this.mdp = mdp;
        this.nomEtu = nomEtu;
        this.preEtu = preEtu;
        this.mail = mail;
        this.tel = tel;
        this.nomTut = nomTut;
        this.nomMai = nomMai;
        this.nomEts = nomEts;
    }

    public int getIdEtu() {
        return idEtu;
    }

    public void setIdEtu(int idEtu) {
        this.idEtu = idEtu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNomEtu() {
        return nomEtu;
    }

    public void setNomEtu(String nomEtu) {
        this.nomEtu = nomEtu;
    }

    public String getPreEtu() {
        return preEtu;
    }

    public void setPreEtu(String preEtu) {
        this.preEtu = preEtu;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNomTut() {
        return nomTut;
    }

    public void setNomTut(String nomTut) {
        this.nomTut = nomTut;
    }

    public String getNomMai() {
        return nomMai;
    }

    public void setNomMai(String nomMai) {
        this.nomMai = nomMai;
    }

    public String getNomEts() {
        return nomEts;
    }

    public void setNomEts(String nomEts) {
        this.nomEts = nomEts;
    }
}
