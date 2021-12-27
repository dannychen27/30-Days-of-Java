package RefactoringTechniques.EliminateAccumulationMethodUsingACollectingParameter.After;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item {

    private Map<String, String> itemInfoHM;
    private String itemName = "";
    private List<Item> children = new ArrayList<>();

    String getItemName() {
        return itemName;
    }

    private void setItemName(String newItemName) {
        itemName = newItemName;
    }

    Item(String itemName) {
        setItemName(itemName);
        itemInfoHM = new HashMap<>(20);
    }

    public void add(Item childNode) {
        children.add(childNode);
    }

    void addItemInformation(String infoName, String info) {
        itemInfoHM.put(infoName, info);
    }

    String getItemInformation(String infoName) {
        return itemInfoHM.get(infoName);
    }

    public String toString() {
        StringBuffer itemInfo = new StringBuffer();
        addItemInfoAndChildren(itemInfo);
        return itemInfo.toString();
    }

    private void addItemInfoAndChildren(StringBuffer itemInfo) {
        itemInformation(itemInfo);
        addChildrenInformation(itemInfo);
    }

    private void itemInformation(StringBuffer itemInfo) {
        itemInfo.append("\n" + itemName + " ");
        if (!itemInfoHM.isEmpty()) {
            itemInfo.append(displayProductInfo());
        }
    }

    private void addChildrenInformation(StringBuffer itemInfo) {
        for (Item node : children) {
            itemInfo.append(node.toString());
        }
    }

    String displayProductInfo() {
        String productInfo = "";
        for (Map.Entry<String, String> entry : itemInfoHM.entrySet()) {
            productInfo += entry.getKey() + ": " + entry.getValue() + " ";
        }
        return productInfo;
    }

    public static void main(String[] args) {
        // Create root
        ItemBuilder products = new ItemBuilder("Products");

        // Add children and their info
        products.addChild("Produce");
        products.addChild("Orange");
        products.addItemInformation("Price", "$1.00");
        products.addItemInformation("Stock", "100");

        // Add siblings
        products.addSibling("Apple");
        products.addSibling("Grapes");

        // Change the current Item to the Root of the tree
        products.editThisItem("Products");

        products.addChild("Cereal");
        products.addChild("Special K");
        products.addItemInformation("Price", "$4.00");
        products.addSibling("Raisin Bran");
        products.addItemInformation("Price", "$4.00");

        products.editThisItem("Apple");
        products.addItemInformation("Price", "$0.25");
        products.editThisItem("Cereal");
        products.addChild("Fiber One");
        products.addItemInformation("Price", "$4.00");

        products.displayAllItems();

        // Print information on just the Cereal Item and its children
        System.out.println("\n" + products.getItemByName("Cereal"));
    }
}
