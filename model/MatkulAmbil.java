package model;

import java.util.*;

public class MatkulAmbil extends Matkul{
    private ArrayList<PresensiMhs> presensiList;
    private double n1, n2, n3;
    
    public MatkulAmbil(String kodeMatkul, int sks, String namaMatkul, ArrayList<PresensiMhs> presensiList, double n1, double n2, double n3){
        super(kodeMatkul, sks, namaMatkul);
        this.presensiList = presensiList;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public ArrayList<PresensiMhs> getPresensiList() {
        return presensiList;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getN3() {
        return n3;
    }

    @Override
    public String toString() {
        return "Nama Matkul : " + super.getNamaMatkul() + "\nPresensi: " + presensiList;
    }
}
