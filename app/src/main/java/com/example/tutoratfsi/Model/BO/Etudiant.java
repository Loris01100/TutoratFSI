package com.example.tutoratfsi.Model.BO;

import android.os.Parcel;
import android.os.Parcelable;

public class Etudiant implements Parcelable{
    private int numEtu;
    private String identifiant;
    private String mdpUtilisateur;
    private String nomEtu;
    private String preEtu;
    private String mailEtu;
    private String telEtu;
    private String nomMaitreApp;
    private String nomEts;
    private BilanUn idBilanUn;
    private BilanDeux idBilanDeux;

    public Etudiant(int numEtu, String identifiant, String mdpUtilisateur, String nomEtu, String preEtu, String mailEtu, String telEtu, String nomMaitreApp, String nomEts, BilanUn idBilanUn, BilanDeux idBilanDeux) {
        this.numEtu = numEtu;
        this.identifiant = identifiant;
        this.mdpUtilisateur = mdpUtilisateur;
        this.nomEtu = nomEtu;
        this.preEtu = preEtu;
        this.mailEtu = mailEtu;
        this.telEtu = telEtu;
        this.nomMaitreApp = nomMaitreApp;
        this.nomEts = nomEts;
        this.idBilanUn = idBilanUn;
        this.idBilanDeux = idBilanDeux;
    }

    public Etudiant() {

    }

    public int getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(int numEtu) {
        this.numEtu = numEtu;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMdpUtilisateur() {
        return mdpUtilisateur;
    }

    public void setMdpUtilisateur(String mdpUtilisateur) {
        this.mdpUtilisateur = mdpUtilisateur;
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

    public String getMailEtu() {
        return mailEtu;
    }

    public void setMailEtu(String mailEtu) {
        this.mailEtu = mailEtu;
    }

    public String getTelEtu() {
        return telEtu;
    }

    public void setTelEtu(String telEtu) {
        this.telEtu = telEtu;
    }

    public String getNomMaitreApp() {
        return nomMaitreApp;
    }

    public void setNomMaitreApp(String nomMaitreApp) {
        this.nomMaitreApp = nomMaitreApp;
    }

    public String getNomEts() {
        return nomEts;
    }

    public void setNomEts(String nomEts) {
        this.nomEts = nomEts;
    }

    public BilanUn getIdBilanUn() {
        return idBilanUn;
    }

    public void setIdBilanUn(BilanUn idBilanUn) {
        this.idBilanUn = idBilanUn;
    }

    public BilanDeux getIdBilanDeux() {
        return idBilanDeux;
    }

    public void setIdBilanDeux(BilanDeux idBilanDeux) {
        this.idBilanDeux = idBilanDeux;
    }

    protected Etudiant(Parcel in) {
        numEtu = in.readInt();
        identifiant = in.readString();
        mdpUtilisateur = in.readString();
        nomEtu = in.readString();
        preEtu = in.readString();
        mailEtu = in.readString();
        telEtu = in.readString();
        nomMaitreApp = in.readString();
        nomEts = in.readString();
        idBilanUn = in.readParcelable(BilanUn.class.getClassLoader());
        idBilanDeux = in.readParcelable(BilanDeux.class.getClassLoader());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numEtu);
        dest.writeString(identifiant);
        dest.writeString(mdpUtilisateur);
        dest.writeString(nomEtu);
        dest.writeString(preEtu);
        dest.writeString(mailEtu);
        dest.writeString(telEtu);
        dest.writeString(nomMaitreApp);
        dest.writeString(nomEts);
        dest.writeParcelable(idBilanUn, flags);
        dest.writeParcelable(idBilanDeux, flags);
    }
    public static final Parcelable.Creator<Etudiant> CREATOR = new Parcelable.Creator<Etudiant>() {
        @Override
        public Etudiant createFromParcel(Parcel in) {
            return new Etudiant(in);
        }

        @Override
        public Etudiant[] newArray(int size) {
            return new Etudiant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
