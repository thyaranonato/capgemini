import Carrinho from "./Carrinho";
import Item from "./Item";
import { Produto } from "./Produto";


let feijao: Produto;
feijao = new Produto("feijão preto", 5, 50);

let arroz = new Produto("arroz branco", 6, 25);

let item1: Item = new Item(feijao, feijao.valorUnitario, 2);

let item2 = new Item(arroz, arroz.valorUnitario, 3);

// let carrinho:Item[] = [item1, item2];

let c1: Carrinho;
c1 = new Carrinho("20/04/2022", "José da Silva");
c1.add(item1);
c1.add(item2);
console.log(c1);

c1.remove(item1);
console.log(c1);

console.log(c1.itens[0].produto.descricao);
