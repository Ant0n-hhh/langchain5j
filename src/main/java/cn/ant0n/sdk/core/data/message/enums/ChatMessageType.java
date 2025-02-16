package cn.ant0n.sdk.core.data.message.enums;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.message.impl.AssistantMessage;
import cn.ant0n.sdk.core.data.message.impl.SystemMessage;
import cn.ant0n.sdk.core.data.message.impl.UserMessage;
import lombok.Getter;

@Getter
public enum ChatMessageType {

    SYSTEM(SystemMessage.class),
    USER(UserMessage.class),
    ASSISTANT(AssistantMessage.class);

    private final Class<? extends ChatMessage> chatMessageClazz;

    ChatMessageType(Class<? extends ChatMessage> chatMessageClazz){
        this.chatMessageClazz = chatMessageClazz;
    }

    public Class<? extends ChatMessage> chatMessageClazz(){
        return chatMessageClazz;
    }
}
