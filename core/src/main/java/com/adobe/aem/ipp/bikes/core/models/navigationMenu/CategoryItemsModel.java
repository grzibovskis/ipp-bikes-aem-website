package com.adobe.aem.ipp.bikes.core.models.navigationMenu;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CategoryItemsModel {
    FunctionsModel passFunction = new FunctionsModel();

    @Inject
    private String catName;
    @Inject
    private String catLink;

    
    public String getCatName(){ return passFunction.ProcessTitle(catName); }
    public String getCatLink(){ return passFunction.ProcessLink(catLink); }
}
