package com.example.fileexplorer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {

    private Button chooseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseButton=(Button)findViewById(R.id.chooseButton);

    }

    public void getArchivo(View view){
        Intent intent1=new Intent(MainActivity.this,FileexplorerActivity.class);
        startActivity(intent1);
    }
}
