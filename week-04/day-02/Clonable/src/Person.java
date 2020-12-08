public class Person {
    private String name;
    private Integer age;
    private String gender;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        name = "Jane Doe";
        age = 30;
        gender = "female";
    }

    protected String getName() {
        return name;
    }

    protected Integer getAge() {
        return age;
    }

    protected String getGender() {
        return gender;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setAge(Integer age) {
        this.age = age;
    }

    protected void setGender(String gender) {
        this.gender = gender;
    }

    protected String personIntroductionString() {
        return "Hi, I'm " + name + ", a " + age + " year old " + gender;
    }

    protected void introduce() {
        System.out.println(personIntroductionString());
    }

    protected void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

}