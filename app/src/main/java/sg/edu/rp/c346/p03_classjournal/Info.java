package sg.edu.rp.c346.p03_classjournal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Info extends AppCompatActivity {

    Button btnEmail, btnAdd, btnInfo;

    ListView lvGrade;
    ArrayList<Grade> alGrade;
    ArrayAdapter aaGrade;
    String message, emailAddress, list;
    int RequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);
        btnEmail = findViewById(R.id.btnEmail);
        lvGrade = findViewById(R.id.lvGrade);

        Intent i = getIntent();
        String module = i.getStringExtra("module");
        emailAddress = i.getStringExtra("email");
        setTitle("Info for " + module);


        alGrade = new ArrayList<Grade>();
        if (module == "C347") {
            alGrade.add(new Grade("B", 1));
            alGrade.add(new Grade("C", 2));
            alGrade.add(new Grade("A", 3));

        }
            Log.d(TAG, alGrade);


        aaGrade = new GradeAdapter(this,R.layout.activity_info,alGrade);
        lvGrade.setAdapter(aaGrade);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(web);
            }
        });

       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent add = new Intent(Info.this, Main2Activity.class);
               add.putExtra("week",alGrade.size()+1);
               startActivity(add);
           }
       });

       btnEmail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent email = new Intent(Intent.ACTION_SEND);
               for (int a = 0; a<alGrade.size(); a++){
                  Grade messageGrade = alGrade.get(a);
                  message = message + "Week " + messageGrade.getWeek() + "DG" + messageGrade.getGrade() + "\n";
               }
               email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
               email.putExtra(Intent.EXTRA_SUBJECT,"Test Email from Daily Grade");
               email.putExtra(Intent.EXTRA_TEXT,"Hi Faci, \n I am ... \n Please see my remarks so far, thanks you! \n" + message);
               email.setType("message/rfc822");
               startActivity(Intent.createChooser(email,"Client:"));
           }

       });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == RequestCode){
                Grade newGrade = (Grade) data.getSerializableExtra("newGrade");
                alGrade.add(newGrade);
                aaGrade.notifyDataSetChanged();

            }
        }
    }

}
