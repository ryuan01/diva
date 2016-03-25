var username;
var password;

// check if either form is filled, or has valid information
function validateForm() {
    
    var uField = document.forms["login_form"]["username"].value;
    var pField = document.forms["login_form"]["password"].value;
    
    if ((uField == null || pField == null) || (uField == "" || pField == "")) {
        return false;
    }
    username = uField;
    password = pField;
    return true;
    
}
// get user login credentials
function getUserInfo() {
    
    if (validateForm()) {
        
        document.getElementById("validator").innerHTML = "\nUsername: " + username + " \nPassword: " + password;
    }
    else {
       
        document.getElementById("validator").innerHTML = "Invalid username or password.";
        document.getElementById("validator").style.color = "red";
    }
}

// create an xml request object
function getXMLHttpRequestObject() {
    var ajax = null;
    if (window.XMLHttpRequest) {
        ajax = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        ajax = new ActiveXObject('MSXML2.XMLHTTP.3.0');
    }
    
    return ajax;
}
// search webserver for vehicle
function searchVehicle() {
    var xhttp = getXMLHttpRequestObject();
    
    xhttp.open("GET", "http://localhost:8080/DIVA_Test/")
    //TODO
}
//
//function searchReservation() {
//    
//    //TODO
//}
// handling the tab bar
jQuery(document).ready(function() {
    jQuery('.tabs .tab-links a').on('click', function(e)  {
        var currentAttrValue = jQuery(this).attr('href');
 
        // Show/Hide Tabs
        jQuery('.tabs ' + currentAttrValue).show().siblings().hide();
 
        // Change/remove current tab to active
        jQuery(this).parent('li').addClass('active').siblings().removeClass('active');
 
        e.preventDefault();
    });
});