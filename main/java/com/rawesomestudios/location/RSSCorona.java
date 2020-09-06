package com.rawesomestudios.location;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class RSSCorona extends AppCompatActivity {



    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager; //have to use this for the recycler view.. setting up a linear layout
    RecyclerAdapter mRecyclerAdapter;

    public RSSCorona() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_r_s_s_corona);


        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.corona_swipe_refresh_layout);
        mRecyclerView = (RecyclerView)findViewById(R.id.corona_recycler_view);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerAdapter = new RecyclerAdapter(this, new ArrayList<RssDataParser.Item>());
        mRecyclerView.setAdapter(mRecyclerAdapter); //set the recycler view

        new GetCoronaFeed().execute();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRecyclerAdapter.clear(); //clear the data because we are going to pass in new data from the url when someone refreshes
                new GetCoronaFeed().execute();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private class GetCoronaFeed extends AsyncTask<Void, Void, ArrayList<RssDataParser.Item>> {
        @Override
        protected ArrayList<RssDataParser.Item> doInBackground(Void... voids) { //neeed additional methods in order to download and proceess the data
            try{
                return loadXmlFromNetwork("https://rss.nytimes.com/services/xml/rss/nyt/Health.xml"); //the url with the data
            } catch (XmlPullParserException e) {
                Log.e("Error", e.getMessage());
            } catch (IOException e) {
                Log.e("Error", e.getMessage());
            }
            return null; //no data
        }

        @Override
        protected void onPostExecute(ArrayList<RssDataParser.Item> items) {

            if(items != null){ //if it is null then the connection did not go through, so we have to make sure item is not null

                Log.d("ArrayList", "Items: " + items.toString());
                int itemSize = items.size();
                for(int i = 0; i < items.size(); i++){ //for look in order to append the items to the mRecyclerAdapter because our RecyclerAdapter is like our container for all the items
                    mRecyclerAdapter.add(i, items.get(i));
                }
                mRecyclerAdapter.notifyDataSetChanged(); //have to notify the recycler adapter that the data has changed (whenever you add or remove stuff)

            } else{ //connection failed and nothing worked
                Log.e("OnPostExecute", "ArrayList is Null");
//                Snackbar.make(this, "No Connection was Made", Snackbar.LENGTH_LONG).show();

            }


        }
    }

    private ArrayList loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {

        //create an InputStream to get the data from the url we pass in

        InputStream inputStream = null;
        RssDataParser rssDataParser = new RssDataParser(); //reference variable used to parse the Rss Data
        ArrayList<RssDataParser.Item> entries = null; //to get the data that gets returned

        try{
            inputStream = downloadUrl(urlString); //go to the link and download it in the form of a string block (input stream)
            //now we can start parsing the data
            entries = rssDataParser.parse(inputStream);
            return entries;
        }finally { //to make sure we have a solid connection afterwards once we are done with it
            if(inputStream != null){
                inputStream.close();
            }
        }

    }

    private InputStream downloadUrl(String urlString) throws IOException { //throw IOException because we are doing some sort of connection

        //we will create our acctual URL here
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        HttpURLConnection.setFollowRedirects(false); //makes sure the connection goes through effeciently
        connection.setConnectTimeout(15*1000); //15 seconds to download
        connection.setRequestMethod("GET"); //we will be pulling the data
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        return inputStream;

    }
}