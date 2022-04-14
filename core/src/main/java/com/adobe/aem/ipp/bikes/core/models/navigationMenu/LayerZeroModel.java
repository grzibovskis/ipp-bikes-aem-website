

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
public class LayerZeroModel {
    FunctionsModel passFunction = new FunctionsModel();

    @Inject
    private String title;
    @Inject
    private String link;
    
    @Inject
    @Named("navItemsFirstList/.")
    private List<LayerOneModel> navLayerOneList;

    
    public String getTitle(){ return passFunction.ProcessTitle(title); }
    public String getTitleAsClass(){ return passFunction.ProcessTitleAsClass(title); }
    public String getLink(){ return passFunction.ProcessLink(link); }


    public boolean isLayerOneConfigured() {
        return navLayerOneList != null && !navLayerOneList.isEmpty();
    } 
    public String isLayerOneConfiguredToClass() {
        if( navLayerOneList != null && !navLayerOneList.isEmpty() ){
            return "hasSublist";
        } else {            
            return "asLinks";
        }
    }  
    public List<LayerOneModel> getNavLayerOneList(){
        return navLayerOneList;
    }

    
}
