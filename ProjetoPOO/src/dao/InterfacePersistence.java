package dao;

import java.util.List;

public interface InterfacePersistence<T> {
    void salvar(List<T> lista);
    List<T> carregar();
}