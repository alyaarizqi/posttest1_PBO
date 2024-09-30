package manajemenKeuangan.finance;

import java.util.ArrayList;
import java.util.Scanner;
import manajemenKeuangan.models.Transaksi;

public class KeuanganPribadi {
    // Static ArrayList untuk menyimpan daftar transaksi
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    
    // Properti tambahan
    private final String pemilik; // Nama pemilik
    private final String mataUang; // Jenis mata uang

    // Constructor
    public KeuanganPribadi(String pemilik, String mataUang) {
        this.pemilik = pemilik;
        this.mataUang = mataUang;
    }

    // Method untuk menambah transaksi
    public static void tambahTransaksi(double nominal, String jenis, String keterangan) {
        Transaksi transaksiBaru = new Transaksi(nominal, jenis, keterangan);
        daftarTransaksi.add(transaksiBaru);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    // Method untuk melihat semua transaksi
    public static void lihatTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            System.out.println("=== Daftar Transaksi ===");
            for (Transaksi transaksi : daftarTransaksi) {
                transaksi.tampilkanTransaksi();
            }
        }
    }

    // Metode baru untuk menampilkan informasi
    public void tampilkanInfo() {
        System.out.println("Pemilik: " + pemilik);
        System.out.println("Mata Uang: " + mataUang);
    }

    // Method untuk menghapus transaksi berdasarkan keterangan
    public static void hapusTransaksi(String keterangan) {
        boolean ditemukan = false;
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getKeterangan().equals(keterangan)) {
                daftarTransaksi.remove(transaksi);
                System.out.println("Transaksi berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }

    // Method untuk meng-update transaksi berdasarkan keterangan
    public static void updateTransaksi(String keterangan) {
        boolean ditemukan = false;
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getKeterangan().equals(keterangan)) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Masukkan nominal uang baru: ");
                double nominalBaru = scanner.nextDouble();
                System.out.print("Masukkan jenis baru (Pendapatan/Pengeluaran): ");
                scanner.nextLine(); // Membersihkan buffer
                String jenisBaru = scanner.nextLine();
                System.out.print("Masukkan keterangan baru: ");
                String keteranganBaru = scanner.nextLine();

                // Meng-update nilai transaksi
                transaksi.setJumlah(nominalBaru);
                transaksi.setJenis(jenisBaru);
                transaksi.setKeterangan(keteranganBaru);

                System.out.println("Transaksi berhasil diupdate.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }
}
