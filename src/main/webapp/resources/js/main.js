(function() {
    var href = window.location.href;
    var elements = document.querySelectorAll('.nav-link')
    for (let i = 0; i < elements.length; i++) {
        var nodeValue = elements[i].attributes['href']['nodeValue'].toString().replace("..","");
        if (href.endsWith(nodeValue)) {
            elements[i].setAttribute("style", "text-shadow: 2px 2px 4px #000000;")
        }
    }
})()