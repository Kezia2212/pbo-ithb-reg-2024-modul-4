package controller;

import model.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.Main;

public class functionAll {
    static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

    public static void main(String[] args) {
        Main.dummy();
    }

    public static void printUserData(String nama, ArrayList<Mahasiswa> mahasiswaList) {
        boolean found = false;
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNama().equalsIgnoreCase(nama)) {
                JOptionPane.showMessageDialog(null, mhs.toString(), "Data Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Mahasiswa dengan nama " + nama + " tidak ditemukan.", "Data Mahasiswa",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void NA(String NIM, String kodeMK, ArrayList<Mahasiswa> mahasiswaList) {
        double nilaiAkhir = 0;
        boolean found = false;

        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNIM().equalsIgnoreCase(NIM)) {
                found = true;

                if (mhs instanceof Sarjana) {
                    Sarjana sarjana = (Sarjana) mhs;
                    nilaiAkhir = hitungNA(sarjana.getMatakuliah(), kodeMK);
                    printNA(NIM, kodeMK, nilaiAkhir, "Sarjana");
                    break;

                } else if (mhs instanceof Magister) {
                    Magister magister = (Magister) mhs;
                    nilaiAkhir = hitungNA(magister.getMatakuliah(), kodeMK);
                    printNA(NIM, kodeMK, nilaiAkhir, "Magister");
                    break;

                } else if (mhs instanceof Doktor) {
                    Doktor doktor = (Doktor) mhs;
                    nilaiAkhir = (doktor.getNs1() + doktor.getNs2() + doktor.getNs3()) / 3;
                    printNA(NIM, kodeMK, nilaiAkhir, "Doktor");
                    break;
                }
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Mahasiswa dengan NIM " + NIM + " tidak ditemukan.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    static double hitungNA(ArrayList<MatkulAmbil> matkulList, String kodeMK) {
        for (MatkulAmbil matkul : matkulList) {
            if (matkul.getKodeMatkul().equalsIgnoreCase(kodeMK)) {
                return (matkul.getN1() + matkul.getN2() + matkul.getN3()) / 3;
            }
        }
        return 0;
    }

    static void printNA(String NIM, String kodeMK, double nilaiAkhir, String tipeMahasiswa) {
        if (nilaiAkhir == 0) {
            JOptionPane.showMessageDialog(null,
                    "Mata kuliah dengan kode " + kodeMK + " tidak ditemukan atau nilai 0.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, nilaiAkhir,
                    "Nilai Akhir Mahasiswa " + tipeMahasiswa + " dengan NIM : " + NIM, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static double NR(String kodeMK, ArrayList<Mahasiswa> mahasiswaList) {
        double nilaiAkhir = 0;
        for (Mahasiswa mhs : mahasiswaList) {
            
            if (mhs instanceof Sarjana) {
                Sarjana sarjana = (Sarjana) mhs;

                nilaiAkhir += hitungNA(sarjana.getMatakuliah(), kodeMK);
            } else if (mhs instanceof Magister)  {
                Magister magister = (Magister) mhs;

                nilaiAkhir += hitungNA(magister.getMatakuliah(), kodeMK);
            } else {
                Doktor doktor = (Doktor) mhs;
                nilaiAkhir += (doktor.getNs1() + doktor.getNs2() + doktor.getNs3()) / 3;

            }
        }
        nilaiAkhir /= mahasiswaList.size();
        return nilaiAkhir;
    }

    public static void menu4(String kodeMK, ArrayList<Mahasiswa> mahasiswaList){
        int total = 0;
        int totalMhs = 0;
        String namaMatkul = "";
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs instanceof Sarjana) {
                Sarjana sarjana = (Sarjana) mhs;
                for (MatkulAmbil ambil : sarjana.getMatakuliah() ) {
                    if (ambil.getKodeMatkul().equalsIgnoreCase(kodeMK)) {
                        totalMhs++;
                        namaMatkul = ambil.getNamaMatkul();
                    }
                }
                if (hitungNA(sarjana.getMatakuliah() ,kodeMK) < 56) {
                    total++;
                }
            } else if (mhs instanceof Magister) {
                Magister magister = (Magister) mhs;
                for (MatkulAmbil ambil : magister.getMatakuliah() ) {
                    if (ambil.getKodeMatkul().equalsIgnoreCase(kodeMK)) {
                        totalMhs++;
                        namaMatkul = ambil.getNamaMatkul();
                    }
                }
                if (hitungNA(magister.getMatakuliah(), kodeMK) < 56) {
                    total++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "<"+ total + "> dari " + "<"+ totalMhs + "> tidak lulus matkul : " + namaMatkul , "Tidak Lulus", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void menu5(String NIM,ArrayList<Mahasiswa> mahasiswaList){
        ArrayList<PresensiMhs> presensiList = null;
        ArrayList<MatkulAmbil> matakuliah = null;
        Mahasiswa mmhs = null;
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNIM().equalsIgnoreCase(NIM)) {
                mmhs = mhs;
            }

            if(mmhs instanceof Sarjana) {
                Sarjana sarjana = (Sarjana) mmhs;
                for (MatkulAmbil ambil : sarjana.getMatakuliah()) {
                    presensiList = ambil.getPresensiList();
                }
                matakuliah = sarjana.getMatakuliah();
            } else if(mmhs instanceof Magister) {
                Magister magister = (Magister) mmhs;
                for (MatkulAmbil ambil : magister.getMatakuliah()) {
                    presensiList = ambil.getPresensiList();
                }
                matakuliah = magister.getMatakuliah();
            }
        }
        JOptionPane.showMessageDialog(null, matakuliah + "Presensi : " + presensiList , "Matkul ambil", JOptionPane.INFORMATION_MESSAGE);
        
    }
}