package cn.ant0n.sdk.core.data.helper;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.text.ChatMessageText;
import cn.ant0n.sdk.core.data.text.impl.AssistantMessageText;
import cn.ant0n.sdk.core.data.text.impl.SystemMessageText;
import cn.ant0n.sdk.core.data.text.impl.UserMessageText;
import cn.ant0n.sdk.core.model.input.Prompt;

import java.util.ArrayList;
import java.util.List;

import static cn.ant0n.sdk.types.Exceptions.illegalArgument;

public class ChatMessageHelper {

    public static List<ChatMessage> toMessage(List<ChatMessageText> chatMessageTexts){
        List<ChatMessage> chatMessages = new ArrayList<>();
        for (ChatMessageText chatMessageText : chatMessageTexts) {
            Prompt prompt = Prompt.from(chatMessageText.text());
            chatMessages.add(toMessage(chatMessageText, prompt));
        }
        return chatMessages;
    }

    public static ChatMessage toMessage(ChatMessageText chatMessageText, Prompt prompt){
        if(chatMessageText instanceof UserMessageText){
            return prompt.toUserMessage();
        }
        else if(chatMessageText instanceof SystemMessageText){
            return prompt.toSystemMessage();
        }
        else if(chatMessageText instanceof AssistantMessageText){
            return prompt.toAssistantMessage();
        }
        else{
            throw illegalArgument("unknown chat message text type");
        }
    }
}
