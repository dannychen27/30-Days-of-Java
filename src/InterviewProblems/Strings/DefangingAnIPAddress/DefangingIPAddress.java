package InterviewProblems.Strings.DefangingAnIPAddress;

public class DefangingIPAddress {

    // Let n = length of the string of the IP address.
    //
    // Time: O(n)
    // --> We must traverse the entire string once.
    // Space: O(n)
    // --> We must store a new string representing the defanged version of the IP address.

    public static void main(String[] args) {
        DefangingIPAddress defangIPaddr = new DefangingIPAddress();

        // Input: address = "0.0.0.0"
        // Output: "0[.]0[.]0[.]0"
        String address1 = "0.0.0.0";
        String defangedIPaddr1 = defangIPaddr.defangIPaddr(address1);
        System.out.println(defangedIPaddr1);  // "0[.]0[.]0[.]0"

        // Input: address = "1.1.1.1"
        // Output: "1[.]1[.]1[.]1"
        String address2 = "1.1.1.1";
        String defangedIPaddr2 = defangIPaddr.defangIPaddr(address2);
        System.out.println(defangedIPaddr2);  // "1[.]1[.]1[.]1"

        // Input: address = "255.100.50.0"
        // Output: "255[.]100[.]50[.]0"
        String address3 = "255.100.50.0";
        String defangedIPaddr3 = defangIPaddr.defangIPaddr(address3);
        System.out.println(defangedIPaddr3);  // "255[.]100[.]50[.]0"
    }

    /**
     * Given a valid (IPv4) IP address, return a defanged version of
     * that IP address.
     *
     * A defanged IP address replaces every period "." with "[.]".
     *
     * Preconditions:
     * - The given address is a valid IPv4 address.
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
