import java.util.List;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(10);
        table.generateTable();
        table.printTable();
        List<List<Tiles>> tableArray = table.getTable();


        table.getCorrectTable();


    }


}
