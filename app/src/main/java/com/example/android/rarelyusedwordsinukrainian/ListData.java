package com.example.android.rarelyusedwordsinukrainian;

/**
 * Created by User on 01.04.16.
 */
public class ListData {
    String word;
    String meaning;

    ListData(String _word, String _meaning) {
        word = _word;
        meaning = _meaning;
    }

    @Override
    public String toString() {
        return word;
    }
}
