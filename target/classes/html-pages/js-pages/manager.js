console.log('testing it works');

window.onload = function(){ 

    getUserName();

    document
    .getElementById("all")
    .addEventListener('click', getAll);

    document
    .getElementById("approved")
    .addEventListener('click', getApproved);

    document
    .getElementById("pending")
    .addEventListener('click', getPending);

    document
    .getElementById("denied")
    .addEventListener('click', getDenied);


}



async function getAll(){
    
    const responsePayload = await fetch(`http://localhost:9002/get-reimbs`);

    const ticket = await responsePayload.json();

    ourDOMManipulation(ticket);
}

async function getApproved(){
    
    const responsePayload = await fetch(`http://localhost:9002/get-all-approved-reimbs`);

    const ticket = await responsePayload.json();

    ourDOMManipulation(ticket);
}

async function getPending(){
    
    const responsePayload = await fetch(`http://localhost:9002/get-all-pending-reimbs`);

    const ticket = await responsePayload.json();

    ourDOMManipulation(ticket);
}

async function getDenied(){
    
    const responsePayload = await fetch(`http://localhost:9002/get-all-denied-reimbs`);

    const ticket = await responsePayload.json();

    ourDOMManipulation(ticket);
}

async function getUserName(){
    

    const responsePayloaded = await fetch(`http://localhost:9002/get-user`);

    const user = await responsePayloaded.json();

    ourDOMManipulationUser(user);

}


function ourDOMManipulationUser(user){

    document.getElementById("change").innerText = "Cool to have you back " + user.userName;
    document.getElementById("gaming").innerText = "Gaming Tag : " + user.loginName;
    
}



function ourDOMManipulation(dataRows){

    const reimbTable =  document.getElementById("reimbursements-table");

    
    for(const x of dataRows){
        
        const row = document.createElement('tr');
        
        let resolved, revtime;

        if(x.reimbResolved == null){

            revtime = '';

        }else{
                resolved= new Date(x.reimbResolved);
                revtime = document.createTextNode(resolved.toUTCString());
        }

        let submitted = new Date(x.reimbSubmitted);
        let subtime = document.createTextNode(submitted.toUTCString());
        
        // console.log(resolved, submitted);

        const properties = ['reimbAmount','author','resolver','status',
        'type','reimbID','reimbDescription'];

        
        for(const information of properties){

            let element;
            
            
            element = document.createElement('td');
            element.innerText = x[information];
            row.appendChild(element);

            
        }

        
        element = document.createElement('td');
        element.appendChild(subtime);
        row.appendChild(element);
        
        if(revtime == ''){

            element = document.createElement('td');
            element.innerText = "";
            row.appendChild(element);

        }else{

            element = document.createElement('td');
            element.appendChild(revtime);
            row.appendChild(element);
        }


        reimbTable.appendChild(row)
    }
    
}

