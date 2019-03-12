package Score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Skor {
    
    // Skoru kaydedip çekmek için yazdığımız class 
    // bir nesneye işimizi halletiricez :)
    private String path = "src/";
    private String name = "yuksekskor.txt";
    
    private String username;
    private int score;
    private File file;
    
    public Skor(){
        fileOpen();
    }
    
    public void skorEkle(String username,int score){
        this.score = score;
        this.username = username;
        kaydet();
    }
    
    public boolean fileOpen(){
       file = new File(path+name);
        System.out.println(file.isFile());
       return file.isFile();
    }
    
    public void kaydet(){
       try(FileWriter fw = new FileWriter(path+name, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println(username+"\t"+score);
} catch (IOException e) {

}
        
    }
    public ArrayList<String> list = new ArrayList<String>();
    public void skorCek() throws IOException{
        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String skor = br.readLine();
                if(skor != null){
                    list.add(skor);
                }
                if(skor == null)
                    break;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Skor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
