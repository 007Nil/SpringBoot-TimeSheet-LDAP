/*
Author : Sagnik Sarkar
Date   : 26.12.19
*/

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/ldapUserdata",
        cache: false,

        success: function (response) {
            var userData = JSON.parse(response);
            console.log('success');
            const userAttributes = ['fullName', 'lastName', 'userName', 'description', 'mobile', 'street', 'postOfficeBox',
                'postalCode', 'postalAddress', 'natinality', 'state', 'organigation', 'email'];

            const userDetails = ['Full Name', 'Last Name', 'User Name', 'Description', 'Mobile', 'Street', 'Post Office',
                'Postal Code', 'Postal Address', 'Natinality', 'State', 'Organigation', 'Email ID'];

            const tableBody = $('#table-data');
            var dataHtml = '';

            // Finally works
            //Dynamic Table which contains all user data fetch from ldap server which is store
            //in a JESON Object
            for (let user of userData) {
                for (let i = 0; i < userAttributes.length; i++) {
                    dataHtml += `<tr>
                                 <td>${userDetails[i]}</td>
                                 <td>${user[userAttributes[i]]}</td> 
                                 </tr>`;
                }
            }

            tableBody.append(dataHtml);
        },
        error: function () {
            console.log('An error occurred.');
        },
    });
});
