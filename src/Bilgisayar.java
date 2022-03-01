import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Bilgisayar {

    private int bilgisayarHarfSayisi; //insanin belirledigi harf sayisini tutar.
    private String bilgisayarKelime; //bilgisayarin sectigi kelimeyi tutar.
    private ArrayList<String> kelimeListesi= new ArrayList<String>(); //belirlenen sayi dahilinde olan kelimeleri tutar.
    private ArrayList<Integer> uzunlukListesi= new ArrayList<Integer>(); //kelimeler.txt icerisinde yer alan kelimelerin uzunluklarini tutar.
    public Scanner input = new Scanner(System.in);
    KelimeOku kelimeOku = new KelimeOku();

    public int bilgisayarHarfSayi() {
        //burada kelimelerin uzunlukları uzunlukListesi arraylistine atilir.
        for (int j=0; j<kelimeOku.Oku().size(); j++) {
            uzunlukListesi.add(kelimeOku.Oku().get(j).length());
        }
        while (true){
            //insandan harf sayisi girmesi istenir.
            System.out.print("Harf sayısını giriniz: ");
            bilgisayarHarfSayisi = input.nextInt();
            //burada girilen sayi dahilinde kelime olup olmadiginin kontrolü yapilir.
            if(uzunlukListesi.contains(bilgisayarHarfSayisi)){
                //System.out.println("girdiğiniz değerde kelimeler mevcut!");
                break;
            }

        }
        return bilgisayarHarfSayisi;

    }

    public ArrayList<String> kelimeListesi() {
        //System.out.println(" ");
        //burada kelimeler.txt deki belirlenen degerde harf sayisina esit olan kelimeler kelimeListesine eklenir.
        for (int i=0; i<kelimeOku.Oku().size(); i++) {
            if(bilgisayarHarfSayisi == kelimeOku.Oku().get(i).length()) {
                kelimeListesi.add(kelimeOku.Oku().get(i));
                //System.out.println(kelimeOku.Oku().get(i));
            }
        }
        return kelimeListesi;
    }

    public String bilgisayarRandomKelime() {
        //burada bilgisayar random sekilde kelime secer.
        //System.out.println(" ");
        Random rand = new Random();
        bilgisayarKelime = kelimeListesi.get(rand.nextInt(kelimeListesi.size()));
        //System.out.println("Belirlenen harf sayısınca olan kelime sayısı: "+kelimeListesi.size());
        //System.out.println("Seçilen kelime: "+bilgisayarKelime);
        return bilgisayarKelime;
    }

    public int getBilgisayarHarfSayisi() {
        return bilgisayarHarfSayisi;
    }

    public void setBilgisayarHarfSayisi(int bilgisayarHarfSayisi) {
        this.bilgisayarHarfSayisi = bilgisayarHarfSayisi;
    }
    public String getBilgisayarKelime() {
        return bilgisayarKelime;
    }

    public void setBilgisayarKelime(String bilgisayarKelime) {
        this.bilgisayarKelime = bilgisayarKelime;
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
