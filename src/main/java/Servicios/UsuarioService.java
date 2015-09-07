/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servicios;

import Modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utilidades.EMF;

/**
 *
 * @author yotas
 */
@Path("/usuarios")
public class UsuarioService {
    
    public UsuarioService(){
        System.out.println("========== ENTRANDO A USUARIO SERVICE============");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios(){  
        EntityManager em = EMF.crearEntityManager();
        return em.createNamedQuery("Usuario.findAll").getResultList();        
    }
    
    
//    la toma de usuario y contraseña la hago por medio de un formulario,
//    asi que @FormParam me viene de perlas
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response loginUsuario(@FormParam("id")Long id){
        
        System.out.println("=====Entrando usuario login==========");
        
        EntityManager em = EMF.crearEntityManager();  
        Usuario usuario= em.find(Usuario.class, id);
        if( usuario!= null){
            return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
        }else {
            return Response.ok("usuario no existe").build();
        }
        
        
        
    }
    
    public Response crearUsuario(Usuario usuario){
        return null;
    }
    
    public Response updateUsuario(Usuario usuario){
        return null;
    }
    
    public Response borrarUsuario(int idUsuario){
        return null;
    }
    
}
