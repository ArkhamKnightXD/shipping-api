package knight.arkham.shipping.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class JsoupService {


    public Elements getAllElementsByTag(String definitionResponse, String tagName) {

        Document document = Jsoup.parse(definitionResponse);

        return document.getElementsByTag(tagName);
    }
}
