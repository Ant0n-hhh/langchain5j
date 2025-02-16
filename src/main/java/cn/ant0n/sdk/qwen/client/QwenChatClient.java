package cn.ant0n.sdk.qwen.client;

import cn.ant0n.sdk.core.model.chat.request.ChatCompletionsConfigContext;
import cn.ant0n.sdk.qwen.api.QwenChatModelApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class QwenChatClient {

    private static final String baseUrl = "https://dashscope.aliyuncs.com/";


    public static QwenChatModelApi create(ChatCompletionsConfigContext context){
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(1200, TimeUnit.SECONDS).
                readTimeout(1200, TimeUnit.SECONDS).
                writeTimeout(1200, TimeUnit.SECONDS).build();


        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(QwenChatModelApi.class);
    }
}
