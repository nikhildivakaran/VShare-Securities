document.getElementById("menu").addEventListener("click", (event) => {
    const menu = event.target;

    const menuContainer = document.getElementById("menu-container");

    if (menuContainer.style.display === "block") {
        menuContainer.style.display = "none";
    } else {
        menuContainer.style.display = "block";
    }

    const viewportWidth = Math.max(document.documentElement.clientWidth, window.innerWidth || 0);
    const rightOffset = viewportWidth - menu.offsetLeft - menu.offsetWidth;
    menuContainer.style.top = menu.offsetTop + (menu.offsetHeight / 2) + 'px';
    menuContainer.style.right = rightOffset + 'px';
});

var menuItems = document.getElementById("menu-items");
menuItems.addEventListener("mouseover",function(event) {
    event.target.style.backgroundColor = "grey";
    event.target.style.color = "white";
});
menuItems.addEventListener("mouseout",function(event) {
    event.target.style.backgroundColor = "white";
    event.target.style.color = "black";
});
menuItems.addEventListener("click",function(event) {
    switch (event.target.id) {
        case "login-button":
            window.open("/loginPage", "_top");
            break;
        case "logout-button":
            window.open("/logout", "_top");
            break;
        case "sign-up-button":
            window.open("/register", "_top");
            break;
        case "about-button":
            window.open("/about", "_top");
            break;
    }
});
