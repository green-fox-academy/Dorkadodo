public class ShiftedCharSequence implements CharSequence {
    private String line;
    private int toShift;

    public ShiftedCharSequence(String line, int toShift) {
        this.line = line;
        this.toShift = toShift;
    }

    @Override
    public int length() {
        return line.length();
    }

    @Override
    public char charAt(int index) {
        return line.charAt(index+toShift);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return line.substring(start+toShift, end+toShift);
    }
}
