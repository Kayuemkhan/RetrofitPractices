package com.example.fakejsonapipostpractices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    DataClass dataClass ;
    PojoClassForPost pojoClassForPost ;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textresult);
        Retrofit retrofit =
                new Retrofit.Builder()
                .baseUrl("https://app.fakejson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataClass = new DataClass("abdul","kayuem","hey","a","a","afg");
        pojoClassForPost = new PojoClassForPost("dmfJEnoQLfJGK1GLzC8joA",dataClass);
        Log.d("pojo class",new Gson().toJson(pojoClassForPost.toString()));
        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);
        Call<PojoClassForResponse> call =   ourRetrofitClient.getPostValue(pojoClassForPost);
        call.enqueue(new Callback<PojoClassForResponse>() {
            @Override
            public void onResponse(Call<PojoClassForResponse> call, Response<PojoClassForResponse> response) {
                String s = "";
                s += "name:"+response.body().getName()+"\n";
                s += "FirstName:"+response.body().getNameFirst()+"\n";
                s += "name:"+response.body().getNameLast()+"\n";
                s += "name:"+response.body().getNameMiddle()+"\n";
                s += "name:"+response.body().getNamePrefix()+"\n";
                s += "name:"+response.body().getNameSuffix()+"\n";

                textView.append(s);
               // Log.d("data",response.body().getName());
            }

            @Override
            public void onFailure(Call<PojoClassForResponse> call, Throwable t) {
                textView.append(t.getMessage());
            }
        });

    }
}