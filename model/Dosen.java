package model;

import java.util.*;

public class Dosen extends Staff {
    private String departemen;
    private ArrayList<MatkulAjar> matkulAjarList;
    
    public Dosen(String nama, String alamat, String ttl, String telepon, String nik, String departemen, ArrayList<MatkulAjar> matkulAjarList) {
        super(nama, alamat, ttl, telepon, nik);
        this.departemen = departemen;
        this.matkulAjarList = matkulAjarList;
    }
    
    public ArrayList<MatkulAjar> getMatkulAjarList() {
        return matkulAjarList;
    }

    public void setMatkulAjarList(ArrayList<MatkulAjar> matkulAjarList) {
        this.matkulAjarList = matkulAjarList;
    }

    public String getDepartemen() { 
        return departemen; 
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen; 
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen: " + departemen + "\nMatkul Ajar: " + matkulAjarList;
    }
}