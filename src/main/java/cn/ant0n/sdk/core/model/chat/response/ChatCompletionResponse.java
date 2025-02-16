package cn.ant0n.sdk.core.model.chat.response;

import cn.ant0n.sdk.core.data.message.impl.AssistantMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatCompletionResponse implements Serializable {
    private String id;
    private Long created;
    private String model;
    private List<ChatCompletionChoices> choices;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChatCompletionChoices implements Serializable {

        private Integer index;

        private String finish_reason;

        private Message message;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Message implements Serializable {
            private String role = "assistant";
            private String content;
        }
    }
}
