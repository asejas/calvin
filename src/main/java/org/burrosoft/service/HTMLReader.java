package org.burrosoft.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLReader {

    public Document readHTML(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public String getImageUrl(Document doc){
        String imageUrl="";
        Elements featureItems=doc.getElementsByAttributeValue("data-shareable-model","FeatureItem");
        System.out.println("ELEMENTOOOOO "+featureItems.text());
        if(!featureItems.isEmpty()){
            imageUrl = featureItems.first().attributes().get("data-image");
        }
        return imageUrl;
    }
}
