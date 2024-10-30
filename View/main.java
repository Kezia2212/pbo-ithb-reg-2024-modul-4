package View;

import java.util.*;
import javax.swing.JOptionPane;
import model.*;
import controller.functionAll;

public class Main {

        static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
        static ArrayList<Staff> karyawanList = new ArrayList<Staff>();

        public static void main(String[] args) {
                dummy();

                int menu;
                do {
                        String pilihMenu = JOptionPane.showInputDialog(
                                        "Pilih Menu \n1.Print User Data \n2.Print NA \n3.Print rata-rata Nilai Akhir \n4.Print data mahasiswa tidak lulus \n5.Print Matkul Ambil \n6.Print total jam ajar dosen \n7.Print gaji staff \n0.Exit");
                        menu = Integer.parseInt(pilihMenu);

                        switch (menu) {
                                case 1:
                                        String nama = JOptionPane.showInputDialog("Masukkan Nama Mahasiswa: ");
                                        functionAll.printUserData(nama, mahasiswaList);

                                        break;

                                case 2:
                                        String NIM = JOptionPane.showInputDialog("Masukkan NIM Mahasiswa: ");
                                        String kodeMK = JOptionPane.showInputDialog("Masukkan Kode MK: ");

                                        functionAll.NA(NIM, kodeMK, mahasiswaList);
                                        break;

                                case 3:
                                        String kodeMK2 = JOptionPane.showInputDialog("Masukkan Kode MK: ");
                                        double rataRata = functionAll.NR(kodeMK2, mahasiswaList);
                                        if (rataRata == 0) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Mata kuliah dengan kode " + kodeMK2 + "nilai 0.",
                                                                "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                        JOptionPane.showMessageDialog(null, rataRata, "Rata-Rata Kode MK",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                        break;

                                case 4:
                                        String kodeMK3 = JOptionPane.showInputDialog("Masukkan Kode MK: ");
                                        functionAll.menu4(kodeMK3, mahasiswaList);
                                        break;

                                case 5:
                                        String NIM2 = JOptionPane.showInputDialog("Masukkan NIM Mahasiswa: ");
                                        functionAll.menu5(NIM2, mahasiswaList);
                                        break;

                                case 6:
                                        String NIK = JOptionPane.showInputDialog("Masukkan NIK Dosen: ");
                                        functionAll.menu6(NIK, karyawanList);
                                        break;

                                case 7:
                                        break;
                                case 0:
                                        JOptionPane.showMessageDialog(null, "Keluar dari program", "",
                                                        JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                        }
                } while (menu != 0);
        }

        public static void dummy() {
                ArrayList<PresensiMhs> presensiListMhs = new ArrayList<>();
                ArrayList<PresensiStaff> presensiListStaff = new ArrayList<>();
                ArrayList<PresensiStaff> presensiListStaff2 = new ArrayList<>();
                ArrayList<PresensiMhs> presensiListMhs2 = new ArrayList<>();
                ArrayList<MatkulAmbil> matkul1 = new ArrayList<>();
                ArrayList<MatkulAmbil> matkul2 = new ArrayList<>();
                ArrayList<MatkulAjar> matkulAjar1 = new ArrayList<>();
                ArrayList<MatkulAjar> matkulAjar2 = new ArrayList<>();
                ArrayList<MatkulAjar> matkulAjar3 = new ArrayList<>();
                ArrayList<MatkulAmbil> matkul4 = new ArrayList<>();

                presensiListMhs.add(new PresensiMhs(new Date(), 1, "08:00")); // Mahasiswa hadir jam 08:00
                presensiListMhs.add(new PresensiMhs(new Date(), 0, "10:00")); // Mahasiswa tidak hadir, jam 10:00
                presensiListMhs.add(new PresensiMhs(new Date(), 1, "14:00")); // Mahasiswa hadir jam 14:00

                presensiListStaff.add(new PresensiStaff(new Date(), 1, 3));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, 5));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, 1));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, 2));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, 3));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, 2));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, 4));
                presensiListStaff.add(new PresensiStaff(new Date(), 1, 2));
                presensiListStaff.add(new PresensiStaff(new Date(), 0, 1));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 5));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 8));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, 2));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 2));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 7));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, 4));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 6));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, 3));
                presensiListStaff2.add(new PresensiStaff(new Date(), 1, 7));
                presensiListStaff2.add(new PresensiStaff(new Date(), 0, 8));

                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "07:30")); // Mahasiswa hadir jam 07:30 (tepat
                                                                               // waktu)
                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "08:15")); // Mahasiswa hadir jam 08:15 (terlambat)
                presensiListMhs2.add(new PresensiMhs(new Date(), 0, "09:00")); // Mahasiswa tidak hadir
                presensiListMhs2.add(new PresensiMhs(new Date(), 1, "12:30")); // Mahasiswa hadir jam 12:30 (siang)
                presensiListMhs2.add(new PresensiMhs(new Date(), 0, "15:00")); // Mahasiswa tidak hadir jam 15:00

                // System.out.println(presensiListMhs2.toString());
                // Matkul Ambil
                MatkulAmbil matkulA1 = new MatkulAmbil("IF001", 4, "Algoritma", presensiListMhs2, 70.1, 30.0, 50.0);
                MatkulAmbil matkulA2 = new MatkulAmbil("IF002", 3, "Matvek", presensiListMhs, 79, 90.0, 100.0);
                MatkulAmbil matkulA3 = new MatkulAmbil("IF003", 2, "Sisber", presensiListMhs2, 80.1, 20.0, 90);
                MatkulAmbil matkulA4 = new MatkulAmbil("IF004", 1, "Prak Algo", presensiListMhs, 70, 90.0, 77.0);
                MatkulAmbil matkulA5 = new MatkulAmbil("IF005", 4, "Basis Data", presensiListMhs2, 80.1, 40.0, 98.0);
                MatkulAmbil matkulA6 = new MatkulAmbil("IF006", 3, "Jaringan Komputer", presensiListMhs, 85.0, 92.5,
                                88.0);
                MatkulAmbil matkulA7 = new MatkulAmbil("IF007", 4, "Pengembangan Web", presensiListMhs2, 78.0, 85.0,
                                94.0);
                MatkulAmbil matkulA8 = new MatkulAmbil("IF008", 2, "Analisis Algoritma", presensiListMhs, 82.0, 75.0,
                                89.0);
                MatkulAmbil matkulA9 = new MatkulAmbil("IF009", 1, "Sistem Operasi", presensiListMhs2, 90.0, 88.0,
                                95.0);
                MatkulAmbil matkulA10 = new MatkulAmbil("IF010", 3, "Kecerdasan Buatan", presensiListMhs, 88.5, 90.0,
                                92.0);
                MatkulAjar matkulA11 = new MatkulAjar("IF001", 4, "Algoritma", presensiListStaff);
                MatkulAjar matkulA12 = new MatkulAjar("IF002", 3, "Matvek", presensiListStaff);
                MatkulAjar matkulA13 = new MatkulAjar("IF003", 2, "Sisber", presensiListStaff);
                MatkulAjar matkulA14 = new MatkulAjar("IF004", 1, "Prak Algo", presensiListStaff);
                MatkulAjar matkulA15 = new MatkulAjar("IF005", 4, "Basis Data", presensiListStaff);

                matkulAjar1.add(matkulA11);
                matkulAjar1.add(matkulA12);
                matkulAjar1.add(matkulA13);
                matkulAjar1.add(matkulA14);
                matkulAjar1.add(matkulA15);

                matkulAjar2.add(new MatkulAjar("IF006", 3, "Jaringan Komputer", presensiListStaff));
                matkulAjar2.add(new MatkulAjar("IF007", 4, "Pengembangan Web", presensiListStaff));
                matkulAjar2.add(new MatkulAjar("IF008", 2, "Analisis Algoritma", presensiListStaff));
                matkulAjar2.add(new MatkulAjar("IF009", 1, "Sistem Operasi", presensiListStaff));
                matkulAjar2.add(new MatkulAjar("IF010", 3, "Kecerdasan Buatan", presensiListStaff));
        
                matkulAjar3.add(new MatkulAjar("IF011", 3, "Cloud Computing", presensiListStaff));
                matkulAjar3.add(new MatkulAjar("IF012", 2, "Keamanan Jaringan", presensiListStaff));
                matkulAjar3.add(new MatkulAjar("IF013", 1, "Kriptografi", presensiListStaff));
                matkulAjar3.add(new MatkulAjar("IF014", 3, "Data Mining", presensiListStaff));
                matkulAjar3.add(new MatkulAjar("IF015", 4, "Internet of Things", presensiListStaff));
                                // System.out.println(matkulA1.toString());
                matkul1.add(matkulA1);
                matkul1.add(matkulA2);
                matkul1.add(matkulA3);
                matkul1.add(matkulA4);
                matkul1.add(matkulA5);
                
                matkul4.add(new MatkulAmbil("IF011", 3, "Cloud Computing", presensiListMhs2, 75.5, 85.0, 90.0));
                matkul4.add(new MatkulAmbil("IF012", 2, "Keamanan Jaringan", presensiListMhs, 78.0, 70.0, 88.0));
                matkul4.add(new MatkulAmbil("IF013", 1, "Kriptografi", presensiListMhs, 85.0, 90.0, 95.0));
                matkul4.add(new MatkulAmbil("IF014", 3, "Data Mining", presensiListMhs, 80.0, 90.0, 95.0));
                matkul4.add(new MatkulAmbil("IF015", 4, "Internet of Things", presensiListMhs, 85.0, 90.0, 95.0));


                matkul2.add(matkulA6);
                matkul2.add(matkulA7);
                matkul2.add(matkulA8);
                matkul2.add(matkulA9);
                matkul2.add(matkulA10);

                

                MatkulPilihan matkul11 = new MatkulPilihan("MP-001", 3, "Pemrograman Web", 5);
                MatkulPilihan matkul12 = new MatkulPilihan("MP-002", 4, "Kecerdasan Buatan", 6);
                MatkulPilihan matkul13 = new MatkulPilihan("MP-003", 2, "Pengembangan Aplikasi Mobile", 4);
                MatkulPilihan matkul14 = new MatkulPilihan("MP-004", 3, "Data Mining", 7);
                MatkulPilihan matkul15 = new MatkulPilihan("MP-005", 2, "Rekayasa Perangkat Lunak", 5);

                // Mahasiswa

                mahasiswaList.add(new Sarjana("Kezia Natalia", "rumah", "Bandung, 22 Des 2004", "0829818928912",
                                "Informatika", "S001", matkul1));
                mahasiswaList.add(new Sarjana("Pierre Yosefa", "begitulah...", "Tasik, 26 July 2004",
                                "0829818928912",
                                "Informatika", "S002", matkul1));
                mahasiswaList.add(new Magister("Silvia Anggreni", "itulah", "Jakarta, 22 Des 2001",
                                "0829818928912",
                                "M001", "Informatika", matkul2, "Kenapa Saya Cepat Pusing"));
                mahasiswaList.add(new Magister("Teguh Handoyo", "Jl. Kenangan", "Bogor, 1 Mei 2002",
                                "082345678912",
                                "M002", "Ilmu Komputer", matkul2, "Penerapan AI dalam Diagnosa"));
                mahasiswaList.add(new Doktor("Dr. Siti", "Jl. Mawar No. 10", "1990-01-01", "08123456789", "D001",
                                "Ilmu Komputer", "Optimasi Algoritma", 85, 90, 95));
                mahasiswaList.add(new Doktor("Dr. Budi Santoso", "Jl. Anggrek No. 5", "1985-03-10", "08134567890",
                                "D002",
                                "Sistem Informasi", "Analisis Big Data", 80, 85, 90));
                mahasiswaList.add(new Sarjana("Lina Sofia", "Jl. Melati", "Bandung, 15 Jan 2003", "08212345678",
                                "Informatika", "S003", matkul4));
                mahasiswaList.add(new Sarjana("Rizky Alif", "Jl. Cempaka", "Jakarta, 20 Feb 2004", "08298765432",
                                "Informatika", "S004", matkul4));
                mahasiswaList.add(new Magister("Silvia Anggreni", "itulah", "Jakarta, 22 Des 2001", "0829818928912",
                                "M001", "Informatika", matkul2, "Kenapa Saya Cepat Pusing"));
                mahasiswaList.add(new Magister("Teguh Handoyo", "Jl. Kenangan", "Bogor, 1 Mei 2002", "082345678912",
                                "M002", "Ilmu Komputer", matkul4, "Penerapan AI dalam Diagnosa"));
                mahasiswaList.add(new Magister("Dewi Lestari", "Jl. Merpati", "Surabaya, 18 Maret 2000", "08234567890",
                                "M003", "Informatika", matkul2, "Perkembangan Teknologi Informasi"));
                mahasiswaList.add(new Magister("Eko Prabowo", "Jl. Kenari", "Yogyakarta, 5 Apr 1999", "08123456789",
                                "M004", "Ilmu Komputer", matkul1, "Implementasi AI dalam Kehidupan Sehari-hari"));
                mahasiswaList.add(new Doktor("Dr. Siti", "Jl. Mawar No. 10", "1990-01-01", "08123456789", "D001",
                                "Ilmu Komputer", "Optimasi Algoritma", 85, 90, 95));
                mahasiswaList.add(new Doktor("Dr. Budi Santoso", "Jl. Anggrek No. 5", "1985-03-10", "08134567890",
                                "D002", "Sistem Informasi", "Analisis Big Data", 80, 85, 90));
                mahasiswaList.add(new Doktor("Dr. Maya", "Jl. Seruni No. 4", "1980-12-12", "08123456789", "D003",
                                "Sistem Komputer", "Keamanan Sistem Informasi", 92, 90, 88));
                mahasiswaList.add(new Doktor("Dr. Anton", "Jl. Flamboyan No. 7", "1978-06-06", "08123456780", "D004",
                                "Data Science", "Analisis Data Besar", 90, 85, 87));

                Staff DosenTetap1 = new DosenTetap("Inge Martina", "di rumahnya", "gatau", "111", "1", "Teknik",
                                matkulAjar1,
                                5000000);
                Staff DosenTetap2 = new DosenTetap("Ko Dion", "di rumahnya", "gatau", "111", "2", "Teknik",
                                matkulAjar2,
                                4500000);
                
                Staff DosenHonorer = new DosenHonorer("Budi Santoso", "Jl. Kenanga No. 5", "1990-06-25", "089876543210",
                                "3", "Sistem Informasi", matkulAjar3, 50000);
                Staff Karyawan = new Karyawan("Udin", "..", "...", "238819", "3", 1000000, presensiListStaff2);
                
                karyawanList.add(DosenTetap1);
                karyawanList.add(DosenTetap2);
                karyawanList.add(DosenHonorer);
                karyawanList.add(Karyawan);
        }

}