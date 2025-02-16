package cn.ant0n.sdk.core.data.text.impl;

import cn.ant0n.sdk.core.data.text.ChatMessageText;
import lombok.Builder;

@Builder
public class SystemMessageText implements ChatMessageText {
    private final String text;

    public SystemMessageText(String text) {
        this.text = text;
    }
    @Override
    public String text() {
        return this.text;
    }

    public static SystemMessageText from(String text){
        return SystemMessageText.builder()
                .text(text)
                .build();
    }
}
