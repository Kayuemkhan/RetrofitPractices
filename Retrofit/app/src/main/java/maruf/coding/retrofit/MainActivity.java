package maruf.coding.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview23);
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClient ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

//       Call<OurMainClass> call =  ourRetrofitClient.getData("DRqlVrlay2NGOafUSTcZEmzkzVEPPTqWW55POFVuqv1Q65VZQzCJvQZQVNJG");
        Call<tutorial2> call = ourRetrofitClient.getData(2, "DRqlVrlay2NGOafUSTcZEmzkzVEPPTqWW55POFVuqv1Q65VZQzCJvQZQVNJG");
       call.enqueue(new Callback<tutorial2>() {
           @Override
           public void onResponse(Call<tutorial2> call, Response<tutorial2> response) {
               if(!response.isSuccessful()){
                   textView.setText("Code:"+response.code());
               }
               else {
                    ObjectDataClass objectDataClass = response.body().getData();
                   String data ="";
                   data += objectDataClass.getName()+"\n";
                   data += objectDataClass.getId()+"\n";
                   data += objectDataClass.getResource()+"\n";
                   data += objectDataClass.getUpdated_at()+"\n";
                   textView.append(data);
               }
           }

           @Override
           public void onFailure(Call<tutorial2> call, Throwable t) {

           }
       });
//       call.enqueue(new Callback<OurMainClass>() {
//           @Override
//           public void onResponse(Call<OurMainClass> call, Response<OurMainClass> response) {
//                if(!response.isSuccessful()){
//                    textView.setText("Code:"+response.code());
//                }
//               if(response.isSuccessful()){
//                    List<ObjectDataClass> list = response.body().getData();
//                    for(ObjectDataClass objectDataClass:list){
//                        String content ="";
//                        content += "ID : "+objectDataClass.getId()+"\n";
//                        content += "Name : "+objectDataClass.getName()+"\n";
//                        content += "Resource : "+objectDataClass.getResource()+"\n";
//                        content += "Updated At : "+objectDataClass.getUpdated_at()+"\n";
//
//                        textView.append(content);
//                    }
//                }
//           }
//
//           @Override
//           public void onFailure(Call<OurMainClass> call, Throwable t) {
//
//           }
//       });
//    }
    }
}