

package com.adobe.aem.ipp.bikes.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.xfa.ut.StringUtils;

@Model(
    adaptables = Resource.class, 
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ItemsLayerThreeModel {

    @Inject
    private String title;
    @Inject
    private String link;
 
    public String getTitle(){
        return StringUtils.isEmpty(title) ? "You forgot to add a title" : title;
    }
    public String getTitleAsClass(){
        return StringUtils.isEmpty(title) ? null : title.replaceAll("\\s", "");
    }
    public String getLink(){
        return StringUtils.isEmpty(link) ? "#" : link+".html";
    }

        
}
