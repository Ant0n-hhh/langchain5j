package cn.ant0n.sdk;

import cn.ant0n.sdk.core.data.text.ChatMessageText;
import cn.ant0n.sdk.core.data.text.impl.SystemMessageText;
import cn.ant0n.sdk.core.data.text.impl.UserMessageText;
import cn.ant0n.sdk.core.model.chat.ChatLanguageModel;
import cn.ant0n.sdk.core.model.chat.request.ChatCompletionsConfigContext;
import cn.ant0n.sdk.core.model.output.Response;
import cn.ant0n.sdk.qwen.QwenChatModel;

public class Main {
    public static void main(String[] args) {

        ChatLanguageModel chatLanguageModel = new QwenChatModel();
        ChatCompletionsConfigContext context = new ChatCompletionsConfigContext();
        context.setApiKey("sk-64dc70df479a4cbab0f1564e67229c7d");
        context.setModel("qwen-coder-plus");
        context.setStream(false);
        context.setTopP((float)0.5);
        context.setTemperature((float)0.5);

        SystemMessageText systemMessageText = SystemMessageText.from("假如你是一个Java面试官");
        UserMessageText userMessageText = UserMessageText.from("请告诉我你一般会问哪些问题?");
        Response<ChatMessageText> response = chatLanguageModel.generate(context, systemMessageText, userMessageText);
        System.out.println(response.content().text());
        System.exit(0);
    }
}