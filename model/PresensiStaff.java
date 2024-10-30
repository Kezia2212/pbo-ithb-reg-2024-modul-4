package model;

import java.util.*;

public class PresensiStaff extends Presensi {
    private int jam;

    
    public PresensiStaff(Date tanggal, int status, int jam) {
        super(tanggal, status);
        this.jam = jam;
    }
    
    public void setJam(int jam) {
        this.jam = jam;
    }

    public int getJam() {
        return jam;
    }

    @Override
    public String toString() {
        return super.toString() + "\nJam: " + jam;
    }
}