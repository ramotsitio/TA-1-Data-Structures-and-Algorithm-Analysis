//child class dari User
class Admin extends User {

    public Admin(String nama) {
        super(nama);
    }

    // method untuk menambahkan lagu ke playlist
    public void tambahLagu(Lagu[] playlist, Lagu laguBaru, int index) {

        if (index < playlist.length) {
            playlist[index] = laguBaru;
            System.out.println("Lagu berhasil ditambahkan.");
        } else {
            System.out.println("Playlist penuh.\n");
        }
    }

    //polymorphism
    @Override
    public void tampilkanAkses() {
        System.out.println("\nAdmin " + nama + " dapat menambahkan lagu.");
    }
}