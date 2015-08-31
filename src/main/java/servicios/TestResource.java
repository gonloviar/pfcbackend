/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utilidades.EMF;

/**
 *
 * @author yotas
 */
@Path("/test")
public class TestResource {
    
   private Usuario usuario;
    
    public TestResource() {
        System.out.println("====PASANDO POR EL CONSTRUCTOR DEL SERVICIO TEST======");
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("alejo primer");
        usuario.setEdad("29");
        usuario.setCorreo("eseESs@jotameil.com");
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario vamosjoder(){
        return usuario;
    }
    
    
//    Si el cuerpo del request va vacio, el servidor devuelve un 500 error
//    De todas maneras he de comprobar que los campos obligatorios no sean
//    null, y si lo son devolver el error manualmente, con el error correspondiente
    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String porFinFunciona(Usuario user){
        
        System.out.println("===== ENTRO AL POST otra vez=====");
        usuario= user;
//        
        System.out.println("=========== POST:ANTES DEL USAR EMF ==========");
        EntityManager em= EMF.crearEntityManager();
        System.out.println("============  POST:DESPUES DE USAR EMF ==========");
        
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        
        System.out.println("===== persistete coño =======");
        
        return usuario.toString();
    }
}

