package com.example.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText titleEt =  findViewById(R.id.et_title);
        final EditText bodyEt =  findViewById(R.id.et_body);
        Button submitBtn =  findViewById(R.id.btn_submit);
        mResponseTv =  findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });

    }

    public void sendPost(String title, String body) {
        mAPIService.savePost(title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Toast.makeText(getApplicationContext(),"post submitted to API." + response.body().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Unable To post",Toast.LENGTH_LONG).show();
                Log.d("TAG", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

}