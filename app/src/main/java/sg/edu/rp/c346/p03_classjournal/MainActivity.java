package sg.edu.rp.c346.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvModule);

        al = new ArrayList<String>();
        al.add("C347");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedModule = al.get(position);
                Intent i = new Intent(MainActivity.this, Info.class);
                i.putExtra("module", selectedModule);

                if (selectedModule == "C347"){
                    i.putExtra("email","jason_lim@rp.edu.sg");

                }

                startActivity(i);



            }
        });

    }
}
