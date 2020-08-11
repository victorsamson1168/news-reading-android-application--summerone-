package com.example.summerone;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;
//api key a8299f4eb1584dbebcae7c6d2561da0b   news api .org

public class MainActivity extends AppCompatActivity {
    Downloadasync start=new Downloadasync();
    private String result;
    CustomAdapter adapterr;
    JSONObject parts;
    JSONArray mainJSONArray;
    private FirebaseAuth mAuth;
    Button logout;
   @Override
 public void onStart() {
       super.onStart();
       // Check if user is signed in (non-null) and update UI accordingly.
       FirebaseUser currentUser = mAuth.getCurrentUser();
       if(currentUser==null){
           Intent authIntent=new Intent(getApplicationContext(),Login.class);
           startActivity(authIntent);
           finish();
       }
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        logout=(Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent mainin=new Intent(getApplicationContext(),Login.class);
                startActivity(mainin);
                finish();
            }
        });

        //UIL initialization
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
           .cacheInMemory(true)
                .cacheOnDisk(true)
           .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
           .defaultDisplayImageOptions(defaultOptions)
           .build();
        ImageLoader.getInstance().init(config);
        //ending of UIL
        adapterr=new CustomAdapter(this,R.layout.design);
        final ListView listView= (ListView) findViewById(R.id.lvl);
        listView.setAdapter(adapterr);




        executeapi();
        try
        {
            parts = new JSONObject(result);
            mainJSONArray = parts.getJSONArray("articles");
            String author,content,title,published,imurl,link;

            for (int i = 0; i < mainJSONArray.length(); i++) {
                JSONObject child = mainJSONArray.getJSONObject(i);
                author = child.getString("author");
                content = child.getString("content");
                title = child.getString("title");
                published = child.getString("publishedAt");
                imurl = child.getString("urlToImage");
                link = child.getString("url");
                Details details = new Details(author, title, published, content, imurl, link);
                adapterr.add(details);

            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView v=(TextView)findViewById(R.id.link) ;

                Intent i=new Intent(getApplicationContext(), Webvv.class);
                i.putExtra("linkage",v.getText().toString());
                Toast.makeText(MainActivity.this, v.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });


    }

    public void executeapi(){
        try {

            result=start.execute("https://newsapi.org/v2/top-headlines?country=in&apiKey=a8299f4eb1584dbebcae7c6d2561da0b").get();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error in exe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }



}

