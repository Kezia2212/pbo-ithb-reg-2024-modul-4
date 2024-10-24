package model;

public class MatkulPilihan extends Matkul {
    private int jmlMinimumMhs;

    public MatkulPilihan(String kodeMatkul, int sks, String namaMatkul, int jmlMinimumMhs) {
        super(kodeMatkul, sks, namaMatkul);
        this.jmlMinimumMhs = jmlMinimumMhs;
    }

    public int getJmlMinimumMhs() {
        return jmlMinimumMhs;
    }

    public void setJmlMinimumMhs(int jmlMinimumMhs) {
        this.jmlMinimumMhs = jmlMinimumMhs;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMinimum Mahasiswa: " + jmlMinimumMhs;
    }
}