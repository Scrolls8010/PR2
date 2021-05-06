package URLCACHEWEB;

import java.util.Map;

public class urlDEMO {

    public static void main(String[] args) {

        PageCache cache = new PageCache();
        cache.warumUp("Files/URLS/urls.txt");
        for (Map.Entry<String,WebPage> entry : cache.getCache().entrySet()) {
            System.out.println(entry.getValue().getContent());
        }

        WebProxy webProxy = new WebProxy(cache);
        webProxy.writePageCacheToFile("Files/URLS/output.txt");
    }




}
