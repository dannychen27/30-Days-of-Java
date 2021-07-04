package SoftwareTesting.TestDrivenDevelopment.GatheringRequirements;

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
        // TODO: what happens if a customer buys out your entire stock of targetCD?
    }

    public HashMap<CompactDisc, Integer> searchCatalogue(String targetName, String targetArtist) {
        HashMap<CompactDisc, Integer> matchingCDsToStock = new HashMap<>();

        // if the user doesn't specify any specific target CD name or target CD artist,
        // simply return the CD information for every CD in the catalogue.
        if (targetName == null && targetArtist == null) {
            for (Map.Entry<CompactDisc, Integer> catalogueEntry : catalogue.entrySet()) {
                matchingCDsToStock.put(catalogueEntry.getKey(), catalogueEntry.getValue());
            }
            return matchingCDsToStock;
        }

        for (Map.Entry<CompactDisc, Integer> catalogueEntry : catalogue.entrySet()) {
            CompactDisc currentCD = catalogueEntry.getKey();

            // you can match on just the CD artist if the target CD's name does not exist.
            if (targetName == null && currentCD.equalsCDArtist(targetArtist)) {
                matchingCDsToStock.put(currentCD, catalogue.get(currentCD));
                continue;
            }

            // you can match on just the CD name if target CD's artist does not exist.
            if (targetArtist == null && currentCD.equalsCDName(targetName)) {
                matchingCDsToStock.put(currentCD, catalogue.get(currentCD));
                continue;
            }

            // ... or you can match on the entire CD if both the target name and target artist exists.
            if (currentCD.equals(targetName, targetArtist)) {
                matchingCDsToStock.put(currentCD, catalogue.get(currentCD));
            }
        }
        return matchingCDsToStock;
    }

    public void receiveCDStock(CompactDisc targetCD, int quantity) {
        if (!catalogue.containsKey(targetCD)) {
            catalogue.put(targetCD, quantity);
        } else {  // catalogue.containsKey(targetCD)
            int stock = getStock(targetCD);
            catalogue.replace(targetCD, stock + quantity);
        }
    }

    public static void main(String[] args) {
        CompactDisc highwayToNowhere = new CompactDisc("Highway to Nowhere", "Drake Bell");
        CompactDisc soulMan = new CompactDisc("Soul Man", "Drake Bell");
        Library library = new Library();
        library.receiveCDStock(highwayToNowhere, 10);
        library.receiveCDStock(soulMan, 10);
        System.out.println(library.getStock(highwayToNowhere));  // 10
        System.out.println(library.searchCatalogue(null, "Drake Bell"));  // {"Soul Man" by Drake Bell=10, "Highway to Nowhere" by Drake Bell=10}

        library.receiveCDStock(highwayToNowhere, 5);
        System.out.println(library.getStock(highwayToNowhere));  // 15
        System.out.println(library.searchCatalogue(null, "Drake Bell"));  // {"Soul Man" by Drake Bell=10, "Highway to Nowhere" by Drake Bell=15}
    }
}
