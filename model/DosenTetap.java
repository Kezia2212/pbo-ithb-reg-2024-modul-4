package model;

import java.util.*;

public class DosenTetap extends Dosen {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public DosenTetap(String nama, String alamat, String ttl, String telepon, String nik, String departemen, ArrayList<MatkulAjar> matkulAjarList, double salary) {
        super(nama, alamat, ttl, telepon, nik, departemen, matkulAjarList);
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Type : " + this.getClass().getSimpleName() + "\n" + super.toString() + super.toString() + "\nSalary: " + salary;
    }
}