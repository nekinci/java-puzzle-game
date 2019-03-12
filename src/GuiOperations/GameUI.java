
package GuiOperations;

import Score.Skor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class GameUI extends JPanel implements IMediator{
    private BufferedImage[][] parts;
    private ImageButton[][] btns;
    private ImageButton[][] buttons;
    private boolean signedw[];
    private boolean signedh[][];
    private static int count = -1;
    private Stack<Integer> stack;
    private static ImageButton selectedButton;
    private int counter = 0;
    private int score = 100, hak = 15;
    private Mediator mediator;
    public int getScore(){
        return score;
    }
    
    public int getHak(){
        return hak;
    }
    
    public GameUI(ImageFragmentation.ImageFragmentation parts,Mediator mediator){
        
        // Oyun bir resimi karıştırıp puzzle ile çözme olduğu için önce resmi parçalamak için class oluşturduk(ImageFragmentation)
        // Bu class resmi parçalıyor. Oyun arayüzümüze gönderiyor.
        // Bu resimleri önce buttonlara yerleştiriyoruz düzgün bir sıra ile init() fonksiyonu
        
        this.parts = parts.getFragmentedImages();
        this.mediator = mediator;
        mediator.addUI(this);
        
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
        }
        setSize(500,500);
        setLayout(null);
        setBackground(Color.BLACK);
        init();
        repaint();
        setVisible(true);

    }
    
    public GameUI(){
        init();
    }
    
    private void init(){
        // Bu fonksiyon resimleri butonlara düzgün bir şekilde ekler. ve bazı initalize edilecek değişkenleri 
        // initalize ederek kullanıma hazırlar.
        
        buttons = new ImageButton[4][4];
        btns = new ImageButton[4][4];
        signedw = new boolean[4];
        signedh = new boolean[4][4];
        
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4 ; j++){
                buttons[i][j] = new ImageButton(parts[i][j]);
                buttons[i][j].setBounds(i*100+3, j*100+3, 100, 100);
                //add(buttons[i][j]);
                signedw[i] = false;
                signedh[i][j] = false;
            }
        }
    }
    
    public void addImages(){
        // Resimleri Oyun arayüzümüze eklemek için yazılan fonksiyon setBounds ile boyut ayarlamaları yapılarak yerleştirilmiştir.
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                btns[i][j].setBounds(i*100+3, j*100+3, 100, 100);
                add(btns[i][j]);
            }
        }
    }
    public int mixImages(){
        
        
        // Bu metod, resimlerin yerlerini karıştırır.
        //signedw[] ve signedh[][] dizilerini kullanma nedenimiz resim atanan yerleri işaretleyerek tekrar oralara resim atmamak için.
        // random bir şekilde w ve h değişkenlerine atıyoruz ve yerleştiriyoruz.
        for (int i = 0; i < 4; i++){
            
            int w = (int) (Math.random() * 10) % 4;
            
            if(signedw[w]){
                i--;
                continue;
            }
            signedw[w] = true;
            for(int j = 0; j < 4; j++){
                int h = (int) (Math.random() * 10) % 4;
                
                if(signedh[w][h]){
                    j--;
                    continue;
                }
                
                signedh[w][h] = true;
                
                btns[i][j] = new ImageButton(buttons[w][h].imageCopy());
                
                
                final ImageButton exBtn = buttons[i][j];
                //Stack kullanma nedenimiz i ve j değişkenlerini saklamak ve selectedButtonun önceki konumunu tutmak.
                //Koordinat kullanılmamıştır sadece nesne karşılaştırılması yapılmıştır ve haliyle nesnelerde matris üzerinde olduğu 
                //için mecburen bazı şeyleri kullanmak zorunda kalabiliyoruz. 
                //Nesne içine id ekleyip id karşılaştırması yapılmamıştır.
                //Tamamen shallow copy mantığı ile değişkenler aynı yerimi point ediyor mu o kontrol edilmiştir eğer aynı yeri point ediyorsa 
                //Ödevde verildiği üzere puanlama yapılmıştır.
                final int a = i, b = j;
                stack = new Stack<>();
                btns[i][j].addActionListener(new ActionListener() {
                    //Burası her button için üstüne tıklanıldığında yapılması gerekenleri yapan fonksiyondur.
                    //Bildiğimiz listener işte. :) 
                    
                    public void actionPerformed(ActionEvent e) {
                        // Tıklanan buton source ile alınmış ve btn değişkenine aktarılmıştır.
                        ImageButton btn = (ImageButton) e.getSource();
                        //Sayıcı atanmış ve iki tane button arka arkaya basması için kontrol blokları eklenmiştir.
                        count++;
                        if(count == 0){
                            // Eğer count 0 ise selectedButton'a sen tıkladığımız butonu göster dedik ve etrafını kırmızıya boyadık burası sadece
                            // bunu yapıyor.
                            // ve tabii ki bir de stack'e bu buttonun matrisde ki konumunu ekliyor, başka yolu olduğunu zannetmiyorum.
                            selectedButton = btn;
                            selectedButton.setBorder(new LineBorder(Color.RED,5));
                            stack.push(new Integer(b));
                            stack.push(new Integer(a));
                        }
                        
                        if(count == 1){
                            // Evet bir tane butona bastık ve countumuz artmış oldu beklemede program bizden ikinci butona basmamızı istiyor
                            // Peki ikinci butona basınca ne yapacak ? 
                            // İşte bunun cevabı bu if blogunda
                            // selectedButton'un border'ını yani az önce kırmızıya boyadığımız yerin kırmızısını siliyor 
                            // artık biz seni seçmedik senle işimiz bitti dediğimizi belirtiyoruz.
                            
                            selectedButton.setBorder(null);
                            BufferedImage tmpImg = selectedButton.imageCopy();
                            selectedButton.setImage(btn.imageCopy());
                            btn.setImage(tmpImg);
                            
                            //Burada ikinci seçilen button un resmiyle ilk tıklanan butonun resmi karşılaştırılıyor.
                            //Eğer doğru yerlerdeyse enabled'ini false yapıyoruz ki tekrar yerini değiştiremesinler artık.
                            //Ve sonuç olarak etraflarını sarıya boyuyoruz ki bizim işimiz tamam mesajı verdiriyoruz.
                            
                            if (btn.imageCopy() == exBtn.imageCopy()){
                                btn.setEnabled(false);
                                btn.setBorder(new LineBorder(Color.YELLOW,5));
                                System.out.println("Ok Ana");
                            }
                            
                            if(selectedButton.imageCopy() == buttons[stack.pop()][stack.pop()].imageCopy()){
                                selectedButton.setEnabled(false);
                                selectedButton.setBorder(new LineBorder(Color.YELLOW,3));
                                System.out.println("Ok yedek");
                            }
                            repaint();
                            count = -1;
                        }
                        
                        // 15 hakkımız her tıklamada düşüyor.
                        //Her tıklamada oyun bittimi kontrolü yapyıroz. gameControl() ile.
                        if(hak > 0 && count == -1){
                            hak--;
                            mediator.hakGuncelle(hak);
                            if(gameControl() == 16){
                                JOptionPane.showMessageDialog(null, "Tebrikler! Kazandınız, skorunuz: "+score);
                                setVisible(false);
                                setEnabled(false);
                                Skor skor = new Skor();
                                skor.skorEkle("User", score);
                            }
                        }
                        
                        //Hakkımız bittiyse artık skor üzerinden işlem yapmaya çalışıyoruz.
                        // 15 hakta kazandın kazandın yoksa 100 puanı unut diyoruz aslında.
                        if(hak == 0){
                            if(score > 0 && count == -1){ // Hakkımız 0 oldu artık tamam herşey güzel, fakat skorumuzda 0dan büyük olmalıki oyunu oynayabilelim demi :)
                                score = score - 10; // Her tıklamada skoru 10 puan düşürüyoruz.
                                mediator.skorGuncelle(score);
                                if(gameControl() == 16){ // ve yine her tıklamada oyun bittimi diye kontrol ediyoruz.
                                    JOptionPane.showMessageDialog(null,"Tebrikler! Skorunuz: "+score); //bittyse ekrana yazdırıyoruz ve skoru kaydediyoruz.
                                    setVisible(false);
                                    setEnabled(false);
                                    Skor skor = new Skor();
                                    skor.skorEkle("User",score);
                                }
                            }
                            if(score == 0){ // skor 0 sa zaten oyunu kaybetmiştir oyun alanını kontrol etme gereği yok.
                                JOptionPane.showMessageDialog(null, "Oyunu kaybettiniz! Skorunuz: "+ score);
                                setEnabled(false);
                                setVisible(false);
                                Skor skor = new Skor();
                                skor.skorEkle("Loser User", score);
                            }
                        }
                        //15 Hakkımız var 
                        //15 hakka kadar skor sabit olarak (100) kalacaktır.
                        //Eğer 15 hak tamamlanırsa skor her bir hamlede 10 puan düşecektir. 
                        //Skor 0 olduğunda oyun bitecektir.
                        //Ve skor txt dosyasına kaydedilecektir.
                        
                        
                    }
                });
               
            }
        }
        resetValues();
        addImages();
        checkImages();
        return counter;
    }
    
    public void resetValues(){
        for(int i = 0; i < 4; i++){
            signedw[i] = false;
            for(int j = 0; j < 4; j++){
                signedh[i][j] = false;
            }
        }
    }
    
    public void checkImages(){
        int a = 0;
        for(int i = 0; i < 4; i++){
            for( int j = 0; j < 4; j++){
                if(btns[i][j].imageCopy() == buttons[i][j].imageCopy()){
                    btns[i][j].setBorder(new LineBorder(Color.YELLOW,2));
                    btns[i][j].setEnabled(false);
                    counter++;
                    a++;
                }
            }
        }
    }

    //Bunlar yukarıda anlatılan işlerin fonksiyonlaştırılmış hali.
    public int gameControl(){
        int c = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if(btns[i][j].imageCopy() == buttons[i][j].imageCopy())
                    System.out.println("c:" + c++);
            }
        }
        return c;
    }
}
