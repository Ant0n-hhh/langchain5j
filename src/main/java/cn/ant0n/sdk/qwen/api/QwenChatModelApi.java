package cn.ant0n.sdk.qwen.api;

import cn.ant0n.sdk.core.model.chat.request.ChatCompletionRequest;
import cn.ant0n.sdk.core.model.chat.response.ChatCompletionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QwenChatModelApi {

    @POST("compatible-mode/v1/chat/completions")
    @Headers({
            "Content-Type: application/json",
            "User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"
    })
    Call<ChatCompletionResponse> completions(@Body ChatCompletionRequest request, @Header("Authorization")String authorization);
}
