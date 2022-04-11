

package com.adobe.aem.ipp.bikes.core.models;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.xfa.ut.StringUtils;

@Model(
    adaptables = Resource.class, 
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ItemsLayerTwoModel {

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

    
    
    @Inject
    @Named("navItemThirdList/.")
    private List<ItemsLayerThreeModel> navLayerThreeList;
    
    public List<ItemsLayerThreeModel> getNavLayerThreeList(){
        return navLayerThreeList;
    }

        
}
