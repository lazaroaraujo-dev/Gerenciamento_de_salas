package dao;

import model.Pagamento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO implements InterfacePersistence<Pagamento> {
    
    private static final String ARQUIVO = "data/pagamentos.json";
    private Gson gson = new Gson();
    
    @Override
    public List<Pagamento> carregar() {
        try {
            File arquivo = new File(ARQUIVO);
            
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }
            
            Reader reader = new FileReader(ARQUIVO);
            Type listType = new TypeToken<ArrayList<Pagamento>>(){}.getType();
            List<Pagamento> pagamentos = gson.fromJson(reader, listType);
            reader.close();
            
            return pagamentos != null ? pagamentos : new ArrayList<>();
            
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public void salvar(List<Pagamento> lista) {
        try {
            new File("data").mkdirs();
            Writer writer = new FileWriter(ARQUIVO);
            gson.toJson(lista, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar pagamentos: " + e.getMessage());
        }
    }
}