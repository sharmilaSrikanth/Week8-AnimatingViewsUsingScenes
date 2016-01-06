package com.shrisharmi.animatingviewsusingscenes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Scene mAScene;
    Scene mAnotherScene;
    ViewGroup translayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        translayout = (ViewGroup)findViewById(R.id.translayout);
        translayout.setOnTouchListener(new RelativeLayout.OnTouchListener()
        {@Override
         public boolean onTouch(View v, MotionEvent event)
            {
                moveButton();
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void moveButton()
    {
        View button = findViewById(R.id.button);
        TransitionManager.beginDelayedTransition(translayout);
     RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(LinearLayout.
                LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        button.setLayoutParams(positionRules);

        ViewGroup.LayoutParams size = button.getLayoutParams();
        size.width = 450;
        size.height = 300;
        button.setLayoutParams(size);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
