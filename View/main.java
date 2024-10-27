package View;

import java.util.*;
import javax.swing.JOptionPane;
import model.*;

public class main {
    static ArrayList<PresensiMhs> presensiListMhs = new ArrayList<PresensiMhs>();
    static ArrayList<PresensiStaff> presensiListStaff = new ArrayList<>();
    static ArrayList<PresensiStaff> presensiListStaff2 = new ArrayList<>();
    static ArrayList<PresensiMhs> presensiListMhs2 = new ArrayList<>();
    static ArrayList<MatkulAmbil> matkul1 = new ArrayList<>();
    static ArrayList<MatkulAmbil> matkul2 = new ArrayList<>();
    static ArrayList<MatkulAjar> matkul3 = new ArrayList<>();
    static ArrayList<MatkulPilihan> matkul4 = new ArrayList<>();
    static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

    public static void main(String[] args) {
        dummy();

        int menu;
        do {
            String pilihMenu = JOptionPane.showInputDialog("Pilih Menu \n1.Print User Data \n2.Print NA \n3.Print rata-rata Nilai Akhir \n4.Print data mahasiswa tidak lulus \n5.Print Matkul Ambil \n6.Print total jam ajar dosen \n7.Print gaji staff \n0.Exit \n: ");
            menu = Integer.parseInt(pilihMenu);

            switch (menu) {
                case 1:
                String nama = JOptionPane.showInputDialog("Masukkan Nama Mahasiswa: ");
                boolean found = false;
                for (Mahasiswa mhs : mahasiswaList) {
                    if (mhs.getNama().equalsIgnoreCase(nama)) {
                        JOptionPane.showMessageDialog(null, mhs.toString(), "Data Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Mahasiswa dengan nama " + nama + " tidak ditemukan.", "Data Mahasiswa", JOptionPane.WARNING_MESSAGE);
                }
                    break;

                case 2:
                    // Tambahkan logika untuk menampilkan data mahasiswa yang tidak lulus
                    break;

                case 3:
                    double rataRataNilaiAkhir = 0;
                    int jmlMahasiswa = 0;
                    for (MatkulAmbil matkul : matkul1) {
                        // rataRataNilaiAkhir += matkul.getNilaiAkhir();
                        jmlMahasiswa++;
                    }
                    if (jmlMahasiswa > 0) {
                        rataRataNilaiAkhir /= jmlMahasiswa;
                        System.out.println("Rata-rata Nilai Akhir: " + rataRataNilaiAkhir);
                    } else {
                        System.out.println("Data tidak tersedia.");
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (menu != 0);
    }

        static void dummy() {
                presensiListMhs.add(new PresensiMhs(new Date(), 1, "08:00")); // Mahasiswa hadir jam 08:00
                presensiListMhs.add(new PresensiMhs(new Date(), 0, "10:00")); // Mahasiswa tidak hadir, jam 10:00
                presensiListMhs.add(new PresensiMhs(new Date(), 1, "14:00")); // Mahasiswa hadir jam 14:00

                presensiListStaff.add(new PresensiStaff(new Date(), 1, "3"));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, "5"));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, "1"));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, "2"));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, "3"));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, "2"));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, "4"));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, "2"));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, "1"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "5"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "8"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, "2"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "2"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "7"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, "4"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "6"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, "3"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, "7"));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, "8"));

                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "07:30")); // Mahasiswa hadir jam 07:30 (tepat
                                                                               // waktu)
                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "08:15")); // Mahasiswa hadir jam 08:15 (terlambat)
                presensiListMhs2.add(new PresensiMhs(new Date(), 0, "09:00")); // Mahasiswa tidak hadir
                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "12:30")); // Mahasiswa hadir jam 12:30 (siang)
                presensiListMhs2.add(new PresensiMhs(new Date(), 0, "15:00")); // Mahasiswa tidak hadir jam 15:00

                // System.out.println(presensiListMhs2.toString());
                // Matkul Ambil
                MatkulAmbil matkulA1 = new MatkulAmbil("IF-001", 4, "Algoritma", presensiListMhs2, 80.1, 90.0, 100.0);
                MatkulAmbil matkulA2 = new MatkulAmbil("IF-002", 3, "Matvek", presensiListMhs, 79, 90.0, 100.0);
                MatkulAmbil matkulA3 = new MatkulAmbil("IF-003", 2, "Sisber", presensiListMhs2, 80.1, 40, 90);
                MatkulAmbil matkulA4 = new MatkulAmbil("IF-004", 1, "Prak Algo", presensiListMhs, 70, 90.0, 77.0);
                MatkulAmbil matkulA5 = new MatkulAmbil("IF-005", 4, "Basis Data", presensiListMhs2, 80.1, 90.0, 98.0);
                MatkulAmbil matkulA6 = new MatkulAmbil("IF-006", 3, "Jaringan Komputer", presensiListMhs, 85.0, 92.5,
                                88.0);
                MatkulAmbil matkulA7 = new MatkulAmbil("IF-007", 4, "Pengembangan Web", presensiListMhs2, 78.0, 85.0,
                                94.0);
                MatkulAmbil matkulA8 = new MatkulAmbil("IF-008", 2, "Analisis Algoritma", presensiListMhs, 82.0, 75.0,
                                89.0);
                MatkulAmbil matkulA9 = new MatkulAmbil("IF-009", 1, "Sistem Operasi", presensiListMhs2, 90.0, 88.0,
                                95.0);
                MatkulAmbil matkulA10 = new MatkulAmbil("IF-010", 3, "Kecerdasan Buatan", presensiListMhs, 88.5, 90.0,
                                92.0);
                MatkulAjar matkulA11 = new MatkulAjar("IF-011", 4, "Rekayasa Perangkat Lunak", presensiListStaff);
                MatkulAjar matkulA12 = new MatkulAjar("IF-012", 2, "Teori Graf", presensiListStaff);
                MatkulAjar matkulA13 = new MatkulAjar("IF-013", 1, "Statistika", presensiListStaff);
                MatkulAjar matkulA14 = new MatkulAjar("IF-014", 3, "Machine Learning", presensiListStaff);
                MatkulAjar matkulA15 = new MatkulAjar("IF-015", 4, "Mobile Programming", presensiListStaff);

                // System.out.println(matkulA1.toString());

                matkul1.add(matkulA1);
                matkul1.add(matkulA2);
                matkul1.add(matkulA3);
                matkul1.add(matkulA4);
                matkul1.add(matkulA5);

                matkul2.add(matkulA6);
                matkul2.add(matkulA7);
                matkul2.add(matkulA8);
                matkul2.add(matkulA9);
                matkul2.add(matkulA10);

                matkul3.add(matkulA11);
                matkul3.add(matkulA12);
                matkul3.add(matkulA13);
                matkul3.add(matkulA14);
                matkul3.add(matkulA15);

                MatkulPilihan matkul11 = new MatkulPilihan("MP-001", 3, "Pemrograman Web", 5);
                MatkulPilihan matkul12 = new MatkulPilihan("MP-002", 4, "Kecerdasan Buatan", 6);
                MatkulPilihan matkul13 = new MatkulPilihan("MP-003", 2, "Pengembangan Aplikasi Mobile", 4);
                MatkulPilihan matkul14 = new MatkulPilihan("MP-004", 3, "Data Mining", 7);
                MatkulPilihan matkul15 = new MatkulPilihan("MP-005", 2, "Rekayasa Perangkat Lunak", 5);

                matkul4.add(matkul11);
                matkul4.add(matkul12);
                matkul4.add(matkul13);
                matkul4.add(matkul14);
                matkul4.add(matkul15);

                // Mahasiswa

                // Dummy data untuk Sarjana
                Mahasiswa MhsSarjana1 = new Sarjana("Kezia Natalia", "rumah", "Bandung, 22 Des 2004", "0829818928912",
                                "Informatika", "1123001", matkul1);
                Mahasiswa MhsSarjana2 = new Sarjana("Pierre Yosefa", "begitulah...", "Tasik, 26 July 2004",
                                "0829818928912",
                                "Informatika", "1123002", matkul2);
                Mahasiswa MhsSarjana3 = new Sarjana("Fani Ardianto", "Jl. Kembang", "Surabaya, 15 Jan 2003",
                                "083234567891",
                                "Informatika", "1123003", matkul1);

                // Dummy data untuk Magister
                Mahasiswa MhsMagister1 = new Magister("Silvia Anggreni", "itulah", "Jakarta, 22 Des 2001",
                                "0829818928912",
                                "1103001", "Informatika", matkul1, "Kenapa Saya Cepat Pusing");
                Mahasiswa MhsMagister2 = new Magister("Teguh Handoyo", "Jl. Kenangan", "Bogor, 1 Mei 2002",
                                "082345678912",
                                "1103002", "Ilmu Komputer", matkul2, "Penerapan AI dalam Diagnosa");

                // Dummy data untuk Doktor
                Mahasiswa MhsDoktor1 = new Doktor("Dr. Siti", "Jl. Mawar No. 10", "1990-01-01", "08123456789", "D001",
                                "Ilmu Komputer", "Optimasi Algoritma", 85, 90, 95);
                Mahasiswa MhsDoktor2 = new Doktor("Dr. Budi Santoso", "Jl. Anggrek No. 5", "1985-03-10", "08134567890",
                                "D002",
                                "Sistem Informasi", "Analisis Big Data", 80, 85, 90);

                // Menambahkan objek-objek Mahasiswa ke ArrayList
                mahasiswaList.add(MhsSarjana1);
                mahasiswaList.add(MhsSarjana2);
                mahasiswaList.add(MhsSarjana3);
                mahasiswaList.add(MhsMagister1);
                mahasiswaList.add(MhsMagister2);
                mahasiswaList.add(MhsDoktor1);
                mahasiswaList.add(MhsDoktor2);

                Staff DosenTetap = new DosenTetap("Inge Martina", "di rumahnya", "gatau", "111", "11111", "Teknik",
                                matkul3,
                                5000000);
                Staff DosenHonorer = new DosenHonorer("Budi Santoso", "Jl. Kenanga No. 5", "1990-06-25", "089876543210",
                                "22222", "Sistem Informasi", matkul3, 50000);
                Staff Karyawan = new Karyawan("Udin", "..", "...", "238819", "33333", 1000000, presensiListStaff2);
                // System.out.println(DosenTetap.toString());
                // System.out.println();
                // System.out.println(DosenHonorer.toString());
                // System.out.println();
                // System.out.println(Karyawan.toString());
                // System.out.println();
        }

}