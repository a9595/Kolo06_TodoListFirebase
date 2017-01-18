package com.tieorange.kolo06_todolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by root on 1/11/17.
 */
public class TodoViewHolder extends RecyclerView.ViewHolder {

    private final CheckBox isDone;
    private final TextView todoItemName;

    public TodoViewHolder(View itemView) {
        super(itemView);

        isDone = (CheckBox) itemView.findViewById(R.id.todoItemIsDone);
        todoItemName = (TextView) itemView.findViewById(R.id.todoItemName);
    }

    public void setModel(TodoItem model) {
        if (model == null || model.getTaskName() == null) return;

        String taskName = model.getTaskName();
        todoItemName.setText(taskName);
    }
}
