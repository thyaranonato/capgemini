import Item from "./Item";
import { Produto } from "./Produto";

let feijao: Produto;
feijao = new Produto("feijão preto", 5, 50);

let arroz = new Produto("arroz branco", 6, 25);

let item1: Item = new Item(feijao, feijao.valorUnitario, 2);

let item2 = new Item(arroz, arroz.valorUnitario, 3);

let carrinho:Item[] = [item1, item2];

carrinho.push(new Item(feijao, feijao.valorUnitario, 3));

console.log(carrinho);
