package repository;

import java.util.HashMap;

public class Repository {

    public <T> void create(T entity) {
        System.out.printf("Entidade %s salva no banco de dados.\n", entity.getClass().getName());
    }

    public void readAll(Class<?> classType) {
        System.out.printf("Lista de entidades " + classType.getName() + ".\n");
    }

    public void readById(Class<?> classType, int id) {
        System.out.printf("Dados da entidade %s com id %d lidos.\n", classType.getName(), id);
    }

    public void update(Class<?> classType, int id, HashMap<String, Object> params) {
        System.out.printf("Alteração da entidade %s com id %d realizada com parâmetros %s.\n",
                classType.getName(), id, params.toString());
    }

    public void deleteById(Class<?> classType, int id) {
        System.out.printf("Entidade %s com id %d excluída do banco de dados.\n", classType.getName(), id);
    }

}
