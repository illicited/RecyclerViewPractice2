package com.cavendersoftworks.recyclerviewpractice2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.renderscript.ScriptGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cavendersoftworks.recyclerviewpractice2.Model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = mStudents.get(position);
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
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imView;
        public TextView tvName;
        public TextView tvCompany;
        public TextView status;

        public ViewHolder(View itemView) {
            super(itemView);

            imView = (ImageView)itemView.findViewById(R.id.imv_picture);
            tvName = (TextView)itemView.findViewById(R.id.tv_Name);
            tvCompany = (TextView)itemView.findViewById(R.id.tv_Company);
            status = (TextView)itemView.findViewById(R.id.currentStatus);
        }
    }

}
