package br.unipar.programacaointernet.servicecep.dao;

import br.unipar.programacaointernet.servicecep.model.Endereco;
import br.unipar.programacaointernet.servicecep.model.Usuario;
import br.unipar.programacaointernet.servicecep.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {

    private EntityManager em = EntityManagerUtil.getManager();

    public EnderecoDAOImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public void update(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(endereco);
        transaction.commit();
        System.out.println("O Endereço " + endereco.toString() + " foi Atualizado com Sucesso!");
    }

    @Override
    public void save(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(endereco);
        transaction.commit();
        System.out.println("O Endereço " + endereco.toString() + " foi Salvo com Sucesso!");
    }

    @Override
    public void delete(Endereco endereco) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(endereco);
        transaction.commit();
        System.out.println("O Endereço " + endereco.toString() + " foi Removido com Sucesso!");
    }

    @Override
    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public List<Endereco> findAll() {
        return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }

    @Override
    public Endereco findByCep(String cep) {
        try {
            return em.createQuery("SELECT e FROM Endereco e WHERE cep = :c",
                            Endereco.class)
                    .setParameter("c", cep)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
