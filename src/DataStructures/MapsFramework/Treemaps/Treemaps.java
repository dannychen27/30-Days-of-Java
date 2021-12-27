package DataStructures.MapsFramework.Treemaps;

import java.util.TreeMap;

public class Treemaps {

    public static void main(String[] args) {
        // - a treemap uses a balanced search tree to store items in a hashtable.
        // - insert, delete, search, contains uses O(logn) time

        // creating a new treemap
        TreeMap<String, String> celebritiesToDiffuserScents = new TreeMap<>();

        // adding items to a treemap
        celebritiesToDiffuserScents.put("Grant Gustin", "strawberry");
        celebritiesToDiffuserScents.put("Nolan Gerard Funk", "strawberry");
        celebritiesToDiffuserScents.put("Shawn Mendes", "strawberry");
        celebritiesToDiffuserScents.put("Ross Lynch", "strawberry");
        celebritiesToDiffuserScents.put("Chord Overstreet", "strawberry");
        celebritiesToDiffuserScents.put("Darren Criss", "strawberry");
        System.out.println(celebritiesToDiffuserScents);
        // {Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry,
        // Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}

        // check membership in a treemap
        System.out.println(celebritiesToDiffuserScents.isEmpty()); // false
        System.out.println(celebritiesToDiffuserScents.containsKey("Grant Gustin")); // true
        System.out.println(celebritiesToDiffuserScents.containsValue("strawberry")); // true

        // get items from a tree set
        System.out.println(celebritiesToDiffuserScents.size()); // 6
        System.out.println(celebritiesToDiffuserScents.keySet());
        // [Chord Overstreet, Darren Criss, Grant Gustin, Nolan Gerard Funk, Ross Lynch, Shawn Mendes]
        System.out.println(celebritiesToDiffuserScents.values());
        // [strawberry, strawberry, strawberry, strawberry, strawberry, strawberry]
        System.out.println(celebritiesToDiffuserScents.entrySet());
        // [Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry,
        // Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry]
        System.out.println(celebritiesToDiffuserScents.get("Grant Gustin")); // strawberry

        System.out.println(celebritiesToDiffuserScents.firstKey()); // Chord Overstreet
        System.out.println(celebritiesToDiffuserScents.firstEntry()); // Chord Overstreet=strawberry

        System.out.println(celebritiesToDiffuserScents.lastKey()); // Shawn Mendes
        System.out.println(celebritiesToDiffuserScents.lastEntry()); // Shawn Mendes=strawberry

        System.out.println(celebritiesToDiffuserScents.ceilingKey("Grant")); // Grant Gustin
        System.out.println(celebritiesToDiffuserScents.ceilingEntry("Grant")); // Grant Gustin=strawberry

        System.out.println(celebritiesToDiffuserScents.floorKey("Grant")); // Darren Criss
        System.out.println(celebritiesToDiffuserScents.floorEntry("Grant")); // Darren Criss=strawberry

        System.out.println(celebritiesToDiffuserScents.higherKey("Grant"));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry}
        System.out.println(celebritiesToDiffuserScents.higherEntry("Grant"));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry}

        System.out.println(celebritiesToDiffuserScents.lowerKey("Grant"));
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}
        System.out.println(celebritiesToDiffuserScents.lowerEntry("Grant"));
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}

        System.out.println(celebritiesToDiffuserScents.headMap("Grant Gustin"));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry}
        System.out.println(celebritiesToDiffuserScents.headMap("Grant Gustin", true));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry}

        System.out.println(celebritiesToDiffuserScents.tailMap("Grant Gustin"));
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}
        System.out.println(celebritiesToDiffuserScents.tailMap("Grant Gustin", true));
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}

        System.out.println(celebritiesToDiffuserScents.subMap("Chord Overstreet", "Grant Gustin"));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry}
        System.out.println(celebritiesToDiffuserScents.subMap("Chord Overstreet", true , "Grant Gustin", true));
        // {Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry}

        System.out.println(celebritiesToDiffuserScents.descendingKeySet());
        // [Shawn Mendes, Ross Lynch, Nolan Gerard Funk, Grant Gustin, Darren Criss, Chord Overstreet]
        System.out.println(celebritiesToDiffuserScents.descendingMap());
        // {Shawn Mendes=strawberry, Ross Lynch=strawberry, Nolan Gerard Funk=strawberry,
        // Grant Gustin=strawberry, Darren Criss=strawberry, Chord Overstreet=strawberry}

        // traversing items in a treemap
        for (String celebrity : celebritiesToDiffuserScents.keySet()) {
            System.out.println(celebrity + " likes " + celebritiesToDiffuserScents.get(celebrity));
            // Chord Overstreet likes strawberry
            // Darren Criss likes strawberry
            // Grant Gustin likes strawberry
            // Nolan Gerard Funk likes strawberry
            // Ross Lynch likes strawberry
            // Shawn Mendes likes strawberry
        }

        // mutate items in a treemap

        System.out.println(celebritiesToDiffuserScents.replace("Darren Criss", "mint"));
        // strawberry
        System.out.println(celebritiesToDiffuserScents);
        // {Chord Overstreet=strawberry, Darren Criss=mint, Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}
        System.out.println(celebritiesToDiffuserScents.replace("Darren Criss", "mint", "strawberry"));
        // true
        System.out.println(celebritiesToDiffuserScents);
        // {Chord Overstreet=strawberry, Darren Criss=strawberry, Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}

        // TODO: - clone()

        // remove items from a treemap
        celebritiesToDiffuserScents.remove("Darren Criss");
        System.out.println(celebritiesToDiffuserScents);
        // {Chord Overstreet=strawberry, Grant Gustin=strawberry, Nolan Gerard Funk=strawberry,
        // Ross Lynch=strawberry, Shawn Mendes=strawberry}

        System.out.println(celebritiesToDiffuserScents.pollFirstEntry()); // Chord Overstreet=strawberry
        System.out.println(celebritiesToDiffuserScents);
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry, Shawn Mendes=strawberry}

        System.out.println(celebritiesToDiffuserScents.pollLastEntry()); // Shawn Mendes=strawberry
        System.out.println(celebritiesToDiffuserScents);
        // {Grant Gustin=strawberry, Nolan Gerard Funk=strawberry, Ross Lynch=strawberry}

        celebritiesToDiffuserScents.clear();
        System.out.println(celebritiesToDiffuserScents); // {}
    }
}
