package InterviewProblems.Hashmaps.UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    // Let n = the number of characters across all email addresses
    //
    // Time: O(n)
    // - We must go through every character from every email to determine unique email addresses
    // Space: O(n)
    // - We may need to store all email addresses if they are all unique.

    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();

        // Input: emails = ["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]
        // Output: 2
        // Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
        String[] emails1 = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int numUniqueEmails1 = uniqueEmailAddresses.numUniqueEmails(emails1);
        System.out.println(numUniqueEmails1);  // 2

        // Input: emails = ["a@leetcode.com", "b@leetcode.com", "c@leetcode.com"]
        // Output: 3
        String[] emails2 = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        int numUniqueEmails2 = uniqueEmailAddresses.numUniqueEmails(emails2);
        System.out.println(numUniqueEmails2);  // 3
    }

    /**
     * Every valid email consists of a local name and a domain name, separated by the '@' sign.
     * Besides lowercase letters, the email may contain one or more '.' or '+'.
     *
     * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the
     * domain name.
     *
     * If you add periods '.' between some characters in the local name part of an email address,
     * mail sent there will be forwarded to the same address without dots in the local name.
     * Note that this rule does not apply to domain names.
     *
     * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
     * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
     * This allows certain emails to be filtered. Note that this rule does not apply to domain names.
     *
     * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
     * It is possible to use both of these rules at the same time.
     *
     * Given an array of strings emails where we send one email to each emails[i],
     * return the number of different addresses that actually receive mails.
     *
     * Preconditions:
     * - 1 <= emails.length <= 100
     * - 1 <= emails[i].length <= 100
     * - emails[i] consist of lowercase English letters, '+', '.' and '@'.
     * - Each emails[i] contains exactly one '@' character.
     * - All local and domain names are non-empty.
     * - Local names do not start with a '+' character.
     * - Domain names end with the ".com" suffix.
     */
    public int numUniqueEmails(String[] emails) {
        // With hashmaps
        // Map<String, Integer> emailsToFrequencies = new HashMap<>();
        // for (String emailAddress : emails) {
        //     String parsedEmail = parseEmailAddress(emailAddress);
        //     emailsToFrequencies.put(parsedEmail, emailsToFrequencies.getOrDefault(parsedEmail, 0) + 1);
        // }
        // return emailsToFrequencies.size();

        // OR equivalently...

        // With hashsets
        Set<String> emailsToFrequencies = new HashSet<>();
        for (String emailAddress : emails) {
            String parsedEmail = parseEmailAddress(emailAddress);
            emailsToFrequencies.add(parsedEmail);
        }
        return emailsToFrequencies.size();
    }

    private String parseEmailAddress(String emailAddress) {
        StringBuilder parsedEmailAddress = new StringBuilder();

        // parse local name (everything before the @)
        int i = 0;
        while (emailAddress.charAt(i) != '@') {
            char currentChar = emailAddress.charAt(i);
            if (currentChar == '.') {
                // skip over the '.' character
                i++;
            } else if (currentChar == '+') {
                // skip over all characters between '+' and '@'
                do {
                    i++;
                } while (emailAddress.charAt(i) != '@');
            } else {
                parsedEmailAddress.append(currentChar);
                i++;
            }
        }

        parsedEmailAddress.append('@');
        i++;

        // parse domain name (everything after the @)
        while (i < emailAddress.length()) {
            parsedEmailAddress.append(emailAddress.charAt(i));
            i++;
        }

        return parsedEmailAddress.toString();
    }
}
