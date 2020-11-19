public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        System.out.println("The current time is " + currentHours + " h " + currentMinutes + " min " + currentSeconds + " s");
        int remainingSec = (24*60*60)-(14*60*60+34*60+42);
        System.out.println("Remaining seconds from this day: " + remainingSec);
    }
}