
const btn = document.querySelector('.cmp-languagenavigation');
const nav = document.querySelector('.cmp-languagenavigation__group');


btn.addEventListener('click', () => {
    if (nav.style.display === 'none'){
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
});


/*
var div = document.querySelector('cmp-languagenavigation');
div.innerHTML += 'European Markets - English'; */

