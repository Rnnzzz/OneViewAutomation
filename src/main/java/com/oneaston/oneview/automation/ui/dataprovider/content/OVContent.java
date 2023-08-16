package com.oneaston.oneview.automation.ui.dataprovider.content;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OVContent {
    private final Map<String, String> content;

    public OVContent(Map<String, String> defaultDetails) {
        this.content = defaultDetails;
    }

    public OVContent() {
        content = new HashMap<>();
    }

    public void addContent(String key, String value) {
        content.put(key, value);
    }

    public void addAll(Map<String, String> content) {
        this.content.putAll(content);
    }

    public String getContent(String key) {
        return content.get(key);
    }

    public Set<String> keySet() {
        return content.keySet();
    }

    public Collection<String> values() {
        return content.values();
    }

    public String toString() {
        return content.toString();
    }
}
