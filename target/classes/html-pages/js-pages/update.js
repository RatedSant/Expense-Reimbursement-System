console.log('testing it works');

window.onload = function(){ //this is essentially a callback function for the window's completion signal

    getUserName();
    getReimbs();
}



async function getReimbs(){
    
    const responsePayload = await fetch(`http://localhost:9002/get-all-pending-reimbs`);

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


    function getElement() {
        console.log(this.reimbID);
        document.getElementById("disabledInput").value = this.reimbID;
    }


    
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

        row.setAttribute("data-bs-target", "#staticBackdrop");
        row.setAttribute("data-bs-toggle", "modal");
        let readRow = getElement.bind(x);
        row.addEventListener('click', readRow);


        reimbTable.appendChild(row)
    }
    
}