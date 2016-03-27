// initialize document forms
jQuery(document).ready(function() {

    // hide textbox for different return location
    jQuery("#differentLocTextBox").hide();
    
    jQuery('.tabs .tab-links a').on('click', function(e)  {
        var currentAttrValue = jQuery(this).attr('href');
 
        // Show/Hide Tabs
        jQuery('.tabs ' + currentAttrValue).show().siblings().hide();
 
        // Change/remove current tab to active
        jQuery(this).parent('li').addClass('active').siblings().removeClass('active');
 
        e.preventDefault();
    });
});
function logout() {
    // log out from server
    window.location.href = "index.html";
}

jQuery(function(){
    jQuery("#pickupDate").datepicker();
    jQuery("#returnDate").datepicker();
});

// show another textbox if there's a different return location
function isDifferentReturnLocation(){
    if (document.getElementById("differentLocation").checked == true){
        jQuery("#differentLocTextBox").show();
    }
    else {
        jQuery("#differentLocTextBox").hide();
    }
}
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
        
        window.location.href = "logged_in.html";
    }
    else {
        var validatorP = document.getElementById("validator");
        validatorP.innerHTML = "Invalid username or password.";
        validatorP.style.color = "red";
        validatorP.style.textAlign = "center";
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
<<<<<<< HEAD
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
=======
>>>>>>> mark
