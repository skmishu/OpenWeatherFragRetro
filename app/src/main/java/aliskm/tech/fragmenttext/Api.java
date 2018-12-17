package aliskm.tech.fragmenttext;

import android.support.annotation.NonNull;

import java.security.Key;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Api {

    static final String BASE_URL= "http://api.openweathermap.org";
    static final String key = "23fee6b56f1670a5d300435fb8083daf";
    static final String latitude = "weather?lat=35&lon=139";
    public String fullUrl = ""+BASE_URL+latitude+"&appid="+key;
    public String url = "forecast/daily?q=Dhaka&mode=json&units=metric&cnt=7&appid="+key;
    public String url2full = "http://api.openweathermap.org/forecast/daily?q=Dhaka&mode=json&units=metric&cnt=7&appid=23fee6b56f1670a5d300435fb8083daf";


    @POST("lead/user_signin")
    @FormUrlEncoded
    Call<String> signIn(@Field("phone") @NonNull String phone, @Field("pass") @NonNull String pass);

    @GET
    Call<String> getAllWeather(@Url String userUrl);
}
