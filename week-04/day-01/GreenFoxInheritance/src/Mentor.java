public class Mentor extends Person {
    private String level;

    public Mentor(String name, Integer age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
        super();
        this.level = "intermediate";
    }

    @Override
    public void getGoal() {
        System.out.println("My goal is to educate brilliant junior software developers.");
    }

    @Override
    public void introduce() {
        System.out.println(super.personIntroductionString() + " " + level + " mentor.");
    }

}
