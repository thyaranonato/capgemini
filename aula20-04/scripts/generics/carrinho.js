"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Item_1 = __importDefault(require("./Item"));
const Produto_1 = require("./Produto");
let feijao;
feijao = new Produto_1.Produto("feijão preto", 5, 50);
let arroz = new Produto_1.Produto("arroz branco", 6, 25);
let item1 = new Item_1.default(feijao, feijao.valorUnitario, 2);
let item2 = new Item_1.default(arroz, arroz.valorUnitario, 3);
let carrinho = [item1, item2];
carrinho.push(new Item_1.default(feijao, feijao.valorUnitario, 3));
console.log(carrinho);
