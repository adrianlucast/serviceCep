package br.unipar.programacaointernet.servicecep.dao;

import br.unipar.programacaointernet.servicecep.model.Usuario;
import java.util.List;

public interface UsuarioDAO {

    void update(Usuario usuario);
    void delete(Usuario usuario);
    void save(Usuario usuario);

    Usuario findById(Long id);
    List<Usuario> findAll();

}
