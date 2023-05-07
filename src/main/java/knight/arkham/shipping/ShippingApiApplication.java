package knight.arkham.shipping;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import knight.arkham.shipping.services.ExcelService;
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
    public CommandLineRunner startup(ExcelService excelService) {
        return args -> {

            excelService.readExcelFile("C:\\Presupuesto-mensual.xlsx");
        };
    }
}
