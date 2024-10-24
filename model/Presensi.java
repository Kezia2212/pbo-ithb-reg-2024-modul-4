package model;

import java.util.*;

public abstract class Presensi {
    private Date tanggal;
    private int status;

    public Presensi(Date tanggal, int status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Tanggal: " + tanggal + "\nStatus: " + status;
    }
}