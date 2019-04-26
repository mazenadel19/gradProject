package com.example.acer_pc.radar;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by AhmedTorres on 27/04/2017.
 */

public class BackgroundTask extends AsyncTask<String ,Void,String > {

    Context ctx;

    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://10.0.3.2/Renta/register.php";
        String login_url="http://127.0.0.1/webapp/login.php";
        String method= params[0];

        if (method.equals("register"))
        {
            String Username=params[1];
            String Email=params[2];
            String Password=params[3];
            String Phone=params[4];
            String District=params[5];
            String Gender=params[6];



            try {

                URL url =new URL(reg_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream OS =httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data= URLEncoder.encode("Username","UTF-8")+"="+URLEncoder.encode(Username,"UTF-8")+"&"+
                        URLEncoder.encode("Email","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8")+"&"+
                        URLEncoder.encode("Phone","UTF-8")+"="+URLEncoder.encode(Phone,"UTF-8")+"&"+
                        URLEncoder.encode("District","UTF-8")+"="+URLEncoder.encode(District,"UTF-8")+"&"+
                        URLEncoder.encode("Gender","UTF-8")+"="+URLEncoder.encode(Gender,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS= httpURLConnection.getInputStream();
                IS.close();
                return "hello";

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }

}

