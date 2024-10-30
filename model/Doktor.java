package model;

public class Doktor extends Mahasiswa{ 
    private String judulPenelitianDisertasi;
    private int ns1, ns2, ns3;

    public String getJudulPenelitianDisertasi() {
        return judulPenelitianDisertasi;
    }

    public void setJudulPenelitianDisertasi(String judulPenelitianDisertasi) {
        this.judulPenelitianDisertasi = judulPenelitianDisertasi;
    }

    public int getNs1() {
        return ns1;
    }

    public void setNs1(int ns1) {
        this.ns1 = ns1;
    }

    public int getNs2() {
        return ns2;
    }

    public void setNs2(int ns2) {
        this.ns2 = ns2;
    }

    public int getNs3() {
        return ns3;
    }

    public void setNs3(int ns3) {
        this.ns3 = ns3;
    }

    public Doktor(String nama, String alamat, String ttl, String telp, String NIM, String jurusan, String judulPenelitianDisertasi, int ns1, int ns2, int ns3) {
        super(nama, alamat, ttl, telp, jurusan, NIM);
        this.judulPenelitianDisertasi = judulPenelitianDisertasi;
        this.ns1 = ns1;
        this.ns2 = ns2;
        this.ns3 = ns3;
    }

    @Override
    public String toString() {
        return "Type : " + this.getClass().getSimpleName() + "\n" + super.toString() + "\nJudul Penelitian Disertasi : " + judulPenelitianDisertasi + "\nNilai Sidang 1 : " + ns1 + "\nNilai Sidang 2 : " + ns2 + "\nNilai Sidang 3 : " + ns3;
    }
}


