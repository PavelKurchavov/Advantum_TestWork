import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

//Класс для задачи 4
public class TrucksAndDriversBase {
    public static Map<Long, Long> trucksToDriver = new ConcurrentHashMap<>();
    public static Map<Long, String> driversToLabelNumber = new ConcurrentHashMap<>();

    public static Optional<Long> getTruckIdByLabelNumber(String labelNumber) {
        Long truckId = null;
        Long driverId = null;

        for (Map.Entry<Long, String> entry : driversToLabelNumber.entrySet()) {
            if (Objects.equals(entry.getValue(), labelNumber)) {
                driverId = entry.getKey();
                break;
            }
        }

        for (Map.Entry<Long, Long> entry : trucksToDriver.entrySet()) {
            if (Objects.equals(entry.getValue(), driverId)) {
                truckId = entry.getKey();
                break;
            }
        }
        return Optional.ofNullable(truckId);
    }


}
