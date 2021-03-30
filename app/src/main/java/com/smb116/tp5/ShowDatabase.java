package com.smb116.tp5;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.smb116.tp5.database.IntervenantDAO;
import com.smb116.tp5.model.Intervenant;

import java.util.ArrayList;
import java.util.List;

public class ShowDatabase extends ListActivity {
    private static final String TAG = ShowDatabase.class.getName();
    private List<String> intListString;

    /** Question 4 */
    public static final String AUTHORITY = "com.smb116.tp5.provider.MyContentProvider";
    public static final String TABLE_NAME = "intervenant";
    public static final Uri URI_INTERVENANT = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /** Question 3 */
//        IntervenantDAO iDAO = new IntervenantDAO(this);
//        Cursor cursorQ3 = iDAO.queryWithCursor();
//        intListString = getListFromCursor(cursorQ3);

        /** Question 4 */
        Cursor cursorQ4 = getContentResolver().query(URI_INTERVENANT,null,null,null,null,null);
        intListString = getListFromCursor(cursorQ4);

        setListAdapter( new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,intListString));
    }

    public List<String> getListFromCursor(Cursor cursor){
        List<String> list = new ArrayList<>();

        while (cursor.moveToNext()){
            list.add(cursor.getString(1)+" "+cursor.getString(2)+" \n"+cursor.getString(3));
        }
        return list;
    }
}

