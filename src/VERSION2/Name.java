package VERSION2;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    //Default Constructor
    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    //Partial Constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "N/A";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    //Full Constructor
    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSuffix() {
        return suffix;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    public void displayName() {
        System.out.println("Name: " + this);
    }

    @Override
    public String toString() {
        String middle = middleName == null || middleName.isEmpty() || middleName.equals("N/A")
                ? "" : " " + middleName.charAt(0) + ".";
        String ending = suffix == null || suffix.isEmpty() ? "" : " " + suffix;
        return lastName + ", " + firstName + middle + ending;
    }       
}
