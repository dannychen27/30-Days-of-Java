package Concepts.Hard.Generics;

import java.util.Objects;

public class Person {
    private String email;
    private String fullName;

    Person(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    Person() {}

    @Override
    public int hashCode() {
        return Objects.hash(email, fullName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;

        // check attribute values for equality
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }

        if (fullName == null) {
            if (other.fullName == null) {
                return false;
            }
        } else if (!fullName.equals(other.fullName)) {
            return false;
        }

        return true;
    }
}
