package InterviewProblems.Strings.GoalParserInterpretation.StringBuilders;

public class GoalParserInterpretation {

    // Let n = the length of the command string
    //
    // Time: O(n)
    // --> We must iterate through the entire string once.
    // Space: O(n)
    // --> We must store a new interpreted string.

    public static void main(String[] args) {
        GoalParserInterpretation goalParserInterpretation = new GoalParserInterpretation();

        // Input: command = "G()(al)"
        // Output: "Goal"
        // Explanation: The Goal Parser interprets the command as follows:
        // G -> G
        // () -> o
        // (al) -> al
        // The final concatenated result is "Goal".
        String command1 = "G()(al)";
        String interpret1 = goalParserInterpretation.interpret(command1);
        System.out.println(interpret1);  // Goal

        // Input: command = "G()()()()(al)"
        // Output: "Gooooal"
        // Explanation: The Goal Parser interprets the command as follows:
        // G -> G
        // () -> o
        // () -> o
        // () -> o
        // () -> o
        // (al) -> al
        // The final concatenated result is "Gooooal".
        String command2 = "G()()()()(al)";
        String interpret2 = goalParserInterpretation.interpret(command2);
        System.out.println(interpret2);  // Gooooal

        // Input: command = "(al)G(al)()()G"
        // Output: "alGalooG"
        // Explanation: The Goal Parser interprets the command as follows:
        // (al) -> al
        // G -> G
        // (al) -> al
        // () -> o
        // () -> o
        // G -> G
        // The final concatenated result is "alGalooG".
        String command3 = "(al)G(al)()()G";
        String interpret3 = goalParserInterpretation.interpret(command3);
        System.out.println(interpret3);  // alGalooG
    }

    /**
     * You own a Goal Parser that can interpret a string command.
     * The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
     * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)"
     * as the string "al". The interpreted strings are then concatenated in the original order.
     *
     * Given the string command, return the Goal Parser's interpretation of command.
     *
     * Preconditions:
     * - 1 <= command.length <= 100.
     * - command consists of "G", "()", and/or "(al)" in some order.
     */
    public String interpret(String command) {
        StringBuilder interpretedString = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            char currentChar = command.charAt(i);
            char nextChar;
            if (i + 1 < command.length()) {
                nextChar = command.charAt(i + 1);
            } else {
                nextChar = ' ';
            }

            if (currentChar == 'G') {
                interpretedString.append("G");
                i++;
            } else if (currentChar == '(' && nextChar == ')') {
                interpretedString.append("o");
                i += 2;
            } else {  // currentChar == '(' && nextChar == 'a'
                interpretedString.append("al");
                i += 4;
            }
        }
        return interpretedString.toString();
    }
}
