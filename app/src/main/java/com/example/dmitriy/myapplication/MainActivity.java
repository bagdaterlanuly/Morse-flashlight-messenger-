package com.example.dmitriy.myapplication;


import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tv;
    private int delay = 0;
    private  String text2 = "";
    private Camera mCamera = null;
    private CameraView mCameraView = null;
    Parameters parameters;
    Morse mr = new Morse();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mCamera = Camera.open();
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if(mCamera != null) {
            mCameraView = new CameraView(this, mCamera);
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
            camera_view.addView(mCameraView);
        }


        ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        final EditText editText = (EditText)findViewById(R.id.editText);
        ImageButton imgSend = (ImageButton)findViewById(R.id.imageButton);
        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,NewActivity.class);
                startActivity(in);
//                tv = (TextView) findViewById(R.id.textView3);
//                tv.setMovementMethod(new ScrollingMovementMethod());
//                String text = editText.getText().toString();
//                text2 = text2 + text + "\n";
//                mr.setText(text);
//                String temp = mr.MorseImp(text);
//                translateFlashLight(temp);
//                editText.setText("");
//                tv.setText(text2);
            }
        });
    }
    public void translateFlashLight(String morseMessage){
        try{
        char[] morseChar = morseMessage.toCharArray();

//        int on=0;
//        int off=0;
//        int delay = 0;
        for(int i=0;i<morseMessage.length();i++) {
            if (morseChar[i] == '.')
                delay = 500;
            else if (morseChar[i] == '-')
                delay = 600;
            else if (morseChar[i] == ' ')
                delay = 700;
            setFlashLigthOn();
            TimeUnit.MILLISECONDS.sleep(delay);
            setFlashLightOff();
            TimeUnit.MILLISECONDS.sleep(delay);
        }
        }catch(InterruptedException e){

            }
//            Thread t = new Thread() {
//                public void run() {
//                    setFlashLigthOn();
//                    try {
//                        Thread.sleep(delay);
//                    } catch (Exception e){
//                        e.printStackTrace();
//                    }
//
//                }
//            };
//            Thread t2 = new Thread() {
//                public void run() {
//                    setFlashLightOff();
//                    try {
//                        Thread.sleep(delay);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            t.start();
//            t2.start();
    }

    //Turn On and Off methods
    public void setFlashLigthOn() {
        if (mCamera != null) {

            parameters = mCamera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            mCamera.setParameters(parameters);


        }
    }

    private void setFlashLightOff() {

        if (mCamera != null) {
            parameters = mCamera.getParameters();
            if (parameters.getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH)) {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
            }
        }
    }
}