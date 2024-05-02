public abstract class Berita implements NewsArticle {
    private final int kodeBerita;
    protected String judul;
    protected String penulis;
    protected String isi;
    protected int tanggal;
    protected String bulan;
    protected int tahun;

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

    @Override
    public void setIsi(String isi) {
        this.isi = isi;
    }

    @Override
    public abstract void display();
}
