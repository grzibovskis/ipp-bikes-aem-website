

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
 
    
    public String getTitle(){ return passFunction.ProcessTitle(title); }
    public String getTitleAsClass(){ return passFunction.ProcessTitleAsClass(title); }
    public String getLink(){ return passFunction.ProcessLink(link); }

    
    
    @Inject
    @Named("navItemsSecondList/.")
    private List<LayerTwoModel> navLayerTwoList;
    
    public boolean isLayerTwoConfigured() {
        return navLayerTwoList != null && !navLayerTwoList.isEmpty();
    } 
    public String isLayerTwoConfiguredToClass() {
        if( navLayerTwoList != null && !navLayerTwoList.isEmpty() ){
            return "hasSublist";
        } else {            
            return "asLinks";
        }
    }  
    public List<LayerTwoModel> getNavLayerTwoList(){
        return navLayerTwoList;
    }

        
}
