package com.example.rawan.charities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by rawan on 8/4/18.
 */

public class DetailedActivity extends AppCompatActivity{
   private ImageView imageView;
    private TextView nameTextView;
    private TextView typeTextView;
    private TextView descTextView;
    private EditText editText;
    private Button button;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);
String name = getIntent().getStringExtra("name");
        String pic = getIntent().getStringExtra("pic");
        String type = getIntent().getStringExtra("type");
        String desc = getIntent().getStringExtra("desc");

        imageView = (ImageView) findViewById(R.id.img_d);
        nameTextView = (TextView) findViewById(R.id.name_d);
        typeTextView = (TextView) findViewById(R.id.type_d);
        descTextView = (TextView) findViewById(R.id.desc_d);
        editText = (EditText) findViewById(R.id.add);
        button = (Button) findViewById(R.id.confirm);

      Picasso.get().load(pic).fit().centerCrop().into(imageView);
        nameTextView.setText("Name: "+name);
        typeTextView.setText("Type: "+type);
        descTextView.setText("Description: "+desc);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (editText.getText().toString().isEmpty()) {
                   Toast.makeText(DetailedActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
               }
               else
                   Toast.makeText(DetailedActivity.this, "Thank you", Toast.LENGTH_LONG).show();

           }
       });
    }
}
