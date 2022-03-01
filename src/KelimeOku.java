import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
public class KelimeOku {

    public ArrayList<String> Oku(){
        //burada kelimeler.txt icerisindeki kelimeler alinip kelimeler arraylistine atilmistir.
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> kelimeler = new ArrayList<String>();
        String path = "src/kelimeler.txt";
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()){
            list.add(s.nextLine());
        }
        for (int i=0; i<list.size(); i++)
        {
            kelimeler.add(list.get(i).substring(0,list.get(i).indexOf(" ")));
        }
        s.close();
        return (kelimeler);
    }

}
