function registerCustomer() {
    event.preventDefault();

    let fullname = document.getElementById("fullname").value;
    let address = document.getElementById("address").value;
    let password = document.getElementById("passwordSign").value;
    let email = document.getElementById("email").value;
    let phoneNumber = document.getElementById("phoneNumber").value;
    console.log(fullname, address, address, email, password, phoneNumber)

    fetch("http://localhost:8080/cs-con/customers", {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify({
            "name": fullname,
            "password": password,
            "address": address,
            "email": email,
            "phoneNumber" : phoneNumber
        })
    }).then(response => {
        response.json().then(data => {
            alert("Customer sucessfully registered with ID: " + data.id);
            window.location.href="/customerPages/customerPageFunction.html"
        });
    })
}

