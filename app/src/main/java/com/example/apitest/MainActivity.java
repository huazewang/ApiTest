package com.example.apitest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.charset.Charset;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String json2 ="{\"appid\":\"BgHdyOfq0XDOpb9nDaZ6WEZoK2akxrjZ\",\"nonce\":\"232323df\",\"ts\":1565935992,\"version\":8,\"phoneNumber\":\"+8615001068898\",\"password\":\"huaze147258369\"}";
    private String url2 ="https://cn-api.coolkit.cn:8080/api/user/login";
    private Button bt_login,bt_Deviceid;
    private Button bt_post,bt_Switch;
    private TextView tv_show;

    final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_post = (Button) findViewById(R.id.bt_post);
        bt_Deviceid = (Button) findViewById(R.id.bt_Deviceid);
        bt_Switch = (Button) findViewById(R.id.bt_Switch);
        bt_login.setOnClickListener(this);
        bt_post.setOnClickListener(this);
        bt_Deviceid.setOnClickListener(this);
        bt_Switch.setOnClickListener(this);

        tv_show = (TextView) findViewById(R.id.tv_show);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                loginRequest();
                break;

            case R.id.bt_post:
                getRequest();
                break;

            case R.id.bt_Deviceid:
                getRequest();
                break;

            case R.id.bt_Switch:
                getRequest();
                break;

        }
    }
//    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//    OkHttpClient client2 = new OkHttpClient();
//    String post(String url2, String json2) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json2);
//        Request request = new Request.Builder()
//                .url(url2)
//                .post(json2)
//                .build();
////同步
//        Response response = client2.newCall(request).execute();
//        if (response.isSuccessful()) {
//            return response.body().string();
//        } else {
//            throw new IOException("Unexpected code " + response);
//        }
//    }

    private void loginRequest() {
        LoginSend loginSend = new LoginSend();
        loginSend.setAppid("BgHdyOfq0XDOpb9nDaZ6WEZoK2akxrjZ");
        loginSend.setNonce("232323df");
        loginSend.setTs(1565935992);
        loginSend.setVersion(8);
        loginSend.setPhoneNumber("+8615001068898");
        loginSend.setPassword("huaze147258369");
        Gson gson = new Gson();
//        String json = gson.toJson(loginSend);

        String json ="{\"appid\":\"BgHdyOfq0XDOpb9nDaZ6WEZoK2akxrjZ\",\"nonce\":\"232323df\",\"ts\":1565935992,\"version\":8,\"phoneNumber\":\"+8615001068898\",\"password\":\"huaze147258369\"}";
//        String authorization = ApiSecurity.HMAC_SHA256("yD9IfXJIoWFR7As2W4XMHdP8PNzbAO6O",json);
//        Log.i("WY", authorization);
//        Log.i("WY", loginSend);
//        final String basic = Credentials.basic("Sign oh9/f4eSAvoqgaXuBuU3yfqfvLdUvFxtkF7M8Ldq+Xs=");
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        RequestBody body1 = RequestBody.create(JSON,json2);
        //RequestBody requestBody = FormBody.create(MediaType.parse("application/json;"), json2);
        RequestBody body2=new FormBody.Builder()
                .add("appid","BgHdyOfq0XDOpb9nDaZ6WEZoK2akxrjZ")
                .add("nonce","232323df")
                .add("ts","1565935992")
                .add("version","8")
                .add("phoneNumber","+8615001068898")
                .add("password","huaze147258369")
                .build();
        final Request request = new Request.Builder()
                .url("https://cn-api.coolkit.cn:8080/api/user/login")
                .post(body1)
                .header("Authorization", "Sign oh9/f4eSAvoqgaXuBuU3yfqfvLdUvFxtkF7M8Ldq+Xs=")
                .build();
                //.header("Authorization", "Sign oh9/f4eSAvoqgaXuBuU3yfqfvLdUvFxtkF7M8Ldq+Xs=").post(requestBody).url("https://cn-api.coolkit.cn:8080/api/user/login").build();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.e("WY", "321");
                        Log.e("WY", "打印POST响应的数据：" + response.body().string());
                        Log.e("WY", json2);
                       // Log.e("AT",parseIatResult( response.body().string()));
                        tv_show.setText("Successful");

                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    private void getRequest() {
        String url="https://cn-api.coolkit.cn:8080/api/user/device";
        String url2="https://cn-api.coolkit.cn:8080/api/user/device/10004d1c37";
        final Request request = new Request.Builder()
//                .get()
//                .tag(this)
                .url(url2)
                .header("Authorization", "Bearer e9804f2362e8332b0b94d50bfb9941de0031e651")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.i("WY", "123");
                        Log.i("WY", "打印GET响应的数据：" + response.body().string());
                        Log.i("WY", "123");
                        tv_show.setText("123");

                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void postRequest() {

        FormBody formBody = new FormBody.Builder()
                .add("", "")
                .build();

        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(formBody)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.i("WY", "321");
                        Log.i("WY", "打印POST响应的数据：" + response.body().string());
                        Log.i("WY", "321");
                        tv_show.setText("321");
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public static String parseIatResult(String myjson) {
        String strAT="";
        try {
            JSONObject json= new JSONObject(myjson);

            strAT=json.getString("at");
            String stRT=json.getString("rt");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  strAT;
    }

}
