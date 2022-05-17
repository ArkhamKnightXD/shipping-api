package knight.arkham.shipping.services;

import knight.arkham.shipping.entities.Ship;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsoupService {

    private static final String baseUrl = "https://shipping.fandom.com/wiki/";


    private Elements getAllElementsByTag(String definitionResponse, String tagName) {

        Document document = Jsoup.parse(definitionResponse);

        return document.getElementsByTag(tagName);
    }


    public Ship getShipData(String shipUrlName){

        String completeUrl = baseUrl + shipUrlName;

        Document document = null;

        try {
            document = Jsoup.connect(completeUrl).get();
        } catch (IOException e) {

            e.printStackTrace();
        }

        var sideBarElements = getAllElementsByTag(document.body().html(), "aside");

        var shipName = sideBarElements.select("h2").first().text();
        var animeName = sideBarElements.select("a").get(1).text();
        var shipPrincipalPhoto = sideBarElements.select("img").first().attr("src");
        var firstCharacterName = sideBarElements.select("td").get(0).text();
        var secondCharacterName = sideBarElements.select("td").get(1).text();
        var canonicalStatus = sideBarElements.select("div").get(4).text();
        var relationshipStatus = sideBarElements.select("div").get(6).text();
        var shipType = sideBarElements.select("div").get(8).text();

        return new Ship(shipName, animeName, shipPrincipalPhoto, firstCharacterName,
                secondCharacterName, canonicalStatus, relationshipStatus, shipType);
    }


    public List<Ship> getFavoriteShipList() {

        List<Ship> list = new ArrayList<>();

        list.add(getShipData("Atsukyoka"));
        list.add(getShipData("SakuSyao"));
        list.add(getShipData("AtsuLucy"));
        list.add(getShipData("GiyuShino"));
        list.add(getShipData("Kiritsugu_x_Iri"));
        list.add(getShipData("Saimatsu"));

        return list;
    }
}
