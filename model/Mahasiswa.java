package model;

public abstract class Mahasiswa extends User {
    private String NIM, jurusan;

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String nIM) {
        NIM = nIM;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Mahasiswa(String nama, String alamat, String ttl, String telp, String jurusan, String NIM) {
        super(nama, alamat, ttl, telp);
        this.NIM = NIM;
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNIM : " + NIM + "\nJurusan : " + jurusan;
    }
}






