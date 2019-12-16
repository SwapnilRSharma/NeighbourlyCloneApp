package com.doodlepie.neighbourlycloneapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doodlepie.neighbourlycloneapp.adapter.PostAdapter;
import com.doodlepie.neighbourlycloneapp.model.Post;

public class MainActivity extends AppCompatActivity implements  PostAdapter.OnPostClickListener{

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private ImageView ivLocation;
    private Dialog dialog;
    private  boolean frsttineclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(this);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager llmPlace = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llmPlace);
        postAdapter = new PostAdapter(this);
        recyclerView.setAdapter(postAdapter);

        ivLocation = (ImageView) findViewById(R.id.ivLocation);
        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }

    private void showPopup() {
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        dialog.setContentView(R.layout.locate_popup);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        if (frsttineclick) {
            dialog.show();
        } else {
            frsttineclick = true;
            showPopup();
        }
    }

    @Override
    public void OnPostClickListener(Post post) {
       // Intent intent = new Intent(HomeActivity.this, ItemDetailsActivity.class);
       // intent.putExtra("FoodName", place.getPlaceName());
       // intent.putExtra("Price", place.getDelivery());
      //  startActivity(intent);
        /*
                Intent scrollable = new Intent(MainActivity.this, PostDetailsActivity.class);

                new DragDismissIntentBuilder(MainActivity.this)
                        .setTheme(DragDismissIntentBuilder.Theme.LIGHT)
                        .setPrimaryColorResource(R.color.textcolor)
                        .setShowToolbar(false)
                        .setFullscreenOnTablets(true)
                        .setToolbarTitle("Hidden Toolbar Sample")
                        .setDragElasticity(DragDismissIntentBuilder.DragElasticity.XXLARGE)
                        .setShouldScrollToolbar(false)
                        .build(scrollable);

                startActivity(scrollable);


         */

        Intent scrollable = new Intent(MainActivity.this, PostDetailsActivity.class);
        startActivity(scrollable);
        overridePendingTransition(R.anim.slide_in_up, 0);
    }
}
