$(document).ready(function () {
    $('#login-submit').click(function (event) {
        event.preventDefault();
        var username = $('#username').val();
        var password = $('#password').val();
        var form = $('#submit-form');

        if (username === "" && password === "") {
            $("#form-messages").css({ "display": "block" }).html('<li>Username can not be emply</li> <li>Password cannot be emply</li>');
        }
        else if (username === "") {
            $("#form-messages").css({ "display": "block" }).text('Username can not be emply');
        }

        else if (password === "") {
            $("#form-messages").css({ "display": "block" }).text('Password can not be emply');
        }

        else {
            var data = 'uname=' + username + '&passwd=' + password;

            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: data,
                cache: false,

                success: function (response) {
                    if (response === true) {
                        console.log('success');
                        $(location).attr('href', 'home');
                    } else {
                        $("#form-messages").css({ "display": "block" }).text('Invalid Credentials');
                        console.log('An error occurred.');
                    }
                },
                error: function (data) {
                    console.log('An error occurred.');
                },

            });
        }

    });

});