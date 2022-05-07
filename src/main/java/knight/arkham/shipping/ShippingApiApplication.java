package knight.arkham.shipping;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import knight.arkham.shipping.services.JsoupService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ship API", version = "1.0", description = "API TESTING"))
public class ShippingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(JsoupService jsoupService) {
        return args -> {

            var url= "https://shipping.fandom.com/wiki/Atsukyoka";
            var url2= "https://shipping.fandom.com/wiki/SakuSyao";
            var url3= "https://shipping.fandom.com/wiki/AtsuLucy";

            Document document = Jsoup.connect(url3).get();

//            System.out.println("Data: "+ document.body().html());

//            Right side bar elements
            var sideBarElements = jsoupService.getAllElementsByTag(document.body().html(), "aside");

            var shipName = sideBarElements.select("h2").first().text();
            var animeName = sideBarElements.select("a").get(1).text();
            var shipPrincipalPhoto = sideBarElements.select("img").first().attr("src");
            var firstCharacterName = sideBarElements.select("td").get(0).text();
            var secondCharacterName = sideBarElements.select("td").get(1).text();
            var canonicalStatus = sideBarElements.select("div").get(4).text();
            var relationshipStatus = sideBarElements.select("div").get(6).text();
            var shipType = sideBarElements.select("div").get(8).text();

            System.out.println(shipName);
            System.out.println(animeName);
            System.out.println(shipPrincipalPhoto);
            System.out.println(firstCharacterName);
            System.out.println(secondCharacterName);
            System.out.println(canonicalStatus);
            System.out.println(relationshipStatus);
            System.out.println(shipType);
//            System.out.println(secondCharacterName);
//
//            for (var element : sideBarElements) {
//
//                System.out.println(element);
//            }
        };
    }
}
