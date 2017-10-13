package fr.patrickwang.androidappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private final String TYPES_OF_RESOURCE_EXTRA = "TYPES_OF_RESOURCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // getResources() can be accessed in every Activity, and allows the developer to retrieve the data stored in the /res folder
        String[] strings = getResources().getStringArray(R.array.resources);
        List<String> resourcesList = Arrays.asList(strings);

        // findViewById can be accessed in every Activity, and allows the instantiation of Android classes for layouts and widgets
        ListView listView = (ListView) findViewById(R.id.home_list_view);
        // To populate a ListView, we need to use the ArrayAdapter class which contains all the elements to be displayed
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, resourcesList);
        listView.setAdapter(adapter);

        // We need to implement the onItemClickListener method to manage the "item clicked" event.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedText = (String) adapterView.getItemAtPosition(i);
                // To go to one Activity to another, we use the Intent class
                Intent intent = new Intent(getApplicationContext(), RequestActivity.class);
                // It is possible to pass information from an Activity to another by adding Extras to the intents
                intent.putExtra(TYPES_OF_RESOURCE_EXTRA, selectedText);
                // The startActivity method is the method that actually starts another Activity
                startActivity(intent);
            }
        });
    }
}
