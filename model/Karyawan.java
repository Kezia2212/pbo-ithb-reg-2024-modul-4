package model;

import java.util.*;

public class Karyawan extends Staff {
    private double salary;
    private ArrayList<PresensiStaff> presensiStaffList;

    
    public Karyawan(String nama, String alamat, String ttl, String telepon, String nik, double salary, ArrayList<PresensiStaff> presensiStaffList) {
        super(nama, alamat, ttl, telepon, nik);
        this.salary = salary;
        this.presensiStaffList = presensiStaffList;
    }
    
    public List<PresensiStaff> getPresensiStaffList() {
        return presensiStaffList;
    }

    public void setPresensiStaffList(ArrayList<PresensiStaff> presensiStaffList) {
        this.presensiStaffList = presensiStaffList;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) { 
        this.salary = salary; 
    }

    @Override
    public String toString() {
        return "Type : " + this.getClass().getSimpleName() + "\n" + super.toString() + super.toString() + "\nSalary: " + salary + "\nPresensi Staff: " + presensiStaffList;
    }
}
