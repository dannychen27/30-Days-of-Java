package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<CompactDisc, Integer> catalogue;

    public Library() {
        catalogue = new HashMap<>();
    }

    public int getStock(CompactDisc targetCD) {
        return catalogue.get(targetCD);
    }

    public void buy(CompactDisc targetCD, int quantity) throws InsufficientStockException {
        int stock = getStock(targetCD);
        if (stock < quantity) {
            throw new InsufficientStockException();
        }
        catalogue.replace(targetCD, stock - quantity);
    }

    public ArrayList<CompactDisc> searchCatalogue(CompactDisc targetCD) {
        ArrayList<CompactDisc> matches = new ArrayList<>();
        for (Map.Entry<CompactDisc, Integer> catalogueEntry : catalogue.entrySet()) {
            CompactDisc currentCD = catalogueEntry.getKey();
            if (currentCD.equals(targetCD)) {
                matches.add(currentCD);
            }
        }
        return matches;
    }

    public void addToCatalogue(CompactDisc targetCD, int quantity) {
        if (!catalogue.containsKey(targetCD)) {
            catalogue.put(targetCD, quantity);
        } else {  // catalogue.containsKey(targetCD)
            int stock = getStock(targetCD);
            catalogue.replace(targetCD, stock + quantity);
        }
    }
}
