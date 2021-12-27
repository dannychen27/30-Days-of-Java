package Libraries.MathLibrary;

public class MathLibrary {

    public static void main(String[] args) {
        System.out.println(Math.class); // class java.lang.Math

        // mathmatical constants, to 15 decimal places
        System.out.println(Math.E); // 2.718281828459045
        System.out.println(Math.PI); // 3.141592653589793

        // trig functions (uses radians)
        System.out.println(Math.sin(-0.2)); // -0.19866933079506122
        System.out.println(Math.cos(0.5)); // 0.8775825618903728
        System.out.println(Math.tan(-0.43)); // -0.45862102348555517

        System.out.println(Math.asin(1)); // 1.5707963267948966
        System.out.println(Math.acos(0.54)); // 1.0003592173949747
        System.out.println(Math.acos(2)); // NaN, outside of [-1, 1]
        System.out.println(Math.atan(-0.3)); // -0.2914567944778671

        System.out.println(Math.sinh(-0.2)); // -0.20133600254109402
        System.out.println(Math.cosh(-0.2)); // 1.020066755619076
        System.out.println(Math.tanh(0.3)); // 0.2913126124515909

        System.out.println(Math.toDegrees(0.45)); // 25.783100780887047
        System.out.println(Math.toRadians(90)); // 1.5707963267948966

        // arithmetic functions
        System.out.println(Math.sqrt(16)); // 4.0
        System.out.println(Math.cbrt(64)); // 4.0
        System.out.println(Math.abs(-12)); // 12
        System.out.println(Math.exp(2)); // 7.38905609893065
        // for doubles and floats
        System.out.println(Math.getExponent(64)); // 6
        System.out.println(Math.IEEEremainder(5.4, 3.1)); // -0.7999999999999998
        System.out.println(Math.log10(12)); // 1.0791812460476249
        System.out.println(Math.log(Math.E)); // 1.0
        System.out.println(Math.pow(3, 4)); // 81.0
        // for ints and longs
        System.out.println(Math.hypot(3, 4)); // 5.0
        // for all numbers (ints, longs, floats, doubles)
        System.out.println(Math.max(3, 4)); // 4
        System.out.println(Math.min(3, 4)); // 3

        // random
        System.out.println(Math.random()); // some number between [0, 1]
        System.out.println(Math.rint(4.3)); // 4.0
        System.out.println(Math.rint(4.6)); // 5.0
        System.out.println(Math.round(6.501)); // 7
        System.out.println(Math.round(6.499)); // 6

        // floor and ceiling
        // for doubles and floats
        System.out.println(Math.ceil(2.3)); // 3.0
        System.out.println(Math.floor(2.3)); // 2.0
        // for ints and longs
        System.out.println(Math.floorDiv(5, 2)); // 2
        System.out.println(Math.floorMod(5, 2)); // 1

        // other utility math functions
        System.out.println(Math.copySign(4, -2)); // -4.0
        System.out.println(Math.copySign(-4, 2)); // 4.0
        System.out.println(Math.signum(-90)); // -1.0
        System.out.println(Math.signum(0)); // -0.0
        System.out.println(Math.signum(90)); // 1.0
        // eliminates rounding errors, works only for ints and longs
        System.out.println(Math.addExact(5, 4)); // 9
        System.out.println(Math.subtractExact(5, 4)); // 1
        System.out.println(Math.multiplyExact(5, 4)); // 20
        System.out.println(Math.negateExact(-43)); // 43
        System.out.println(Math.decrementExact(9)); // 8
        System.out.println(Math.incrementExact(9)); // 10
        System.out.println(Math.toIntExact((long) 6.5)); // 6
    }
}
