package knight.arkham.shipping.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.shipping.entities.Ship;
import knight.arkham.shipping.services.JsoupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1")
@RestController
public class ShipController {

    private final JsoupService jsoupService;

    public ShipController(JsoupService jsoupService) {
        this.jsoupService = jsoupService;
    }


    @GetMapping("/ships/{shipName}")
    @Operation(summary = "Get Specific Ship Data", description = "Get all ship specific data available")
    public ResponseEntity<Ship> getShipData(@PathVariable String shipName) {

        return new ResponseEntity<>(jsoupService.getShipData(shipName), HttpStatus.OK);
    }


    @GetMapping("/ships/")
    @Operation(summary = "Get Favorite Ship Data", description = "Get all favorite ship data available")
    public ResponseEntity<List<Ship>> getFavoriteShipList() {

        return new ResponseEntity<>(jsoupService.getFavoriteShipList(), HttpStatus.OK);
    }
}
