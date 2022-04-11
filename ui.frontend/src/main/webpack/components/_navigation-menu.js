
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
        property:  '[data-cmp-hook-navigationmenu="text"]',
        message:   '[data-cmp-hook-navigationmenu="model_message"]'
    };

    function NavigationMenu(config) {

        function init(config) {
            // Best practice:
            // To prevents multiple initialization, remove the main data attribute that
            // identified the component.
            config.element.removeAttribute("data-cmp-is");

            var property = config.element.querySelectorAll(selectors.property);
            property = property.length == 1 ? property[0].textContent : null;

            var model = config.element.querySelectorAll(selectors.message);
            model = model.length == 1 ? model[0].textContent : null;

            if (console && console.log) {
                console.log(
                    "NavigationMenu component JavaScript example",
                    "\nText property:\n", property,
                    "\nModel message:\n", model
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


    var activeMenu_layer1 ;   
    var activeMenu_layer2 ; 

    $(".cmp-navigationmenu__mainlist_item").mouseenter(function() {
        activeMenu_layer1 = $(this).attr("id");
        
        $(".cmp-navigationmenu__sub-list").removeClass("active"); //[IK] remove visability from all submenus
        $("#l2_childof__"+ activeMenu_layer1 ).addClass("active");
        console.log("U entered the teritory of ["+ activeMenu_layer1 +"] ?");
    });

    $(".cmp-navigationmenu__layer-2-item").mouseenter(function() {
        activeMenu_layer2 = $(this).attr("id");

        $(".cmp-navigationmenu__list-layer-3").removeClass("active");//[IK] remove visability from only layer 3 submenus
        $("#l3_childof__"+ activeMenu_layer2 ).addClass("active");
        console.log("l2 hover over ["+ activeMenu_layer2 +"] ?");
    });

    $(".cmp-navigationmenu__nav-container").hover(function() {
        $(".cmp-navigationmenu__sublist-main-container").toggleClass("visable");
        console.log("Show/hide submenu.");
    });

    

    $(".cmp-navigationmenu__mainlist_item").click(function() {
        console.log("Y are u Cliking on ["+ $(this).text() +"] ?");
    });

}());
