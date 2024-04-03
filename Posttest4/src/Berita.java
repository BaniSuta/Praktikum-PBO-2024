public class Berita {
    private int kodeBerita;
    private String judul;
    private String penulis;
    private String isi;
    private int tanggal;
    private String bulan;
    private int tahun;

    public Berita(int kodeBerita, String judul, String penulis, String isi, int tanggal, String bulan, int tahun) {
        this.kodeBerita = kodeBerita;
        this.judul = judul;
        this.penulis = penulis;
        this.isi = isi;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public int getKodeBerita() {
        return kodeBerita;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setTanggal(int tanggal, String bulan, int tahun) {
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void display() {
        System.out.println("Judul Berita : " + this.judul);
        System.out.println("Penulis Berita : " + this.penulis);
        System.out.println("Tanggal Berita : " + this.tanggal + " " + this.bulan + " " + this.tahun);
        System.out.println("Isi Berita : " + this.isi);
    }
}
