package services;

import dao.EspacoDAO;
import exceptions.EspacoException;
import model.Espaco;
import model.SalaDeReuniao;
import model.CabineIndividual;
import model.Auditorio;

import java.util.List;

public class SalaService {

    private EspacoDAO espacoDAO = new EspacoDAO();

    // ============= CADASTRAR =================
    public void cadastrar(Espaco espaco) throws EspacoException {

        if (espaco.getNome() == null || espaco.getNome().equals("")) {
            throw new EspacoException("Nome inválido.");
        }

        if (espaco.getCapacidade() <= 0) {
            throw new EspacoException("Capacidade inválida.");
        }

        if (espaco.getPrecoPorHora() < 0) {
            throw new EspacoException("Preço inválido.");
        }

        espacoDAO.salvar(espaco);
    }

    // ============= LISTAR =================
    public List<Espaco> listar() {
        return espacoDAO.listar();
    }

    // ============= BUSCAR POR ID =============
    public Espaco buscarPorId(int id) throws EspacoException {
        Espaco e = espacoDAO.buscarPorId(id);

        if (e == null) {
            throw new EspacoException("Espaço não encontrado.");
        }

        return e;
    }

    // ============= EDITAR =================
    public void editar(Espaco espaco) throws EspacoException {

        Espaco existe = espacoDAO.buscarPorId(espaco.getId());

        if (existe == null) {
            throw new EspacoException("Espaço inexistente.");
        }

        espacoDAO.atualizar(espaco);
    }

    // ============= REMOVER =================
    public void remover(int id) throws EspacoException {

        Espaco existe = espacoDAO.buscarPorId(id);

        if (existe == null) {
            throw new EspacoException("Espaço inexistente.");
        }

        espacoDAO.remover(id);
    }

    // ============= CRIAR ESPAÇO EM TEMPO REAL =============
    public Espaco criarEspaco(String tipo, int id, String nome, int capacidade, double preco, boolean usarProjetor)
            throws EspacoException {

        tipo = tipo.toLowerCase();

        if (tipo.equals("reuniao")) {
            return new SalaDeReuniao(id, nome, capacidade, preco, usarProjetor);
        }
        else if (tipo.equals("cabine")) {
            return new CabineIndividual(id, nome, capacidade, preco);
        }
        else if (tipo.equals("auditorio")) {
            return new Auditorio(id, nome, capacidade, preco);
        }
        else {
            throw new EspacoException("Tipo inválido.");
        }
    }
}
