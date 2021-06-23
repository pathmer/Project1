var selectedrequest;
var selectedformdata;
var selectedattachments;


function refresheditrequestpage() {
    getselectedrequest();




    setTimeout(function(){

    },500);
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

    setTimeout(function(){
        getselectedformdata();
    },100);
    setTimeout(function(){
        getselectedattachments();
    },100);

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

function cancel() {
    window.location = "/Project1/html/HomePage.html"
}

function addattachments() {
    window.location = "/Project1/html/AddAttachments.html"
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