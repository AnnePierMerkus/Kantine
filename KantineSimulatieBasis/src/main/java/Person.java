package main.java;

/**
 * The type Person.
 */
public class Person {
    /**
     * The Burger service number.
     */
    String burgerServiceNumber;
    /**
     * The First name.
     */
    String firstName;
    /**
     * The Last name.
     */
    String lastName;
    /**
     * The Birth date.
     */
    Date birthDate;
    /**
     * The Gender.
     */
    char gender;

    /**
     * Instantiates a new Person.
     *
     * @param burgerServiceNumber the burger service number
     * @param firstName           the first name
     * @param lastName            the last name
     * @param birthDate           the birth date
     * @param gender              the gender
     */
    public Person (String burgerServiceNumber, String firstName, String lastName, Date birthDate, char gender)
    {
        setBurgerServiceNumber(burgerServiceNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setGender(gender);
    }

    /**
     * Instantiates a new Person.
     *
     * @param burgerServiceNumber the burger service number
     * @param firstName           the first name
     * @param lastName            the last name
     */
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

    /**
     * Gets burger service number.
     *
     * @return the burger service number
     */
    public String getBurgerServiceNumber() {
        return burgerServiceNumber;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthDate.getDatumAsString();
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
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

    /**
     * Sets burger service number.
     *
     * @param burgerServiceNumber the burger service number
     */
    public void setBurgerServiceNumber(String burgerServiceNumber) {
        this.burgerServiceNumber = burgerServiceNumber;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
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
