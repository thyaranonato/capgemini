import { IEmployee, IDao } from './interfaces';

class Employee implements IEmployee, IDao {
    empCode: number;
    empName: string;
    empFone: string;

    constructor(empCode: number, empName: string, empFone: string) {
        this.empCode = empCode;
        this.empName = empName;
        this.empFone = empFone;
    }

    getSalary(salary: number): number {
        return salary;
    };

    getManagerName(name: string): string {
        return name;
    }

    salvar(): boolean {
        return true;
    }

    alterar(id: number): boolean {
        return true;
    }

    consultar(): string[] {
        let x:string[] = [];
        return x;
    }

    consultarPorId(id: number): string {
        return "Maria";
    }

    excluir(id: number): void {
        console.log("Excluído com sucesso!");
    }
}