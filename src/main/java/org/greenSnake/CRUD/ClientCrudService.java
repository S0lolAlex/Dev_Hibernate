package org.greenSnake.CRUD;

import org.greenSnake.data.Client;
import org.greenSnake.Utils.HibernateUtil;
import org.greenSnake.data.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import java.util.List;

public class ClientCrudService {
    private SessionFactory ssesion = HibernateUtil.getInstance().getSessionFactory();

    public void create(Client client) {
        try (Session session = ssesion.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
        }
    }

    public String getById(long id) {
        try (Session session = ssesion.openSession()) {
            Client client = session.get(Client.class, id);
            return client.getName();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
            return "error";
        }
    }

    public void setName(long id, String name) {
        try (Session session = ssesion.openSession()) {
            Client client = session.get(Client.class, id);
            client.setName(name);
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
        }
    }

    public boolean isDeleteById(long id) {
        try (Session session = ssesion.openSession()) {
            Client client = session.get(Client.class, id);
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
            return true;
        } catch (HqlInterpretationException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Client> listAll() {
        try (Session session = ssesion.openSession()) {
            Query<Client> clients = session.createQuery("from Client", Client.class);
            return clients.list();
        } catch (HqlInterpretationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
