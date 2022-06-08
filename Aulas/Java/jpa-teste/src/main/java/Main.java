import java.util.ArrayList;
import java.util.List;

//import com.jpa.controller.ProdutoDAO;
import com.jpa.model.Produto;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        //ProdutoDAO dbProduto = new ProdutoDAO();

        List<Produto> prod_list = new ArrayList<>();

        Produto prod1 = new Produto();
        prod1.setId(1l);
        prod1.setQuantidade(1);
        prod1.setCategoria("Eletrodoméstico");
        prod1.setNome("TV");
        prod1.setValor(2000.0f);

        prod_list.add(prod1);

        Produto prod2 = new Produto();
        prod2.setId(2l);
        prod2.setQuantidade(1);
        prod2.setCategoria("Eletrodoméstico");
        prod2.setNome("Microondas");
        prod2.setValor(500.0f);      

        prod_list.add(prod2);

        JSONArray json_arr = new JSONArray();
        json_arr.put(prod_list);

        System.out.println(json_arr);

        //dbProduto.remover(prod);   
    }
}