package VERSION5;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() { this("N/A", "", "N/A", ""); }
    public Name(String firstName, String lastName) { this(firstName, "", lastName, ""); }
    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }
    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getSuffix() { return suffix; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSuffix(String suffix) { this.suffix = suffix; }

    public void displayName() { System.out.println("Name: " + this); }

    @Override
    public String toString() {
        String middle = middleName == null || middleName.isBlank()
                ? "" : " " + middleName.charAt(0) + ".";
        String ending = suffix == null || suffix.isBlank() ? "" : " " + suffix;
        return lastName + ", " + firstName + middle + ending;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name other)) return false;
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(middleName, other.middleName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(suffix, other.suffix);
    }

    @Override
    public int hashCode() { return Objects.hash(firstName, middleName, lastName, suffix); }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
