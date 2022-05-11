
// Example of how a component should be initialized via JavaScript
// This script logs the value of the component's text property model message to the console

(function() {
    "use strict";

    // Best practice:
    // For a good separation of concerns, don't rely on the DOM structure or CSS selectors,
    // but use dedicated data attributes to identify all elements that the script needs to
    // interact with.
    var selectors = {
        self:      '[data-cmp-is="navigationmenu"]',
        value_text:  '[data-cmp-hook-navigationmenu="model_text"]',
        value_message:   '[data-cmp-hook-navigationmenu="model_message"]',
        value_cat:   '[data-cmp-hook-navigationmenu="model_category"]'
    };
    
    function NavigationMenu(config) {

        function init(config) {
            // Best practice:
            // To prevents multiple initialization, remove the main data attribute that
            // identified the component.
            config.element.removeAttribute("data-cmp-is");

            var property = config.element.querySelectorAll(selectors.value_text);
            property = property.length == 1 ? property[0].textContent : null;

            var model = config.element.querySelectorAll(selectors.value_message);
            model = model.length == 1 ? model[0].textContent : null;

            var cat = config.element.querySelectorAll(selectors.value_cat);
            cat = cat.length == 1 ? cat[0].textContent : null;

            if (console && console.log) {
                console.log(
                    "NavigationMenu component JavaScript example",
                    "\nText property:\n", property,
                    "\nModel message:\n", model,
                    "\nCat message:\n", cat
                );
            }
        }

        if (config && config.element) {
            init(config);
        }
    }

    // Best practice:
    // Use a method like this mutation obeserver to also properly initialize the component
    // when an author drops it onto the page or modified it with the dialog.
    function onDocumentReady() {
        var elements = document.querySelectorAll(selectors.self);
        for (var i = 0; i < elements.length; i++) {
            new NavigationMenu({ element: elements[i] });
        }

        var MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
        var body             = document.querySelector("body");
        var observer         = new MutationObserver(function(mutations) {
            mutations.forEach(function(mutation) {
                // needed for IE
                var nodesArray = [].slice.call(mutation.addedNodes);
                if (nodesArray.length > 0) {
                    nodesArray.forEach(function(addedNode) {
                        if (addedNode.querySelectorAll) {
                            var elementsArray = [].slice.call(addedNode.querySelectorAll(selectors.self));
                            elementsArray.forEach(function(element) {
                                new NavigationMenu({ element: element });
                            });
                        }
                    });
                }
            });
        });

        observer.observe(body, {
            subtree: true,
            childList: true,
            characterData: true
        });
    }

    if (document.readyState !== "loading") {
        onDocumentReady();
    } else {
        document.addEventListener("DOMContentLoaded", onDocumentReady);
    }



    //[IK] variables
    var activeMenu_layer1 ;   
    var activeMenu_layer2 ;
    var activeMenu_layer3 ;  

    //[IK] hide all submenus and set the submenu of the currenly mouseoverd main-list-item as active
    $(".cmp-navigationmenu__mainlist_item").mouseenter(function() {
        //[] set currnt ID
        activeMenu_layer1 = $(this).attr("id");          

        //[] set respective item as highlighted
            $(".cmp-navigationmenu__item-link").removeClass("highlighted_main");
            $("#mainlink_"+ activeMenu_layer1 ).addClass("highlighted_main");

        //[] hide all other menus and show child menu of respective item
            $(".cmp-navigationmenu__sub-list-container").removeClass("active"); 
            $("#layer_1_containerOf__"+ activeMenu_layer1 ).addClass("active");   

        AddColumClassToCategryList("#layer_1_childof__"+ activeMenu_layer1);
    }); 
    
    //[IK] hide layer_2 submenus and show the layer_2 submenu of the currently mouseovered layer_1 item
    $(".cmp-navigationmenu__layer_1-item").mouseenter(function() {
        activeMenu_layer2 = $(this).attr("id");

        //[IK] remove visability from only layer_2 submenus, and then add vis. to the specified one
            $(".cmp-navigationmenu__list_container_layer_2").removeClass("active");
            $("#layer_2_containerOf__"+ activeMenu_layer2 ).addClass("active");

        //[IK] remove highlights only from layer_1 submenus, and then add highl. to the specified one
            $(".cmp-navigationmenu__item-link.layer_1_link").removeClass("highlighted_sub");
            $(this).children("a.hasSublist").addClass("highlighted_sub");
        
        AddColumClassToCategryList("#layer_2_childof__"+ activeMenu_layer2);
    }); 
    
    //[IK] hide layer_3 cat_lists and show the layer_3 cat_list of the currently mouseovered layer_2 item
    $(".cmp-navigationmenu__layer_2-item").mouseenter(function() {
        activeMenu_layer3 = $(this).attr("id");

        //[IK] remove visability from only layer_3 submenus, and then add vis. to the specified one
            $(".cmp-navigationmenu__list_container_layer_3").removeClass("active");
            $("#layer_3_containerOf__"+ activeMenu_layer3 ).addClass("active");

        //[IK] remove highlights only from layer_2 submenus, and then add highl. to the specified one
            $(".cmp-navigationmenu__item-link.layer_2_link").removeClass("highlighted_sub");
            $(this).children("a.hasSublist").addClass("highlighted_sub");

        AddColumClassToCategryList("#layer_3_childof__"+ activeMenu_layer3);
        
    }); 
    
    //[IK] as long as the cursor is within the nav element, the menus will be visable
    $(".cmp-navigationmenu__nav-container").hover(function() {
        $(".cmp-navigationmenu__sublist-main-container").toggleClass("visable");
    }); 
    
    //[IK] when the cursor leaves, hide and diactivate all menus
    $(".cmp-navigationmenu").mouseleave(function(){
        //[IK] remove highlights from main menu
        $(".cmp-navigationmenu__mainlist_item").children(".cmp-navigationmenu__item-link").removeClass("highlighted_main"); 

        //[IK] remove highlights from all submenus
        $(".cmp-navigationmenu__item-link").removeClass("highlighted_sub");
        
        //[IK] remove visability from all submenus
        $(".cmp-navigationmenu__sub-list-container").removeClass("active"); 

        $(".cmp-navigationmenu__sublist-main-container").removeClass("visable");
    });
    
}());


function AddColumClassToCategryList(pass_listID){

    if( $( pass_listID ).is(".cmp-navigationmenu__categoryList") ){
        var child_count = $( pass_listID ).children().length;
       
        if( child_count <= 6 ){ 
            $( pass_listID ).addClass("col_count_one"); 
        } else if( child_count > 6 && child_count <= 12 ){
            $( pass_listID ).addClass("col_count_two"); 
        } else {
            $( pass_listID ).addClass("col_count_three"); 
        }
        
    }
}
