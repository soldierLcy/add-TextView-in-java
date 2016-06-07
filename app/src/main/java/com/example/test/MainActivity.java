package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT = " ●  测试-点击按钮1添加 \n";
    private static final String TEXT1 = "测试-点击按钮2添加";
    private StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buffer = new StringBuffer();

        final TextView view = (TextView) findViewById(R.id.text);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.linear);

        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buffer.append(TEXT);
                view.setText(buffer);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTextView myTextView = new MyTextView(MainActivity.this);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,60);
                myTextView.setLayoutParams(params);
                myTextView.setMyText(TEXT1);
                layout.addView(myTextView);
            }
        });
    }
}
