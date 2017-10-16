package com.example.noxusfrosted.lazyinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.noxusfrosted.lazyinstagram.adapter.PostAdapter;
import com.example.noxusfrosted.lazyinstagram.api.Api;
import com.example.noxusfrosted.lazyinstagram.model.UserProfile;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private Spinner accountSpinner;
    private String layoutType = "grid";
    private String user = "android";
    private ArrayList<String> account = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountSpinner = findViewById(R.id.spinner);
        createAccount();
        ArrayAdapter<String> adapterAccount = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, account);
        accountSpinner.setAdapter(adapterAccount);
        accountSpinner.setOnItemSelectedListener(this);
        getUserProfile(user);
    }

    private void getUserProfile(String name) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        api.getProfile(name).enqueue(new retrofit2.Callback<UserProfile>() {
            @Override
            public void onResponse(retrofit2.Call<UserProfile> call, retrofit2.Response<UserProfile> response) {
                UserProfile userProfile = response.body();
                display(userProfile);
            }
            @Override
            public void onFailure(retrofit2.Call<UserProfile> call, Throwable t) {

            }
        });
    }


    private void display(UserProfile userProfile){

        ImageView imageProfile = findViewById(R.id.imageProfile);
        Glide.with(this).load(userProfile.getUrlProfile()).into(imageProfile);




        Glide.with(MainActivity.this).load(userProfile.getUrlProfile()).into(imageProfile);
        TextView textPost = findViewById(R.id.textPost);
        textPost.setText("Post\n" + userProfile.getPost());
        TextView textFollowing = findViewById(R.id.textFollowing);
        textFollowing.setText("Following\n" + userProfile.getFollowing());
        TextView textFollower = findViewById(R.id.textFollower);
        textFollower.setText("Follower\n" + userProfile.getFollower());
        TextView textBio = findViewById(R.id.textBio);
        textBio.setText(userProfile.getBio());

        RecyclerView list = findViewById(R.id.list);
        if (layoutType.equals("grid")) {
            list.setLayoutManager(new GridLayoutManager(this, 3));
        } else{
            list.setLayoutManager(new LinearLayoutManager(this));
        }
        PostAdapter adapter = new PostAdapter(this);
        adapter.setData(userProfile.getPosts());
        adapter.setLayoutType(layoutType);
        list.setAdapter(adapter);




    }



    public void createAccount(){
        account.add("@android");
        account.add("@nature");
        account.add("@cartoon");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        switch (item) {
            case "@android":
                user = "android";
                break;
            case "@cartoon":
                user = "cartoon";
                break;
            default:
                user = "nature";
                break;
        }
        getUserProfile(user);
    }

    public void onGrid(View view) {
        layoutType = "grid";
        getUserProfile(user);
    }

    public void onList(View view) {
        layoutType = "list";
        getUserProfile(user);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
