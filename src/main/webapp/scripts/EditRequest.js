var activeuser = {};
var selectedrequest = {};
var selectedformdata = {};
var selectedattachments = {};
var selectedaccount = {};
var selecteduser = {};
var d = new Date();

function refresheditrequestpage() {

    getselectedrequest();

    getselectedformdata();

    getselectedattachments();

    getselectedaccount();

    getselecteduser();

    getactiveuser();

    buildrequestformtable();

    buildrequestprocessingtable();

    buildaccounttable();

    buildbigboxtable();

    disablebuttons();

}

function getselectedrequest() {
    url = 'http://localhost:8080/Project1/site/getselectedrequest';
    let xhttpgetselectedrequest = new XMLHttpRequest();
    let getselectedrequestsend = JSON.stringify(null);
    function getselectedrequestfunc() {
        let r = xhttpgetselectedrequest.responseText;
        selectedrequest = JSON.parse(r);
    }
    sendrequest(xhttpgetselectedrequest, url, "GET", getselectedrequestfunc, getselectedrequestsend);
}

function getselectedformdata() {
    url = 'http://localhost:8080/Project1/site/getselectedformdata';
    let xhttpgetselectedformdata = new XMLHttpRequest();
    let getselectedformdatasend = JSON.stringify(null);
    function getselectedformdatafunc() {
        let r = xhttpgetselectedformdata.responseText;
        selectedformdata = JSON.parse(r);
    }
    sendrequest(xhttpgetselectedformdata, url, "GET", getselectedformdatafunc, getselectedformdatasend);
}

function getselectedattachments() {
    url = 'http://localhost:8080/Project1/site/getselectedattachments';
    let xhttpgetselectedattachments = new XMLHttpRequest();
    let getselectedattachmentssend = JSON.stringify(null);
    function getselectedattachmentsfunc() {
        let r = xhttpgetselectedattachments.responseText;
        selectedattachments = JSON.parse(r);
    }
    sendrequest(xhttpgetselectedattachments, url, "GET", getselectedattachmentsfunc, getselectedattachmentssend);
}

function getselectedaccount() {
    url = 'http://localhost:8080/Project1/site/getselectedaccount';
    let xhttpgetselectedaccount = new XMLHttpRequest();
    let getselectedaccountsend = JSON.stringify(null);
    function getselectedaccountfunc() {
        let r = xhttpgetselectedaccount.responseText;
        selectedaccount = JSON.parse(r);
    }
    sendrequest(xhttpgetselectedaccount, url, "GET", getselectedaccountfunc, getselectedaccountsend);
}

function getselecteduser() {
    url = 'http://localhost:8080/Project1/site/getselecteduser';
    let xhttpgetselecteduser = new XMLHttpRequest();
    let getselectedusersend = JSON.stringify(null);
    function getselecteduserfunc() {
        let r = xhttpgetselecteduser.responseText;
        selecteduser = JSON.parse(r);
    }
    sendrequest(xhttpgetselecteduser, url, "GET", getselecteduserfunc, getselectedusersend);
}

function getactiveuser() {
    url = 'http://localhost:8080/Project1/site/getactiveuser';
    let xhttpgetactiveuser = new XMLHttpRequest();
    let getactiveusersend = JSON.stringify(null)
    function getactiveuserfunc() {
        let r = xhttpgetactiveuser.responseText;
        activeuser = JSON.parse(r);
    }
    sendrequest(xhttpgetactiveuser, url, "GET", getactiveuserfunc, getactiveusersend)
    
}

function cancel() {
    window.location = "/Project1/html/HomePage.html"
}

function addattachments() {
    //window.location = "/Project1/html/AddAttachments.html"
}

