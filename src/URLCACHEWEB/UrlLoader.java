package URLCACHEWEB;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLoader {

    public static WebPage loadWebpage(String url) throws UrlLoaderException {
        URL webpage;
        try {
            webpage = new URL(url);
        } catch (MalformedURLException e) {
            throw new UrlLoaderException("URL Load error", e);
        }
        try (
                BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(webpage.openStream())))
        ) {
            String line;
            StringBuilder content = null;
            while ((line= br.readLine())!=null) {
                content.append(line);
            }
            return new WebPage(url, content.toString());
        } catch (IOException e) {
            throw new UrlLoaderException("URL Load error", e);
        }
        //        try {
//            URL page = new URL("http://www.orf.at");
//            return new WebPage(url,page.getContent().toString());
//        } catch (MalformedURLException e) {
//           throw new UrlLoaderException("URL LOAD ERROR", e);
//        } catch (IOException e) {
//            throw new UrlLoaderException("URL LOAD ERROR", e);
//        }

    }

}
