/*
Bünyamin Göymen
02180201041

Kullanılan programlar:
-Netbeans 8.2
-java 8
 */
package randomnumbergenerator;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
         
        /* 
        Not: Normalde Orta kare yöntemi ve Doğrusal eşlik yönetmi ile 100'er tane rastgele sayı üretilmesi gerekiyordu. 
        Ancak Ben iki seçenek daha koydum. İsterseniz istediğiniz yöntem ile istediğiniz kadar rastgele sayı üretebilirsiniz,
        isterseniz de direk her iki yöntemdende 100'er tane üreterek ekrana yazdırabilirsiniz.
         */

        String secim = ""; // Kullanıcının hangi seçeneği seçtiğini bu değişkende tutacağız
        Scanner s = new Scanner(System.in); // Ekran girdisi almak için bu değişkeni kullanacağız

       
        RandomGenerator rg = new RandomGenerator(); // Benim oluşturudğum class için bir değişken oluşturuyorum. Orta kare yöntemi ya da Doğrusal eşlik yöntemi mototları bu sınıfta yer alıyor.

        //Kullanıcı istediği kadar veri çalıştırabilmesi için bir while döngüsü kuruyoruz. 
        //Kullanıcı q harfine basmadığı sürece program devam edecektir.
        while (!"q".equals(secim)) {
            //Kullanıcıya istediği seçenekleri sunuyoruz. Normalde ödevde sadece 3.seçenek vardı. Ben diğer iki seçeneği de ekledim.
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("1- İstediğiniz Kadar Orta Kare Yöntemi ile Ratgele Sayı üretmek");
            System.out.println("2- İstediğiniz Kadar Doğrusal Eşilk Yöntemi ile Ratgele Sayı üretmek");
            System.out.println("3- 100 tane Orta Kare Yöntemi ile , 100 tane Doğrusal Eşlik Yöntemi ile Rastgele sayı üretme ");
            System.out.println("q-Çıkış");
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("Lütfen seçiminizi yapınız:");
            secim = s.next(); //Kullanıcının girdisini alıyoruz.

            //Switch case ile kullanıcının hangi seçeneği seçtiğini bulup ona göre işlem yapıyoruz.
            switch (secim) {
                case "1":
                    // İlk olarak kullanıcı 1.seçeneği seçtiyse kaç tane rastgele sayı üretilmek istendiğini soruyoruz. 
                    System.out.println("Lüten ne kadar sayı üretmek isteidğinizi giriniz:");
                    int n = s.nextInt(); // Kullanıcının kaç tane rastgele sayı isteiğini bu değişkene atıyoruz.
                    System.out.println(n + " tane sayı üretiliyor..."); 
                    int[] result = rg.ortaKare(n); //kullanıcının girdiği n değeri ile orta kare ile rastgele sayı üreten metoda yolluyorum. O metot da oluşturulan bütün rastgele sayıları dizi olarak dönüyor.
                    rg.print(result, n, "Orta Kare Yöntemi"); // Aynı sınıfın içinde, dizinin içeriğini yazdıracak bir metot da mevcut. O metoda yukarıda dönen diziyi yolluyorum. Böylelikle oluşturulan rastgele sayılar ekrana basılmış oluyor.
                    break;
                case "2":
                    //Eğer kullanıcı 2.seçeneği seçmiş ise Doğrusal Eşli yöntemi ile rastgele sayı üretme işlemine başlıyoruz.
                    //İlk olarak kullanıcı kaç tane rastgele sayı üretmek istediğini soruyoruz.
                    System.out.println("Lüten ne kadar sayı üretmek isteidğinizi giriniz:");
                    int n2 = s.nextInt();//Kullanıcının girdiği değeri bu değişkene atıyoruz.
                    System.out.println(n2 + " tane sayı üretiliyor...");
                    double[] result2 = rg.dogrusalEslik(n2); // daha sonra doğrusal eşlik ile rastgele sayı üreten metoda bu n2 değerini yolluyoruz. Bu metot bize double şeklidne dizi dönederiyor.  
                    //Bu kısımda ekrana yazdırma işlemi yapılmıyor. Bir üst satırdaki çağrılan metot da yazdırma işlemi yapılıyor. Bunun sebebi de Z değerleriyle birlikte rastgele sayıları yazdırmak. Yani normalde bize bir dizi dönüyor ancak onu kllanmıyoruz. Ancak o dizi ile istediğimiz şey yapılaibilir.
                    break;
                case "3":
                    //Kullanıcı 3 nolu seçeneği seçerse de ilk olarak 100 tane orta kare yöntemi ile 100 tane de Doğrusal eşlik yöntemi ile rastgele sayı üretiliyor.
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    System.out.println("100 tane Orta Kare yöntemi ile sayı üretiliyor..."); 
                    int[] result3 = rg.ortaKare(100); // İlk olarak orta kare yöntemine 100 sayısı yollanıyor. Ve rastgele değerler bir dizi içerisinde dönüyor
                    rg.print(result3, 100, "Orta Kare Yöntemi"); // Gelen diziyi ekrana yazdırma metoduna yolluyoruz.
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    System.out.println("100 tane Doğrusal Eşlik yöntemi ile sayı üretiliyor...");
                    double[] result4 = rg.dogrusalEslik(100); // Orta kare yöntemi ile yapılan işlem bittikten sonra Doğrusal eşlik yöntemi ile 100 tane rastgele sayı oluşturma metoduna yolluyoruz.
                    // doğrusal eşlik motdu bir dizi dönüyor ancak onun hem z değeri hem de rastgele sayı değeri olduğu için aynı metot da yazdırma işlemi yapılıyor. Bu dönen dizi ile herhangi bir şey yapılmıyor. Ancak istenilen şey yapılabilir.
                    System.out.println("---------------------------------------------------------------------------------------------------");

                    break;
                case "q":
                    System.out.println("Çıkış yapılıyor..."); // Kullanıcı 1 değerini seçtiyse bu uyarıyı ekrana basıyoruz. Başka hiçbir şey yapmıyoruz.
                    break;
                default:
                    //Kullanıcı bu değerler dışında bir şey girerse ekrana hatayı basıyoruz. Ve döngü devam ettiği için kullanıcıya hangi seçeneği isteidğini tekrardan soruyruz.
                    System.out.println("Hatalı seçim Lütfen doğru bir seçim giriniz.");
                    break;
            }//switch case son
        } //while son

    }//main son

}//class son
