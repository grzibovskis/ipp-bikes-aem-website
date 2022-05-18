"use strict"

use (function () {

    var titleByAuthor = granite.resource.properties["titleProperty"];
    var jcrtitle = currentPage.title;
    var pageName = currentPage.name;

    	var title = titleByAuthor || jsrtitle || pageName;

    return{

        title:title

    };

});