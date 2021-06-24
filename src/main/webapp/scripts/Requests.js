let url = "";
var d = new Date();
var currentyear = d.getFullYear();
var returnrequest;
var currentyearaccount;
var lastcostValue = 0;
var lasteventTypeValue = "certification";
setInterval(function() {
    var newcostValue = document.getElementById('costs').value;
    var neweventTypeValue = document.getElementById('eventType').value;
    if ((lastcostValue != newcostValue) || (lasteventTypeValue != neweventTypeValue)) {
        lastcostValue = newcostValue;
        lasteventTypeValue = neweventTypeValue;
        updatereimbursement();
    }
}, 100);


function refreshrequestpage() {
    url = 'http://localhost:8080/Project1/site/getaccount';
    let xhttpgetaccount = new XMLHttpRequest();
    let getaccountsend = JSON.stringify(currentyear)
    function getaccountfunc() {
        let account = xhttpgetaccount.responseText;
        currentyearaccount = JSON.parse(account);
    }
    sendrequest(xhttpgetaccount, url, "POST", getaccountfunc, getaccountsend)
    
}

function submitrequest(){
    if (document.getElementById('title').value == false) {
        return;
    }
    else if (document.getElementById('startDate').value == false) {
        return;
    }
    else if (document.getElementById('times').value == false) {
        return;
    }
    else if (document.getElementById('locations').value == false) {
        return;
    }
    else if (document.getElementById('description').value == false) {
        return;
    }
    else if (document.getElementById('costs').value == false) {
        return;
    }
    else if (document.getElementById('gradeFormat').value == false) {
        return;
    }
    else if (document.getElementById('eventType').value == false) {
        return;
    }
    else if (document.getElementById('justification').value == false) {
        return;
    }
    var date1 = new Date(document.getElementById('startDate').value);
    var ans = (date1.getTime() - d.getTime()) / (1000 * 3600 * 24);
    if (ans < 7) {
        return;
    }
    else {
        newrequest();
        setTimeout(function(){
            newformdata();
        },400);
        setTimeout(function(){
            newattachments();
        },500);
        setTimeout(function(){
            window.location = "/Project1/html/HomePage.html"
        },600);
    }
}


function newrequest() {
    let url = 'http://localhost:8080/Project1/site/addRequest';

    // collect user input
    let rtitle = document.getElementById('title').value;
    let rstartDate = document.getElementById('startDate').value;
    let rreimbursement = parseFloat(document.getElementById('estreimbursement').innerHTML);

    // create request object
    let request = {
        title : rtitle,
        startDate : rstartDate,
        reimbursement : rreimbursement
    }

    // AJAX Call
    let xhttpnewrequest = new XMLHttpRequest();
    let newrequestsend = JSON.stringify(request)
    function newrequestfunc() {
        let r = xhttpnewrequest.responseText;
        returnrequest = JSON.parse(r);
    }
    sendrequest(xhttpnewrequest, url, "POST", newrequestfunc, newrequestsend)
}

function newformdata () {
    let url = 'http://localhost:8080/Project1/site/addFormdata';

    let rtimes = document.getElementById('times').value;
    let rlocations = document.getElementById('locations').value;
    let rdescription = document.getElementById('description').value;
    let rcosts = document.getElementById('costs').value;
    let rgradeFormat = document.getElementById('gradeFormat').value;
    let reventType = document.getElementById('eventType').value;
    let rjustification = document.getElementById('justification').value;
    let rmissedWorkhrsperwk = document.getElementById('missedWorkhrsperwk').value;
    let rrequests = returnrequest.id;

    let formData = {
        times: rtimes,
        locations: rlocations,
        description: rdescription,
        costs: rcosts,
        gradeFormat: rgradeFormat,
        eventType: reventType,
        justification: rjustification,
        missedWorkhrsperwk: rmissedWorkhrsperwk,
        requests : rrequests
    }

    // AJAX Call
    let xhttpnewformdata = new XMLHttpRequest();
    let nnewformdatasend = JSON.stringify(formData)
    function newformdatafunc() {
        console.log('newformdata success');
    }
    sendrequest(xhttpnewformdata, url, "POST", newformdatafunc, nnewformdatasend)
}

function newattachments () {
    let url = 'http://localhost:8080/Project1/site/addattachments';

    let rrequests = returnrequest.id;

    let attachments = {
        requests : rrequests
    }

    // AJAX Call
    let xhttpnewattachments = new XMLHttpRequest();
    let newattachmentssend = JSON.stringify(attachments)
    function newattachmentsfunc() {
        console.log('newattachments success');
    }
    sendrequest(xhttpnewattachments, url, "POST", newattachmentsfunc, newattachmentssend)
}

function cancel() {
    window.location = "/Project1/html/HomePage.html"
}

function sendrequest(xhttp, url, GETPOST, funcstuff, send) {
    // AJAX Call
    xhttp.onreadystatechange = sendrequestfunc;
    xhttp.open(GETPOST, url, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(send);
    function sendrequestfunc() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                funcstuff();
            }
        }
    }
}

function updatereimbursement() {
    let balance = currentyearaccount.balance;
    let cost = document.getElementById('costs').value;
    let event = document.getElementById('eventType').value;
    let percent;
    if (event == 'certification') {
        percent = 1;
    }
    else if (event == 'techtrain') {
        percent = .9;
    }
    else if (event == 'unicourse') {
        percent = .8;
    }
    else if (event == 'certclass') {
        percent = .75;
    }
    else if (event == 'seminar') {
        percent = .6;
    }
    else if (event == 'other') {
        percent = .3;
    }
    let estreimbursement = cost * percent;
    if (estreimbursement > balance) {
        estreimbursement = balance;
    }
    document.getElementById('estreimbursement').innerHTML = estreimbursement;
}

