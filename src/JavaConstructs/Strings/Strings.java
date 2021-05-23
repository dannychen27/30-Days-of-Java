package JavaConstructs.Strings;

public class Strings {

    public static void main(String[] args) {
        String message = "I like diffusers";
        System.out.println(message);  // I like diffusers

        // string access methods
        System.out.println(message.length());  // 16
        System.out.println(message.indexOf('l'));  // 2
        System.out.println(message.lastIndexOf('s')); // 15

        // string membership methods
        System.out.println(message.contains("diffusers")); // true
        System.out.println(message.isEmpty()); // false
        System.out.println(message.startsWith("I"));  // true
        System.out.println(message.startsWith("like", 2)); // true
        System.out.println(message.endsWith("s"));  // true

        // string concatenation
        String message2 = " more";
        System.out.println(message.concat(message2));  // I like diffusers more

        // String search methods
        System.out.println(message.charAt(0));       // I
        System.out.println(message.indexOf("l"));    // 2

        // String casting
        String message3 = "144";
        int message3Stringified = Integer.valueOf(message3);
        System.out.println(message3Stringified);  // 144

        double message4 = 150.0;
        String message4Stringified = Double.toString(message4);
        System.out.println(message4Stringified); // 150.0

        // more string equality methods
        System.out.println(message.matches("^ $"));  // false, regex matches ... ?
        System.out.println(message.equalsIgnoreCase("I LiKe DiFfUsErS"));  // true

        // string copy methods
        String[] splittedMessage = message.split(" ");
        for (String word : splittedMessage) {
            System.out.println(word); // I, like, diffusers
        }

        String subMessage = message.substring(2);  // like diffusers
        System.out.println(subMessage);
        String subMessage2 = message.substring(2, 10); // like dif
        System.out.println(subMessage2);

        // String mutation methods
        System.out.println(message.toUpperCase());   // "I LIKE DIFFUSERS"
        System.out.println(message.toLowerCase());   // "i like diffusers"

        String message5 = message.replace("like", "LOVE");
        System.out.println(message5);  // I LOVE diffusers

        String message6 = message.replaceFirst("f", "F");
        System.out.println(message6);  // I like diFfusers

        String message7 = message.replaceAll("f", "F");
        System.out.println(message7);  // I like diFFusers

        // TODO: - regionMatches()
        String message8 = "";
        String message9 = "";

        String message10 = String.format("I love %s", "~");
        System.out.println(message10);  // I love ~

        String message11 = "     I   like   diffusers     ";
        System.out.println(message11.trim()); // I like diffusers (without surrounding whitespace)
    }
}
