package cn.ant0n.sdk.core.model.input;

public interface PromptTemplateInput {

    String getTemplate();


    default String template(){
        return "template";
    }
}
