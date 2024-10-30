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
            } else if (mhs instanceof Magister) {
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

    public static void menu4(String kodeMK, ArrayList<Mahasiswa> mahasiswaList) {
        int totalTidakLulus = 0; // Jumlah mahasiswa yang tidak lulus
        int totalMhs = 0; // Total mahasiswa yang mengambil mata kuliah
        String namaMatkul = ""; // Nama mata kuliah
    
        for (Mahasiswa mhs : mahasiswaList) {
            ArrayList<MatkulAmbil> matkulList = null;
    
            // Tentukan jenis mahasiswa dan ambil daftar mata kuliah
            if (mhs instanceof Sarjana) {
                matkulList = ((Sarjana) mhs).getMatakuliah();
            } else if (mhs instanceof Magister) {
                matkulList = ((Magister) mhs).getMatakuliah();
            }
    
            if (matkulList != null) {
                for (MatkulAmbil ambil : matkulList) {
                    // Cek apakah kode mata kuliah cocok
                    if (ambil.getKodeMatkul().equalsIgnoreCase(kodeMK)) {
                        if (namaMatkul.isEmpty()) {
                            namaMatkul = ambil.getNamaMatkul(); // Set nama mata kuliah hanya sekali
                        }
                        totalMhs++; // Tambah jumlah mahasiswa yang mengambil mata kuliah
    
                        // Hitung nilai akhir dan cek jika kurang dari 56
                        double nilaiAkhir = hitungNA(matkulList, kodeMK);
                        if (nilaiAkhir < 56) {
                            totalTidakLulus++;
                        }
                        break; // Keluar dari loop setelah menemukan mata kuliah yang cocok
                    }
                }
            }
        }
    
    
        JOptionPane.showMessageDialog(null,
                "<" + totalTidakLulus + "> dari " + "<" + totalMhs + "> tidak lulus matkul : " + namaMatkul, "Tidak Lulus",
                JOptionPane.INFORMATION_MESSAGE);
    
    }
    

    public static void menu5(String NIM, ArrayList<Mahasiswa> mahasiswaList) {
        ArrayList<PresensiMhs> presensiList = null;
        ArrayList<MatkulAmbil> matakuliah = null;
        Mahasiswa mmhs = null;
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.getNIM().equalsIgnoreCase(NIM)) {
                mmhs = mhs;
            }

            if (mmhs instanceof Sarjana) {
                Sarjana sarjana = (Sarjana) mmhs;
                for (MatkulAmbil ambil : sarjana.getMatakuliah()) {
                    presensiList = ambil.getPresensiList();
                }
                matakuliah = sarjana.getMatakuliah();
            } else if (mmhs instanceof Magister) {
                Magister magister = (Magister) mmhs;
                for (MatkulAmbil ambil : magister.getMatakuliah()) {
                    presensiList = ambil.getPresensiList();
                }
                matakuliah = magister.getMatakuliah();
            }
        }
        JOptionPane.showMessageDialog(null, matakuliah + "Presensi : " + presensiList, "Matkul ambil",
                JOptionPane.INFORMATION_MESSAGE);

    }

    public static void menu6(String NIK, ArrayList<Staff> staffList) {
        int totalJam = 0;

        for (Staff staff : staffList) {
            if (staff.getNIK().equalsIgnoreCase(NIK)) {
                if (staff instanceof DosenTetap) {
                    DosenTetap dosenTetap = (DosenTetap) staff;
                    totalJam += itungJam(dosenTetap);
                } else if (staff instanceof DosenHonorer) {
                    DosenHonorer dosenHonorer = (DosenHonorer) staff;
                    totalJam += itungJam(dosenHonorer);
                }
                break;
            }
        }

        if (totalJam == 0) {
            JOptionPane.showMessageDialog(null, "Tidak ada jam kerja", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Jam kerja : " + totalJam, "Jam Kerja Staff",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static int itungJam(Dosen dosen){
        int jamKerja = 0;
        for (MatkulAjar matkulAjar : dosen.getMatkulAjarList()) {
            for (PresensiStaff stafAbs : matkulAjar.getPresensiStaffList()) {
                if (stafAbs.getStatus() == 1) {
                    jamKerja += stafAbs.getJam();
                }
            }
        }
        return jamKerja;
    }


    public static void menu7(String NIK, ArrayList<Staff> staffList){
        double salary = 0;
        int totalAbsen = 0;
        for (Staff staff : staffList) {
            if (staff.getNIK().equalsIgnoreCase(NIK)) {
                if (staff instanceof DosenHonorer) {
                    DosenHonorer honor = (DosenHonorer) staff;
                    for (MatkulAjar matkulAjar : honor.getMatkulAjarList()) {
                        for (PresensiStaff stafAbs : matkulAjar.getPresensiStaffList()) {
                            if (stafAbs.getStatus() == 1) {
                                totalAbsen++;
                            }
                        }
                    }
                    salary = honor.getHororPerSKS() * totalAbsen;
                } else if (staff instanceof DosenTetap) {
                    DosenTetap tetep = (DosenTetap) staff;
                    for (MatkulAjar matkulAjar : tetep.getMatkulAjarList()) {
                        for (PresensiStaff stafAbs : matkulAjar.getPresensiStaffList()) {
                            if (stafAbs.getStatus() == 1) {
                                totalAbsen++;
                            }
                        }
                    }
                    salary = tetep.getSalary() + (totalAbsen*25000);
                } else if (staff instanceof Karyawan) {
                    Karyawan kar = (Karyawan) staff;
                    for (PresensiStaff stafAbs : kar.getPresensiStaffList()) {
                        if (stafAbs.getStatus() == 1) {
                            totalAbsen++;
                        }
                    }
                    salary = totalAbsen/22*salary;
                } 
                break;
            } else {
                JOptionPane.showMessageDialog(null, "NIK staff yang dicari tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                return;

            }
        }
        JOptionPane.showMessageDialog(null, "Salarynya : " + salary, "Jam Kerja Staff",
                    JOptionPane.INFORMATION_MESSAGE);
    }

}
