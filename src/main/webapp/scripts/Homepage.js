let url = "";
var d = new Date();
var currentyear = d.getFullYear();

function newrequestpage() {
    window.location = "/Project1/html/Request.html"
}

function submitrequest(){
    newrequest();
    // setTimeout(function(){
    //     newformdata();
    // },100);
    // setTimeout(function(){
    //     newattachments();
    // },100);
    // setTimeout(function(){
    //     updateformdata();
    // },100);
    setTimeout(function(){
        //window.location = "/Project1/html/HomePage.html"
    },100);
}


function newrequest() {
    let url = 'http://localhost:8080/Project1/site/addRequest';

    // collect user input
    let rtitle = document.getElementById('title').value;
    let rstartDate = document.getElementById('startDate').value;

    // create request object
    let request = {
        title: rtitle,
        startDate: rstartDate,
    }
    console.log(request);
    // AJAX Call
    let xhttpnewrequest = new XMLHttpRequest();
    let newrequestsend = JSON.stringify(request)
    function newrequestfunc() {
        console.log('newrequest success');
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

    let formdata = {
        times: rtimes,
        locations: rlocations,
        description: rdescription,
        costs: rcosts,
        gradeFormat: rgradeFormat,
        eventType: reventType,
        justification: rjustification,
    }

    // AJAX Call
    let xhttpnewformdata = new XMLHttpRequest();
    let nnewformdatasend = JSON.stringify(formdata)
    function newformdatafunc() {
        console.log('newformdata success');
    }
    sendrequest(xhttpnewformdata, url, "POST", newformdatafunc, nnewformdatasend)
}

function newattachments () {
    let url = 'http://localhost:8080/Project1/site/addattachments';

    let attachments = {
    }

    // AJAX Call
    let xhttpnewattachments = new XMLHttpRequest();
    let newattachmentssend = JSON.stringify(attachments)
    function newattachmentsfunc() {
        console.log('newattachments success');
    }
    sendrequest(xhttpnewattachments, url, "POST", newattachmentsfunc, newattachmentssend)
}

function updateformdata () {
    let url = 'http://localhost:8080/Project1/site/updateFormdata';

    let rmissedWorkhrsperwk = document.getElementById('missedWorkhrsperwk').value;

    let formdata2 = {
        missedWorkhrsperwk: rmissedWorkhrsperwk,
    }









}

function cancel() {
    window.location = "/Project1/html/HomePage.html"
}


function logout() {
    let url = 'http://localhost:8080/Project1/site/logout';
    let xhttplogout = new XMLHttpRequest();
    let accountsend = JSON.stringify(null)
    function logoutfunc() {
        let r = xhttplogout.responseText;
        r = JSON.parse(r);
        if (r == "loggedout") {
            window.location = "/Project1/html/Login.html"
        }
    }
    sendrequest(xhttplogout, url, "GET", logoutfunc, accountsend)
}


function editrequest() {
    window.location = "/Project1/html/EditRequest.html"
}


function save() {
    window.location = "/Project1/html/HomePage.html"
}


function addattachments() {
    window.location = "/Project1/html/AddAttachments.html"
}

function refreshhomepage() {
    // Update account info
    year.value = currentyear;
    changeyear();
}

function sendrequest(xhttp, url, GETPOST, funcstuff, send) {
    // AJAX Call
    //console.log(url, GETPOST, funcstuff, send);
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

function changeyear() {
    // Update account info
    url = 'http://localhost:8080/Project1/site/getaccount';
    let xhttpchangeyear = new XMLHttpRequest();
    let accyear = document.getElementById('year').value;
    let accountsend = JSON.stringify(accyear)
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
    sendrequest(xhttpchangeyear, url, "POST", accountfunc, accountsend)
    setTimeout(function(){
        getusershortrequests();
    },100);
    setTimeout(function(){
        getothershortrequests();
    },100);
}

function getusershortrequests() {
    url = 'http://localhost:8080/Project1/site/getusershortrequests';
    let xhttpgetusershortrequests = new XMLHttpRequest();
    let userrequestsend = null;
    function userrequestsfunc() {
        let userrequests = xhttpgetusershortrequests.responseText;
        userrequests = JSON.parse(userrequests);

        console.log(userrequests);
        
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
                tr.setAttribute('onclick', 'editrequest()');

                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = request.title;
                tr.appendChild(tdTitle);

                let tdStart = document.createElement('td');
                tdStart.innerHTML = request.startDate;
                tr.appendChild(tdStart);
                
                let tdReimbursement = document.createElement('td');
                tdReimbursement.innerHTML = request.reimbursement;
                tr.appendChild(tdReimbursement);

                let tdStatus = document.createElement('td');
                tdStatus.innerHTML = request.status;
                tr.appendChild(tdStatus);

                let tdPriority = document.createElement('td');
                tdPriority.innerHTML = request.priority;
                tr.appendChild(tdPriority);

                userrequestsTable.appendChild(tr);
            }
        }
        userRequestsSection.appendChild(userrequestsTable);
    }
    sendrequest(xhttpgetusershortrequests, url, "GET", userrequestsfunc, userrequestsend)
}

function getothershortrequests() {
    url = 'http://localhost:8080/Project1/site/getothershortrequests';
    let xhttpgetothershortrequests = new XMLHttpRequest();
    let otherrequestsend = null;
    function otherrequestsfunc() {
        let otherrequests = xhttpgetothershortrequests.responseText;
        otherrequests = JSON.parse(otherrequests);

        console.log(otherrequests);
        
        // Create a table
        let otherRequestsSection = document.getElementById('otherRequestsSection');
        otherRequestsSection.innerHTML = 'Other Requests';
        
        let otherrequestsTable = document.createElement('table');
        otherrequestsTable.id = 'otherrequestsTable';

        // we will need: <tr> table row, <td> for each piece of data in that row, <th> for the header

        // Create table header row
        let thRow = document.createElement('tr');
        let tHeaders = ['Title', 'Start Date', 'Reimbursement', 'Status', 'Priority'];
        for (let h of tHeaders) {
            let th = document.createElement('th');
            th.innerHTML = h;
            thRow.appendChild(th);
        }

        otherrequestsTable.append(thRow);
        if (otherrequests != null) {
            for (let request of otherrequests) {
                let tr = document.createElement('tr');
                tr.setAttribute('onclick', 'editrequest()');

                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = request.title;
                tr.appendChild(tdTitle);

                let tdStart = document.createElement('td');
                tdStart.innerHTML = request.startDate;
                tr.appendChild(tdStart);
                
                let tdReimbursement = document.createElement('td');
                tdReimbursement.innerHTML = request.reimbursement;
                tr.appendChild(tdReimbursement);

                let tdStatus = document.createElement('td');
                tdStatus.innerHTML = request.status;
                tr.appendChild(tdStatus);

                let tdPriority = document.createElement('td');
                tdPriority.innerHTML = request.priority;
                tr.appendChild(tdPriority);

                otherrequestsTable.appendChild(tr);
            }
        }
        otherRequestsSection.appendChild(otherrequestsTable);
    }
    sendrequest(xhttpgetothershortrequests, url, "GET", otherrequestsfunc, otherrequestsend)
}