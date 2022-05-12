package com.adobe.aem.ipp.bikes.core.models;

import java.util.List;

/**
* Represents the Heroimage AEM Component for the ipp-bikes project.
**/
public interface Heroimage {
    /***
    * @return a string to display as the name.
    */
    String getName();

    /***
    * Occupations are to be sorted alphabetically in a descending order.
    *
    * @return a list of occupations.
    */
    List<String> getOccupations();

    /***
    * @return a boolean if the component has enough content to display.
    */
    boolean isEmpty();
}