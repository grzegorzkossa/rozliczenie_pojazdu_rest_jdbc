package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.common.Ride;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.db.TransportDB;

import java.util.List;

@RestController
public class TransportController {
    private final static Logger log = LoggerFactory.getLogger(TransportController.class);
    private final TransportDB transportDB;

    public TransportController(TransportDB transportDB) {
        this.transportDB = transportDB;
    }

    @GetMapping("/")
    public String getTest() {
        return "Działa JDBC";
    }

    @GetMapping("/vehicle/{vehicleId}/rides")
    public List<Ride> getRides(@PathVariable("vehicleId") long vehicleId) {
        log.info("Wyświetlamy listę przejazdów");
        return transportDB.getRides(vehicleId);
    }
    @GetMapping("vehicle/{vehicleId}/ride/{rideId}")
    public Ride getRide(@PathVariable("vehicleId") long vehicleId, @PathVariable("rideId") long rideId) {
        log.info("Wyświetlamy przejazd");
        return transportDB.getRide(vehicleId, rideId);
    }
}
