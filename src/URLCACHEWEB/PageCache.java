package URLCACHEWEB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PageCache {

    private HashMap<String,WebPage> cache = new HashMap<>();

    public HashMap<String, WebPage> getCache() {
        return cache;
    }

    public WebPage readFromCache(String url) throws CacheMissException {

        for (Map.Entry<String,WebPage> entry : cache.entrySet()) {

            if (entry.getKey().equals(url)) {
                return entry.getValue();
            }

        }
        throw new CacheMissException("Page not in cache!");
    }

    public void writeToCache (WebPage webPage) {
        cache.put(webPage.getUrl(), webPage);
    }

    public void warumUp (String pathToUrls) {

        try (BufferedReader br = new BufferedReader(new FileReader(pathToUrls))) {

            String line;
            while ((line=br.readLine())!=null) {

                try {
                    writeToCache(UrlLoader.loadWebpage(line));
                } catch (UrlLoaderException e) {
                    System.out.println("couldnt load page " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
