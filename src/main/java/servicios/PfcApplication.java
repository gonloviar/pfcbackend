/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author yotas
 */

@ApplicationPath("/servicios")
public class PfcApplication extends Application
{
   private Set<Object> singletons = new HashSet<Object>();

   public PfcApplication()
   {
       System.out.println("======ENTRANDO A PFCAPLICATION=====");
      singletons.add(new TestResource());
   }

   @Override
   public Set<Object> getSingletons()
   {
      return singletons;
   }
}
