package com.greenfox.interfaceExcercises;

public class Todo implements Printable {
    private String task;
    private String priority;
    private boolean done;

    public void setTask(String task) {
        this.task = task;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public void printAllFields() {
        System.out.println("Task: " + task + " | Priority: " + priority + " | Done: " + done);
    }
}
