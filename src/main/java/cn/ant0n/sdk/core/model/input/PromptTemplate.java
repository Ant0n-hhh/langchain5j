package cn.ant0n.sdk.core.model.input;


import java.util.HashMap;
import java.util.Map;

public class PromptTemplate {

    private static Map<String, String> PRESET_TEMPLATE = new HashMap<>();

    static {
        PRESET_TEMPLATE.put("BUSINESS", PresetTemplate.BUSINESS);
    }

    private final TemplateRender render;
    private PromptTemplateFactory FACTORY = new DefaultPromptTemplateFactory();

    public PromptTemplate(String template, boolean presetTemplate) {
        render = FACTORY.create(new PromptTemplateInput() {
            @Override
            public String getTemplate() {
                if(!presetTemplate){
                    return template;
                }
                ensureExistTemplate(template);
                return PRESET_TEMPLATE.get(template);
            }
        });
    }

    public Prompt apply(Map<String, Object> variables){
        return Prompt.from(render.render(variables));
    }

    public static PromptTemplate from(String template, boolean presetTemplate){
        return new PromptTemplate(template, presetTemplate);
    }

    private void ensureExistTemplate(String template) {
        if(!PRESET_TEMPLATE.containsKey(template)){
            throw new RuntimeException("template not exist");
        }
    }
}
