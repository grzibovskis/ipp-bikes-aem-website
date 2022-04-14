package com.adobe.aem.ipp.bikes.core.models.navigationMenu;
import com.adobe.xfa.ut.StringUtils;

public class FunctionsModel {


    //[IK] process "title" value
    public String ProcessTitle(String inputTitle) {
        return StringUtils.isEmpty(inputTitle) ? "No Title Provided" : inputTitle;
    }

    //[IK] turn a provided "title" into a css compatable className
    public String ProcessTitleAsClass(String inputTitleToClass){
        return StringUtils.isEmpty(inputTitleToClass) ? null : inputTitleToClass.replaceAll("[^a-zA-Z0-9]+", "").trim();
    }

    //[IK] process "link" value
    public String ProcessLink(String inputLink) {
        return StringUtils.isEmpty(inputLink) ? "#" : inputLink+".html";
    }
    

    
}
