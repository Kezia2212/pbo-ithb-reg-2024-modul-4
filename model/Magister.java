package model;

import java.util.*;

public class Magister extends Mahasiswa{ 
    private ArrayList<MatkulAmbil> matakuliah;
    private String judulPenelitianTesis;

    public String getJudulPenelitian() {
        return judulPenelitianTesis;
    }

    public void setJudulPenelitian(String judulPenelitian) {
        this.judulPenelitianTesis = judulPenelitian;
    }

    public ArrayList<MatkulAmbil> getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(ArrayList<MatkulAmbil> matakuliah) {
        this.matakuliah = matakuliah;
    }

    public Magister(String nama, String alamat, String ttl, String telp, String NIM, String jurusan, ArrayList<MatkulAmbil> matakuliah, String judulPenelitianTesis) {
        super(nama, alamat, ttl, telp, jurusan, NIM);
        this.matakuliah = matakuliah;
        this.judulPenelitianTesis = judulPenelitianTesis;
    }

    @Override
    public String toString() {
        return "Type : " + this.getClass().getSimpleName() + "\n" + super.toString() + "\nMatakuliah " + matakuliah;
    }

}

