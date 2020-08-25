package pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.lomza.programowanie.rozliczenie_pojazdu_rest_jdbc.common.Ride;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransportDB {
    private final static Logger log= LoggerFactory.getLogger(TransportDB.class);
    private final NamedParameterJdbcTemplate template;
    private final BeanPropertyRowMapper<Ride> rideMapper = BeanPropertyRowMapper.newInstance(Ride.class);

    public TransportDB(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    public List<Ride> getRides(long vehicleId) {
        log.info("List rides");
        return template.query(
                "SELECT r.id, r.rideDate, r.counterBefore, r.counterAfter, r.km, " +
                        "r.whence, r.`where`, r.rideKind, r.fuelCondition, r.fuelAdd, r.fuelAfter, " +
                        "SUM(s.fuel) as fuel, f.price, SUM(s.fuel*f.price) as currency, r.fuelNorm " +
                        "FROM transportMyBatis.Ride r " +
                        "LEFT JOIN transportMyBatis.Settlement  s on r.id = s.idRide " +
                        "LEFT JOIN transportMyBatis.Refuel f on f.id = s.idRefuel " +
                        "WHERE r.idVehicle = :vehicleId "+
                        "GROUP BY r.id, r.whence, r.`where`, r.rideKind, f.price " +
                        "ORDER BY r.id ",
                new MapSqlParameterSource("vehicleId", vehicleId), rideMapper);
    }

    public Ride getRide(long vehicleId,  long rideId) {
        log.info("Object ride");
        Map<String, String> map = new HashMap<>();
        map.put("vehicleId", Long.toString(vehicleId));
        map.put("rideId", Long.toString(rideId));
        return template.queryForObject(
                "SELECT r.id, r.rideDate, r.counterBefore, r.counterAfter, r.km, " +
                        "r.whence, r.`where`, r.rideKind, r.fuelCondition, r.fuelAdd, r.fuelAfter, " +
                        "SUM(s.fuel) as fuel, f.price, SUM(s.fuel*f.price) as currency, r.fuelNorm " +
                        "FROM transportMyBatis.Ride r " +
                        "LEFT JOIN transportMyBatis.Settlement  s on r.id = s.idRide " +
                        "LEFT JOIN transportMyBatis.Refuel f on f.id = s.idRefuel " +
                        "WHERE r.idVehicle = :vehicleId and r.id = :rideId " +
                        "GROUP BY r.id, r.whence, r.`where`, r.rideKind, f.price " +
                        "ORDER BY r.id",
                map, rideMapper);
    }
}
