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
public class CategoryModel {
    FunctionsModel passFunction = new FunctionsModel();

    @Inject
    private String catListID; 
    
    public String getCategoryListID(){ return passFunction.ProcessTitle(catListID); }
    
    
    @Inject
    @Named("categoryItems/.")
    private List<CategoryItemsModel> categoryListItems;
    
    public boolean isCategoryItemsConfigured() {
        return categoryListItems != null && !categoryListItems.isEmpty();
    } 
    public List<CategoryItemsModel> getCatListItems(){
        return categoryListItems;
    }

}