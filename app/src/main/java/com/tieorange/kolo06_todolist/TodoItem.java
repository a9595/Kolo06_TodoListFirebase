package com.tieorange.kolo06_todolist;

/**
 * Created by root on 1/11/17.
 */
public class TodoItem {

    private String key;
    private String taskName;
    private boolean isDone;

    public TodoItem() {
    }

    public TodoItem(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
