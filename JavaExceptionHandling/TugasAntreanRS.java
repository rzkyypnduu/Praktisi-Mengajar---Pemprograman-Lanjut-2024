package JavaExceptionHandling;

import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class TugasAntreanRS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Antrian Rumah Sakit
        Queue<String> antrian = new ArrayDeque<String>(10);

        int pilih = 0;

        do {
            try {
                System.out.println("\nSelamat datang di Rumah Sakit CAHAYA MEDIKA!");
                System.out.println("Silakan pilih menu:");
                System.out.println("1. Tambah pasien ke antrian");
                System.out.println("2. Panggil pasien berikutnya");
                System.out.println("3. Daftar antrian");
                System.out.println("4. Keluar");

                System.out.print("Masukkan pilihan Anda: ");
                pilih = input.nextInt();

                switch (pilih) {
                    case 1:
                        System.out.print("Silakan masukkan nama pasien:");
                        String namaPasien = input.next();
                        antrian.offer(namaPasien);
                        System.out.println("Pasien berhasil ditambahkan ke antrian.");
                        break;
                    case 2:
                        if (!antrian.isEmpty()) {
                            System.out.println("Pasien berikutnya silakan masuk.");
                            System.out.println(antrian.poll());
                        } else {
                            System.out.println("Antrian kosong.");
                        }
                        break;
                    case 3:
                        System.out.println("Daftar Antrean: " + antrian);
                        break;
                    case 4:
                        System.out.println("Terima kasih");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.next(); // membersihkan input yang salah
            } catch (NoSuchElementException e) {
                System.out.println("Kesalahan: Antrian kosong atau input tidak ditemukan.");
            } catch (IllegalStateException e) {
                System.out.println("Kesalahan: Operasi tidak diizinkan.");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        } while (pilih != 4);

        input.close();
    }
}

