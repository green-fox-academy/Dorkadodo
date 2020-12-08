public class Gnirts implements CharSequence {
    private String line;

    public Gnirts(String line) {
        this.line = line;
    }

    @Override
    public int length() {
        return line.length();
    }

    @Override
    public char charAt(int index) {
        return line.toCharArray()[(line.toCharArray().length) - (index)];
    }

    @Override
    public String toString() {
        String reverseLine = "";
        for (int i = 0; i < line.length(); i++) {
            reverseLine += line.toCharArray()[line.length() - i - 1];
        }
        return reverseLine;
    }

    @Override
    public Gnirts subSequence(int start, int end) {
        String subLine = line.toString();
        subLine = subLine.substring(start, end);
        Gnirts gnirts = new Gnirts(subLine);
        return gnirts;
    }
}
