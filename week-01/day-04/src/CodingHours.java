public class CodingHours {
    public static void main(String[] args) {
        int dailyCoding = 6;
        int semesterWeeks = 17;
        int workdaysAWeek = 5;

        int resultHours = dailyCoding * semesterWeeks * workdaysAWeek;
        System.out.println(resultHours + " hours is spent with coding in a semester by an attendee, " +
                "if the attendee only codes on workdays.");
        double avarage = ((double) workdaysAWeek * dailyCoding) / 52 * 100;

        System.out.println("The average coding hours " +
                " of all the work hours during a semester is " + avarage + "%");


    }
}
