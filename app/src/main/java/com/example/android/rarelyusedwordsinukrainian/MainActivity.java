package com.example.android.rarelyusedwordsinukrainian;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    /**
     * Called when the activity is first created.
     */
    private ArrayList<ListData> wordList;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] words = getResources().getStringArray(R.array.rarely_used_words);
        String[] meanings = getResources().getStringArray(R.array.rarely_used_description);

        //Create an array of objects ListData and fill in data
        wordList = new ArrayList<ListData>();
        for (int i = 1; i <= 5; i++) {
            wordList.add(new ListData(words[i - 1], meanings[i - 1]));
        }

        listView = (ListView) findViewById(android.R.id.list);

        ListAdapter listAdapter = new ListAdapter(this, wordList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, WordMeaningActivity.class);
        ListData listData = wordList.get(position);
        intent.putExtra(WordMeaningActivity.EXT_LabelToShow, listData.word);
        intent.putExtra(WordMeaningActivity.EXT_TextToShow, listData.meaning);
        startActivity(intent);
    }
}
