package DataStructures.CollectionsFramework.TreeSets;

import java.util.TreeSet;

public class TreeSets {

    public static void main(String[] args) {
        // - a treeset uses a balanced search tree to
        // - insert, delete, search, contains uses O(logn) time

        // creating a new tree set
        TreeSet<String> r5Members = new TreeSet<>();

        // adding items to a tree set
        r5Members.add("Rydel Lynch");
        r5Members.add("Ross Lynch");
        r5Members.add("Riker Lynch");
        r5Members.add("Rocky Lynch");
        r5Members.add("Ellington Ratliff");
        System.out.println(r5Members); // [Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch, Rydel Lynch]

        // check membership in tree set
        System.out.println(r5Members.isEmpty()); // false
        System.out.println(r5Members.contains("Ross Lynch")); // true

        // get items from a tree set
        System.out.println(r5Members.size()); // 5
        System.out.println(r5Members.first()); // Ellington Ratliff
        System.out.println(r5Members.last()); // Rydel Lynch

        // - TODO: floor(E e) greatest element <= e, null otherwise
        // - TODO: ceiling(E e) least element >= e, null otherwise
        // - TODO: higher(E e) least element > e, null otherwise
        // - TODO: lower(E e) greatest element < e, null otherwise
        System.out.println(r5Members.ceiling("Riker")); // Riker Lynch
        System.out.println(r5Members.floor("Riker")); // Ellington Ratliff
        System.out.println(r5Members.higher("Riker Lynch")); // Rocky Lynch
        System.out.println(r5Members.lower("Riker Lynch")); // Ellington Ratliff

        // - TODO: headSet() items < (<= if inclusive true) e
        // - TODO: tailSet() items > (>= if inclusive true) e
        System.out.println(r5Members.headSet("Rocky Lynch", true)); // [Ellington Ratliff, Riker Lynch, Rocky Lynch]
        System.out.println(r5Members.headSet("Rocky Lynch")); // [Ellington Ratliff, Riker Lynch]
        System.out.println(r5Members.tailSet("Rocky Lynch", true)); // [Rocky Lynch, Ross Lynch, Rydel Lynch]
        System.out.println(r5Members.tailSet("Rocky Lynch")); // [Rocky Lynch, Ross Lynch, Rydel Lynch]

        // traversing items in a tree set
        for (String r5Member : r5Members) {
            System.out.println(r5Member); // Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch, Rydel Lynch
        }

        // - TODO: descendingSet()
        System.out.println(r5Members.descendingSet()); // [Rydel Lynch, Ross Lynch, Rocky Lynch, Riker Lynch, Ellington Ratliff]

        // - TODO: subSet() -- all items where e1 < items < e2 (<= if inclusive true)
        System.out.println(r5Members.subSet("Ellington Ratliff", "Rydel Lynch"));
        // [Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch]
        System.out.println(r5Members.subSet("Ellington Ratliff", true, "Rydel Lynch", false));
        // [Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch]
        System.out.println(r5Members.subSet("Ellington Ratliff", false, "Rydel Lynch", true));
        // [Riker Lynch, Rocky Lynch, Ross Lynch, Rydel Lynch]
        System.out.println(r5Members.subSet("Ellington Ratliff", true, "Rydel Lynch", true));
        // [Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch, Rydel Lynch]

        // mutate items in a tree set
        // - TODO: clone()

        // remove items from a tree set
        System.out.println(r5Members.pollLast()); // Rydel Lynch
        System.out.println(r5Members); // [Ellington Ratliff, Riker Lynch, Rocky Lynch, Ross Lynch]
        System.out.println(r5Members.pollFirst()); // Ellington Ratliff
        System.out.println(r5Members); // [Riker Lynch, Rocky Lynch, Ross Lynch]
        r5Members.remove("Rocky Lynch");
        System.out.println(r5Members); //[Riker Lynch, Ross Lynch]
        r5Members.clear();
        System.out.println(r5Members); // []
    }
}
