package com.moutamid.tourismsimpleapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fxn.stash.Stash;
import com.moutamid.tourismsimpleapp.R;
import com.moutamid.tourismsimpleapp.brain.Brain;
import com.moutamid.tourismsimpleapp.model.DataModel;
import com.moutamid.tourismsimpleapp.utils.Constants;

import java.io.Console;
import java.util.ArrayList;

public class AllItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_items);

        String params = getIntent().getStringExtra(Constants.PARAMS);

        if (params.equals(Constants.FOOD))
            tasksArrayList = Brain.foodDataArrayList();

        else tasksArrayList = Brain.topDestinationsDataArrayList();

        initRecyclerView();

    }

    private ArrayList<DataModel> tasksArrayList;

    private RecyclerView conversationRecyclerView;
    private RecyclerViewAdapterMessages adapter;

    private void initRecyclerView() {

        conversationRecyclerView = findViewById(R.id.all_items_recyclerview);
        //conversationRecyclerView.addItemDecoration(new DividerItemDecoration(conversationRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        adapter = new RecyclerViewAdapterMessages();
        //        LinearLayoutManager layoutManagerUserFriends = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
//            int numberOfColumns = 3;
//        int mNoOfColumns = calculateNoOfColumns(getApplicationContext(), 50);
        conversationRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setReverseLayout(true);
//        conversationRecyclerView.setLayoutManager(linearLayoutManager);
        conversationRecyclerView.setHasFixedSize(true);
        conversationRecyclerView.setNestedScrollingEnabled(false);

        conversationRecyclerView.setAdapter(adapter);

        //    if (adapter.getItemCount() != 0) {

        //        noChatsLayout.setVisibility(View.GONE);
        //        chatsRecyclerView.setVisibility(View.VISIBLE);

        //    }

    }

    /*public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }*/

    private class RecyclerViewAdapterMessages extends RecyclerView.Adapter
            <RecyclerViewAdapterMessages.ViewHolderRightMessage> {

        @NonNull
        @Override
        public ViewHolderRightMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_items, parent, false);
            return new ViewHolderRightMessage(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolderRightMessage holder, int position) {

            holder.title.setText(tasksArrayList.get(position).title);
            holder.imageView.setImageResource(tasksArrayList.get(position).drawable);

            holder.layout.setOnClickListener(view -> {
                Stash.put(Constants.SAVED_OBJECT, tasksArrayList.get(position));
                startActivity(new Intent(AllItemsActivity.this, SingleItemActivity.class));
            });


        }

        @Override
        public int getItemCount() {
            if (tasksArrayList == null)
                return 0;
            return tasksArrayList.size();
        }

        public class ViewHolderRightMessage extends RecyclerView.ViewHolder {

            TextView title;
            ImageView imageView;
            RelativeLayout layout;

            public ViewHolderRightMessage(@NonNull View v) {
                super(v);
                title = v.findViewById(R.id.titleallitem);
                imageView = v.findViewById(R.id.imageallitem);
                layout = v.findViewById(R.id.parentLayout);

            }
        }

    }

}