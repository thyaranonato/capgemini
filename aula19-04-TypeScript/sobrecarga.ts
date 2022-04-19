function ola(text:string):string;
function ola(text:number):number;
function ola(text:any):any {
    return `Olá ${text}`;
};

console.log(ola("Tudo bem Joãozinho?"));
console.log(ola(100));
