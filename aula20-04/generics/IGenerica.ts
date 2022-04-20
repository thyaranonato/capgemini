interface IDaoGenerica<T> {
    salvar(): boolean;
    excluir(id:number):number;
    consultarTodos():T[];
    consultarPeloId(id:number): T;
    alterar(objeto:T):boolean;
}

export { IDaoGenerica };