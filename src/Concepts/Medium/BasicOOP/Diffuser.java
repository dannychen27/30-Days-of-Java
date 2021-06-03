package Concepts.Medium.BasicOOP;

// OOP lets us create classes (custom types)
// Diffuser is a class
// All code must belong inside the class
// An object is an instance of a class
// Every class extends Object
class Diffuser {
    // name is an attribute
    // we can associate different variable names with different objects

    // We want to assign access modifiers based on the principle of least privilege:
    // only provide the least amount of access necessary for the object to do its job
    // properly.
    String name;
    boolean onStatus;

    // The default constructor is used if a more specific constructor
    // is not already defined.
    Diffuser() { }

    // We can use the diffuser class as a template, think of it as
    // a diffuser maker that lets you create lots of diffuser objects
    Diffuser(String name) {
        this.name = name;
        this.onStatus = false;
    }

    // getters and setters restrict access to instance variables
    // and provide users with a consistent interface with working with objects.
    void setName(String name) {
        // notice we cannot write name = name since it's unclear whether name is an
        // attribute or a parameter to this method.
        // The "this" keyword disambiguates by referring to the object itself.
        // So this.name is the instance attribute and name is the parameter of this method.
        this.name = name;
    }

    // setters allow you to do more than just set variable values.
    // e.g. you could check if isOn is a valid state, or if its age is >= 0, and throw an error otherwise,
    // you could add a print statement that says "Successfully set attribute value to ______."
    void setOn(boolean isOn) {
        // Java variable names follow camelCase (first lowercase word, followed by capitalized words)
        // instead of Python or C's pothole_case/snake_case (multiple words separated by underscores)
        onStatus = isOn;
    }

    // likewise, getters let you customize how you obtain the value of an instance attribute
    String getName() {
        return name;
    }

    boolean getOnStatus() {
        return onStatus;
    }
}
