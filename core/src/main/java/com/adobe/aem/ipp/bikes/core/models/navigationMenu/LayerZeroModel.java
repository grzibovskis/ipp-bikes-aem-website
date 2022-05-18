

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
    private String listConnect;
    
    
    @Inject
    @Named("navItemsFirstList/.")
    private List<LayerOneModel> navLayerOneList;

    
    public String getTitle(){ return passFunction.ProcessTitle(title); }
    public String getTitleAsClass(){ return passFunction.ProcessTitleAsClass(title); }
    public String getLink(){ return passFunction.ProcessLink(link); }
    public String getListConnect(){ return passFunction.ProcessListConnect(listConnect); }


    public boolean isLayerOneConfigured() {
        return navLayerOneList != null && !navLayerOneList.isEmpty();
    } 
    /*
    public String isNextLayerConfiguredToClass() { //isLayerOneConfiguredToClass() {
        if( isLayerOneConfigured() || getListConnect() != null ){
            return "hasSublist";
        } else {            
            return "asLinks";
        }
    }*/
    public String isNextLayerConfiguredToClass() {
        return passFunction.isNextLayerConfiguredToClass( isLayerOneConfigured(), listConnect);
    }

    public List<LayerOneModel> getNavigationLayerOneList(){
        return navLayerOneList;
    }
}
