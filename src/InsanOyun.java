import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class InsanOyun extends Insan{
    private char harf;
    private char cevap;
    private int bilinenHarfSayisi; //bilgisayarin bildigi harflerin sayisini tutuyor.
    private int bilinenHarfIndex; //bilgisayarin bildigi harflerin indexlerinin yerini tutyor.
    boolean sonuc = false;
    char denetle='-';
    boolean mantik=true;

    public Scanner input = new Scanner(System.in);
    public char harfTahmin() {
        //bilgisayar random sekilde harf seciyor.
        Random rand = new Random();
        harf  = (char) ('a' + Math.random() * ('z'-'a' + 1));
        return harf;
    }
    public void InsanTahmin() {
        Scanner input = new Scanner(System.in);
        Insan insan = new Insan();
        ArrayList<String> kelime= new ArrayList<String>(); //insanin belirledigi kelimeyi tutmak icin arraylist tanimlandi.
        int hak=10;
        System.out.println("İNSAN KELİMEYİ BELİRLEYECEK!");
        insan.insanHarfSayi();
        //ilk olarak kelime arraylisti cizgilerden olusuyor.
        for (int i=0; i<insan.getInsanHarfSayisi(); i++) {
            kelime.add("-");
        }
        //cizgilerden olusan kelimeyi ekrana bastiriyorum.
        for (int j=0; j<kelime.size(); j++) {
            System.out.print(kelime.get(j));
        }
        System.out.println();
        int bilinen=0;
        while (sonuc == false) {
            //bilgisayar random olarak harf tahmin ediyor.
            System.out.println("Harf tahmin ediyorum: "+harfTahmin());
            System.out.print("Bildim mi? (e/h): ");
            cevap = input.next().charAt(0);
            if(cevap == 'e'){
                //bilgisayar dogru harf tahmin ettiyse indexleri isteniyor ve bu indexler arraylistte tutuluyor.
                ArrayList<Integer> indexler = new ArrayList<Integer>();
                System.out.print("Kaç harf bildim: ");
                //kac adet harf bilindigi soruluyor.
                bilinenHarfSayisi = input.nextInt();
                //mantiksiz bir sayi girildiyse hata veriyor.
                if(bilinenHarfSayisi>insan.getInsanHarfSayisi() || bilinenHarfSayisi<0) {
                    System.out.println("Geçersiz bir sayı girdiniz.");

                }
                //mantiklli bir sayi girildiginde calisacak if blogu asagidadir.
                if(bilinenHarfSayisi>0 && bilinenHarfSayisi<=insan.getInsanHarfSayisi()){
                    bilinen+=bilinenHarfSayisi;
                    System.out.println();
                    for (int i=0; i<bilinenHarfSayisi; i++) {
                        //bilinen harflerin indexleri aliniyor.
                        System.out.print((i+1)+". harfin sırası: ");
                        bilinenHarfIndex = input.nextInt();
                        if(bilinenHarfIndex>insan.getInsanHarfSayisi() || bilinenHarfIndex<0) {
                            System.out.println("Geçersiz bir sayı girdiniz.");
                            mantik=false;
                        }
                        if(bilinenHarfIndex>0 && bilinenHarfIndex<=insan.getInsanHarfSayisi()){
                            indexler.add(bilinenHarfIndex-1);
                            mantik=true;
                        }

                    }
                    if(mantik==true){
                        //girilen indexler mantikliysa kelimedeki cizgiler doru tahmin edilen harfler ile yerini degistiriyor.
                        for (int j=0; j<bilinenHarfSayisi; j++) {
                            kelime.set(indexler.get(j),String.valueOf(harf));
                        }
                        for (int a=0; a<kelime.size(); a++) {
                            System.out.print(kelime.get(a));
                        }
                        System.out.println();
                        if(!kelime.contains(String.valueOf(denetle))){
                            //kelime hic cizgi icermiyorsa bilgisayar oyunu kazandi demektir.
                            System.out.println("Oyunu kazandım.");
                            break;
                        }
                    }

                }


            }
            if(cevap == 'h') {
                //dogru bilinmeyen her harf icin hak 1 tane azalir, eger hak 0 olursa oyun kaybedilir.
                hak--;
                System.out.println(hak+ " hakkım kaldı.");
                if(hak==0){
                    System.out.println("Oyunu kaybettim.");
                    break;
                }

            }

        }


    }

    public char getCevap() {
        return cevap;
    }

    public void setCevap(char cevap) {
        this.cevap = cevap;
    }

    public int getBilinenHarfSayisi() {
        return bilinenHarfSayisi;
    }

    public void setBilinenHarfSayisi(int bilinenHarfSayisi) {
        this.bilinenHarfSayisi = bilinenHarfSayisi;
    }

    public int getBilinenHarfIndex() {
        return bilinenHarfIndex;
    }

    public void setBilinenHarfIndex(int bilinenHarfIndex) {
        this.bilinenHarfIndex = bilinenHarfIndex;
    }

    public char getHarf() {
        return harf;
    }

    public void setHarf(char harf) {
        this.harf = harf;
    }
}
