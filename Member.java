//Child class dari User
class Member extends User {

    public Member(String nama) {
        super(nama);
    }

    //mencari lagu berdasarkan judul
    public void cariLagu(Lagu[] playlist, String judul) {

        boolean ditemukan = false;

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null &&
                    playlist[i].getJudul().equalsIgnoreCase(judul)) {

                playlist[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Lagu tidak ditemukan.\n");
        }
    }

    //menghitung rata-rata durasi lagu
    public void rataRataDurasi(Lagu[] playlist) {

        double total = 0;
        int jumlah = 0;

        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                total += playlist[i].getDurasi();
                jumlah++;
            }
        }

        if (jumlah > 0) {
            System.out.printf("Rata-rata durasi: %.2f menit\n", (total / jumlah));
        } else {
            System.out.println("Playlist kosong.\n");
        }
    }

    // Polymorphism
    @Override
    public void tampilkanAkses() {
        System.out.println("Member " + nama + " dapat melihat dan mencari lagu.");
    }
}