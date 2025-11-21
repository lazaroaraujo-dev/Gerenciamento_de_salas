package dao;

import model.Espaco;                    	// Classe do modelo
import com.google.gson.Gson;            	// Conversor JSON
import java.io.File;                   	 	// Manipular arquivos
import java.io.FileReader;              	// Ler arquivos
import java.io.IOException;             	// Tratar erros
import java.io.Reader;                  	// Interface leitura
import java.lang.reflect.Type;          	// Trabalhar com tipos
import com.google.gson.reflect.TypeToken;   // Definir tipo lista
import java.util.ArrayList;             	// Implementação lista
import java.util.List;                  	// Interface lista
import java.io.FileWriter;              	// Escrever arquivos
import java.io.Writer;                  	// Interface escrita

public class EspacoDAO implements InterfacePersistence<Espaco> {
    
    private static final String ARQUIVO = "data/espacos.json";
    private Gson gson = new Gson();
    @Override
    public List<Espaco> carregar() {
        try {
            File arquivo = new File(ARQUIVO);
            
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }
            
            Reader reader = new FileReader(ARQUIVO);
            Type listType = new TypeToken<ArrayList<Espaco>>(){}.getType();
            List<Espaco> espacos = gson.fromJson(reader, listType);
            reader.close();
            
            return espacos != null ? espacos : new ArrayList<>();
            
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    //void pq nao preciso retornar nada.
    @Override
    public void salvar(List<Espaco> lista) {
    	try {
    		// Garante que a pasta 'data' esteja criada.
    		new File("data").mkdirs();
    		// Cria um objeto para escrever no arquivo JSON.
    		Writer writer = new FileWriter(ARQUIVO);
    		// Converter PARA JSON
    		gson.toJson(lista, writer);
    		
    		writer.close();
    	} catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
    	}
    }
}