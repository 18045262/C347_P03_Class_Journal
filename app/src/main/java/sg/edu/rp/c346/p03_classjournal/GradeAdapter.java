package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> grades;
    private Context context;
    private ImageView ivGrade;
    private TextView tvGrade, tvWeek,tvDG;

    public GradeAdapter(Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        grades = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvGrade = rowView.findViewById(R.id.tvResult);
        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvDG = rowView.findViewById(R.id.tvDG);
        ivGrade = rowView.findViewById(R.id.imageViewGrade);

        Grade currentWeek = grades.get(position);
        tvWeek.setText("Week " + currentWeek.getWeek());
        tvGrade.setText(currentWeek.getGrade());

        tvDG.setText("DG");
        ivGrade.setImageResource(R.drawable.dg);

        return rowView;
    }

}
