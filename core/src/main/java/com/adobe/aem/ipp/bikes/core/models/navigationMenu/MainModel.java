
package com.adobe.aem.ipp.bikes.core.models.navigationMenu;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.xfa.ut.StringUtils;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import java.util.List;
import java.util.Optional;

@Model(
    adaptables = Resource.class,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MainModel {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;
    
    //NavMenuFunctions passFunction = new NavMenuFunctions();

    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    //--- Properties
    @ValueMapValue
    private String title;
    @ValueMapValue
    private String text;
    @ValueMapValue
    private String iconLink;

    //--- Categories
    @Inject
    @Named("categoryList/.")
    public List<CategoryModel> listOfCategoryLists;
    

    //--- navIconSelect
    @ValueMapValue
    private String fileReference; //[IK] the reference to the file of the "navicon" dialog element    

    //--- Tab Iteems   
    @Inject
    @Named("navItemsMainList/.")
    public List<LayerZeroModel> listOfLayerZero; //[IK] "navItemsMainList/." = "name" property of the "field" tag in "_cq_dialog"*/
    //--- other
    private String message;


    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                .map(Page::getPath).orElse("");

        message = "Hello from NavMenu V2!\n"
            + "[NM] Resource type is : " + resourceType + "\n"
            + "[NM] Current page is :  " + currentPagePath + "\n"            
            + "[NM] isTabConfigured() :  " + isTabConfigured() + "\n";
    }

  
    
    public String getMessage() {
        return message;
    }
    public String getTitle() {
        return StringUtils.isEmpty(title) ? "Default title text!" : title;
    }
    public String getText() {
        return StringUtils.isEmpty(text) ? null : text.toUpperCase();
    }
    public String getIconLink() {
        return StringUtils.isEmpty(iconLink) ? "#" : iconLink+".html";
    }
    public String getNavIcon() {
        return fileReference;
    }

    
    public boolean isTabConfigured() {
        return listOfLayerZero != null && !listOfLayerZero.isEmpty();
    }    
    public List<LayerZeroModel> getNavigationLayerZeroList(){
        return listOfLayerZero;
    }  

    public boolean isCategoryConfigured() {
        return listOfCategoryLists != null && !listOfCategoryLists.isEmpty();
    }    
    public List<CategoryModel> getCategoryList(){
        return listOfCategoryLists;
    } 
}