//Parent class
class User {

    protected String nama;

    public User(String nama) {
        this.nama = nama;
    }

    //method yang akan dioverride
    public void tampilkanAkses() {
        System.out.println("User memiliki akses dasar.");
    }

     // Method untuk melihat playlist
    public void lihatPlaylist(Lagu[] playlist) {
        System.out.println("\nDaftar Lagu:");
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                System.out.print((i+1) + ". ");
                playlist[i].tampilkanInfo();
            }
        }
    }
}