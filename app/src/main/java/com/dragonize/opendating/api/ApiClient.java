package com.dragonize.opendating.api;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String baseUrl = "https://";
    private static final String baseWebUrl = "http://";
    private static Retrofit retrofit = null;
    private static Retrofit web_retrofit = null;
    private static Long cacheSize = (long) (5 * 1024 * 1024);
    private static Cache myCache;
    //
//    val okHttpClient = OkHttpClient.Builder()
//            .cache(myCache)
//            .addInterceptor { chain ->
//            var request = chain.request()
//        request = if (hasNetwork(context)!!)
//        request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
//                    else
//        request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
//        chain.proceed(request)
//    }
//                .build()
    public static Retrofit getAPI(){
        if(retrofit == null){
            Gson gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getWebAPI(Context context){
        File file = context.getCacheDir();
        File[] files = file.listFiles();
        Log.i("Cache Files",file.listFiles().length+"");
        Log.i("File1 file",files[0].getName()+"");
        Log.i("File2 file",files[1].getName()+"");
        myCache = new Cache(context.getCacheDir(), cacheSize);
        if(web_retrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().cache(myCache).addInterceptor(interceptor).build();
            Gson gson = new GsonBuilder().setLenient().create();

            web_retrofit = new Retrofit.Builder()
                    .baseUrl(baseWebUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return web_retrofit;
    }

}
