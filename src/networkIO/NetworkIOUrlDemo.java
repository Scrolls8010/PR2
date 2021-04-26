package networkIO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkIOUrlDemo {

    public static void main(String[] args) {

        try {
            URL wiki = new URL("https://en.wikipedia.org/wiki/List_of_universities_in_Austria");
            //InputStream wikiContent = wiki.openStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(wiki.openStream())))
           {
                String html;
                while ((html = br.readLine()) !=null){
                    System.out.println(html);
                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