function buildaccounttable() {
    let accountdata = document.getElementById('accountdata');
    accountdata.innerHTML = 'Account Details';
        
    let accountdataTable = document.createElement('table');
    accountdataTable.id = 'accountdataTable';

    // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

    // Create table header row
    let thRow = document.createElement('tr');
    let tHeaders = ['Balance $', 'Pending $', 'Reimbursed $'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.innerHTML = h;
        thRow.appendChild(th);
    }

    accountdataTable.append(thRow);

    let tr = document.createElement('tr');

    let tdbalance = document.createElement('td');
    tdbalance.innerHTML = selectedaccount.balance;
    tr.appendChild(tdbalance);

    let tdpending = document.createElement('td');
    tdpending.innerHTML = selectedaccount.pending;
    tr.appendChild(tdpending);
    
    let tdreimbursed = document.createElement('td');
    tdreimbursed.innerHTML = selectedaccount.reimbursed;
    tr.appendChild(tdreimbursed);

    accountdataTable.appendChild(tr);

    accountdata.appendChild(accountdataTable);
}


function buildrequestformtable() {
    let requestFormData = document.getElementById('requestFormData');
    requestFormData.innerHTML = 'Request Details';
        
    let requestFormDataTable = document.createElement('table');
    requestFormDataTable.id = 'requestFormDataTable';

    // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

    // Create table header row
    let thRow = document.createElement('tr');
    let tHeaders = ['Title', 'Fiscal Year', 'Start Date', 'First Name', 'Last Name', 'Time', 'Cost $', 'Grade Format', 'Event Type', 'Missed Work hrs/wk'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.innerHTML = h;
        thRow.appendChild(th);
    }

    requestFormDataTable.append(thRow);

    let tr = document.createElement('tr');

    let tdtitle = document.createElement('td');
    tdtitle.innerHTML = selectedrequest.title;
    tr.appendChild(tdtitle);

    let tdayear = document.createElement('td');
    tdayear.innerHTML = selectedaccount.ayear;
    tr.appendChild(tdayear);
    
    let tdstartDate = document.createElement('td');
    var date = new Date(selectedrequest.startDate);
    tdstartDate.innerHTML = date.toDateString();
    tr.appendChild(tdstartDate);

    let tdfirstname = document.createElement('td');
    tdfirstname.innerHTML = selecteduser.firstname;
    tr.appendChild(tdfirstname);

    let tdlastname = document.createElement('td');
    tdlastname.innerHTML = selecteduser.lastname;
    tr.appendChild(tdlastname);

    let tdtimes = document.createElement('td');
    tdtimes.innerHTML = selectedformdata.times;
    tr.appendChild(tdtimes);

    let tdcosts = document.createElement('td');
    tdcosts.innerHTML = selectedformdata.costs;
    tr.appendChild(tdcosts);
    
    let tdgradeFormat = document.createElement('td');
    tdgradeFormat.innerHTML = selectedformdata.gradeFormat;
    tr.appendChild(tdgradeFormat);

    let tdeventType = document.createElement('td');
    tdeventType.innerHTML = selectedformdata.eventType;
    tr.appendChild(tdeventType);

    let tdmissedWorkhrsperwk = document.createElement('td');
    tdmissedWorkhrsperwk.innerHTML = selectedformdata.missedWorkhrsperwk;
    tr.appendChild(tdmissedWorkhrsperwk);

    requestFormDataTable.appendChild(tr);

    requestFormData.appendChild(requestFormDataTable);

}


