public class BeritaSport extends Berita {
    private String namaTeam1;
    private String namaTeam2;
    private int skorTeam1;
    private int skorTeam2;

    public BeritaSport(int kodeBerita, String judul, String penulis, String isi, int tanggal, String bulan, int tahun,
            String namaTeam1, String namaTeam2, int skorTeam1, int skorTeam2) {
        super(kodeBerita, judul, penulis, isi, tanggal, bulan, tahun);
        this.namaTeam1 = namaTeam1;
        this.namaTeam2 = namaTeam2;
        this.skorTeam1 = skorTeam1;
        this.skorTeam2 = skorTeam2;
    }

    public void setNamaTeam1(String namaTeam1) {
        this.namaTeam1 = namaTeam1;
    }

    public void setNamaTeam2(String namaTeam2) {
        this.namaTeam2 = namaTeam2;
    }

    public void setSkorTeam1(int skorTeam1) {
        this.skorTeam1 = skorTeam1;
    }

    public void setSkorTeam2(int skorTeam2) {
        this.skorTeam2 = skorTeam2;
    }

    public void displaySport() {
        super.display();
        System.out.println("Skor " + this.namaTeam1 + " : " + this.skorTeam1);
        System.out.println("Skor " + this.namaTeam2 + " : " + this.skorTeam2);
    }
}
