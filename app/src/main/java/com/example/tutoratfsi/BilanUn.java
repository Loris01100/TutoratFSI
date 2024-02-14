package com.example.tutoratfsi;

import java.util.Date;

public class BilanUn {
    private int idBilanUn;
    private int noteEts;
    private Date dateBilanUn;
    private int noteDossierUn;
    private int noteOralUn;
    private String rqBilanUn;

    public BilanUn(int idBilanUn, int noteEts, Date dateBilanUn, int noteDossierUn, int noteOralUn, String rqBilanUn) {
        this.idBilanUn = idBilanUn;
        this.noteEts = noteEts;
        this.dateBilanUn = dateBilanUn;
        this.noteDossierUn = noteDossierUn;
        this.noteOralUn = noteOralUn;
        this.rqBilanUn = rqBilanUn;
    }

    public int getIdBilanUn() {
        return idBilanUn;
    }

    public void setIdBilanUn(int idBilanUn) {
        this.idBilanUn = idBilanUn;
    }

    public int getNoteEts() {
        return noteEts;
    }

    public void setNoteEts(int noteEts) {
        this.noteEts = noteEts;
    }

    public Date getDateBilanUn() {
        return dateBilanUn;
    }

    public void setDateBilanUn(Date dateBilanUn) {
        this.dateBilanUn = dateBilanUn;
    }

    public int getNoteDossierUn() {
        return noteDossierUn;
    }

    public void setNoteDossierUn(int noteDossierUn) {
        this.noteDossierUn = noteDossierUn;
    }

    public int getNoteOralUn() {
        return noteOralUn;
    }

    public void setNoteOralUn(int noteOralUn) {
        this.noteOralUn = noteOralUn;
    }

    public String getRqBilanUn() {
        return rqBilanUn;
    }

    public void setRqBilanUn(String rqBilanUn) {
        this.rqBilanUn = rqBilanUn;
    }
}
