interface IEmployee {
    empCode: number;
    empName: string;
    getSalary(salary: number): number;
    getManagerName(name: string): string;
}

// CRUD
interface IDao {
    salvar():boolean;
    alterar(id:number):boolean;
    consultar():string[];
    consultarPorId(id:number):string;
    excluir(id:number):void;
}

export { IEmployee, IDao };
