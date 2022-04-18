class Agenda {
    constructor(data, hora, descricao, contato) {
        this.data = data,
        this.hora = hora,
        this.descricao = descricao,
        this._contato = contato
    }

    display() {
        console.log(`
            Data: ${this.data}
            hora: ${this.hora}
            Descrição: ${this.descricao}
            Contato: ${this.contato}`);
    }
}

let registro = new Agenda('18/04/22', '15:00', 'Estudar', 'Bruno');
console.log(registro);
registro.display();

let registro2 = new Agenda();
registro2.data = '15/04/2022';
registro2.display();
