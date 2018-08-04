package com.example.rawan.charities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by rawan on 8/3/18.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
    private Context context;
    private List<charitiesData> listItems;
    public RvAdapter(Context con, List<charitiesData> listOfItems) {
    context=con;
    listItems=listOfItems;
    }

    public void setData(List<charitiesData> data) {
        this.listItems= data;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutHolderView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.rv_content,
                parent,
                false);
        return new ViewHolder(layoutHolderView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.setContent(listItems.get(position));

    }
    @Override
    public int getItemCount() {
        return listItems.size();    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameView;
        private TextView typeView;
        private TextView descView;
        private ImageView picView;
        private LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.name);
            typeView = (TextView) itemView.findViewById(R.id.type);
            descView = (TextView) itemView.findViewById(R.id.des);
            picView = (ImageView) itemView.findViewById(R.id.pic);
            layout = (LinearLayout) itemView.findViewById(R.id.rv_layout);

        }

        public void setContent( final charitiesData data) {

            nameView.setText("Name: " + data.getOrganization_name());
            typeView.setText("Type: " + data.getOrganization_type());
            descView.setText("Description: " + data.getOrganization_desc());
            Picasso.get().load(data.getOrganization_pic()).fit().centerCrop().into(picView);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (data != null) {
                        Intent intent = new Intent(context, DetailedActivity.class);
                        intent.putExtra("name", data.getOrganization_name());
                        intent.putExtra("pic", data.getOrganization_pic());
                        intent.putExtra("type", data.getOrganization_type());
                        intent.putExtra("desc", data.getOrganization_desc());
                        context.startActivity(intent);
                    } else
                        Toast.makeText(context, "ana 7ases bs el data null", Toast.LENGTH_LONG).show();

                }
            });


        }
    }}
