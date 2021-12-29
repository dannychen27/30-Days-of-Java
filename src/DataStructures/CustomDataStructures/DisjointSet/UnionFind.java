package DataStructures.CustomDataStructures.DisjointSet;

public interface UnionFind<T> {
    /**
     * Return true if there are no items in any of the disjoint sets.
     */
    boolean isEmpty();

    /**
     * If a new element newItem does not belong to any disjoint set,
     * create a new disjoint set containing only newItem, with newItem as the
     * representative.
     *
     * Otherwise, throw an IllegalArgumentException stating that the disjoint set
     * already contains newItem.
     */
    void makeSet(T newItem);

    /**
     * Return the representative of the disjoint set containing targetItem,
     * or null if targetItem is not in any disjoint set.
     */
    T findSet(T targetItem);

    /**
     * If targetItem1 and targetItem2 exist, create a new disjoint set which contains the
     * union of the elements of the two sets containing targetItem1 and targetItem2, while
     * destroying the two original sets containing targetItem1 and targetItem2.
     *
     * The representative of the disjoint set containing targetItem1 is the representative
     * of the new disjoint set.
     *
     * If targetItem1 and targetItem2 are already in the same disjoint set, this
     * operation has no effect.
     *
     * If one or both of targetItem1 and targetItem2 do not exist, throw an
     * IllegalArgumentException stating that one of targetItem1 and targetItem2 do not
     * exist in the disjoint set.
     */
    void union(T targetItem1, T targetItem2);
}
