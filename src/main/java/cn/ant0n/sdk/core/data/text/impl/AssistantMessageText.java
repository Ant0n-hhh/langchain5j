package cn.ant0n.sdk.core.data.text.impl;

import cn.ant0n.sdk.core.data.text.ChatMessageText;
import lombok.Builder;

@Builder
public class AssistantMessageText implements ChatMessageText {
    private final String text;

    public AssistantMessageText(String text) {
        this.text = text;
    }
    @Override
    public String text() {
        return this.text;
    }

    public static AssistantMessageText from(String text){
        return AssistantMessageText.builder()
                .text(text)
                .build();
    }
}
