async function processRegistration(form) {
    const formData = new FormData(form);

    // console.log(form);
    // console.log(Array.from(formData));
    // console.log(JSON.stringify(formData));

    const settings = {
        method: 'POST',
        body: formData
    };
    try {
        const fetchResponse = await fetch('/register', settings);
        return await fetchResponse.json();
    } catch (error) {
        return error;
    }
}

form = document.getElementsByTagName("form")[0];

if (form.addEventListener) {
    form.addEventListener("submit", function(evt) {
        evt.preventDefault();
        processRegistration(evt.target);
    }, true);
}
else {
    form.attachEvent('onsubmit', function(evt){
        evt.preventDefault();
        processRegistration(evt);
    });
}
