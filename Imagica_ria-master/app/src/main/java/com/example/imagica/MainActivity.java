package com.example.imagica;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playbutton;
        playbutton= (Button) findViewById(R.id.playbutton);
        Button instruction;
        instruction= (Button) findViewById(R.id.instructbutton);
        Button exitbutton;
        exitbutton= (Button) findViewById(R.id.exitbutton);

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(".PlayActivity");
                startActivity(intent);
            }
        });
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);

            }
        });
    }

	public void onButtonShowPopupWindowClick(View view){
		LayoutInflater inflater = (LayoutInflater)
			getSystemService(LAYOUT_INFLATER_SERVICE);
		View popupView = inflater.inflate(R.layout.popup_window,null);
		int width = LinearLayout.LayoutParams.WRAP_CONTENT;
		int height = LinearLayout.LayoutParams.WRAP_CONTENT;
		boolean focusable = true;
		final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
		popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

		popupView.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				popupWindow.dismiss();
				return true;
		    }
	    });
	
        //instruction.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //Intent intent=new Intent(".InstructActivity");
                //startActivity(intent);
            //}
        //});
    }
}
