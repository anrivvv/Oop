package VERSION6;

import java.util.Objects;

public final class Name implements Cloneable {
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
        this.firstName = requireName(firstName);
        this.middleName = Objects.requireNonNull(middleName, "middleName cannot be null; use an empty string if absent.").trim();
        this.lastName = requireName(lastName);
        this.suffix = Objects.requireNonNull(suffix, "suffix cannot be null; use an empty string if absent.").trim();
    }

    private static String requireName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        return value.trim();
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getSuffix() { return suffix; }
    public void setFirstName(String firstName) { this.firstName = requireName(firstName); }
    public void setMiddleName(String middleName) { this.middleName = Objects.requireNonNull(middleName, "middleName cannot be null; use an empty string if absent.").trim(); }
    public void setLastName(String lastName) { this.lastName = requireName(lastName); }
    public void setSuffix(String suffix) { this.suffix = Objects.requireNonNull(suffix, "suffix cannot be null; use an empty string if absent.").trim(); }

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
