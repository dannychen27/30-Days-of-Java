package Constructs.Easy.BitwiseOperators;

public class BitwiseOperators {

    public static void main(String[] args) {
        // bitwise operators in Java return a boolean value:
        // - &, bitwise and
        // - |, bitwise or
        // - ^, bitwise (exclusive) or -- xor
        // - >>, right shift -- like floor division by 2
        // - <<, left shift -- like multiplication by 2 (until you shift all 1's into the void)
        // todo: is it possible to do bitwise math with doubles?

        // 5 == 101
        // 4 == 100
        System.out.println(5 & 4); // 101 & 100 == 100 = 4 in decimal
        System.out.println(5 | 4); // 101 | 100 == 101 = 5 in decimal
        System.out.println(5 ^ 4); // 101 ^ 100 == 001 = 1 in decimal

        // 8 == 1000
        // 0 == 0000
        System.out.println(8 & 8); // 1000 & 1000 == 1000 = 8 in decimal
        System.out.println(8 | 8); // 1000 | 1000 == 1000 = 8 in decimal
        System.out.println(8 ^ 8); // 1000 ^ 1000 == 0000 = 0 in decimal

        // 1000 == 1111101000
        // 990 == 1111011110
        System.out.println(1000 & 990); // 1111101000 & 1111011110 == 1111001000 = 968 in decimal
        System.out.println(1000 | 990); // 1111101000 | 1111011110 == 1111111110 = 1022 in decimal
        System.out.println(1000 ^ 990); // 1111101000 ^ 1111011110 == 0000110110 = 54 in decimal

        // 4 == 100
        // 5 == 101
        System.out.println(4 << 1); // 000100 << 1 == 001000 = 8 in decimal
        System.out.println(4 << 2); // 000100 << 2 == 010000 = 16 in decimal
        System.out.println(4 << 3); // 000100 << 3 == 100000 = 32 in decimal

         int i = 4;
         while (i != 0) {
              i = i << 1;
              System.out.println(i);
              // this goes all the way up to 2^30 == 1,073,741,824,
              // then goes back down to -2,147,483,648, then 0
         }

        long j = 4;
        while (j != 0) {
            j = j << 1;
            System.out.println(j);
            // this goes all the way up to 2^62 == 4,611,686,018,427,387,904,
            // then goes back down to -9,223,372,036,854,775,808, then 0
        }

        // System.out.println(4 >> 1); // 000100 >> 1 == 000010 = 2 in decimal
        // System.out.println(4 >> 2); // 000100 >> 2 == 000001 = 1 in decimal
        // System.out.println(4 >> 3); // 000100 >> 3 == 000000 = 0 in decimal
    }
}
