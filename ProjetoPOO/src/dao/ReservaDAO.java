package dao;

import model.Reserva;                   	// Classe do modelo
import com.google.gson.Gson;            	// Conversor JSON
import java.io.File;                    	// Manipular arquivos
import java.io.FileReader;              	// Ler arquivos  
import java.io.FileWriter;              	// Escrever arquivos
import java.io.IOException;             	// Tratar erros
import java.io.Reader;                  	// Interface leitura
import java.io.Writer;                  	// Interface escrita
import java.lang.reflect.Type;          	// Trabalhar com tipos
import com.google.gson.reflect.TypeToken; 	// Definir tipo lista
import java.util.ArrayList;            		// Implementação lista
import java.util.List;                		// Interface lista

public class ReservaDAO implements InterfacePersistence<Reserva> {
    
    private static final String ARQUIVO = "data/reservas.json";
    private Gson gson = new Gson();
    
    @Override
    public List<Reserva> carregar() {
        try {
            File arquivo = new File(ARQUIVO);
            
            if (!arquivo.exists()) {
                return new ArrayList<>();
            }
            
            Reader reader = new FileReader(ARQUIVO);
            Type listType = new TypeToken<ArrayList<Reserva>>(){}.getType();
            List<Reserva> reservas = gson.fromJson(reader, listType);
            reader.close();
            
            return reservas != null ? reservas : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    @Override
    public void salvar(List<Reserva> lista) {
        try {
            new File("data").mkdirs();
            Writer writer = new FileWriter(ARQUIVO);
            gson.toJson(lista, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar reservas: " + e.getMessage());
        }
    }
}
