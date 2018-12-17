package aliskm.tech.fragmenttext;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class FragmentTwo extends Fragment {

    private Api weatherServiceApi;
    private View rootView;
    private TextView dataTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_two, container, false);
        initializeAll(rootView);
        return rootView;
    }

    private void initializeAll(View rootView) {
        dataTv = rootView.findViewById(R.id.dataTv);
        networkLibraryInitialize();

    }


    private void networkLibraryInitialize() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        weatherServiceApi = retrofit.create(Api.class);

        Call<String> myCall = weatherServiceApi.getAllWeather("data/2.5/weather?zip=94040,us&appid=23fee6b56f1670a5d300435fb8083daf");
        myCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    Log.e("data", "success: " + response.body());
                    dataTv.setText("" + response.body() + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("data", "onFailure: " + t);
            }
        });
    }

}
