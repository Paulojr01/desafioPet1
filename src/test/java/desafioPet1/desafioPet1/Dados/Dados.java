package desafioPet1.desafioPet1.Dados;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Dados {

    public  Map dadosPedidoTest200 (){

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formataDataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String dataHoraFormatada = dataHoraAtual.format(formataDataHora);

        Map<String,Object> params = new HashMap<>();
        params.put("id", 80);
        params.put("petId", 70);
        params.put("quantity", 40);
        params.put("shipDate", dataHoraFormatada);
        params.put("status", "placed");
        params.put("complete", true);

        return params;
    }


    public Map dadosIdVazio (){

        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formataDataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String dataHoraFormatada = dataHoraAtual.format(formataDataHora);

        Map<String,Object> params = new HashMap<>();
        params.put("id", "");
        params.put("petId", "11");
        params.put("quantity", "11");
        params.put("shipDate", dataHoraFormatada);
        params.put("status", "placed");
        params.put("complete", true);

        return params;
    }

}
