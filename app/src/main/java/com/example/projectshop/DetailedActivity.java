package com.example.projectshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailedActivity extends AppCompatActivity {


    //private TextView id;
    private TextView textViewPersonName;
    private TextView fullDescription;
    private ImageView image;
    private TextView dateOfBirth;
    private Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);



        textViewPersonName = (TextView)findViewById(R.id.textViewPersonName);
        //id= (TextView)findViewById(R.id.id);
        share = (Button)findViewById(R.id.Share_button);
        fullDescription = (TextView)findViewById(R.id.textViewPersonDescription);
        image = (ImageView)findViewById(R.id.PersonPhoto);
        dateOfBirth = (TextView) findViewById(R.id.dateOfBirth);

        String personName = getIntent().getStringExtra("name");
        textViewPersonName.setText(personName + "\n");
        //String iD = getIntent().getStringExtra("id");
        //id.setText(iD);
        String description = getIntent().getStringExtra("description");
        fullDescription.setText(description+"\n");
        String image_path = getIntent().getStringExtra("image");
        Bitmap bitmap = BitmapFactory.decodeFile(image_path);
        image.setImageBitmap(bitmap);
        String birthDate = getIntent().getStringExtra("date");
        dateOfBirth.setText(birthDate);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "description");
                startActivity(Intent.createChooser(intent, "Share data"));
            }
        });


    }
}
