import java.util.Scanner;

public class BioskopWithScanner18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] penonton = new String[4][2];
        int pilihan;

        while (true) {
            System.out.println("===== Menu =====");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    int baris, kolom;
                    String nama, next;
                    do {
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();

                        while (true) {
                            System.out.print("Masukkan baris (1-4): ");
                            baris = sc.nextInt();
                            System.out.print("Masukkan kolom (1-2): ");
                            kolom = sc.nextInt();
                            sc.nextLine();

                            if (baris >= 1 && baris <= 4 && kolom >= 1 && kolom <= 2) {
                                if (penonton[baris - 1][kolom - 1] == null) {
                                    penonton[baris - 1][kolom - 1] = nama;
                                    System.out.println("Data penonton berhasil ditambahkan.");
                                    break;
                                } else {
                                    System.out.println("Kursi pada baris " + baris + " kolom " + kolom
                                            + " sudah terisi oleh " + penonton[baris - 1][kolom - 1]);
                                    System.out.println("Silakan pilih kursi lain.");
                                }
                            } else {
                                System.out.println(
                                        "Posisi baris atau kolom tidak valid. Silakan masukkan nomor yang benar.");
                            }
                        }
                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();
                    } while (next.equalsIgnoreCase("y"));
                    break;
                case 2:
                    System.out.println("===== Daftar Penonton =====");
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Penonton pada baris ke-" + (i + 1) + ": ");
                        String[] row = penonton[i];
                        for (int j = 0; j < row.length; j++) {
                            if (row[j] == null) {
                                row[j] = "***";
                            }
                        }
                        System.out.println(String.join(", ", row));
                    }
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1, 2, atau 3.");
            }
        }
    }
}
