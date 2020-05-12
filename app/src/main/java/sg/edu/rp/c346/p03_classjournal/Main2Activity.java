package sg.edu.rp.c346.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Integer newWeek, selectedGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvNewWeek = findViewById(R.id.tvNewWeek);

        Button btn = findViewById(R.id.btnSubmit);

        Intent i2 = getIntent();
        newWeek = i2.getIntExtra("week",0);
        tvNewWeek.setText("Week " + newWeek);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgGrade = findViewById(R.id.rgGrade);
                selectedGrade = rgGrade.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedGrade);

                Grade newGrade = new Grade(rb.getText().toString(),newWeek);
                Intent i = new Intent();
                i.putExtra("newGrade",newGrade);
                setResult(RESULT_OK,i);
                finish();

            }
        });


    }
}
