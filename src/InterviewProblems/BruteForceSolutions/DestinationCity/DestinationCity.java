package InterviewProblems.BruteForceSolutions.DestinationCity;

import java.util.ArrayList;
import java.util.List;

public class DestinationCity {

    // Let n = the number of paths in the paths array
    //
    // Time: O(n ^ 2)
    // --> for each path in the paths array, we compare it to every other path in the paths array
    // Space: O(1)
    // --> We only store a single destination city in the variable destinationCity.

    public static void main(String[] args) {
        DestinationCity dc = new DestinationCity();

        // Input: paths = [["A", "Z"]]
        // Output: "Z"
        List<List<String>> paths1 = new ArrayList<>();
        paths1.add(new ArrayList<>());
        paths1.get(0).add("A");
        paths1.get(0).add("Z");
        String destinationCity1 = dc.destCity(paths1);
        System.out.println(destinationCity1);  // Z

        // Input: paths = [["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]
        // Output: "Sao Paulo"
        // Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the
        // destination city.
        // Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
        List<List<String>> paths2 = new ArrayList<>();
        paths2.add(new ArrayList<>());
        paths2.get(0).add("London");
        paths2.get(0).add("New York");
        paths2.add(new ArrayList<>());
        paths2.get(1).add("New York");
        paths2.get(1).add("Lima");
        paths2.add(new ArrayList<>());
        paths2.get(2).add("Lima");
        paths2.get(2).add("Sao Paulo");
        String destinationCity2 = dc.destCity(paths2);
        System.out.println(destinationCity2);  // Sao Paulo

        // Input: paths = [["B", "C"], ["D", "B"], ["C", "A"]]
        // Output: "A"
        // Explanation: All possible trips are:
        // "D" -> "B" -> "C" -> "A".
        // "B" -> "C" -> "A".
        // "C" -> "A".
        // "A".
        // Clearly the destination city is "A".
        List<List<String>> paths3 = new ArrayList<>();
        paths3.add(new ArrayList<>());
        paths3.get(0).add("B");
        paths3.get(0).add("C");
        paths3.add(new ArrayList<>());
        paths3.get(1).add("D");
        paths3.get(1).add("B");
        paths3.add(new ArrayList<>());
        paths3.get(2).add("C");
        paths3.get(2).add("A");
        String destinationCity3 = dc.destCity(paths3);
        System.out.println(destinationCity3);  // A
    }

    /**
     * You are given the array paths, where paths[i] = [cityAi, cityBi]
     * means there exists a direct path going from cityAi to cityBi.
     *
     * Return the destination city, that is, the city without any path
     * outgoing to another city.
     *
     * It is guaranteed that the graph of paths forms a line without any loop,
     * therefore, there will be exactly one destination city.
     *
     * Preconditions:
     * - 1 <= paths.length <= 100
     * - paths[i].length == 2
     * - 1 <= cityAi.length, cityBi.length <= 10
     * - cityAi != cityBi
     * - All strings consist of lowercase and uppercase English letters and the space character.
     */
    public String destCity(List<List<String>> paths) {
        String destinationCity = "";
        for (List<String> path : paths) {
            String cityA = path.get(0);
            String cityB = path.get(1);
            boolean foundDestinationCity = false;
            for (List<String> path2 : paths) {
                String cityA2 = path2.get(0);
                String cityB2 = path2.get(1);
                if (cityA2.equals(cityB) && !cityB2.equals(cityA)) {
                    foundDestinationCity = true;
                    break;
                }
            }
            if (!foundDestinationCity) {
                destinationCity = cityB;
            }
        }
        return destinationCity;
    }
}
