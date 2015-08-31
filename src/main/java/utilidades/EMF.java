/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author yotas
 */

@WebListener
public class EMF implements ServletContextListener {
    
    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf=Persistence.createEntityManagerFactory("pfc-persistencia");
        System.out.println("============ CREADO EL EMF ================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        emf.close();
    }
    
    public static EntityManager crearEntityManager(){
        if(emf == null){
            throw new IllegalStateException("Contexto no se ha inicializado aun");
        }
        
        System.out.println("============= USANDO EL EMF   vamos====================");
        System.out.println("=========  emf==null :  ");
        System.out.println(emf==null);
        
        EntityManager em= emf.createEntityManager();
        
        System.out.println("====  LINEA ANTES DEL RETURN");
        return em;
    }   
    
    
}
