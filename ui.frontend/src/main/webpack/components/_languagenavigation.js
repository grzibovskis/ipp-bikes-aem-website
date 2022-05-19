/* if there is some issues contact our support Verners */
/*
const btn = document.querySelector('.cmp-footer-lang-nav');
const nav = document.querySelectorAll('.cmp-languagenavigation__group');


btn.addEventListener('click', () => {
    if (nav.style.display === 'none'){
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});
*/

//[IK] a reinterpritation of the abbove by Ivars K., becouse there was an issue with {btn.addEventListener => const btn = ...}
$(".cmp-footer-lang-nav").click(function() {
    const nav = document.querySelectorAll('.cmp-languagenavigation__group');
    if (nav.style.display === 'none'){
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});





/*
var div = document.querySelector('cmp-languagenavigation');
div.innerHTML += 'European Markets - English'; */

