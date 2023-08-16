package com.oneaston.oneview.automation.ui.dataprovider;


import com.oneaston.oneview.automation.ui.dataprovider.content.OVContent;

import java.util.List;

public interface IOVDetailsService {

    List<OVContent> getOVDetailsFromFile(String staticfile);

    OVContent getDetails(String[] dataperline);

}
