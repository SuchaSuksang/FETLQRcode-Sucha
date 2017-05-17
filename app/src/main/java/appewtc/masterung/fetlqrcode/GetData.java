package appewtc.masterung.fetlqrcode;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by THQN150303 on 17/05/2017.
 */

public class GetData extends AsyncTask<Object, Object, String> {

    //Explicit
    private Context context ;


    public GetData(Context context) {
        this.context = context;
    }


    @Override
    protected String doInBackground(Object... params) {

        try {

            OkHttpClient okHttpClient =new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url((String) params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("17MayV2","e doin ==>" + e.toString());
            return null;

        }

    }
}//Main Class
