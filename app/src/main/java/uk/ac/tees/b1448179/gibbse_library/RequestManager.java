package uk.ac.tees.b1448179.gibbse_library;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import uk.ac.tees.b1448179.gibbse_library.DictionaryModels.APIResponse;


//API handling
public class RequestManager {
    Context context;

    //create object for retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //constructor for request manager
    public RequestManager(Context context) {

        this.context = context;
    }

    public void getWordMeaning(OnFetchDataListener listener, String word){

        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call <List<APIResponse>> call = callDictionary.callMeanings(word);

        try{
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    listener.onError("Oop, Request Failed!! Please try again");

                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An Error somewhere!", Toast.LENGTH_SHORT).show();
        }

    }


    //create the interface for API calling
    public interface CallDictionary {
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callMeanings(
                @Path("word") String word

        );

    }

}
