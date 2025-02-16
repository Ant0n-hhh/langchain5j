package cn.ant0n.sdk.qwen;

import cn.ant0n.sdk.core.data.helper.ChatMessageHelper;
import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.text.ChatMessageText;
import cn.ant0n.sdk.core.data.text.impl.AssistantMessageText;
import cn.ant0n.sdk.core.model.chat.ChatLanguageModel;
import cn.ant0n.sdk.core.model.chat.request.ChatCompletionRequest;
import cn.ant0n.sdk.core.model.chat.request.ChatCompletionsConfigContext;
import cn.ant0n.sdk.core.model.chat.response.ChatCompletionResponse;
import cn.ant0n.sdk.core.model.output.Response;
import cn.ant0n.sdk.qwen.api.QwenChatModelApi;
import cn.ant0n.sdk.qwen.client.QwenChatClient;
import cn.ant0n.sdk.types.Exceptions;
import retrofit2.Call;

import java.util.List;

public class QwenChatModel implements ChatLanguageModel {


    @Override
    public Response<ChatMessageText> generate(List<ChatMessageText> chatMessageTexts, ChatCompletionsConfigContext context) {
        List<ChatMessage> chatMessages = ChatMessageHelper.toMessage(chatMessageTexts);
        QwenChatModelApi qwenChatModelApi = QwenChatClient.create(context);

        String authorization = "Bearer ".concat(context.getApiKey());

        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel(context.getModel());
        request.setStream(context.getStream());
        request.setTemperature(context.getTemperature());
        request.setTopP(context.getTopP());

        for (ChatMessage chatMessage : chatMessages) {
            request.add(chatMessage.type(), chatMessage.content());
        }

        try{
            Call<ChatCompletionResponse> call = qwenChatModelApi.completions(request, authorization);
            ChatCompletionResponse response = call.execute().body();
            if(response == null) return null;
            return Response.from(AssistantMessageText.from(response.getChoices().get(0).getMessage().getContent()));
        }catch (Exception e){
            throw Exceptions.modelRequestException("qwen model request error".concat(e.getMessage()));
        }
    }
}
