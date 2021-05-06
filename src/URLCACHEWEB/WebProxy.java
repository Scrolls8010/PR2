package URLCACHEWEB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WebProxy {

    private PageCache cache;
    private int numCacheHits;
    private int numCacheMisses;

    public WebProxy() {
        this.cache = new PageCache();
    }

    public WebProxy(PageCache cache) {
        this.cache = cache;
    }

    public WebPage fetch (String url) throws UrlLoaderException {
        WebPage page;

        try {
            page=cache.readFromCache(url);
            numCacheHits++;
        } catch (CacheMissException e) {
           numCacheMisses++;
           page=UrlLoader.loadWebpage(url);
           cache.writeToCache(page);
        }
return page;
    }

    public String statHits() {
        return "stats hits: " + this.numCacheHits;
    }

    public String statsMisses() {
        return "stats misses: " + this.numCacheMisses;
    }

    public boolean writePageCacheToFile (String pathToFile) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile))) {

            for (Map.Entry<String, WebPage> entry : cache.getCache().entrySet()) {
                bw.write(entry.getKey() + ";" + entry.getValue().getContent());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
return true;
    }




}

