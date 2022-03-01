import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
public class BilgisayarOyun extends Bilgisayar{
    public void BilgisayarTahmin() {
        Scanner input = new Scanner(System.in);
        KelimeOku kelimeOku = new KelimeOku();
        Bilgisayar bilgisayar = new Bilgisayar();
        ArrayList<String> kelime= new ArrayList<String>(); //bilgisayarin belirledigi kelimeyi tutmasi icin arraylist olusturdum.
        boolean sonuc=false;
        int hak=10;
        System.out.println("BİLGİSAYAR KELİMEYİ BELİRLEYECEK!");
        bilgisayar.bilgisayarHarfSayi();
        bilgisayar.kelimeListesi();
        bilgisayar.bilgisayarRandomKelime();
        //System.out.println("Seçilen kelime: "+bilgisayar.getBilgisayarKelime());

        for (int i=0; i<bilgisayar.getBilgisayarHarfSayisi(); i++) {
            kelime.add("-"); //burada kelimeyi ilk olarak ekranda cizgiler halinde gostermek icin bu kodu yazdim.
        }
        for (int j=0; j<kelime.size(); j++) {
            System.out.print(kelime.get(j)); // yazdigim cizgili kelime arraylisti ekrana bastiriyorum.
        }
        System.out.println();
        ArrayList<String> kelimeTut= new ArrayList<String>(); //ileride karsilastirma yapmak icin secilen kelimeyi bu arraylistte tutuyorum.
        for (int i=0; i<bilgisayar.getBilgisayarHarfSayisi(); i++) {
            kelimeTut.add(String.valueOf(bilgisayar.getBilgisayarKelime().charAt(i)));
        }
        //System.out.println(kelimeTut);

        while (sonuc==false) {
            System.out.print("Harf tahmin edin: ");
            char harf = input.next().charAt(0);
            harf = Character.toLowerCase(harf); //girilen her harfi kucuk harfe donusturuyorum.
            if(!bilgisayar.getBilgisayarKelime().contains(String.valueOf(harf))) {
                //girilen harf kelime icerisinde yer almiyorsa calisacak kodu yaziyorum.
                hak--;
                System.out.println("Bilemediniz. "+hak+" hakkınız kaldı!");
                if(hak==0){
                    System.out.println("Oyunu kaybettiniz!");
                    System.out.println("Seçilen kelime: "+bilgisayar.getBilgisayarKelime());
                    break;
                }
            }
            else{
                for(int i=0; i<bilgisayar.getBilgisayarKelime().length(); i++) {
                    if(harf == bilgisayar.getBilgisayarKelime().charAt(i)){
                        //girilen harf secilen kelime icerisinde yer aliyorsa calisacak kodu burada yaziyorum.
                        //System.out.println(i+". indexte bulundu!!!!!!");
                        System.out.println("Bildiniz!");
                        //cizgilerden olusan kelime arraylistimde indexlere gore degisiklik yapiyorum, bilinen harfleri set ediyorum.
                        kelime.set(i,String.valueOf(harf));
                        for (int j=0; j<kelime.size(); j++) {
                            System.out.print(kelime.get(j));
                        }
                        if(kelime.equals(kelimeTut)){
                            //eger kelime arraylisti tuttugum kelimeTut arraylistine esitlenmisse oyunu kazandin yazdiriyorum.
                            System.out.println();
                            System.out.println("Oyunu kazandınız.");
                            sonuc=true;
                        }
                        System.out.println();
                    }
                }
            }

        }

    }
}
