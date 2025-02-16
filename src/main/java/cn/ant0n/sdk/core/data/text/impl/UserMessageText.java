package cn.ant0n.sdk.core.data.text.impl;

import cn.ant0n.sdk.core.data.text.ChatMessageText;
import lombok.Builder;

@Builder
public class UserMessageText implements ChatMessageText {

    private final String text;

    public UserMessageText(String text) {
        this.text = text;
    }
    @Override
    public String text() {
        return this.text;
    }

    public static UserMessageText from(String text){
        return UserMessageText.builder()
                .text(text)
                .build();
    }
}
