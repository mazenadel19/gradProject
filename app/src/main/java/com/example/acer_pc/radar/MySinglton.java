package com.example.acer_pc.radar;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ahmed Torres on 6/16/2017.
 */

public class MySinglton {
    private static MySinglton mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;


    private MySinglton(Context context)
    {
        mCtx=context;
        requestQueue= getRequestQueue();


    }

    public RequestQueue getRequestQueue() {

        if(requestQueue==null)
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        return requestQueue;
    }

    public static synchronized MySinglton getInstance(Context context) {
        if(mInstance==null)
        {

            mInstance = new MySinglton(context);
        }

        return mInstance;
    }


    public <T> void addTIoRequestQue(Request<T> request)
    {
        getRequestQueue().add(request);

    }




}
