package cn.ant0n.sdk.core.data.message.impl;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.message.enums.ChatMessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Builder
public class AssistantMessage implements ChatMessage, Serializable {

    @Setter
    @Getter
    private String content;


    public static AssistantMessage from(String content){
        return AssistantMessage.builder().content(content).build();
    }

    @Override
    public String type() {
        return "assistant";
    }

    @Override
    public String content() {
        return content;
    }
}
