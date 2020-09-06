package com.rawesomestudios.location;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<RssDataParser.Item> mDataset;


    public RecyclerAdapter(Context context, ArrayList<RssDataParser.Item> dataset){
        this.mContext = context;
        this.mDataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //return the actual view holder
        //making a layout from a specified layout already in the app
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_feed_item, viewGroup, false);
        //it will inflate the rss_feed_item into the recycler view
        ViewHolder viewHolder = new ViewHolder(view); //making a view holder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final RssDataParser.Item item = mDataset.get(position);

        //whenever they click on the card view, it will take them to a url link that is specified in RssDataParser.Item, variable link
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast tell us that we got this working
                //this gives us the position of the card view when we click it
                Toast.makeText(viewHolder.cardView.getContext(), position+"", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW); //opens up a seperate view
                intent.setData(Uri.parse(item.link));
                //opening intent
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                //when we click the card view it will take us to a new web browser in the app
            }
        });

        viewHolder.rssTitle.setText(item.title);
        viewHolder.rssDescription.setText(item.description);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void add(int position, RssDataParser.Item item) {//purpse of this method is to add it to the mDataset arraylist

        mDataset.add(position, item);
        //to referesh the data and ensure its changed (updating the recycler view)
        notifyItemChanged(position);

    }

    public void remove(RssDataParser.Item item){
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void clear(){
        mDataset.clear();
    }

    //this will store all the views inside rss_feed_item.. like the title, cardview, and description
    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView rssTitle, rssDescription;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view.findViewById(R.id.card_view);
            rssTitle = (TextView)view.findViewById(R.id.item_title);
            rssDescription = (TextView)view.findViewById(R.id.item_description);
        }

    }


}
