package io.github.robinhosz.buy.graphql.produto.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.github.robinhosz.buy.entities.Compra;
import io.github.robinhosz.buy.entities.Produto;

public class ProdutoResolver implements GraphQLResolver<Produto> {

    //Exemplo simples de um Resolver, onde basicamente ele formata o campo de valor.

    public String valorReais(Produto produto) {
        return "R$ "+produto.getValor();
    }
}
