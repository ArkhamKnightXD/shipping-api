package knight.arkham.shipping.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1")
@RestController
public class ShipController {


    @GetMapping("/ship")
    @Operation(summary = "Get All Ship Data", description = "Get all ship data available")
    public ResponseEntity<String> getAllVideoGames() {

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
