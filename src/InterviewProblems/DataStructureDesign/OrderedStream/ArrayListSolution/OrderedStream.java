package InterviewProblems.DataStructureDesign.OrderedStream.ArrayListSolution;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    /**
     * There is a stream of n (idKey, value) pairs arriving in an arbitrary order,
     * where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.
     *
     * Design a stream that returns the values in increasing order of their IDs by returning a chunk
     * (list) of values after each insertion. The concatenation of all the chunks should result in a
     * list of the sorted values.
     */

    List<String> items;
    int currentID;

    public static void main(String[] args) {
        OrderedStream stream = new OrderedStream(5);
        System.out.println(stream.insert(3, "ccc"));  // []
        System.out.println(stream.insert(1, "aaa"));  // ["aaa"]
        System.out.println(stream.insert(2, "bbb"));  // ["bbb", "ccc"]
        System.out.println(stream.insert(5, "eee"));  // []
        System.out.println(stream.insert(4, "ddd"));  // ["ddd", "eee"]
    }

    /**
     * Constructs the stream to take n values.
     *
     * Preconditions:
     * - 1 <= n <= 1000.
     * - 1 <= id <= n.
     * - value.length == 5.
     * - value consists only of lowercase letters.
     */
    public OrderedStream(int n) {
        currentID = 0;
        items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(null);
        }
    }

    /**
     * Inserts the pair (idKey, value) into the stream,
     * then returns the largest possible chunk of currently inserted values that appear next in the order.
     *
     * Preconditions:
     * - Each call to insert will have a unique id.
     * - Exactly n calls will be made to insert.
     */
    public List<String> insert(int idKey, String value) {
        // add new value to items
        items.set(idKey - 1, value);

        // print out all items from idKey to currentID (if nonempty),
        // or until the end of the list
        List<String> answer = new ArrayList<>();
        while (currentID < items.size() && items.get(currentID) != null) {
            answer.add(items.get(currentID));
            currentID++;
        }
        return answer;
    }
}
