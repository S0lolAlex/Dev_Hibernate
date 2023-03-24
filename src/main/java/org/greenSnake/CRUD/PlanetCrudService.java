package org.greenSnake.CRUD;

import org.greenSnake.data.Planet;
import org.greenSnake.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import java.util.List;

public class PlanetCrudService {
    private SessionFactory ssesion = HibernateUtil.getInstance().getSessionFactory();
    public void create(Planet planet){
        try (Session session = ssesion.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
        }
    }

    public String getById(String id) {
        try (Session session = ssesion.openSession()) {
            Planet planet = session.get(Planet.class, id);
            return planet.getName();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
            return "error";
        }
    }

    public void setName(String id, String name) {
        try (Session session = ssesion.openSession()) {
            Planet planet = session.get(Planet.class, id); // 3 is ID of user.
            planet.setName(name);
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(planet);
            transaction.commit();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
        }
    }

    public boolean isDeleteById(String id) {
        try (Session session = ssesion.openSession()) {
            Planet planet = session.get(Planet.class,id);
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
            return true;
        }
        catch(HqlInterpretationException e ) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Planet> listAll() {
        try (Session session = ssesion.openSession()) {
        Query<Planet> planets = session.createQuery("from Planet", Planet.class);
        return planets.list();
        }catch (HqlInterpretationException e){
            e.printStackTrace();
            return null;
        }
    }
}
