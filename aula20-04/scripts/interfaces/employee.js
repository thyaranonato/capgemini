"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Employee {
    constructor(empCode, empName, empFone) {
        this.empCode = empCode;
        this.empName = empName;
        this.empFone = empFone;
    }
    getSalary(salary) {
        return salary;
    }
    ;
    getManagerName(name) {
        return name;
    }
    salvar() {
        return true;
    }
    alterar(id) {
        return true;
    }
    consultar() {
        let x = [];
        return x;
    }
    consultarPorId(id) {
        return "Maria";
    }
    excluir(id) {
        console.log("Excluído com sucesso!");
    }
}
