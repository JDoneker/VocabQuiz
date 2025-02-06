package com.example.vocabquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {
    private ArrayList<CheckBox> checkBoxArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        checkBoxArrayList = new ArrayList<>();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Button button = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to SecondActivity
                checkBoxArrayList.clear();
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox1_1));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox1_2));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox1_3));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox1_4));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_1));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_2));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_3));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_4));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_5));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox2_6));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox3_1));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox3_2));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox3_3));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox3_4));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox3_5));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox4_1));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox4_2));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox4_3));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox4_4));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox4_5));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_1));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_2));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_3));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_4));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_5));
                checkBoxArrayList.add((CheckBox) findViewById(R.id.checkBox5_6));
                ArrayList<String> trueArrayList  = new ArrayList<>();
                for (CheckBox checkBox : checkBoxArrayList) {
                    if(checkBox.isChecked()){
                        trueArrayList.add(getResources().getResourceName(checkBox.getId()).split("/")[1]);
                    }
                }


                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putStringArrayListExtra("key", trueArrayList);
                startActivity(intent);

            }
        });
    }
}