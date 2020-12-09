import java.util.ArrayList;
import java.util.List;

public class Sum {
    List<Integer> numbers;
    public Sum (){
        numbers = new ArrayList<>();
    }

    public void addNumber (Integer number){
        if (number == null){
            throw new NullPointerException();
        }
        numbers.add(number);
    }

    public Integer sumOfNumbers (){
        Integer sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum+=numbers.get(i);
        }
        return sum;
    }
}
