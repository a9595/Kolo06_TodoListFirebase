package com.tieorange.kolo06_todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference todoItemsRef;
    private FirebaseRecyclerAdapter<TodoItem, TodoViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFirebase();
        initRecycler();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                addNewTodoItem(new Date().toString());
            }
        });
    }

    private void initRecycler() {
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new FirebaseRecyclerAdapter<TodoItem, TodoViewHolder>
                (TodoItem.class, R.layout.item_todo, TodoViewHolder.class, todoItemsRef) {
            @Override
            public void populateViewHolder(TodoViewHolder viewHolder,
                                           TodoItem model, int position) {
                viewHolder.setModel(model);
            }
        };
        recycler.setAdapter(mAdapter);
    }

    private void addNewTodoItem(String taskName) {
        TodoItem todoItem = new TodoItem(taskName);
        todoItemsRef.push().setValue(todoItem);
    }

    private void initFirebase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        todoItemsRef = database.getReference("todoItems");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_addNewTodoItem) {
            Toast.makeText(this, "Add new item", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
