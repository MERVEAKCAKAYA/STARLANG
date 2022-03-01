import java.util.Scanner;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //asagida gerekli siniflardan nesneler üretildi.
        BilgisayarOyun bilgisayarOyun = new BilgisayarOyun();
        InsanOyun insanOyun = new InsanOyun();
        System.out.println("********************************ADAM ASMACA OYUNU BAŞLIYOR********************************");
        System.out.println();

        while (true){
            System.out.print("İlk olarak kelimeyi bilgisayarın tahmin etmesi için <b>, insanın tahmin etmesi için <i> , çıkmak için <ç> basınız: ");
            System.out.println();
            char secim = input.next().charAt(0);
            secim=Character.toLowerCase(secim);
            if(secim == 'b'){
                bilgisayarOyun.BilgisayarTahmin();
                System.out.println();
                System.out.println("*************************************************************************");
                System.out.println();
            }
            if(secim == 'i'){
                insanOyun.InsanTahmin();
                System.out.println();
                System.out.println("*************************************************************************");
                System.out.println();
            }
            if(secim == 'ç'){
                System.out.println();
                System.out.println("Oyun kapatılıyor.");
                break;
            }
            else {
                System.out.println();
                System.out.println("Geçerli bir değer giriniz.");
            }

        }




    }
}
