package cn.ant0n.sdk.core.data.message.impl;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import cn.ant0n.sdk.core.data.message.enums.ChatMessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
public class SystemMessage implements ChatMessage, Serializable {


    @Getter
    @Setter
    private String content;




    public static SystemMessage from(String content) {
        return SystemMessage.builder().content(content).build();
    }

    @Override
    public String type() {
        return "system";
    }

    @Override
    public String content() {
        return content;
    }
}
