public class Student extends Person implements Cloneable {
    private String previousOrganization;
    private Integer skippedDays;

    public Student(String name, Integer age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        skippedDays = 0;
    }

    public Student() {
        super();
        previousOrganization = "The School of Life";
        skippedDays = 0;
    }

    @Override
    public void getGoal() {
        System.out.println("My goal is to be a junior software developer.");
    }

    @Override
    public void introduce() {
        System.out.println(super.personIntroductionString() + " from " + previousOrganization +
                " who skipped " + skippedDays + " days from the course already.");
    }

    public Integer skipDays(Integer numberOfDays) {
        skippedDays += numberOfDays;
        return skippedDays;
    }

    @Override
    public Student clone() {
        Student student2 = new Student();
        student2.setName(this.getName());
        student2.setAge(this.getAge());
        student2.setGender(this.getGender());
        student2.previousOrganization = this.previousOrganization;
        student2.skippedDays = this.skippedDays;
        return student2;
    }
}
