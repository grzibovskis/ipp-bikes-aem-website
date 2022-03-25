package com.adobe.aem.ipp.bikes.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

import com.adobe.cq.export.json.ExporterConstants;

@Model(
    adaptables = SlingHttpServletRequest.class, 
    adapters = { NavigationMenu.class }, 
    resourceType = NavigationMenu.RESOURCE_TYPE_TABS, 
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, 
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)

public class NavigationMenu {

    public static final String RESOURCE_TYPE_TABS = "ipp-bikes/components/content/tabs";

    @Inject
    @Via("resource")
    private List<NavigationMenuItem> tabItems;

    public List<NavigationMenuItem> getTabItems() {
        return tabItems;
    }

}