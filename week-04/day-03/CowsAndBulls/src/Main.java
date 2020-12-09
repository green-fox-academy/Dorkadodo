public class Main {
    public static void main(String[] args) {
        CAB cab = new CAB();
        cab.startGame();
        System.out.println(cab.getNumberToGuess());
        while(cab.getState().equals("playing")){
            cab.guesses();
        }
    }
}
