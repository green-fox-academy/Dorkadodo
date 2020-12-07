public class Sponsor extends Person {
    private String company;
    private Integer hiredStudents;

    public Sponsor(String name, Integer age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        hiredStudents = 0;
    }

    public Sponsor() {
        super();
        company = "Google";
        hiredStudents = 0;
    }

    @Override
    public void introduce() {
        System.out.println(super.personIntroductionString() + " who represents " + company +
                " and hired " + hiredStudents + " students so far.");
    }

    public Integer hire() {
        return ++hiredStudents;
    }

    @Override
    public void getGoal() {
        System.out.println("My goal is to hire brilliant junior software developers.");
    }


}
