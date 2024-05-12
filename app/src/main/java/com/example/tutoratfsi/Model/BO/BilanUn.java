package com.example.tutoratfsi.Model.BO;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class BilanUn implements Parcelable{
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

    public BilanUn() {
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

    protected BilanUn(Parcel in) {
        noteEts = in.readInt();
        long tmpDate = in.readLong();
        dateBilanUn = tmpDate == -1 ? null : new Date(tmpDate);
        noteDossierUn = in.readInt();
        noteOralUn = in.readInt();
        rqBilanUn = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(noteEts);
        dest.writeLong(dateBilanUn != null ? dateBilanUn.getTime() : -1);
        dest.writeInt(noteDossierUn);
        dest.writeInt(noteOralUn);
        dest.writeString(rqBilanUn);
    }

    public static final Parcelable.Creator<BilanUn> CREATOR = new Parcelable.Creator<BilanUn>() {
        @Override
        public BilanUn createFromParcel(Parcel in) {
            return new BilanUn(in);
        }

        @Override
        public BilanUn[] newArray(int size) {
            return new BilanUn[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
