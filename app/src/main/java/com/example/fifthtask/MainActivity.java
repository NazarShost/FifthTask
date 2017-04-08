package com.example.fifthtask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView lv;
    private String[] lang;
    final Intent []intent=new Intent[3];
    private void initResources(){
        Resources res = getResources();
        lang = res.getStringArray(R.array.NamesPhone);
    }
    private void initLanguagesListView(){
        lv.setAdapter(new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1,lang));
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context;
        context = getApplicationContext();
        intent[0] = new Intent(context,Nexus.class);
        intent[1] = new Intent(context,Xiaomi.class);
        intent[2] = new Intent(context,IPhone.class);
        lv = (ListView) findViewById(R.id.languages);
        initResources();
        initLanguagesListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id){
                switch (pos){
                    case 0 :
                        startActivity(intent[0]);
                        break;
                    case 1 :
                        startActivity(intent[1]);
                        break;
                    case 2 :
                        startActivity(intent[2]);
                        break;
                }

            }
    });

}
}
