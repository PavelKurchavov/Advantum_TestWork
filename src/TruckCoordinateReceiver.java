import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TruckCoordinateReceiver {
    private final Map<Integer, Instant> truckIdToLastValidInstantMap = new ConcurrentHashMap<>();

    public void receiveCoordinates(int truckId, int x, int y, Instant measurementTime) {
        Instant lastValidInstant = truckIdToLastValidInstantMap.get(truckId);
        if (lastValidInstant == null || measurementTime.compareTo(lastValidInstant) > 0) {
            truckIdToLastValidInstantMap.put(truckId, measurementTime);
            processCoordinates(truckId, x, y, measurementTime);
        }
    }

    public void processCoordinates(int truckId, int x, int y, Instant measurementTime) {
        System.out.println("Пришел пакет " + truckId + " " + x + " " + y + " " + measurementTime);
    }
}
