

package com.adobe.aem.ipp.bikes.core.models.navigationMenu;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = Resource.class, 
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class LayerOneModel {
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

    
    
    @Inject
    @Named("navItemsSecondList/.")
    private List<LayerTwoModel> navLayerTwoList_java;
    
    public boolean isLayerTwoConfigured() {
        return navLayerTwoList_java != null && !navLayerTwoList_java.isEmpty();
    } 
    /*
    public String isNextLayerConfiguredToClass() { //isLayerTwoConfiguredToClass() {
        if( isLayerTwoConfigured() || getListConnect() != null ){
            return "hasSublist";
        } else {            
            return "asLinks";
        }
    }  */
    public String isNextLayerConfiguredToClass() {
        return passFunction.isNextLayerConfiguredToClass( isLayerTwoConfigured(), listConnect);
    }

    public List<LayerTwoModel> getNavigationLayerTwoList(){
        return navLayerTwoList_java;
    }  

    
}
