// Display the default slider value

var slider = document.getElementById("slRange");
var output = document.getElementById("valueOutput");
output.innerHTML = "$" + slider.value; 

console.log (output);

// Update the current slider value 
slider.oninput = function() {
  output.innerHTML = "$" +  this.value;
};

