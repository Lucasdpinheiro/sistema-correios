package main;

import java.util.HashMap;

import entregas.EntregaPadrao;
import entregas.EntregaSedex12;
import entregas.EntregaSedexHoje;
import entregas.Taxavel;
import models.EntregaModel;
import models.ProdutoModel;
import repository.Repository;

public class SistemaCorreios {
    public static void main(String[] args) {

        EntregaPadrao entregaPadrão = new EntregaPadrao();
        EntregaSedex12 entregaSedex12 = new EntregaSedex12();
        EntregaSedexHoje entregaSedexHoje = new EntregaSedexHoje();

        SistemaCorreios.taxar(entregaPadrão);
        SistemaCorreios.taxar(entregaSedex12);
        SistemaCorreios.taxar(entregaSedexHoje);

        Repository repository = new Repository();

        EntregaModel entregaDAO = new EntregaModel();
        ProdutoModel produtoDAO = new ProdutoModel();

        repository.create(entregaDAO);
        repository.create(produtoDAO);

        repository.readAll(EntregaModel.class);
        repository.readAll(ProdutoModel.class);

        repository.readById(EntregaModel.class, 0);
        repository.readById(ProdutoModel.class, 0);

        HashMap<String, Object> inputJSON = new HashMap<>();
        inputJSON.put("prazo", "2022/08/19");

        repository.update(EntregaModel.class, 0, inputJSON);

        inputJSON.clear();
        inputJSON.put("peso", 5f);

        repository.update(ProdutoModel.class, 0, inputJSON);

        repository.deleteById(EntregaModel.class, 0);
        repository.deleteById(ProdutoModel.class, 0);

    }

    public static void taxar(Taxavel produto) {
        produto.taxarEntrega();
    }
}
