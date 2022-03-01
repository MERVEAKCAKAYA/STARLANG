import java.util.ArrayList;
import java.util.Random;
public class Insan {

    private int insanHarfSayisi; //bilgisayarin random belirledigi harf sayisini tutuyor.
    private String insanKelime; //insanin kafasindan tuttugu kelimeyi tutuyor.
    private ArrayList<String> kelimeListesi= new ArrayList<String>(); //belirlenen sayi dahilinde olan kelimeleri tutar.
    private ArrayList<Integer> uzunlukListesi= new ArrayList<Integer>();  //kelimeler.txt icerisinde yer alan kelimelerin uzunluklarini tutar.
    KelimeOku kelimeOku = new KelimeOku();
    Random random = new Random();
    public int insanHarfSayi() {
        for (int j=0; j<kelimeOku.Oku().size(); j++) {
            //burada kelimeler txtdeki kelimelerin uzunlukları alinip listeye atilir.
            uzunlukListesi.add(kelimeOku.Oku().get(j).length());
        }
        insanHarfSayisi = random.nextInt(12) + 1; // burada hangi araliklarda harf sayisi secilecegi belirleniyor. Oyun kisa sursun diye 1 ile 12 arasinda secim yaptiriyorum.
        System.out.print("Harf sayısını belirliyorum: "+insanHarfSayisi);
        System.out.println();
        return  insanHarfSayisi;
    }
    public int getInsanHarfSayisi() {
        return insanHarfSayisi;
    }

    public void setInsanHarfSayisi(int insanHarfSayisi) {
        this.insanHarfSayisi = insanHarfSayisi;
    }

    public String getInsanKelime() {
        return insanKelime;
    }

    public void setInsanKelime(String insanKelime) {
        this.insanKelime = insanKelime;
    }

    public ArrayList<String> getKelimeListesi() {
        return kelimeListesi;
    }

    public void setKelimeListesi(ArrayList<String> kelimeListesi) {
        this.kelimeListesi = kelimeListesi;
    }

    public ArrayList<Integer> getUzunlukListesi() {
        return uzunlukListesi;
    }

    public void setUzunlukListesi(ArrayList<Integer> uzunlukListesi) {
        this.uzunlukListesi = uzunlukListesi;
    }

}
