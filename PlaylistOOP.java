/*
PROGRAM SISTEM MANAJEMEN PLAYLIST MUSIK
Kelompok:
1. RAMOT MANGIRING SILABAN (2902718263)
2. LUTFAN DAVI (2902716680)
3. DEVA NUR FADHILAH (2902738302)
4. THOMAS MICHAEL HAMONANGAN (2902716781)
*/
import java.util.Scanner;

public class PlaylistOOP {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Membuat array untuk menyimpan objek Lagu
        Lagu[] playlist = new Lagu[10];

        // membuat objek Admin dan Member
        Admin admin = new Admin("Andi");
        Member member = new Member("Budi");

        // Tambahkan beberapa lagu awal
        admin.tambahLagu(playlist, new Lagu("Alamak", "Rizky Febian", 4.3), 0);
        admin.tambahLagu(playlist, new Lagu("Stecu Stecu", "Faris Adam", 3.8), 1);
        admin.tambahLagu(playlist, new Lagu("Perfect", "Ed Sheeran", 4.1), 2);

        int jumlahLagu = 3; // karena sudah ada 3 lagu awal
        int role;

        do {
            System.out.println("\n=== SISTEM PLAYLIST ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("0. Keluar");
            System.out.print("Pilih:");

            role = input.nextInt();
            input.nextLine(); // bersihkan newline

            switch (role) {

                case 1: // role sabgai ADMIN
                    admin.tampilkanAkses();
                    int menuAdmin;
                    do {
                        System.out.println("\n=== MENU ADMIN ===");
                        System.out.println("1. Tambah Lagu");
                        System.out.println("2. Lihat Playlist");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih: ");

                        menuAdmin = input.nextInt();
                        input.nextLine();

                        switch (menuAdmin) {
                            case 1:
                                if (jumlahLagu < playlist.length) {
                                    System.out.print("Judul Lagu: ");
                                    String judul = input.nextLine();

                                    System.out.print("Artis: ");
                                    String artis = input.nextLine();

                                    System.out.print("Durasi (menit): ");
                                    double durasi = input.nextDouble();
                                    input.nextLine();

                                    Lagu laguBaru = new Lagu(judul, artis, durasi);
                                    admin.tambahLagu(playlist, laguBaru, jumlahLagu);
                                    jumlahLagu++;
                                } else {
                                    System.out.println("Playlist penuh!");
                                }
                                break;

                            case 2:
                                admin.lihatPlaylist(playlist);
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Pilihan tidak valid!");
                        }

                    } while (menuAdmin != 0);
                    break;

                case 2: // Role sebagai MEMBER
                    member.tampilkanAkses();
                    int menuMember;
                    do {
                        System.out.println("\n=== MENU MEMBER ===");
                        System.out.println("1. Lihat Playlist");
                        System.out.println("2. Cari Lagu");
                        System.out.println("3. Rata-rata Durasi");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih: ");

                        menuMember = input.nextInt();
                        input.nextLine();

                        switch (menuMember) {
                            case 1:
                                member.lihatPlaylist(playlist);
                                break;

                            case 2:
                                System.out.print("Masukkan judul lagu: ");
                                String cari = input.nextLine();
                                member.cariLagu(playlist, cari);
                                break;

                            case 3:
                                member.rataRataDurasi(playlist);
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Pilihan tidak valid!");
                        }

                    } while (menuMember != 0);
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (role != 0);

        input.close();
    }
}