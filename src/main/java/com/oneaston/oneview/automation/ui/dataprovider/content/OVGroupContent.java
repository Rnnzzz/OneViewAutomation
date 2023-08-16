package com.oneaston.oneview.automation.ui.dataprovider.content;

import java.util.*;

public class OVGroupContent {
    private final Map<String, OVContent> contentGroup;

    public OVGroupContent() {
        contentGroup = new HashMap<>();
    }

    public OVGroupContent(String groupName, OVContent content) {
        this.contentGroup = new HashMap<String, OVContent>() {{
            put(groupName, content);
        }};
    }

    public void addContent(String key, OVContent value) {
        contentGroup.put(key, value);
    }

    public OVContent getContentOfGroup(String contentKey) {
        if (isContentNotExisting(contentKey)) {
            return new OVContent();
        }
        return contentGroup.get(contentKey);
    }

    public Set<String> keySet() {
        return contentGroup.keySet();
    }

    public Collection<OVContent> values() {
        return contentGroup.values();
    }

    public String toString() {
        return contentGroup.toString();
    }

    public void clear() {
        contentGroup.clear();
    }

    public void add(String instrumentCode, OVContent collateralDetails) {
        this.addContent(instrumentCode, collateralDetails);
    }

    public List<String> filter(String contentKey) {
        List<String> values = new ArrayList<>();
        for (String key : contentGroup.keySet()) {
            if (!checkIfContentValueIsNull(contentGroup.get(key).getContent(contentKey))) {
                values.add(contentGroup.get(key).getContent(contentKey));
            }

        }
        return values;
    }

    public int getSize() {
        return contentGroup.size();
    }

    boolean checkIfContentValueIsNull(String contentValue) {
        return contentValue == null;
    }

    public boolean isContentNotExisting(String content) {
        return !contentGroup.containsKey(content);
    }
}
