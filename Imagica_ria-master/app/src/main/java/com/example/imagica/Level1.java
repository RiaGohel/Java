package com.example.imagica;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Level1 extends AppCompatActivity {

    private static final String TAG = "Level 1";

    //FireBase
    private DatabaseReference reference;


    //Widgets
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        count=0;
        Log.d(TAG, "OnCreate: started");

        imageView = (ImageView) findViewById(R.id.lev1_1);
        imageView2 = (ImageView) findViewById(R.id.lev1_2);
        imageView3 = (ImageView) findViewById(R.id.lev1_diff1);
        imageView4 = (ImageView) findViewById(R.id.lev1_diff2);
        imageView5 = (ImageView) findViewById(R.id.lev1_diff3);
        //imageView6=(ImageView) findViewById(R.id.lev1_diff4);

        reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("Level1");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.child("url").getValue().toString();
                String diff1 = dataSnapshot.child("diff1").getValue().toString();
                String diff2 = dataSnapshot.child("diff2").getValue().toString();
                String diff3 = dataSnapshot.child("diff3").getValue().toString();
                // String diff4=dataSnapshot.child("diff4").getValue().toString();

                if (!url.isEmpty()) {

                    Picasso.get()
                            .load(url)
                            .into(imageView);

                    Picasso.get()
                            .load(url)
                            .into(imageView2);

                }

                if (!diff1.isEmpty()) {
                    Picasso.get()
                            .load(diff1)
                            .into(imageView3);
                }

                if (!diff2.isEmpty()) {
                    Picasso.get()
                            .load(diff2)
                            .into(imageView4);
                }

                if (!diff3.isEmpty()) {
                    Picasso.get()
                            .load(diff3)
                            .into(imageView5);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView3.animate().alpha(0f).setDuration(2000);
                count+=1;
                showToast();
            }
        });

        imageView4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView4.animate().alpha(0f).setDuration(2000);
                count+=1;
                showToast();
            }
        }));

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.animate().alpha(0f).setDuration(2000);
                count+=1;
                showToast();
            }
        });
    }

    protected void showToast() {
        if (count == 3) {
            LayoutInflater inflater = getLayoutInflater();

            View toastLayout = inflater.inflate(R.layout.my_toast,
                    (ViewGroup) findViewById(R.id.toast_root_view));

            TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
            header.setText("Congratulations!");

            TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
            body.setText("You cleared the level");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(toastLayout);
            toast.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                }
            }, 1000);
        }
    }
}