function buildrequestprocessingtable() {

    let requestprocessing = document.getElementById('requestprocessing');
    requestprocessing.innerHTML = 'Request Processing';
        
    let requestProcessingTable = document.createElement('table');
    requestProcessingTable.id = 'requestProcessingTable';

    // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

    // Create table header row
    let thRow = document.createElement('tr');
    let tHeaders = ['Priority', 'Status', 'Reimbursement $', 'Last Modified', 'Employee Apv', 'Super Apv', 'Manager Apv', 'Dept Apv', 'Benco Apv'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.innerHTML = h;
        thRow.appendChild(th);
    }

    requestProcessingTable.append(thRow);

    let tr = document.createElement('tr');

    let tdpriority = document.createElement('td');
    var date1 = new Date(selectedrequest.startDate);
    var ans = (date1.getTime() - d.getTime()) / (1000 * 3600 * 24);
    if (ans < 14) {
        tdpriority.innerHTML = 'URGENT';
    }
    else {
        tdpriority.innerHTML = selectedrequest.priority;
    }
    tr.appendChild(tdpriority);

    let tdstatus = document.createElement('td');
    if ((activeuser.id == selectedrequest.inbox) && (selectedrequest.status == 'pending')){
        tdstatus.innerHTML = "Action Needed";
    }
    else {
        tdstatus.innerHTML = selectedrequest.status;
    }

    tr.appendChild(tdstatus);
    
    let tdreimbursement = document.createElement('td');
    tdreimbursement.innerHTML = selectedrequest.reimbursement;
    tr.appendChild(tdreimbursement);

    let tddatetimestamp = document.createElement('td');
    var date = new Date(selectedrequest.datetimestamp);
    tddatetimestamp.innerHTML = date.toDateString();
    tr.appendChild(tddatetimestamp);

    let tdempapp = document.createElement('td');
    if (selectedrequest.empapp == null) {
        tdempapp.innerHTML = '-';
    }
    else {
        tdempapp.innerHTML = selectedrequest.empapp;
    }
    tr.appendChild(tdempapp);

    let tdsupapp = document.createElement('td');
    if (selectedrequest.supapp == null) {
        tdsupapp.innerHTML = '-';
    }
    else {
        tdsupapp.innerHTML = selectedrequest.supapp;
    }
    tr.appendChild(tdsupapp);

    let tdmanapp = document.createElement('td');
    if (selectedrequest.manapp == null) {
        tdmanapp.innerHTML = '-';
    }
    else {
        tdmanapp.innerHTML = selectedrequest.manapp;
    }
    tr.appendChild(tdmanapp);
    
    let tddhdapp = document.createElement('td');
    if (selectedrequest.dhdapp == null) {
        tddhdapp.innerHTML = '-';
    }
    else {
        tddhdapp.innerHTML = selectedrequest.dhdapp;
    }
    tr.appendChild(tddhdapp);

    let tdbenapp = document.createElement('td');
    if (selectedrequest.benapp == null) {
        tdbenapp.innerHTML = '-';
    }
    else {
        tdbenapp.innerHTML = selectedrequest.benapp;
    }
    tr.appendChild(tdbenapp);

    requestProcessingTable.appendChild(tr);

    requestprocessing.appendChild(requestProcessingTable);

}

        
function buildbigboxtable() {

    let bigboxdata = document.getElementById('bigboxdata');
    bigboxdata.innerHTML = 'Other Information';
        
    let bigboxdataTable = document.createElement('table');
    bigboxdataTable.id = 'bigboxdataTable';

    // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

    // Create table header row
    let thRow = document.createElement('tr');
    let tHeaders = ['Location', 'Description', 'Justification', 'Annual Balance Exceeded', 'Exceeded Reason', 'Denial Reason'];
    for (let h of tHeaders) {
        let th = document.createElement('th');
        th.innerHTML = h;
        thRow.appendChild(th);
    }

    bigboxdataTable.append(thRow);

    let tr = document.createElement('tr');

    let tdlocations = document.createElement('td');
    tdlocations.innerHTML = selectedformdata.locations;
    tr.appendChild(tdlocations);

    let tddescription = document.createElement('td');
    tddescription.innerHTML = selectedformdata.description;
    tr.appendChild(tddescription);
    
    let tdjustification = document.createElement('td');
    tdjustification.innerHTML = selectedformdata.justification;
    tr.appendChild(tdjustification);

    let tdamountexceeded = document.createElement('td');
    tdamountexceeded.innerHTML = selectedrequest.amountexceeded;
    tr.appendChild(tdamountexceeded);

    let tdexceededreason = document.createElement('td');
    if (selectedrequest.exceededreason == null) {
        tdexceededreason.innerHTML = '-';
    }
    else {
        tdexceededreason.innerHTML = selectedrequest.exceededreason;
    }
    tr.appendChild(tdexceededreason);

    let tddenialreason = document.createElement('td');
    if (selectedrequest.denialreason == null) {
        tddenialreason.innerHTML = '-';
    }
    else {
        tddenialreason.innerHTML = selectedrequest.denialreason;
    }
    tr.appendChild(tddenialreason);

    bigboxdataTable.appendChild(tr);

    bigboxdata.appendChild(bigboxdataTable);

}

