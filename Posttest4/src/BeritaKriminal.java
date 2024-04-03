public class BeritaKriminal extends Berita {
    private String lokasi;
    private String nmPelaku;
    private String nmKorban;

    public BeritaKriminal(int kodeBerita, String judul, String penulis, String isi, int tanggal, String bulan,
            int tahun, String lokasi, String nmPelaku, String nmKorban) {
        super(kodeBerita, judul, penulis, isi, tanggal, bulan, tahun);
        this.lokasi = lokasi;
        this.nmPelaku = nmPelaku;
        this.nmKorban = nmKorban;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setNmPelaku(String nmPelaku) {
        this.nmPelaku = nmPelaku;
    }

    public void setNmKorban(String nmKorban) {
        this.nmKorban = nmKorban;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Lokasi Kejadian : " + this.lokasi);
        System.out.println("Nama Pelaku : " + this.nmPelaku);
        System.out.println("Nama Korban : " + this.nmKorban);
    }
}
