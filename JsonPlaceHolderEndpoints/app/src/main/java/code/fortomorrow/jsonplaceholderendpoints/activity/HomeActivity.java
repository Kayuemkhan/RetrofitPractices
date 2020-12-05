package code.fortomorrow.jsonplaceholderendpoints.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import code.fortomorrow.jsonplaceholderendpoints.R;
import code.fortomorrow.jsonplaceholderendpoints.retrofit.CommentsData;
import code.fortomorrow.jsonplaceholderendpoints.retrofit.IdCallData;
import code.fortomorrow.jsonplaceholderendpoints.retrofit.OurRetrofirClient;
import code.fortomorrow.jsonplaceholderendpoints.retrofit.POJOClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resultTextView = findViewById(R.id.resultTV);
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofirClient ourRetrofirClient = retrofit.create(OurRetrofirClient.class);
          Call<List<POJOClass>> call = ourRetrofirClient.getPosts(2);
//        Call<IdCallData> callDataCall = ourRetrofirClient.getposts(2);
//        Call<List<CommentsData>> commentsDataCall = ourRetrofirClient.getPosts(1);
        call.enqueue(new Callback<List<POJOClass>>() {
            @Override
            public void onResponse(Call<List<POJOClass>> call, Response<List<POJOClass>> response) {
                if(!response.isSuccessful()){
                    resultTextView.append(response.message());
                }
                else {
                    List<POJOClass> pojoClass = response.body();
                    for(POJOClass pojoClass1: pojoClass){
                        String content ="";
                        content += "ID : "+pojoClass1.getId()+"\n";
                        content += "Name : "+pojoClass1.getBody()+"\n";
                        content += "Resource : "+pojoClass1.getTitle()+"\n";
                        content += "Updated At : "+pojoClass1.getUserId()+"\n";

                        resultTextView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<POJOClass>> call, Throwable t) {
                resultTextView.append(t.getMessage());
            }
        });
//        callDataCall.enqueue(new Callback<IdCallData>() {
//            @Override
//            public void onResponse(Call<IdCallData> call, Response<IdCallData> response) {
//                if(!response.isSuccessful()){
//                    resultTextView.append(response.message());
//                }
//                else {
//                    IdCallData idCallData = response.body();
//                    String content ="";
//                    content += "ID : "+idCallData.getId()+"\n";
//                    content += "Name : "+idCallData.getBody()+"\n";
//                    content += "Resource : "+idCallData.getTitle()+"\n";
//                    content += "Updated At : "+idCallData.getUserId()+"\n";
//                    resultTextView.append(content);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<IdCallData> call, Throwable t) {
//
//            }
//        });
//        commentsDataCall.enqueue(new Callback<List<CommentsData>>() {
//            @Override
//            public void onResponse(Call<List<CommentsData>> call, Response<List<CommentsData>> response) {
//                if(!response.isSuccessful()){
//                    resultTextView.append(response.message());
//                }
//                else {
//                    List<CommentsData> list = response.body();
//                    for(CommentsData data:list){
//                        String content = "";
//                        content += "ID : "+data.getName()+"\n";
//                        content += "Name : "+data.getBody()+"\n";
//                        content += "Resource : "+data.getEmail()+"\n";
//                        content += "Updated At : "+data.getId()+"\n";
//                        content += "Updated At : "+data.getPostId()+"\n";
//
//                        resultTextView.append(content);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CommentsData>> call, Throwable t) {
//
//            }
//        });

    }
}