function approverequest(appden) {
    if (('No' == appden) && (document.getElementById('denyreason').value == false)) {
        return;
    }
    else {
        selectedrequest.denialreason = document.getElementById('denyreason').value
        document.getElementById("approve").disabled = true;
        document.getElementById("deny").disabled = true;
        document.getElementById("denyreason").disabled = true;
    }
    if ('employee' == activeuser.utype) {
        selectedrequest.empapp = appden;
        selectedrequest.inbox = activeuser.manager;
    }
    else if ('supervisor' == activeuser.utype) {
        selectedrequest.supapp = appden;
        if (selecteduser.id == activeuser.id) {
            selectedrequest.inbox = activeuser.manager;
        }
        else {
            selectedrequest.inbox = activeuser.depthead;
        }
    }
    else if ('manager' == activeuser.utype) {
        selectedrequest.manapp = appden;
        selectedrequest.inbox = 5;
    }
    else if ('depthead' == activeuser.utype) {
        selectedrequest.dhdapp = appden;
        selectedrequest.inbox = 5;
    }
    else if ('benco' == activeuser.utype) {
        selectedrequest.benapp = appden;
        selectedrequest.inbox = selecteduser.id;
    }
    else if ('bencosupervisor' == activeuser.utype) {
        selectedrequest.benapp = appden;
        selectedrequest.inbox = selecteduser.id;
    }
    if ('No' == appden){
        selectedrequest.inbox = 0;
        selectedrequest.status = 'Denied';
        selectedaccount.pending = selectedaccount.pending - selectedrequest.reimbursement;
        let b = 1000 - selectedaccount.pending
        if (b < 0) {
            selectedaccount.balance = 0
        }
        else {
            selectedaccount.balance = b
        }
        url = 'http://localhost:8080/Project1/site/updateaccount';
        let xhttupdateaccount = new XMLHttpRequest();
        let uupdateaccountsend = JSON.stringify(selectedaccount);
        function updateaccountfunc() {
            let r = xhttupdateaccount.responseText;
            selectedaccount = JSON.parse(r);
        }
        sendrequest(xhttupdateaccount, url, "POST", updateaccountfunc, uupdateaccountsend);
    }
    url = 'http://localhost:8080/Project1/site/updaterequest';
    let xhttpupdaterequest = new XMLHttpRequest();
    let updaterequestsend = JSON.stringify(selectedrequest);
    function updaterequestfunc() {
        let r = xhttpupdaterequest.responseText;
        selectedrequest = JSON.parse(r);
    }
    sendrequest(xhttpupdaterequest, url, "POST", updaterequestfunc, updaterequestsend);

    refresheditrequestpage();

}

function complete() {
    selectedrequest.status = 'Completed';
    selectedaccount.pending = selectedaccount.pending - selectedrequest.reimbursement;
    selectedaccount.reimbursed = selectedaccount.reimbursed + selectedrequest.reimbursement;

    url = 'http://localhost:8080/Project1/site/updateaccount';
    let xhttupdateaccount2 = new XMLHttpRequest();
    let uupdateaccountsend2 = JSON.stringify(selectedaccount);
    function updateaccountfunc2() {
        let r = xhttupdateaccount2.responseText;
        selectedaccount = JSON.parse(r);
    }
    sendrequest(xhttupdateaccount2, url, "POST", updateaccountfunc2, uupdateaccountsend2);

    url = 'http://localhost:8080/Project1/site/updaterequest';
    let xhttpupdaterequest2 = new XMLHttpRequest();
    let updaterequestsend2 = JSON.stringify(selectedrequest);
    function updaterequestfunc2() {
        let r = xhttpupdaterequest2.responseText;
        selectedrequest2 = JSON.parse(r);
    }
    sendrequest(xhttpupdaterequest2, url, "POST", updaterequestfunc2, updaterequestsend2);

    refresheditrequestpage();

}

