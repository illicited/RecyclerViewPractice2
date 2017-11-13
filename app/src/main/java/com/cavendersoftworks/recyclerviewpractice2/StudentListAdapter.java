package com.cavendersoftworks.recyclerviewpractice2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cavendersoftworks.recyclerviewpractice2.Model.Student;
import com.cavendersoftworks.recyclerviewpractice2.View.DetailActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {
    //public static final String STUDENT_ID_KEY = "student_id_key";
    public static final String STUDENT_KEY = "student_key";
    private List<Student> mStudents;
    private Context context;

    public StudentListAdapter(List<Student> mStudents, Context context) {
        this.mStudents = mStudents;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView = inflater.inflate(R.layout.list_student, parent, false);
        LinearLayoutManager lm = new LinearLayoutManager(context);

        ViewHolder vh = new ViewHolder(studentView);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Student student = mStudents.get(position);
        String fileName = student.getImageName();

        try {
            InputStream is = context.getAssets().open(fileName);
            Drawable d  = Drawable.createFromStream(is, null);

            holder.tvName.setText(student.getName());
            holder.tvCompany.setText(student.getCompany());
            holder.status.setText(student.getStatus());
            holder.imView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.sView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "You selected " + student.getName(), Toast.LENGTH_SHORT).show();
                //String studentID = student.getItemId();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(STUDENT_KEY, student);
                context.startActivity(intent);
            }
        });

        holder.sView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "Student ID is " + student.getItemId(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imView;
        private TextView tvName;
        private TextView tvCompany;
        private TextView status;
        private View sView;

        private ViewHolder(View itemView) {
            super(itemView);

            imView = (ImageView)itemView.findViewById(R.id.imv_picture);
            tvName = (TextView)itemView.findViewById(R.id.tv_NameDetail);
            tvCompany = (TextView)itemView.findViewById(R.id.tv_CompanyDetail);
            status = (TextView)itemView.findViewById(R.id.currentStatus);
            sView = itemView;
        }
    }

}
