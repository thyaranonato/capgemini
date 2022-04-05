function onSubmit() {
    let nome = document.getElementById("nome");
    let idade = document.getElementById("idade");
    let email = document.getElementById("email");
    let date = document.getElementById("date");
    let datetime = document.getElementById("datetime");
    let lista = document.getElementById("lista");
    if(nome.value === ""){
        alert("Informe o nome");
        nome.focus();
        return;
    } else if(idade.value === ""){
        alert("Informe a idade");
        idade.focus();
        return;
    } else if(email.value === ""){
        alert("Informe o email");
        email.focus();
        return;
    } else if(date.value === ""){
        alert("Informe a data");
        date.focus();
        return;
    } else if(datetime.value === ""){
        alert("Informe a data e hora");
        datetime.focus();
        return;
    } else if(lista !== "checked"){
        alert("Informe campo");
        lista.focus();
        return;
    } 
    document.getElementsByTagName("form")[0].submit();
}