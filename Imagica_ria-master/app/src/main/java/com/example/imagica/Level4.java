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

public class Level4 extends AppCompatActivity {


    private static final String TAG="Level 4";

    //FireBase
    private DatabaseReference reference;


    //Widgets
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        count=0;
        Log.d(TAG, "OnCreate: started");

        imageView=(ImageView) findViewById(R.id.lev4_1);
        imageView2=(ImageView) findViewById(R.id.lev4_2);
        imageView3=(ImageView) findViewById(R.id.lev4_diff1);
        imageView4=(ImageView) findViewById(R.id.lev4_diff2);
        imageView5=(ImageView) findViewById(R.id.lev4_diff3);
        imageView6=(ImageView) findViewById(R.id.lev4_diff4);
        imageView7=(ImageView) findViewById(R.id.lev4_diff5);
        imageView8=(ImageView) findViewById(R.id.lev4_diff6);

        reference= FirebaseDatabase.getInstance().getReference();

        Query query=reference.child("Level4");


        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url=dataSnapshot.child("url").getValue().toString();
                String diff1=dataSnapshot.child("diff1").getValue().toString();
                String diff2=dataSnapshot.child("diff2").getValue().toString();
                String diff3=dataSnapshot.child("diff3").getValue().toString();
                String diff4=dataSnapshot.child("diff4").getValue().toString();
                String diff5=dataSnapshot.child("diff5").getValue().toString();
                String diff6=dataSnapshot.child("diff6").getValue().toString();


                if(!url.isEmpty())
                {

                    Picasso.get()
                            .load(url)
                            .into(imageView);

                    Picasso.get()
                            .load(url)
                            .into(imageView2);

                }

                if(!diff1.isEmpty())
                {
                    Picasso.get()
                            .load(diff1)
                            .into(imageView3);
                }
                if(!diff2.isEmpty())
                {
                    Picasso.get()
                            .load(diff2)
                            .into(imageView4);
                }
                if(!diff3.isEmpty())
                {
                    Picasso.get()
                            .load(diff3)
                            .into(imageView5);
                }
                if(!diff4.isEmpty())
                {
                    Picasso.get()
                            .load(diff4)
                            .into(imageView6);
                }
                if(!diff5.isEmpty())
                {
                    Picasso.get()
                            .load(diff5)
                            .into(imageView7);
                }
                if(!diff6.isEmpty())
                {
                    Picasso.get()
                            .load(diff6)
                            .into(imageView8);
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
                count += 1;
                showToast();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView4.animate().alpha(0f).setDuration(2000);
                count += 1;
                showToast();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.animate().alpha(0f).setDuration(2000);
                count += 1;
                showToast();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView6.animate().alpha(0f).setDuration(2000);
                count += 1;
                showToast();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView7.animate().alpha(0f).setDuration(2000);
                count += 1;
                showToast();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView8.animate().alpha(0f).setDuration(2000);
                count += 1;
                showToast();
            }
        });
    }
    protected void showToast() {
        if (count == 5) {
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
