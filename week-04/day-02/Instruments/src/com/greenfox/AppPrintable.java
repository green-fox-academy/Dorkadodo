package com.greenfox;
import com.greenfox.interfaceExcercises.Domino;
import com.greenfox.interfaceExcercises.Todo;

import java.util.ArrayList;
import java.util.List;

public class AppPrintable {
    public static void main(String[] args) {


        Domino d = new Domino();
        d.setLeftField(3);
        d.setRightField(2);
        Todo t = new Todo();
        t.setTask("Buy milk");
        t.setPriority("high");
        t.setDone(true);
        List<Domino> dominoes = new ArrayList<>();
        List<Todo> todos = new ArrayList<>();
        dominoes.add(d);
        todos.add(t);

        for (Domino domino : dominoes) {
            d.printAllFields();
        }

        for (Todo todo : todos) {
            t.printAllFields();
        }
    }
}
