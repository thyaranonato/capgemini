function validateData() {
    let nome = document.getElementById("nome");
    let fone = document.getElementById("fone");
    let email = document.getElementById("email");
    let profissao = document.getElementById("profissao");
    let cidade = document.getElementById("cidade");
    let estado = document.getElementById("estado");
    let imagem = document.getElementById("imagem");
    if (nome.value === "") {
        alert("Informe o nome");
        nome.focus();
        return;
    } else if (fone.value === "") {
        alert("Informe o fone");
        fone.focus();
        return;
    } else if (email.value === "") {
        alert("Informe o email");
        email.focus();
        return;
    } else if (profissao.value === "") {
        alert("Informe a profissao");
        profissao.focus();
        return;
    } else if (cidade.value === "") {
        alert("Informe a cidade");
        cidade.focus();
        return;
    } else if (estado.value === "") {
        alert("Informe o estado");
        estado.focus();
        return;
    } else if (imagem.value === "") {
        alert("Informe a imagem");
        imagem.focus();
        return;
    }
    document.getElementsByTagName("form")[0].submit();
}