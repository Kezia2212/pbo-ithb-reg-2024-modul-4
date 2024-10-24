package model;

public abstract class User implements method{
    private String nama, alamat, ttl, telp;

    public User(String nama, String alamat, String ttl, String telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.ttl = ttl;
        this.telp = telp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    @Override
    public String toString(){
        return "Nama: " + nama + "\nAlamat: " + alamat + "\nTTL: " + ttl + "\nTelepon: " + telp;
    }

}