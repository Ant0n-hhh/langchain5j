package cn.ant0n.sdk.core.model.chat.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatCompletionsConfigContext {
    private String model;
    private Boolean stream;
    private Float temperature;
    private Float topP;

    private String apiKey;
}
