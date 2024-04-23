package br.unipar.programacaointernet.servicecep.service;

import br.unipar.programacaointernet.servicecep.dao.UsuarioDAO;
import br.unipar.programacaointernet.servicecep.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.model.Usuario;
import br.unipar.programacaointernet.servicecep.util.EntityManagerUtil;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI {
    @Override
    public String boasVindas(String nome) {
        return "Olá, seja Bem Vindo(a) " + nome + "!";
    }

    @Override
    public String salvarUsuario(String nome, String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setNome(nome);

        usuarioDAO.save(usuario);

        return "O Usuário " + usuario.getNome() + "foi Salvo com Sucesso!";
    }

    @Override
    public String editarUsuario(Long id,
                              String nome,
                              String login,
                              String senha) {

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = usuarioDAO.findById(id);

        if (login != null)
            usuario.setLogin(login);

        if (senha != null)
            usuario.setSenha(senha);

        if (nome != null)
            usuario.setNome(nome);


        usuarioDAO.update(usuario);

        return "O Usuário " + usuario.getNome() + " foi Alterado com Sucesso!";
    }

    @Override
    public Usuario consultaUsuarioPorID(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        return usuarioDAO.findById(id);
    }

    @Override
    public List<Usuario> consultaUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        return usuarioDAO.findAll();
    }

    @Override
    public String deletarUsuario(Long id) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil
                .getManager());

        Usuario usuario = usuarioDAO.findById(id);
        usuarioDAO.delete(usuario);

        return "O Usuário " + usuario.getNome() + " foi Removido com Sucesso!";
    }
}
