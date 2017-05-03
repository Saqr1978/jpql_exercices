/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author formation
 */
public class JPQLTest {
    
//    @Test
//    public void req2(){
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = factory.createEntityManager();
        
//        Query query = em.createQuery("SELECT f FROM Film f WHERE f.id=4");
//        Query query = em.createQuery("SELECT MIN(f.annee) FROM Film f");
//        Film film = (Film) query.getSingleResult();
//        System.out.println("***" + film.getTitre());
//        long nbFilms = (long) query.getSingleResult();
//        Query query = em.createQuery(""
//                +"SELECT COUNT(l) "
//                +"FROM Lien l "
//                +"  JOIN l.film f "
//                +"WHERE f.titre='Big Lebowski'");
//        Query query = em.createQuery("SELECT COUNT(f) FROM Film f JOIN f.realisateurs r WHERE r.nom='Polanski'");
//        int anneemini = (int) query.getSingleResult();
//        System.out.println("***" + nbFilms);
//        long n = (long) query.getSingleResult();
//        long nbPol = (long) query.getSingleResult();
        
//        Assert.assertEquals(1968, n);
//        System.out.println("***"+ anneemini);
//        Query query = em.createQuery("SELECT COUNT(f) FROM Film f JOIN f.acteurs a WHERE a.nom='Polanski'");
//        long nbActPol = (long) query.getSingleResult();
//        System.out.println("Le nombre de films interprété par Polanski est "+nbActPol);
//        Query query = em.createQuery("SELECT Film f JOIN f.realisateurs r "
//                                    +"JOIN f.pays p "
//                                    +"JOIN f.genre g "
//                                    +"WHERE r.nom='Polanski' "
//                                    +"AND p.nom='UK' "
//                                    +"AND g.nom='Horreur'");
//        String nomAngPolHor = (String) query.getSingleResult();
//        System.out.println("Le nombre de films interprété par Polanski est "+nomAngPolHor);
//        
//        Assert.assertEquals("Le bal des vampires", nomAngPolHor);
//        
//    }
    @Test
    public void req10(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.realisateurs r WHERE r.nom='Coen'");
        long nbCoen = (long) query.getSingleResult();
        System.out.println("Le nombre de films réalisés par les frères Coen est "+nbCoen);
        
        
    }
    
    @Test
    public void req11(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.realisateurs r JOIN f.acteurs a WHERE r.nom='Coen' AND a.nom='Buscemi'");
        long nbCoenBusc = (long) query.getSingleResult();
        System.out.println("Le nombre de films réalisés par les frères Coen et interprété par Steve Buscemi est "+nbCoenBusc);
        
        
    }
    
    @Test
    public void req12(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.realisateurs r JOIN f.genre g JOIN f.acteurs a WHERE r.prenom='Ethan' AND a.nom='Buscemi' AND g.nom='Policier' INTERSECT SELECT COUNT (f) FROM Film f JOIN f.realisateurs r JOIN f.acteurs a JOIN f.genre g WHERE r.prenom='Joel' AND a.nom='Buscemi' AND g.nom='Policier'");
        long nbCoenBuscPol = (long) query.getSingleResult();
        System.out.println("Le nombre de films policiers réalisés par les frères Coen et interprété par Steve Buscemi est "+nbCoenBuscPol);
        
        
    }
    @Test
    public void req13(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (sa) FROM Serie s JOIN s.saisons sa WHERE s.titre='Dexter'");
        long saDext = (long) query.getSingleResult();
        System.out.println("Le nombre de saisons de la série Dexter est "+saDext);
        
        
    }
    
    @Test
    public void req14(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (ep) FROM Serie s JOIN s.saisons sa JOIN sa.episodes ep WHERE s.titre='Dexter' AND sa.numSaison='8'");
        long saDext = (long) query.getSingleResult();
        System.out.println("Le nombre d'épisode de la saison 8 série Dexter est "+saDext);
        
        
    }
    @Test
    public void req15(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (ep) FROM Serie s JOIN s.saisons sa JOIN sa.episodes ep WHERE s.titre='Dexter'");
        long saDext = (long) query.getSingleResult();
        System.out.println("Le nombre d'épisode de la série Dexter est "+saDext);
        
        
    }
    
    @Test
    public void req16(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (l) FROM Film f JOIN f.genre g JOIN f.pays p JOIN f.liens l WHERE g.nom='Policier' AND p.nom='USA'");
        long saDext = (long) query.getSingleResult();
        System.out.println("Le nombre de films policiers américains est "+saDext);
        
        
    }
    
    @Test
    public void req17(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (l) FROM Film f JOIN f.genre g JOIN f.acteurs a JOIN f.liens l WHERE g.nom='Horreur' AND a.nom='Polanski'");
        long nbHorActPol = (long) query.getSingleResult();
        System.out.println("Le nombre de films d'horreur joués par Polanski est "+nbHorActPol);
        
        
    }
    @Test
    public void req18(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.genre g JOIN f.acteurs a  WHERE g.nom='Horreur' EXCEPT SELECT COUNT (f) FROM Film f JOIN f.acteurs a WHERE a.nom='Polanski'");
        long nbHorMinPol = (long) query.getSingleResult();
        System.out.println("Le nombre de films d'horreur sauf ceux joués par Polanski est "+nbHorMinPol);
        
        
    }
    @Test
    public void req19(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.acteurs a WHERE a.nom='Polanski' EXCEPT SELECT COUNT (f) FROM Film f JOIN f.acteurs a WHERE a.nom!='Polanski'");
        long nbFilmSansPol = (long) query.getSingleResult();
        System.out.println("Le nombre de films joués par Polanski seulement est "+nbFilmSansPol);
        
        
    }
    
    @Test
    public void req20(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.acteurs a WHERE a.nom='Polanski' UNION SELECT COUNT (f) FROM Film f JOIN f.genre g WHERE g.nom='Horreur'");
        long nbFilmHorAndPol = (long) query.getSingleResult();
        System.out.println("Le nombre de films d'horreur et ceux joués par Polanski est "+nbFilmHorAndPol);
        
        
    }
    @Test
    public void req21(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT COUNT (f) FROM Film f JOIN f.genre g GROUP BY g");
        long nbFilmParGenre = (long) query.getSingleResult();
        System.out.println("Le nombre de films d'horreur et ceux joués par Polanski est "+nbFilmParGenre);
        
        
    }
    
}
