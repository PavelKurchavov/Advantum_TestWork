
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Solution {

    // Task #1
    public static String trucksAndCargo(int x1, int x2, int xCargo) {
        int firstTruckToCargoDistance = Math.abs(x1 - xCargo);
        int secondTruckToCargoDistance = Math.abs(x2 - xCargo);

        if (firstTruckToCargoDistance < secondTruckToCargoDistance) return "1";
        else if (firstTruckToCargoDistance > secondTruckToCargoDistance) return "2";

        return null;
    }


    //Task #2
    public static int wordsCount(String str) {
        int wordsCount = 1;

        for (Character c : str.toCharArray()) {
            String cAsStr = c.toString();
            if (cAsStr.equals(cAsStr.toUpperCase(Locale.ROOT))) wordsCount++;
        }
        return wordsCount;
    }


    //Task #3
    public long findFirstTruck(List<Truck> trucks, int xCargo, int yCargo) {
        Truck firstTruck = trucks.get(0);
        double bestTruckTime = Double.POSITIVE_INFINITY;
        for (Truck truck : trucks) {
            double distance = Math.sqrt(Math.pow(xCargo - truck.x, 2) + Math.pow(yCargo - truck.y, 2));
            double time = distance / truck.speed;
            if (time < bestTruckTime) {
                bestTruckTime = time;
                firstTruck = truck;
            }
        }
        return firstTruck.id;
    }


    //Task #4 Решение в классе TrucksAndDriversBase
    //Task #5 Решение в классе TruckCoordinateReceiver


    //Task #6 Oops...


    //Task #7
    private static final Set<Node> originalNodes = new HashSet<>();
    public static Node copyGraph(Node someNodeOfOriginalGraph) {
        if (originalNodes.contains(someNodeOfOriginalGraph)) {
            return null;
        }
        originalNodes.add(someNodeOfOriginalGraph);
        Node copiedNode = new Node();
        copiedNode.value = someNodeOfOriginalGraph.value;
        copiedNode.copiedFrom = someNodeOfOriginalGraph;
        Set<Node> copiedLinks = new HashSet<>();

        for (Node link : someNodeOfOriginalGraph.linkedNodes) {
            Node copiedLinkNode = copyGraph(link);
            if (copiedLinkNode != null) {
                copiedLinks.add(copiedLinkNode);
            }
        }

        copiedNode.linkedNodes = copiedLinks;
        return copiedNode;
    }

    //psvm (Пусть будет)
    public static void main(String[] args) {
    }

}
