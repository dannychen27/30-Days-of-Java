package Concepts.Medium.PassByReferenceAndValue;

import java.util.ArrayList;
import java.util.List;

class Counter {
    List<Counter> partners = new ArrayList<>();

    Counter() {

    }

    void increment(int x) {
        x++;
    }

    void decrement(int x) {
        x--;
    }

    void addPartner(Counter newPartner) {
        partners.add(newPartner);
    }

    void removePartner(Counter oldPartner) {
        partners.remove(oldPartner);
    }
}
