package RefactoringTechniques.ReplaceConditionalsWithCommandPattern.After;

import java.util.ArrayList;
import java.util.List;

class CustomerGroup {

    List<BillPayer> customers;

    CustomerGroup() {
        customers = new ArrayList<>();
    }

    public void add(BillPayer newPayer) {
        customers.add(newPayer);
    }

    public BillPayer get(int customerIndex) {
        return customers.get(customerIndex);
    }
}
