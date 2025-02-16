package cn.ant0n.sdk.core.data.message.impl;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.message.enums.ChatMessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
public class UserMessage implements ChatMessage, Serializable {

    @Getter
    @Setter
    private String content;




    public static UserMessage from(String content) {
        return UserMessage.builder().content(content).build();
    }

    @Override
    public String type() {
        return "user";
    }

    @Override
    public String content() {
        return content;
    }
}
