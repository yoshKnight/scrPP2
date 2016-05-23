package pp2.scrum.dominio.comando;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

public class MostrarProyectoNuevo implements IComando<HomeController>
{

   public Resultado Execute(HomeController homeController)
   {
      Resultado resultado = new Resultado();
      try 
      {
         homeController.getProyectoNuevo().setVisible(true);
      }
      catch(Exception e)
      {
         resultado.AgregarError("Error", e.getMessage());
      };
      return resultado;
   }

}
