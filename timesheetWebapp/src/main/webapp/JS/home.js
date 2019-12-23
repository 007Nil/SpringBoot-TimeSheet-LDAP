$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/ldapUserdata",
        cache: false,

        success: function (response) {
            console.log(response);
            console.log('success');
        },
        error: function () {
            console.log('An error occurred.');
        },

    });
});
