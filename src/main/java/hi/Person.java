package hi;

public class Person {
    final private static int AGE_LIMIT = 18;

    private String firstName;
    private String lastName;
    private int age;

    /**
     * @param firstName - first name of the person
     * @param lastName - last name of the person
     * @param age - age of the person in number
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person makePerson(Person that, String firstName) throws UnderAgeException {
        if (this.age < AGE_LIMIT || that.age < AGE_LIMIT) {
            throw new UnderAgeException();
        }
        return new Person(firstName, this.getLastName(), 0);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName + ", " + age;
    }
}
