package cn.ant0n.sdk.core.data.message;

import cn.ant0n.sdk.core.data.message.enums.ChatMessageType;

public interface ChatMessage {



    String type();

    String content();
}
