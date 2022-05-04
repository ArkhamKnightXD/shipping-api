package knight.arkham.shipping;

import knight.arkham.shipping.services.JsoupService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShippingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(JsoupService jsoupService) {
        return args -> {


            Document document = Jsoup.connect("https://shipping.fandom.com/wiki/Atsukyoka").get();

//            System.out.println("Data: "+ document.body().html());

//            Right side bar elements
            var metaElements = jsoupService.getAllElementsByTag(document.body().html(), "aside");
//
            for (var element : metaElements) {

                System.out.println(element);
            }
        };
    }
}
