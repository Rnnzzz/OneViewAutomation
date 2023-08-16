package com.oneaston.oneview.automation.ui.dataprovider.content;

import org.openqa.selenium.WebElement;

import java.util.*;

public class OVPageContent {
    private final Map<String, OVGroupContent> contentPage;

    public OVPageContent() {
        contentPage = new HashMap<>();
    }

    public void addContent(String key, OVGroupContent value) {
        contentPage.put(key, value);
    }

    public OVGroupContent getGroupContentOfKey(String key) {
        if (isGroupNotExisting(key)) {
            return new OVGroupContent();
        }
        return contentPage.get(key);
    }

    public Set<String> keySet() {
        return contentPage.keySet();
    }

    public Collection<OVGroupContent> values() {
        return contentPage.values();
    }

    public String toString() {
        return contentPage.toString();
    }

    public void clear() {
        contentPage.clear();
    }

    public boolean isGroupExisting(String groupName) {
        return contentPage.containsKey(groupName);
    }

    public boolean isGroupNotExisting(String groupName) {
        return !contentPage.containsKey(groupName);
    }

    public void addAllGroup(List<WebElement> groupElementList) {
        for (WebElement groupElement : groupElementList) {
            this.addContent(groupElement.getAttribute("innerText").replaceAll("[0-9]* - ", ""), new OVGroupContent());
        }
    }

    public void addGroup(String group) {
        this.addContent(group, new OVGroupContent());
    }

    public void addContentPerGroup(String desiredGroup, OVGroupContent OVGroupContent) {
        if (isGroupExisting(desiredGroup)) {
            this.addContent(desiredGroup, OVGroupContent);
        }
    }

    public OVGroupContent getOVContentGroup() {
        OVGroupContent contentFromUi = new OVGroupContent();
        for (String groupKey : contentPage.keySet()) {
            for (String contentKey : contentPage.get(groupKey).keySet()) {
                contentFromUi.addContent(contentKey, contentPage.get(groupKey).getContentOfGroup(contentKey));
            }
        }
        return contentFromUi;
    }

    public List<String> getValuesOfKey(OVGroupContent group, String valueKey) {
        List<String> values = new ArrayList<>();
        for (String key : group.keySet()) {
            values.add(group.getContentOfGroup(key).getContent(valueKey));
        }
        return values;
    }


}
