package com.smb116.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.smb116.tp5.database.IntervenantDAO;
import com.smb116.tp5.model.Intervenant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ShowDatabase.class);
        startActivity(intent);
    }
}