package RefactoringTechniques.EliminateAccumulationMethodUsingACollectingParameter.Before;

import java.util.ArrayList;
import java.util.List;

class ItemBuilder {

    private List<Item> items = new ArrayList<>();

    // Stores the root and parent Item objects for the
    // current Item you are working with so you can
    // add siblings and children based on location in
    // the tree structure
    private Item root;
    private Item current;
    private Item parent;

    ItemBuilder(String rootName) {
        root = new Item(rootName);
        addItemToArrayList(root);

        current = root;
        parent = root;
        root.addItemInformation("Parent", parent.getItemName());
    }

    void addItemInformation(String name, String value) {
        current.addItemInformation(name, value);
    }

    void addChild(String child) {
        Item childNode = new Item(child);
        addItemToArrayList(childNode);

        current.add(childNode);
        parent = current;
        current = childNode;

        // store the parent for the Item project
        childNode.addItemInformation("Parent", parent.getItemName());
    }

    void addSibling(String sibling) {
        Item siblingNode = new Item(sibling);
        addItemToArrayList(siblingNode);

        // add a child node to the parent Item
        parent.add(siblingNode);
        current = siblingNode;

        // store the parent for the Item project
        siblingNode.addItemInformation("Parent", parent.getItemName());
    }

    private void addItemToArrayList(Item newItem) {
        items.add(newItem);
    }

    public String toString() {
        return root.toString();
    }

    void displayAllItems() {
        for (Item item : items) {
            System.out.println(item.getItemName() + ": " + item.displayProductInfo());
        }
    }

    void editThisItem(String itemName) {
        for (Item item: items) {
            if (item.getItemName().equals(itemName)) {
                current = item;

                // Gets the name of the stored parent object
                // and passes it so that parent can be set
                // as the parent in the ItemBuilder
                setItemsParent(current.getItemInformation("Parent"));
            }
        }
    }

    // set the parent Item for ItemBuilder
    private void setItemsParent(String parentItem) {
        for (Item item : items) {
            if (item.getItemName().equals(parentItem)) {
                parent = item;
            }
        }
    }

    // Return the Item based on the name passed into the method
    Item getItemByName(String itemToGet) {
        Item itemToReturn = null;
        for (Item item : items) {
            if (item.getItemName().equals(itemToGet)) {
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
}
