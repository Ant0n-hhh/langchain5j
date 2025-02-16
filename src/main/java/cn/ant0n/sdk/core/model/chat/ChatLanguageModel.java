package cn.ant0n.sdk.core.model.chat;

import cn.ant0n.sdk.core.data.text.ChatMessageText;
import cn.ant0n.sdk.core.model.chat.request.ChatCompletionsConfigContext;
import cn.ant0n.sdk.core.model.output.Response;

import java.util.Arrays;
import java.util.List;

public interface ChatLanguageModel {


    default Response<ChatMessageText> generate(ChatCompletionsConfigContext context, ChatMessageText... chatMessageTexts) {
        return generate(Arrays.asList(chatMessageTexts), context);
    }

    /**
     * 主要与大模型对话交流的接口
     * @param chatMessageTexts
     * @return
     */
    Response<ChatMessageText> generate(List<ChatMessageText> chatMessageTexts, ChatCompletionsConfigContext context);
}
