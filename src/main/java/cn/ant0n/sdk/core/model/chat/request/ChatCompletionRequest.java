package cn.ant0n.sdk.core.model.chat.request;

import cn.ant0n.sdk.core.data.message.ChatMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatCompletionRequest implements Serializable {
    private String model;
    private Boolean stream;
    private List<Message> messages = new ArrayList<>();
    private Float temperature;
    @JsonProperty("top_p")
    private Float topP;

    @Data
    @NoArgsConstructor
    public static class Message{

        private String role;
        private String content;

        public Message(String role, String content) {
            this.content = content;
            this.role = role;
        }
    }

    public void add(String role, String content){
        messages.add(new Message(role, content));
    }

}
