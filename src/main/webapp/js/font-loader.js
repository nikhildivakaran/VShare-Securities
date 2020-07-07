function addFont(fontLink) {
    var link = document.createElement('link');
    link.setAttribute('rel', 'stylesheet');
    link.setAttribute('type', 'text/css');
    link.setAttribute('href', fontLink);
    document.head.appendChild(link);
}

var fontsLinkList = [
    'https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap'
];

for(var fontLink of fontsLinkList){
    addFont(fontLink);
}