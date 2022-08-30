package randomnumbergenerator;

import java.util.Random;

public class RandomGenerator {

    //Bu metot orta kare yöntemi ile istenilen kadar rastgele sayı üreten metotdur. 
    public int[] ortaKare(int n) {
        //n değeri kullanıcının kaç tane rastgele sayı üretmek istediğini belirtmektedir.
        int[] result = new int[n]; // n tane rastgele sayı üreteceğimiz için o boyutta bir dizi oluşturuyoruz. Daah sonra rastgele sayıları bu diziye aktarıp döndüreceğiz.

        //Normalde rastgele sayıyı biz üretiyoruz. Ancak ilk değeri kodlama dilinde bulunan kütüphane ekliyor (4 basamaklı buluyor.)
        Random random = new Random();// ilk değeri rastgele yaptığımız için random adındaki değişkenimizi oluşturuyoruz.
        int randomNumber = 1000 + random.nextInt(9001); // Başlangıç için 4 basamaklı rastgele bir sayı üretiyoruz.
        int basamakSayisi = String.valueOf(randomNumber).length(); // ilk değerimizin kaç basamaklı olduğunu belirtiyoruz. Bu kod randomNumber'ın kaç basamaklı olduğunu bize gösteriyor. İlk olarka stirng değere ödöndürüp boyutuna baktığımız anda kaç haneli olduğu görülüyor. Böyle yapma sebebimiz ise daha sonradan randomNumber'in isteğe bağlı oalrak değiştirlebilir olduğundandır.
        /*
        Not:
         -Normalde random yerine istenilen sayı girilebilir. Ancak daha rastgele olması için ilk sayıyı da java daki random kütüphanesi oluşturuyor.
         -Eğer ilk sayı sabit bir değer atanacaksa basamakSayisi değerine de o atanan sayının kaç basamaklı olduğu yazılmalıdır. (Ancak otomatik şekilde kendisi kaç basamaklı olduğunu hesaplıyor.)
         -Eğer randomNumber 2500 seçilirse ondna sonra üretilecek bütün sayılar da 2500 olacaktır.
         -Ratgele sayının binler basamağı 0 olabiliyor. Böyle bir durumda rastgele sayımız 3 basamaklı hale gelebiliyor (Örneğin 0280 değeri rastgele sayı olarak çıkabiliyor. O zaman ürettiğimiz rastgele sayı 280 oluyor.)
         */

        //İlk olarak başlangıçta üretilen rastgele değeri ekrana yazıyoruz:
        System.out.println("Başlangıç olarak rastgele sayı: " + randomNumber);

        // Daha sonra kullanıcının istediği kadar rastgele değer üretebilmek için for döngüsü oluşturuyoruz. Ve n kadar dönmesini sağlıyoruz.
        for (int i = 0; i < n; i++) {

            randomNumber = randomNumber * randomNumber; // ilk olarak seçilen random sayıyı kendisi ile çarpıyoruz (Yani karesini alıyoruz.)
            String stringNumber = String.valueOf(randomNumber); // Sayıyı parçalamak için string değere döndürüyoruz. (Ortadaki dört haneli değeri almamız gerekiyor. Bunu yaparken string'e dönüştürüp substring metodunu uygulayacağız. Bunu uyguladıktan sonra tekrar integer değere döndüreceğiz.)

            /*
            Sayımız dört basamaklı olana kadar bir sağdan bir soldan olmak üzere sayımızı kırpıyoruz.
            Bunun için ilk olarak while döngüsü oluşturuyoruz. Bu döngü stringNumber'ın boyutu basamak sayısına eşit olana kadar dönüyor.
            Tabii bir sağdan bir soldan sayımızı kırparken en son hangi tarafı kırptığımızı da tutmamız gerekiyor. Bunu da uygulayan adlı değişkende tutuyoruz.
            uygulayan adlı değişken sıfır ise sağdan kırpacağız. Bir ise de soldan kırpacağız. Başlangıç olarak da sağdan kırpmaya başlayacağız(Bu sebeple de uygulama değerinin başlangıç hali sıfırdır.)
            Her kırpma işleminde uygulama değeirnin içeriğini de değiştiriyoruz. Sıfırsa bir, birse sıfır yapıyoruz. Böylelikle Sırasıyla sağı ve solu kırpmış oluyoruz.
            Bu işlemi, sayımızın basamak sayısı yukarıda tanımlanan basamakSayisi'na işet olana kadar devam ediyor.
            Böylelikle ortadaki değeri alabiliyoruz.
            
            Böyle bir sistem yapmamızın sebebi:
            Rastgele sayının karesi, 5 ile 8 basamak arasında bir yerde oluyor. 
            Normalde eğer basamak çift haneli olsaydı her iki taraftanda basamak farkının yarısı kırpılarak sonuça ulaşılabilirdi. Ancak bazı durumlarda böyle olmayabiliyor.
            Bu sebeple eğer basamak sayısı çift ise iki taraftan da eşit şekilde kırpılmış oluyor.
            Ancak basamak sayısı tek ise sağ taraftan bir tık fazla krpılıyor (Dersteki örneklerde öyleydi). 
            
             */
            int uygulanan = 0; //ilk olarak hangi tarafı uyguladığımızı tutmak için uygulanan adında bir değişken oluşturuyoruz. 
            while (!(stringNumber.length() <= basamakSayisi)) { // rastgele sayının basamak sayısı yukarıda belirlenen basamakSayisi'na eşit olana kadar bir while döngüsü başlatıyoruz.
                if (uygulanan == 0) { // döngü ilk defa başlıyorsa ya da bir önceki turda sol taraf kırpıldıysa bu if'e girer
                    //Bu if sağ tarafın kırpılmasını sağlar
                    uygulanan = 1; // ilk olarak bir sonraki turda sol tarafın kırpılması için uygulanan değişkenini 1 olarak güncelliyoruz.

                        stringNumber = stringNumber.substring(0, stringNumber.length() - 1); // var olan sayımıza substirng yaparak en son değer hariç diğer değerlerii alıyoruz (Örneğin: "123456" değerine bu komut uygulanırsa "12345" değerine düşecektir.)
                } else { //bir önceki turda sağ taraf kırpıldıysa bu else'e girer
                    //Bu else sol tarafın kırpılmasını sağlar
                    uygulanan = 0; // ilk olarak bir sonraki turda sağ tarafın kırpılması için uygulanan değişkenini 0 olarak güncelliyoruz.

                        stringNumber = stringNumber.substring(1, stringNumber.length()); // var olan sayımıza substirng yaparak ilk değer hariç diğer değerlerii alıyoruz (Örneğin: "123456" değerine bu komut uygulanırsa "23456" değerine düşecektir.)
                }//else son
            } //while döngüsü son

            randomNumber = Integer.parseInt(stringNumber); // Daha sonra oluşan değerimizi randomNumber değişkenine atıyoruz. (for döngüsünün bir sonraki turunda da aynı işlem tekrarlanabilsin diye oluşturulan rastgele sayımız en baştaki değere atanıyor.)
            result[i] = randomNumber; // oluşturulan rasstgele sayı diziye kaydediliyor.
        } // for döngüsü son
        return result; // en sonda dizimizi yollyuruz.
    } // metot son

