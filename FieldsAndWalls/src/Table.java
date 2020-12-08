import java.util.*;

public class Table {
    private int numberOfRowsAndColumns;
    private List<List<Tiles>> table;
    private int counterOfCheckedFields;

    public Table(int numberOfRowsAndColumns) {
        table = new ArrayList<List<Tiles>>();
        this.numberOfRowsAndColumns = numberOfRowsAndColumns;
    }

    public void printTable() {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.size(); j++) {
                System.out.print(table.get(i).get(j).getType());
            }
            System.out.println();
        }
    }

    public List<List<Tiles>> getTable() {
        return table;
    }

    public int getCounterOfCheckedFields() {
        return counterOfCheckedFields;
    }

    public List<List<Tiles>> generateTable() {
        Random random = new Random();
        for (int i = 0; i < numberOfRowsAndColumns; i++) {
            List<Tiles> row = new ArrayList<Tiles>();
            for (int j = 0; j < numberOfRowsAndColumns; j++) {
                Tiles tile;
                if (1 < random.nextInt(10)) {
                    tile = new Field();
                } else {
                    tile = new Wall();
                }
                row.add(tile);
            }
            table.add(row);
        }
        return table;
    }

    public void getCorrectTable() {
        while (!(isTheTableCorrect())) {
            int[] indexOfField = firstNotCheckedField();
            Tiles tile = new Field();
            if (isValidTile(indexOfField[0], indexOfField[1] - 1)) {
                table.get(indexOfField[0]).set(indexOfField[1] - 1, tile);
            } else {
                table.get(indexOfField[0] - 1).set(indexOfField[1], tile);
            }
            floodFillCheck();
            printTable();                            //for testing
            System.out.println();
            System.out.println(isTheTableCorrect());
            System.out.println("CounterOfCheckedFields: " + getCounterOfCheckedFields());
            System.out.println("Fields: " + numberOfFields());
        }
    }

    private int[] firstNotCheckedField() {
        int[] indexOfField = {-1, -1};
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(0).size(); j++) {
                if (!(table.get(i).get(j).getWasChecked())) {
                    if (!(table.get(i).get(j).getType().equals("Wall"))) {
                        indexOfField[0] = i;
                        indexOfField[1] = j;
                        return indexOfField;
                    }
                }
            }
        }
        return indexOfField;
    }

    public int numberOfFields() {
        int numberOfFields = 0;
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(0).size(); j++) {
                if (table.get(i).get(j).getType().equals("Field")) {
                    numberOfFields++;
                }
            }
        }
        return numberOfFields;
    }

    public boolean isTheTableCorrect() {
        if (floodFillCheck() == numberOfFields()) {
            return true;
        }
        return false;
    }

    public int floodFillCheck() {
        setCheckedStatusToZero();
        Tiles tile = new Field();
        table.get(0).set(0, tile);
        counterOfCheckedFields = 0;
        continueToNextField(0, 0);
        return counterOfCheckedFields;
    }

    private void setCheckedStatusToZero() {
        for (int i = 0; i < table.size(); i++) {
            for (int j = 0; j < table.get(0).size(); j++) {
                table.get(i).get(j).setWasChecked(false);
            }
        }
    }

    private boolean isFreeField(int i, int j) {
        if (isValidTile(i, j)) {
            if (!(table.get(i).get(j).getWasChecked()) && (table.get(i).get(j).getType()).equals("Field")) {
                return true;
            }
        }
        return false;

    }

    private boolean isValidTile(int i, int j) {
        if ((j >= 0) && ((j) < numberOfRowsAndColumns) && (i >= 0) && ((i) < numberOfRowsAndColumns)) {
            return true;
        }
        return false;
    }


    private void continueToNextField(int i, int j) {
        table.get(i).get(j).setWasChecked(true);
        counterOfCheckedFields += 1;
        if (!(isFreeField(i, j - 1) || isFreeField(i, j + 1)
                || isFreeField(i + 1, j) || isFreeField(i - 1, j))) {
        }
        if (isFreeField(i, j - 1)) {
            continueToNextField(i, j - 1);
        }
        if (isFreeField(i, j + 1)) {
            continueToNextField(i, j + 1);
        }
        if (isFreeField(i + 1, j)) {
            continueToNextField(i + 1, j);
        }
        if (isFreeField(i - 1, j)) {
            continueToNextField(i - 1, j);
        }
    }


}
