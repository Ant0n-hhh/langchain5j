package cn.ant0n.sdk.core.model.input.test;

import cn.ant0n.sdk.core.model.input.DefaultTemplateRender;
import cn.ant0n.sdk.core.model.input.PromptTemplate;
import cn.ant0n.sdk.core.model.input.TemplateRender;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DefaultTemplateRenderTest {



    @Test
    public void test_01(){
        String template = "BUSINESS";
        Map<String, Object> variables = new HashMap<>();
        variables.put("language", "C++");

        PromptTemplate promptTemplate = PromptTemplate.from(template, true);
        System.out.println(promptTemplate.apply(variables).toUserMessage().content());
    }
}