    public double[] dogrusalEslik(int n) {
        double[] result = new double[n]; // oluşturulan rastgele değerleri tutmak için bir dizi oluşturuyoruz. 
        int[] ZArray = new int[n]; // Oluşturulan bütün z değerlerini tutmak için bir dizi oluşturuyoruz. 

        //Başlangıçta varsayılan olarak verilen değerleri random olarak biz oluşturuyoruz.
        // Normalde rastgele sayıları biz buluyoruz. Ancak başlangıç değeri olanları java kütüphanesi ile rastgele bulyuroz (m,a,c ve z0 rastgele belirleniyor.)
        Random random = new Random();
        int a = 1 + random.nextInt(10); // formuldeki a sayısını üretiyoruz. Sıfır çıkarsa diye de 1 ekliyoruz.
        int c = 1 + random.nextInt(10); //formüldeki b sayısını üretiyoruz. Sıfır çıkarsa diye de 1 ekliyoruz.
        ZArray[0] = 1 + random.nextInt(10); // formüldeki z0 sayısını üretiyoruz. Sıfır çıkarsa diye de 1 ekliyoruz.
        int m = 11 + random.nextInt(10); // Bu hyukarıdakilerin hepsinden büyük olmalı. Bu sebeple 11 ekledik. Ne gelirse gelsin artık m hepsinden büyük olur.

        //Başlangıç için oluşturulan değerşeri ekrana yazdırıyoruz.
        System.out.println("--------------");
        System.out.println("Belirlenen değerler: ");
        System.out.println("a: " + a);
        System.out.println("c: " + c);
        System.out.println("Z0: " + ZArray[0]);
        System.out.println("m: " + m);
        System.out.println("--------------");

        // İlk olarak yaptığımız şey Z değerlerini bulmak. Ve bulduğumuz z değerlerini yukarıda oluşturduğumuz z dizinie aktarmak.
        // bu for döngüsü ile ilk olarak bütün z sayılarını buluyoruz.
        for (int i = 1; i < n; i++) {
            //ilk Z değerini(Yani Z0 değerini) rastgele sayı ile belirliyoruz. Ayrıca formülde bir önceki z değeri kulalnıldığı için de döngü 1 den başlamak zorunda.
            ZArray[i] = (a * ZArray[i - 1] + c) % m; // Var olan formül ile Z değeirmi biliyoruz ve diziye aktarıyoruz.
        } // birinci for son

        // Bu forda bulduğumuz z sayıları ile rastgele değerimizi oluşturup diziye atkarıyoruz.
        for (int i = 0; i < n; i++) {
            result[i] = (double) ZArray[i] / m; // Bulunan z değerine göre rastgele sayıyı buluyoruz. (Zi/m förmülünü uygulayarak.) Daha sonra bu değerleri diziye aktarıyoruz.
            System.out.println((i + 1) + ". adimda üretilen z Değeri: " + ZArray[i]); // Ekrana bulunan Z değerini yazıyoruz.
            System.out.println((i + 1) + ". adimda üretilen rastgele Sayı: " + result[i]); // Ekrana bulunan rastgele sayı değerini yazıyoruz.i
        } // ikinci for son

        return result; // En sonra rastgele  sayıları aktardığımız diziyi döndürüyoruz.
    } // metot son

    //Ekrana yazdırma metodu
    public void print(int[] array, int n, String yontem) {
        //İlk olarak ekrana yazdıracağımız diziyi, dizinin boyutunu ve kullanılan yöntemi bu metoda parametre olarak alıyoruz
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Yöntem: " + yontem); // Burada ilk olarak ekrana yöntemi yazdırıyurz
        for (int i = 0; i < n; i++) { // Sonra gelen boyuta göre bir for döngüsü oluşturuyoruz.
            int m = i + 1; // Ekrana yazı yazdırırken 1,2,3.. gibi sayıları yazdırmak için m değerini oluşturuyoruz. Yani ekranda i değerinin hep bir fazlası görülüyor. Görünüş için tasarlanmış bir sistem.
            System.out.println(m + ": " + array[i]); // daha sonra dizinin içeriğini yazdırıyoruz.
        } // for döngüsü son
        System.out.println("----------------------------------------------------------------------------------");
    }//metot son

}//class son
