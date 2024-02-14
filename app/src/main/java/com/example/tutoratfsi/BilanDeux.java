package com.example.tutoratfsi;

import java.util.Date;

public class BilanDeux {
    private int idBilanDeux;
    private int noteOralDeux;
    private int noteDossierDeux;
    private Date dateBilanDeux;
    private String rqBilanDeux;
    private String sujetMemoire;

    public BilanDeux(int idBilanDeux, int noteOralDeux, int noteDossierDeux, Date dateBilanDeux, String rqBilanDeux, String sujetMemoire) {
        this.idBilanDeux = idBilanDeux;
        this.noteOralDeux = noteOralDeux;
        this.noteDossierDeux = noteDossierDeux;
        this.dateBilanDeux = dateBilanDeux;
        this.rqBilanDeux = rqBilanDeux;
        this.sujetMemoire = sujetMemoire;
    }

    public int getIdBilanDeux() {
        return idBilanDeux;
    }

    public void setIdBilanDeux(int idBilanDeux) {
        this.idBilanDeux = idBilanDeux;
    }

    public int getNoteOralDeux() {
        return noteOralDeux;
    }

    public void setNoteOralDeux(int noteOralDeux) {
        this.noteOralDeux = noteOralDeux;
    }

    public int getNoteDossierDeux() {
        return noteDossierDeux;
    }

    public void setNoteDossierDeux(int noteDossierDeux) {
        this.noteDossierDeux = noteDossierDeux;
    }

    public Date getDateBilanDeux() {
        return dateBilanDeux;
    }

    public void setDateBilanDeux(Date dateBilanDeux) {
        this.dateBilanDeux = dateBilanDeux;
    }

    public String getRqBilanDeux() {
        return rqBilanDeux;
    }

    public void setRqBilanDeux(String rqBilanDeux) {
        this.rqBilanDeux = rqBilanDeux;
    }

    public String getSujetMemoire() {
        return sujetMemoire;
    }

    public void setSujetMemoire(String sujetMemoire) {
        this.sujetMemoire = sujetMemoire;
    }
}
