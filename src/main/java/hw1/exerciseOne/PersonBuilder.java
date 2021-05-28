package hw1.exerciseOne;

public class PersonBuilder implements Builder{

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    @Override
    public Builder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public Builder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public Builder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public Builder setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Builder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public Builder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Person build(){
        Person person = new Person(firstName, lastName, middleName, country, address, phone, age, gender);
        return person;
    }
}
