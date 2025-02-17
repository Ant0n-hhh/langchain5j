package cn.ant0n.sdk.core.model.input;

import cn.ant0n.sdk.types.Exceptions;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTemplateRender implements TemplateRender {

    private final Pattern VARIABLE_PATTERN = Pattern.compile("\\{\\{(.+?)}}");
    private final String template;
    private final Set<String> allVariables;

    public DefaultTemplateRender(String template) {
        this.template = template;
        this.allVariables = new HashSet<String>();
        extractVariables(this.template);
    }

    private void extractVariables(String template){
        Matcher matcher = VARIABLE_PATTERN.matcher(template);
        while(matcher.find()){
            allVariables.add(matcher.group(1));
        }
    }

    @Override
    public String render(Map<String, Object> variables) {
        ensureAllVariablesProvided(variables);
        String result = this.template;
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            String variable = entry.getKey();
            String value = String.valueOf(entry.getValue());
            result = replaceAll(result, variable, value);
        }
        return result;
    }

    private void ensureAllVariablesProvided(Map<String, Object> variables){
        for(String variable : allVariables){
            if(!variables.containsKey(variable)){
                throw Exceptions.promptTemplateVariablesMissing();
            }
        }
    }

    private String replaceAll(String template, String variable, String value){
        if(StringUtils.isBlank(variable) || StringUtils.isBlank(value)){
            throw Exceptions.promptTemplateVariablesMissing();
        }
        return template.replace(this.isDoubleCurlyBracket(variable), value);
    }

    private String isDoubleCurlyBracket(String variable){
        return "{{" + variable + "}}";
    }
}
