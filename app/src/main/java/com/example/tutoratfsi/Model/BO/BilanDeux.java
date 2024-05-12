package com.example.tutoratfsi.Model.BO;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class BilanDeux implements Parcelable{
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

    public BilanDeux() {
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
    protected BilanDeux(Parcel in) {
        sujetMemoire = in.readString();
        long tmpDate = in.readLong();
        dateBilanDeux = tmpDate == -1 ? null : new Date(tmpDate);
        noteDossierDeux = in.readInt();
        noteOralDeux = in.readInt();
        rqBilanDeux = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sujetMemoire);
        dest.writeLong(dateBilanDeux != null ? dateBilanDeux.getTime() : -1);
        dest.writeInt(noteDossierDeux);
        dest.writeInt(noteOralDeux);
        dest.writeString(rqBilanDeux);
    }

    public static final Parcelable.Creator<BilanDeux> CREATOR = new Parcelable.Creator<BilanDeux>() {
        @Override
        public BilanDeux createFromParcel(Parcel in) {
            return new BilanDeux(in);
        }

        @Override
        public BilanDeux[] newArray(int size) {
            return new BilanDeux[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
