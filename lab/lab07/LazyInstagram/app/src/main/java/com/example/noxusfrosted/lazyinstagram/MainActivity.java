package com.example.noxusfrosted.lazyinstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MainActivity extends AppCompatActivity {

    private String user = "android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                //Log.d(TAG, "onResponse: " + response.body());
                UserProfile userProfile = response.body();
                display(userProfile);
            }
            @Override
            public void onFailure(retrofit2.Call<UserProfile> call, Throwable t) {
                //Log.d(TAG, "onFailure");
            }
        });
    }


    private void display(UserProfile userProfile){

        ImageView imageProfile = findViewById(R.id.imageProfile);
        Glide.with(this).load(userProfile.getUrlProfile()).into(imageProfile);


        TextView textUser = findViewById(R.id.textUser);
        textUser.setText("@"+userProfile.getUser());
        TextView textPost = findViewById(R.id.textPost);
        textPost.setText("Post\n"+userProfile.getPost());
        TextView textFollower = findViewById(R.id.textFollower);
        textFollower.setText("Follower\n"+userProfile.getFollower());
        TextView textFollwing = findViewById(R.id.textFollwing);
        textFollwing.setText("Following\n"+userProfile.getFollowing());
        TextView textBio = findViewById(R.id.textBio);
        textBio.setText(userProfile.getBio());

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(this, 3));
        PostAdapter adapter = new PostAdapter(this);
        adapter.setData(userProfile.getPosts());
        list.setAdapter(adapter);

    }

    //public void onResponse(retrofit2.Call<UserProfile> call, retrofit2.Response<UserProfile> response) {
    //   display(response.body());

    //}

}
