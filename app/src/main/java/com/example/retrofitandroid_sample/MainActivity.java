package com.example.retrofitandroid_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitandroid_sample.API.ApiService;
import com.example.retrofitandroid_sample.Adapter.UserAdapter;
import com.example.retrofitandroid_sample.model.Currency;
import com.example.retrofitandroid_sample.model.Post;
import com.example.retrofitandroid_sample.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    private TextView tv_success , tv_code , tv_info , tv_post;
//    Button callAPI;
    private RecyclerView recyclerView;
    private List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.recycview_callapi);

        recyclerView = findViewById(R.id.rcv);
        list = new ArrayList<>();
        callApigetUsers();
//        tv_code = findViewById(R.id.code);
//        tv_success = findViewById(R.id.success);
//        tv_info = findViewById(R.id.infor);
//        callAPI = findViewById(R.id.callAPI);
//        tv_post = findViewById(R.id.tv_post);
//
//        callAPI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //clickCallAPI();
//                sendPosts();
//            }
//        });
//    }
//
//    private void clickCallAPI() {
//        //http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
//        //https://jsonplaceholder.typicode.com/posts
//
//        //ApiService.apiService.call("843d4d34ae72b3882e3db642c51e28e6","VND","USD",1)
//        ApiService.apiService.call()
//                .enqueue(new Callback<Currency>() {
//                    @Override
//                    public void onResponse(Call<Currency> call, Response<Currency> response) {
//                        Toast.makeText(MainActivity.this,"call API Success" , Toast.LENGTH_LONG).show();
//                        Currency currency = response.body();
//                        if(currency != null && currency.isSuccess()==false){
//                            tv_success.setText(String.valueOf(currency.isSuccess()));
//                            tv_code.setText(String.valueOf(currency.getError().getCode()));
//                            tv_info.setText(currency.getError().getInfo());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Currency> call, Throwable t) {
//                        Toast.makeText(MainActivity.this,"call API error" , Toast.LENGTH_LONG).show();
//                    }
//                });
//    }
//
//    private void sendPosts(){
//        Post post = new Post(31 , 10 , "Trinh Khắc Hùng" , "Trịnh Khắc Hùng Sample");
//
//        ApiService.apiService.sendPost(post).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                Toast.makeText(MainActivity.this,"call API Success" , Toast.LENGTH_LONG).show();
//
//                Post postResult = response.body();
//                if(postResult != null){
//                    tv_post.setText(postResult.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//            }
//        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void callApigetUsers(){
        ApiService.apiService.getListUser(1).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(MainActivity.this,"call API Success" , Toast.LENGTH_LONG).show();
                list = response.body();
                UserAdapter userAdapter = new UserAdapter(list);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"call API error" , Toast.LENGTH_LONG).show();
            }
        });
    }
}