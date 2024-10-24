package model;

import java.util.*;

public class Sarjana extends Mahasiswa { 
    private ArrayList<MatkulAmbil> matakuliah;

    public ArrayList<MatkulAmbil> getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(ArrayList<MatkulAmbil> matakuliah) {
        this.matakuliah = matakuliah;
    }

    public Sarjana(String nama, String alamat, String ttl, String telp, String jurusan, String NIM, ArrayList<MatkulAmbil> matakuliah) {
        super(nama, alamat, ttl, telp, jurusan, NIM);
        this.matakuliah = matakuliah;
    }

    @Override
    public String toString() {
        return "Type : " + this.getClass().getSimpleName() + "\n" + super.toString() + "\nMatkul: " + matakuliah;
    }
}