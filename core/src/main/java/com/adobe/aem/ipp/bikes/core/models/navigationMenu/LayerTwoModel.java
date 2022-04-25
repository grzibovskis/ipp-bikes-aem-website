

package com.adobe.aem.ipp.bikes.core.models.navigationMenu;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = Resource.class, 
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class LayerTwoModel {
    FunctionsModel passFunction = new FunctionsModel();

    @Inject
    private String title;
    @Inject
    private String link;
    @Inject
    private String listConnect;
 
    public String getTitle(){ return passFunction.ProcessTitle(title); }
    public String getTitleAsClass(){ return passFunction.ProcessTitleAsClass(title); }
    public String getLink(){ return passFunction.ProcessLink(link); }
    public String getListConnect(){ return passFunction.ProcessListConnect(listConnect); }

/*
    public String isNextLayerConfiguredToClass() {
        if( getListConnect() != null ){
            return "hasSublist";
        } else {
            return "asLinks";
        }
    }  */
        
    public String isNextLayerConfiguredToClass() { 
        return passFunction.isNextLayerConfiguredToClass( false, listConnect);
    }
}
