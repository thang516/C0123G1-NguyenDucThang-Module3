function checkName(name, id) {
    // let name = document.getElementById("regexName").value;
    const nameInput = document.querySelector(`[name=${name}]`).value;
    let regexName = /^[A-Z][a-z]*(\s[A-Z][a-z]*)+$/;
    if (regexName.test(nameInput)) {
        document.getElementById(id).innerText = "";
    } else {
        document.getElementById(id).innerText = "The Name is not in the correct format";
    }
}
function checkDayOfBirth(){
    let dayOfBirth = document.getElementById("dayOfBirth").value;
    let regexDayOfBirth = /^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$/;
    if (regexDayOfBirth.test(dayOfBirth)) {
        document.getElementById("checkDayOfBirth").innerText = "";
    } else {
        document.getElementById("checkDayOfBirth").innerText = "The Date is not in the correct format !"+
            "\n Please insert with format YYYY-MM-DD";
    }
}
function checkPhoneNumber(){
    let phoneNumber = document.getElementById("phone").value;
    let reGexPhoneNumb = /^0[1-9]([0-9]){8}$/;
    if (reGexPhoneNumb.test(phoneNumber)) {
        document.getElementById("checkPhone").innerText = "";
    } else {
        document.getElementById("checkPhone").innerText = "The Phone Number is not in the correct format ! " +
            "\n Please insert with format 0(1->9)XXXXXXXX";
    }
}
function checkEmail() {
    let email = document.getElementById("email").value;
    let regexEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    if (regexEmail.test(email)) {
        document.getElementById("checkEmail").innerText = "";
    } else {
        document.getElementById("checkEmail").innerText = "The Email is not in the correct format";
    }
}