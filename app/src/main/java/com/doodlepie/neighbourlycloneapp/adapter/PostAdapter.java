package com.doodlepie.neighbourlycloneapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doodlepie.neighbourlycloneapp.R;
import com.doodlepie.neighbourlycloneapp.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ItemHolder>{

    private List<Post> mPosts = new ArrayList<>();
    private Context context;
    private final OnPostClickListener mListener;

    public PostAdapter(Context context){
        this.context = context;

        try {
            this.mListener = ((OnPostClickListener) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement OnPostClickListener.");
        }

        String[] postName = {"Swapnil | 2 Days", "Deep | 3 Days", "Rohit | 4 Days"};

        String[] postLocation = {"Pune", "Mumbai", "Nashik"};

        String[] postMessage = {"Hello Everyone", "Hello Everyone", "Hello Everyone"};

        String[] postName2 = {"Abhishek| 3 Days", "Rohit | 6 Days", "Rudraksh | 8 Days"};

        for (int i = 0; i < 3; i++){
            Post post = new Post(postName[i], postLocation[i], postMessage[i], postName2[i], "25 Likes | 3 Answers");
            mPosts.add(post);
        }
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item, viewGroup, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, int position) {
        final Post post =  mPosts.get(position);

        holder.mItem = post;

        holder.postName.setText(post.getName());
        holder.postLocation.setText(post.getLocation());
        holder.postMessage.setText(post.getMessage());
        holder.postName2.setText(post.getName2());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.OnPostClickListener(post);
            }
        });
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView postName, postLocation, postMessage, postName2;
        public final View mView;
        public Post mItem;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            postName = itemView.findViewById(R.id.tvPostTime);
            postLocation = itemView.findViewById(R.id.tv_location);
            postMessage = itemView.findViewById(R.id.tvMessage);
            postName2 = itemView.findViewById(R.id.tvPostTime1);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnPostClickListener {
        void OnPostClickListener(Post post);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}