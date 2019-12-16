package com.doodlepie.neighbourlycloneapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.davidmiguel.dragtoclose.DragListener;
import com.davidmiguel.dragtoclose.DragToClose;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW_PROGRESS = "extra_show_progress";
    final boolean[] isAnimationFirstTime = {false};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item_view);

        //ItemViewFragment cardTwoFragment = ItemViewFragment.newInstance();
        //getSupportFragmentManager().beginTransaction().add(R.id.cardContainer, cardTwoFragment);


        DragToClose dragToClose = findViewById(R.id.drag_to_close);
        dragToClose.setDragListener(new DragListener() {
            @Override
            public void onStartDraggingView() {

            }

            @Override
            public void onDragging(float v) {

            }

            @Override
            public void onViewCosed() {
                finish();
            }
        });

        final TextView textView = findViewById(R.id.answer);
        final CircleImageView circleImageView = findViewById(R.id.circluar_image);
        final EditText et_cmnt = (EditText) findViewById(R.id.et_cmnt);
        final ImageView img_cmnt = (ImageView) findViewById(R.id.img_cmnt);
        final ImageView send = (ImageView) findViewById(R.id.send);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleImageView.setVisibility(View.VISIBLE);
                et_cmnt.setVisibility(View.VISIBLE);
                img_cmnt.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            }
        });

        et_cmnt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    // start fade out animation
                    circleImageView.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in));
                    //Make the elements invisible
//                       Animation btthree = AnimationUtils.loadAnimation(getContext(), R.anim.btthree);
//                        circleImageView.startAnimation(btthree);
                    circleImageView.setVisibility(View.VISIBLE);
                    img_cmnt.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
                    send.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pus_up_out));
                    et_cmnt.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
                    send.setVisibility(View.GONE);
                    isAnimationFirstTime[0] = false;

                } else {
                    // Make fade in elements Visible first
//                       Animation  bttone = AnimationUtils.loadAnimation(getContext(), R.anim.bttone);
//                        circleImageView.startAnimation(bttone);
                    if (!isAnimationFirstTime[0]) {
                        et_cmnt.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right));
                        img_cmnt.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right));
                        circleImageView.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pus_up_out));
                        circleImageView.setVisibility(View.GONE);
                        send.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_up_in));
                        send.setVisibility(View.VISIBLE);
                        isAnimationFirstTime[0] = true;
                    }
                    // start fade in animation

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }
}