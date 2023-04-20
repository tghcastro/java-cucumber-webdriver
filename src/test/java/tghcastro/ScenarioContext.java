package tghcastro;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setValue(String key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getValue(String key){
        return scenarioContext.get(key);
    }

    public Boolean contains(String key){
        return scenarioContext.containsKey(key);
    }

    public String toString() {
        String stringValue = "";
        for (Map.Entry<String,Object> entry : this.scenarioContext.entrySet()) {
            stringValue+= String.format("[%s:%s]", entry.getKey(), entry.getValue());
        }
        return stringValue;
    }
}
