package model;

import java.util.*;

public class MatkulAjar extends Matkul {
    private ArrayList<PresensiStaff> presensiStaffList;

    public MatkulAjar(String kodeMatkul, int sks, String namaMatkul, ArrayList<PresensiStaff> presensiStaffList){
        super(kodeMatkul, sks, namaMatkul);
        this.presensiStaffList = presensiStaffList;
    }

    public List<PresensiStaff> getPresensiStaffList() {
        return presensiStaffList;
    }

    @Override
    public String toString() {
        return super.toString() +  "\nPresensi Staff: " + presensiStaffList;
    }
}