import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int pilih;
    static ArrayList<Berita> listBerita = new ArrayList();
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(isr);
    static String[] arrBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "September", "Oktober",
            "November", "Desember" };
    static boolean ulang = true;

    public static void main(String[] args) throws IOException {
        ulang = true;
        while (ulang == true) {
            System.out.println("Selamat Datang di PosKaltim");
            System.out.println("================================================================");
            System.out.println("1. Lihat Berita");
            System.out.println("2. Tambah Berita");
            System.out.println("3. Edit Berita");
            System.out.println("4. Hapus Berita");
            System.out.println("0. Exit Program");
            System.out.print(">>> ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    display();
                    break;
                case 2:
                    menuKategoriBerita();
                    break;
                case 3:
                    menuEdit();
                    break;
                case 4:
                    deleteBerita();
                    break;
                case 0:
                    System.out.println("Terima Kasih :)");
                    ulang = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void menuEdit() throws NumberFormatException, IOException {
        boolean ulang1 = true;
        while (ulang1 == true) {
            System.out.println("Menu Edit");
            System.out.println("================================================");
            System.out.println("1. Edit Judul");
            System.out.println("2. Edit Penulis");
            System.out.println("3. Edit Isi");
            System.out.println("4. Edit Tanggal");
            System.out.println("0. Exit Menu");
            System.out.print(">>> ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    editJudul();
                    break;
                case 2:
                    editPenulis();
                    break;
                case 3:
                    editIsi();
                    break;
                case 4:
                    menuEditTanggal();
                    break;
                case 0:
                    ulang1 = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void menuKategoriBerita() throws NumberFormatException, IOException {
        boolean ulang1 = true;
        while (ulang1 == true) {
            System.out.println("Pilih Kategori Berita Yang Ingin Ditambah");
            System.out.println("================================================");
            System.out.println("1. Kategori Sport");
            System.out.println("2. Kategori Kriminal");
            System.out.println("0. Exit Menu");
            System.out.print(">>> ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    addBeritaSport();
                    break;
                case 2:
                    addBeritaKriminal();
                    break;
                case 0:
                    ulang1 = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void menuEditTanggal() throws NumberFormatException, IOException {
        boolean ulang2 = true;
        while (ulang2 == true) {
            System.out.println("Menu Edit Tanggal");
            System.out.println("================================");
            System.out.println("1. Edit Tanggal");
            System.out.println("2. Edit Bulan");
            System.out.println("3. Edit Tahun");
            System.out.println("4. Edit Keseluruhan Tanggal");
            System.out.println("0. Exit Menu");
            System.out.print(">>> ");
            pilih = Integer.parseInt(input.readLine());

            switch (pilih) {
                case 1:
                    editTanggal();
                    break;
                case 2:
                    editBulan();
                    break;
                case 3:
                    editTahun();
                    break;
                case 4:
                    editDate();
                    break;
                case 0:
                    ulang2 = false;
                    break;

                default:
                    error();
                    break;
            }
        }
    }

    static void display() {
        System.out.println("List Berita");
        System.out.println("================================================");
        if (listBerita.size() != 0) {
            int i = 1;
            for (Berita brt : listBerita) {
                System.out.println("[" + i + "]");
                if (brt instanceof BeritaSport) {
                    ((BeritaSport) brt).display();
                } else if (brt instanceof BeritaKriminal) {
                    ((BeritaKriminal) brt).display();
                }
                System.out.println("================================================");
                i++;
            }
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }
    }

    static void addBeritaSport() throws NumberFormatException, IOException {
        String penulis, judul, isi, bulan, team1, team2;
        int kodeBerita, tanggal, tahun, skor1, skor2;
        System.out.println("Add Berita");
        while (true) {
            System.out.print("Masukkan Kode Berita : ");
            kodeBerita = Integer.parseInt(input.readLine());
            if (listBerita.size() != 0) {
                if (cekKodeBerita(kodeBerita) == true) {
                    System.out.println("Kode Berita Sudah Ada!");
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.print("Masukkan Nama Penulis : ");
        penulis = input.readLine();
        System.out.print("Masukkan Judul Berita : ");
        judul = input.readLine();
        System.out.print("Masukkan Tanggal : ");
        tanggal = Integer.parseInt(input.readLine());
        while (true) {
            System.out.print("Masukkan Bulan : ");
            bulan = input.readLine();
            if (cekBulan(bulan) == true) {
                break;
            } else {
                error();
            }
        }
        System.out.print("Masukkan Tahun : ");
        tahun = Integer.parseInt(input.readLine());
        System.out.print("Masukkan Isi Berita : ");
        isi = input.readLine();
        System.out.print("Masukkan Team 1 : ");
        team1 = input.readLine();
        System.out.print("Masukkan Skor Team " + team1 + " : ");
        skor1 = Integer.parseInt(input.readLine());
        System.out.print("Masukkan Team 2 : ");
        team2 = input.readLine();
        System.out.print("Masukkan Skor Team " + team2 + " : ");
        skor2 = Integer.parseInt(input.readLine());

        BeritaSport beritaSport = new BeritaSport(kodeBerita, judul, penulis, isi, tanggal, bulan, tahun, team1, team2,
                skor1, skor2);
        listBerita.add(beritaSport);
    }

    static void addBeritaKriminal() throws NumberFormatException, IOException {
        String penulis, judul, isi, bulan, nmPelaku, nmKorban, lokasi;
        int kodeBerita, tanggal, tahun;
        System.out.println("Add Berita");
        while (true) {
            System.out.print("Masukkan Kode Berita : ");
            kodeBerita = Integer.parseInt(input.readLine());
            if (listBerita.size() != 0) {
                if (cekKodeBerita(kodeBerita) == true) {
                    System.out.println("Kode Berita Sudah Ada!");
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.print("Masukkan Nama Penulis : ");
        penulis = input.readLine();
        System.out.print("Masukkan Judul Berita : ");
        judul = input.readLine();
        System.out.print("Masukkan Tanggal : ");
        tanggal = Integer.parseInt(input.readLine());
        while (true) {
            System.out.print("Masukkan Bulan : ");
            bulan = input.readLine();
            if (cekBulan(bulan) == true) {
                break;
            } else {
                error();
            }
        }
        System.out.print("Masukkan Tahun : ");
        tahun = Integer.parseInt(input.readLine());
        System.out.print("Masukkan Isi Berita : ");
        isi = input.readLine();
        System.out.print("Masukkan Lokasi Kejadian : ");
        lokasi = input.readLine();
        System.out.print("Masukkan Nama Pelaku : ");
        nmPelaku = input.readLine();
        System.out.print("Masukkan Nama Korban : ");
        nmKorban = input.readLine();

        BeritaKriminal beritaKriminal = new BeritaKriminal(kodeBerita, judul, penulis, isi, tanggal, bulan, tahun,
                lokasi, nmPelaku, nmKorban);
        listBerita.add(beritaKriminal);
    }

    static void editJudul() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            String judulBaru;
            System.out.println("Edit Judul Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Judul Berita Yang Baru : ");
                    judulBaru = input.readLine();

                    berita.setJudul(judulBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editPenulis() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            String penulisBaru;
            System.out.println("Edit Penulis Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Penulis Berita Yang Baru : ");
                    penulisBaru = input.readLine();

                    berita.setPenulis(penulisBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editIsi() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            String isiBaru;
            System.out.println("Edit Isi Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Isi Berita Yang Baru : ");
                    isiBaru = input.readLine();

                    berita.setIsi(isiBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editTanggal() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            int tanggalBaru;
            System.out.println("Edit Tanggal Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Tanggal Berita Yang Baru : ");
                    tanggalBaru = Integer.parseInt(input.readLine());

                    berita.setTanggal(tanggalBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editBulan() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            String bulanBaru;
            System.out.println("Edit Bulan Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Bulan Berita Yang Baru : ");
                    while (true) {
                        bulanBaru = input.readLine();

                        for (int j = 0; j < arrBulan.length; j++) {
                            if (cekBulan(bulanBaru) == true) {
                                berita.setBulan(bulanBaru);
                                System.out.println("Data Berhasil Diedit");
                                return;
                            } else {
                                error();
                            }
                        }
                    }
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editTahun() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            int tahunBaru;
            System.out.println("Edit Tahun Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    System.out.println("Masukkan Tahun Berita Yang Baru : ");
                    tahunBaru = Integer.parseInt(input.readLine());

                    berita.setTahun(tahunBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
            error();
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }

    }

    static void editDate() throws NumberFormatException, IOException {
        if (listBerita.size() != 0) {
            int kodePilih;
            boolean check = true;

            System.out.println("Edit Kesuluruhan Tanggal Berita");
            System.out.println("================================================");
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Diedit : ");
            kodePilih = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodePilih) {
                    int tanggalBaru, tahunBaru;
                    String bulanBaru = "";
                    System.out.println("Masukkan Tanggal Berita Yang Baru : ");
                    tanggalBaru = Integer.parseInt(input.readLine());

                    System.out.println("Masukkan Bulan Berita Yang Baru : ");
                    while (check == true) {
                        bulanBaru = input.readLine();

                        for (int j = 0; j < arrBulan.length; j++) {
                            if (cekBulan(bulanBaru) == false) {
                                error();
                            } else {
                                check = false;
                            }
                        }
                    }

                    System.out.println("Masukkan Tahun Berita Yang Baru : ");
                    tahunBaru = Integer.parseInt(input.readLine());

                    berita.setTanggal(tanggalBaru, bulanBaru, tahunBaru);
                    System.out.println("Data Berhasil Diedit");
                    return;
                }
            }
        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }
    }

    static void deleteBerita() throws NumberFormatException, IOException {
        int kodeHapus;
        System.out.println("List Berita");
        System.out.println("================================================");
        if (listBerita.size() != 0) {
            for (int i = 0; i < listBerita.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Kode Berita : " + listBerita.get(i).getKodeBerita());
                listBerita.get(i).display();
                System.out.println("================================================");
            }

            System.out.print("Masukkan Kode Berita Yang Ingin Dihapus : ");
            kodeHapus = Integer.parseInt(input.readLine());

            for (int i = 0; i < listBerita.size(); i++) {
                Berita berita = listBerita.get(i);
                if (berita.getKodeBerita() == kodeHapus) {
                    listBerita.remove(i);
                    System.out.println("Data Berhasil Dihapus!");
                    return;
                }
            }

            error();

        } else {
            System.out.println("Belum Ada Berita Yang Diinputkan!");
            System.out.println("================================================");
        }
    }

    static void error() {
        System.out.println("Invalid Input Brader!");
    }

    static boolean cekBulan(String bulan) {
        boolean result = false;
        for (int i = 0; i < arrBulan.length; i++) {
            if (bulan.equals(arrBulan[i])) {
                result = true;
                break;
            }
        }
        return result;
    }

    static boolean cekKodeBerita(int kode) {
        boolean result = false;
        for (int i = 0; i < listBerita.size(); i++) {
            if (listBerita.get(i).getKodeBerita() == kode) {
                result = true;
                break;
            }
        }
        return result;
    }
}
