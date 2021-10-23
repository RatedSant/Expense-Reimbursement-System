console.log('testing it works');

window.onload = function(){

    getUserName();
}


async function getUserName(){
    

    const responsePayload = await fetch(`http://localhost:9002/get-user`);

    const user = await responsePayload.json();

    ourDOMManipulation(user);

}


function ourDOMManipulation(user){

    document.getElementById("change").innerText = "Cool to have you back " + user.userName;
    document.getElementById("gaming").innerText = "Gaming Tag : " + user.loginName;
    
}




