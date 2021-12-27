// Without specifying the package name below, the default package becomes the unnamed package,
// which increases the risk of name collisions, especially for larger projects

package Concepts.Easy.Packages;

// Easy version: no import, just specify the full path to both Package classes.

// Slicker version: You could add just one import statement for one version of Package,
// and then assume you automatically have access to the other version of Package.
// If you import both versions of Package, you will get a package naming conflict.
import Concepts.Easy.Packages.package1.Package;
//import Concepts.Easy.Packages.package2.Package;

// Tricky version: Using this will cause problems if you try to import both versions of Package!
// import Concepts.Easy.Packages.*;


public class Packages {
    // Doesn't Concepts.Easy.Packages.package2.* make our code bigger
    // in size because it imports everything?
    //
    // Concepts.Easy.Packages.package2.* is for the developer's convenience
    // The expanded version is for the reader's convenience.
    //
    // It doesn't affect what classes are available to us, it affects what
    // you have to type to be clear about what you're importing.
    // To see why compare the two code snippets below.
    public static void main(String[] args) {
        // Easy version
        Concepts.Easy.Packages.package1.Package p1 = new Concepts.Easy.Packages.package1.Package();
        Concepts.Easy.Packages.package2.Package p2 = new Concepts.Easy.Packages.package2.Package();

        // Slicker version
        Package p3 = new Package(); // This comes from the JavaConcepts.Easy.Packages.package1 package
        Concepts.Easy.Packages.package2.Package p4 = new Concepts.Easy.Packages.package2.Package();
    }
}
