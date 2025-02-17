package cn.ant0n.sdk.core.model.input;

import java.util.Map;

public interface TemplateRender {


    /**
     * 渲染模板
     * @param variables 可变变量
     * @return 渲染后的提示词模板
     */
    String render(Map<String, Object> variables);
}
