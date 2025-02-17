package cn.ant0n.sdk.core.model.input;

public class DefaultPromptTemplateFactory implements PromptTemplateFactory {



    @Override
    public TemplateRender create(PromptTemplateInput input) {
        return new DefaultTemplateRender(input.getTemplate());
    }
}
