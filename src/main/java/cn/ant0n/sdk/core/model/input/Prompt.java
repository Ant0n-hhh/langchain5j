package cn.ant0n.sdk.core.model.input;


import cn.ant0n.sdk.core.data.message.impl.AssistantMessage;
import cn.ant0n.sdk.core.data.message.impl.SystemMessage;
import cn.ant0n.sdk.core.data.message.impl.UserMessage;

import static cn.ant0n.sdk.types.utils.ValidationUtils.ensureNotBlank;

public class Prompt {

    private final String text;

    public Prompt(String text) {
        this.text = ensureNotBlank(text);
    }


    public UserMessage toUserMessage() {
        return UserMessage.from(this.text);
    }

    public SystemMessage toSystemMessage() {
        return SystemMessage.from(this.text);
    }

    public AssistantMessage toAssistantMessage() {
        return AssistantMessage.from(this.text);
    }


    public static Prompt from(String text){
        return new Prompt(text);
    }
}
