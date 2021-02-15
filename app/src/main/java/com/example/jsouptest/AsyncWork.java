package com.example.jsouptest;

import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class AsyncWork extends AsyncTask<Void, Void, String> {
    private String webValues;

    @Override
    protected String doInBackground(Void... params) {
        webValues ="";
        Document doc;
        try {
            doc = Jsoup.connect("https://2chmm.com/").get();
            webValues = doc.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return webValues;
    }
    @Override
    protected void onPostExecute(String result) {
        MainActivity.setValues(webValues);
    }
}