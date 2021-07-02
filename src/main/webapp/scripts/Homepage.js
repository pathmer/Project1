let url = "";
var d = new Date();
var currentyear = d.getFullYear();
var activeuser = {};


function newrequestpage() {
    window.location = "/Project1/html/Request.html"
}

function logout() {
    let url = 'http://localhost:8080/Project1/site/logout';
    let xhttplogout = new XMLHttpRequest();
    let accountsend = JSON.stringify(null);
    function logoutfunc() {
        let r = xhttplogout.responseText;
        r = JSON.parse(r);
        if (r == "loggedout") {
            window.location = "/Project1/html/Login.html"
        }
    }
    sendrequest(xhttplogout, url, "GET", logoutfunc, accountsend);
}


function editrequest(thisrequestid) {
    url = 'http://localhost:8080/Project1/site/setselectedrequest';
    let xhttpsetactiverequest = new XMLHttpRequest();
    requestid = {
        id : thisrequestid
    }
    let setactiverequestsend = JSON.stringify(requestid);
    function setactiverequestfunc() {
    }
    sendrequest(xhttpsetactiverequest, url, "POST", setactiverequestfunc, setactiverequestsend);

    window.location = "/Project1/html/EditRequest.html"
}

function refreshhomepage() {
    // Update account info
    year.value = currentyear;
    changeyear();
    if ('employee' == activeuser.utype) {
        document.getElementById("otherRequestsSection").style.display = "none";
    }
}

function changeyear() {
    // Update account info
    url = 'http://localhost:8080/Project1/site/getaccount';
    let xhttpchangeyear = new XMLHttpRequest();
    let accyear = document.getElementById('year').value;
    let accountsend = JSON.stringify(accyear);
    function accountfunc() {
        let account = xhttpchangeyear.responseText;
        account = JSON.parse(account);
        if (account != null) {
            balance.innerHTML = '$ ' + account.balance;
            pending.innerHTML = '$ ' + account.pending;
            reimbursed.innerHTML = '$ ' + account.reimbursed;
        }
        else {
            balance.innerHTML = '$ ';
            pending.innerHTML = '$ ';
            reimbursed.innerHTML = '$ ';
        }
    }
    sendrequest(xhttpchangeyear, url, "POST", accountfunc, accountsend);

    getactiveuser();

    getusershortrequests();

    getothershortrequests();

}

function getusershortrequests() {
    url = 'http://localhost:8080/Project1/site/getusershortrequests';
    let xhttpgetusershortrequests = new XMLHttpRequest();
    let userrequestsend = null;
    function userrequestsfunc() {
        let userrequests = xhttpgetusershortrequests.responseText;
        userrequests = JSON.parse(userrequests);
        
        // Create a table
        let userRequestsSection = document.getElementById('userRequestsSection');
        userRequestsSection.innerHTML = 'My Requests';
        
        let userrequestsTable = document.createElement('table');
        userrequestsTable.id = 'userrequestsTable';

        // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

        // Create table header row
        let thRow = document.createElement('tr');
        let tHeaders = ['Title', 'Start Date', 'Reimbursement', 'Status', 'Priority'];
        for (let h of tHeaders) {
            let th = document.createElement('th');
            th.innerHTML = h;
            thRow.appendChild(th);
        }

        userrequestsTable.append(thRow);
        if (userrequests != null) {
            for (let request of userrequests) {
                let tr = document.createElement('tr');
                tr.value = request.id;
                tr.setAttribute('onclick', 'editrequest(this.value)');

                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = request.title;
                tr.appendChild(tdTitle);

                let tdStart = document.createElement('td');
                var date = new Date(request.startDate);
                tdStart.innerHTML = date.toDateString();
                tr.appendChild(tdStart);
                
                let tdReimbursement = document.createElement('td');
                tdReimbursement.innerHTML = request.reimbursement;
                tr.appendChild(tdReimbursement);

                let tdStatus = document.createElement('td');
                if ((activeuser.id == request.inbox) && (request.status == 'pending')) {
                    tdStatus.innerHTML = "Action Needed";
                }
                else {
                    tdStatus.innerHTML = request.status;
                }
                tr.appendChild(tdStatus);

                let tdPriority = document.createElement('td');
                var date1 = new Date(request.startDate);
                var ans = (date1.getTime() - d.getTime()) / (1000 * 3600 * 24);
                if (ans < 14) {
                    tdPriority.innerHTML = 'URGENT';
                }
                else {
                    tdPriority.innerHTML = request.priority;
                }
                tr.appendChild(tdPriority);

                userrequestsTable.appendChild(tr);
            }
        }
        userRequestsSection.appendChild(userrequestsTable);
    }
    sendrequest(xhttpgetusershortrequests, url, "GET", userrequestsfunc, userrequestsend);
}

function getothershortrequests() {
    url = 'http://localhost:8080/Project1/site/getothershortrequests';
    let xhttpgetothershortrequests = new XMLHttpRequest();
    let otherrequestsend = null;
    function otherrequestsfunc() {
        let otherrequests = xhttpgetothershortrequests.responseText;
        otherrequests = JSON.parse(otherrequests);
        
        // Create a table
        let otherRequestsSection = document.getElementById('otherRequestsSection');
        otherRequestsSection.innerHTML = 'Other Requests';
        
        let otherrequestsTable = document.createElement('table');
        otherrequestsTable.id = 'otherrequestsTable';

        // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

        // Create table header row
        let thRow = document.createElement('tr');
        let tHeaders = ['Title', 'Start Date', 'Reimbursement $', 'Status', 'Priority'];
        for (let h of tHeaders) {
            let th = document.createElement('th');
            th.innerHTML = h;
            thRow.appendChild(th);
        }

        otherrequestsTable.append(thRow);
        if (otherrequests != null) {
            for (let request of otherrequests) {
                let tr = document.createElement('tr');
                tr.value = request.id;
                tr.setAttribute('onclick', 'editrequest(this.value)');

                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = request.title;
                tr.appendChild(tdTitle);

                let tdStart = document.createElement('td');
                var date = new Date(request.startDate);
                tdStart.innerHTML = date.toDateString();
                tr.appendChild(tdStart);
                
                let tdReimbursement = document.createElement('td');
                tdReimbursement.innerHTML = request.reimbursement;
                tr.appendChild(tdReimbursement);

                let tdStatus = document.createElement('td');
                if ((activeuser.id == request.inbox) && (request.status == 'pending')){
                    tdStatus.innerHTML = "Action Needed";
                }
                else {
                    tdStatus.innerHTML = request.status;
                }
                tr.appendChild(tdStatus);

                let tdPriority = document.createElement('td');
                var date1 = new Date(request.startDate);
                var ans = (date1.getTime() - d.getTime()) / (1000 * 3600 * 24);
                if (ans < 14) {
                    tdPriority.innerHTML = 'URGENT';
                }
                else {
                    tdPriority.innerHTML = request.priority;
                }
                tr.appendChild(tdPriority);

                otherrequestsTable.appendChild(tr);
            }
        }
        otherRequestsSection.appendChild(otherrequestsTable);
    }
    sendrequest(xhttpgetothershortrequests, url, "GET", otherrequestsfunc, otherrequestsend);
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