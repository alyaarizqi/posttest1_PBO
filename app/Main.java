package manajemenKeuangan.app;

import java.util.Scanner;
import manajemenKeuangan.finance.KeuanganPribadi;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;
            
            do {
                System.out.println("\n=== Aplikasi Keuangan Pribadi ===");
                System.out.println("1. Tambah Transaksi");
                System.out.println("2. Lihat Transaksi");
                System.out.println("3. Hapus Transaksi");
                System.out.println("4. Update Transaksi");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                
                switch (pilihan) {
                    case 1 -> {
                        // Tambah transaksi
                        System.out.print("Masukkan nominal uang (Rp) : ");
                        double nominal = scanner.nextDouble();
                        System.out.print("Masukkan jenis (Pendapatan/Pengeluaran): ");
                        scanner.nextLine(); // Membersihkan buffer
                        String jenis = scanner.nextLine();
                        System.out.print("Masukkan keterangan: ");
                        String keterangan = scanner.nextLine();
                        KeuanganPribadi.tambahTransaksi(nominal, jenis, keterangan);
                    }
                        
                    case 2 -> // Lihat transaksi
                        KeuanganPribadi.lihatTransaksi();
                        
                    case 3 -> {
                        // Hapus transaksi
                        KeuanganPribadi.lihatTransaksi();
                        System.out.print("Masukkan keterangan transaksi yang ingin dihapus: ");
                        scanner.nextLine(); // Membersihkan buffer
                        String keteranganHapus = scanner.nextLine();
                        KeuanganPribadi.hapusTransaksi(keteranganHapus);
                    }
                        
                    case 4 -> {
                        // Update transaksi
                        KeuanganPribadi.lihatTransaksi();
                        System.out.print("Masukkan keterangan transaksi yang ingin diupdate: ");
                        scanner.nextLine(); // Membersihkan buffer
                        String keteranganUpdate = scanner.nextLine();
                        KeuanganPribadi.updateTransaksi(keteranganUpdate);
                    }
                        
                    case 5 -> System.out.println("Terima kasih!");
                        
                    default -> System.out.println("Pilihan tidak valid.");
                }
                
            } while (pilihan != 5);
        }
    }
}

