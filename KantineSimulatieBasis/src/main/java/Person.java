package main.java;

public class Person {
    String burgerServiceNumber;
    String firstName;
    String lastName;
    Date birthDate;
    char gender;

    public Person (String burgerServiceNumber, String firstName, String lastName, Date birthDate, char gender)
    {
        setBurgerServiceNumber(burgerServiceNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setGender(gender);
    }

    public Person(String burgerServiceNumber, String firstName, String lastName)
    {
        this(burgerServiceNumber, firstName, lastName, new Date(), 'o');
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder()
                .append(burgerServiceNumber)
                .append(", ")
                .append(firstName)
                .append(", ")
                .append(lastName)
                .append(", ")
                .append(getBirthDate())
                .append(", ")
                .append(gender);

        return str.toString();
    }

    public String getBurgerServiceNumber() {
        return burgerServiceNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate.getDatumAsString();
    }

    public String getGender() {
        if (Character.toLowerCase(gender) == 'm')
        {
            return "Male";
        }
        else if (Character.toLowerCase(gender) == 'f')
        {
            return "Female";
        }
        else
        {
            return "Unknown";
        }
    }

    public void setBurgerServiceNumber(String burgerServiceNumber) {
        this.burgerServiceNumber = burgerServiceNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(char gender) {
        if (Character.toLowerCase(gender) == 'm' || Character.toLowerCase(gender) == 'f') {
            this.gender = gender;
        }
        else
        {
            this.gender = 'u';
        }
    }
}
