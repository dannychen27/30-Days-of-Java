package JavaDataStructures.MapsFramework.Hashmap;

import java.util.HashMap;

public class Hashmaps {

    public static void main(String[] args) {
        // - Notice that the type annotations of the keys and values are objects,
        // so you must autobox any primitive types.
        // - Because hashing allows us to store key-value pairs non-contiguously, hashmap key-value
        // pairs are not necessarily sorted.

        // creating a new hashmap
        HashMap<String, String> diffusersToPrices = new HashMap<>();

        // add items to hashmap
        diffusersToPrices.put("lavender", "$9.99");
        diffusersToPrices.put("sweet orange", "$12.99");
        diffusersToPrices.put("lemongrass", "$5.99");
        System.out.println(diffusersToPrices);  // {lavender=$9.99, sweet orange=$12.99, lemongrass=$5.99} -- more or less

        // check membership in hashmap
        System.out.println(diffusersToPrices.containsKey("lavender"));   // true
        System.out.println(diffusersToPrices.containsKey("$9.99"));      // false, is a value but not a key
        System.out.println(diffusersToPrices.containsValue("$9.99"));    // true
        System.out.println(diffusersToPrices.containsValue("lavender")); // false, is a key but not a value

        // get items in hashmap
        System.out.println(diffusersToPrices.size());  // 3
        System.out.println(diffusersToPrices.keySet()); // [lavender, sweet orange, lemongrass] -- more or less
        System.out.println(diffusersToPrices.values()); // [$9.99, $12.99, $5.99] -- more or less
        System.out.println(diffusersToPrices.get("lavender"));  // $9.99
        System.out.println(diffusersToPrices.getOrDefault("jasmine", "$3.99")); // $3.99

        // set items in hashmap
        diffusersToPrices.replace("lavender", "$4.99");
        System.out.println(diffusersToPrices);  // {lavender=$4.99, sweet orange=$12.99, lemongrass=$5.99} -- more or less

        // traversing items in hashmap
        for (String diffuserScent : diffusersToPrices.keySet()) {  // iterate through keys
            System.out.println(diffuserScent); // lavender, sweet orange, lemongrass --- more or less
        }

        for (String price : diffusersToPrices.values()) {  // iterate through values
            System.out.println(price);  // $9.99, $12.99, $5.99 -- more or less
        }

        for (String diffuserScent : diffusersToPrices.keySet()) {  // print keys and values at the same time
            System.out.println("Diffuser Scent: " + diffuserScent);
            System.out.println("Price: " + diffusersToPrices.get(diffuserScent));
            // Diffuser Scent: lavender -- more or less
            // Price: $4.99
            // Diffuser Scent: lemongrass
            // Price: $5.99
            // Diffuser Scent: sweet orange
            // Price: $12.99
        }

        // remove items from hashmap
        System.out.println(diffusersToPrices.remove("lavender", "$4.99")); // true
        System.out.println(diffusersToPrices);  // {sweet orange=$12.99, lemongrass=$5.99} -- more or less
        diffusersToPrices.remove("lemongrass");
        System.out.println(diffusersToPrices);  // {sweet orange=$12.99} -- more or less
        diffusersToPrices.clear();
        System.out.println(diffusersToPrices);  // {}
    }
}