function changeamount() {

    let newpending = selectedaccount.pending - selectedrequest.reimbursement + parseFloat(document.getElementById('amountchange').value);
    let newbalance = 1000 - selectedaccount.reimbursed - newpending;
    selectedrequest.amountexceeded = 'No';
    selectedrequest.exceededreason = null;
    if (newbalance < 0) {
        if (document.getElementById('exceededreason').value == false) {
            return;
        }
        else {
            newbalance = 0.00;
            selectedrequest.amountexceeded = 'Yes';
            selectedrequest.exceededreason = document.getElementById('exceededreason').value;
        }
    }
    selectedaccount.balance = newbalance;
    selectedaccount.pending = newpending;
    selectedrequest.reimbursement = document.getElementById('amountchange').value;

    url = 'http://localhost:8080/Project1/site/updateaccount';
    let xhttupdateaccount2 = new XMLHttpRequest();
    let uupdateaccountsend2 = JSON.stringify(selectedaccount);
    function updateaccountfunc2() {
        let r = xhttupdateaccount2.responseText;
        selectedaccount = JSON.parse(r);
    }
    sendrequest(xhttupdateaccount2, url, "POST", updateaccountfunc2, uupdateaccountsend2);

    url = 'http://localhost:8080/Project1/site/updaterequest';
    let xhttpupdaterequest2 = new XMLHttpRequest();
    let updaterequestsend2 = JSON.stringify(selectedrequest);
    function updaterequestfunc2() {
        let r = xhttpupdaterequest2.responseText;
        selectedrequest2 = JSON.parse(r);
    }
    sendrequest(xhttpupdaterequest2, url, "POST", updaterequestfunc2, updaterequestsend2);

    refresheditrequestpage();
}

function disablebuttons() {
    if (activeuser.id != selectedrequest.inbox) {
        document.getElementById("approve").disabled = true;
        document.getElementById("deny").disabled = true;
        document.getElementById("denyreason").disabled = true;
    }
    if (('depthead' == selecteduser.utype) && ('Yes' != selectedrequest.dhdapp)) {
        document.getElementById("complete").disabled = true;
    }
    if (('employee' == selecteduser.utype) || ('supervisor' == selecteduser.utype) || ('manager' == selecteduser.utype)) {
        if ('Yes' != selectedrequest.manapp) {
            document.getElementById("complete").disabled = true;
        }
    }
    if ((('benco' == activeuser.utype) || ('bencosupervisor' == activeuser.utype)) && (('benco' == selecteduser.utype) || ('bencosupervisor' == selecteduser.utype))) {
        document.getElementById("approve").disabled = true;
        document.getElementById("deny").disabled = true;
        document.getElementById("denyreason").disabled = true;
    }
    if ('Yes' == selectedrequest.benapp) {
        document.getElementById("amount").disabled = true;
        document.getElementById("amountchange").disabled = true;
        document.getElementById("exceededreason").disabled = true;
    }
    if (('benco' == activeuser.utype) && ('Yes' == selectedrequest.benapp)) {
        document.getElementById("approve").disabled = true;
    }
    if ((selectedrequest.status == 'Completed') || (selectedrequest.status == 'Denied')) {
        document.getElementById("amount").disabled = true;
        document.getElementById("amountchange").disabled = true;
        document.getElementById("exceededreason").disabled = true;
        document.getElementById("approve").disabled = true;
        document.getElementById("deny").disabled = true;
        document.getElementById("denyreason").disabled = true;
        document.getElementById("complete").disabled = true;
        document.getElementById("requestinfo").disabled = true;
        document.getElementById("addattachments").disabled = true;
    }
    if (('employee' == activeuser.utype) || ('supervisor' == activeuser.utype) || ('manager' == activeuser.utype) || ('depthead' == activeuser.utype)) {
        document.getElementById("bencobuttons").style.display = "none";
        document.getElementById("complete").style.display = "none";
        // add accounts button disabled
    }
}

function sendrequest(xhttp, url, GETPOST, funcstuff, send) {
    // AJAX Call
    xhttp.onreadystatechange = sendrequestfunc;
    xhttp.open(GETPOST, url, false);
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