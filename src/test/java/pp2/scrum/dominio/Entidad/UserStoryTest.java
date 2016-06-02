package pp2.scrum.dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.dominio.entidad.CriterioAceptacion;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;


public class UserStoryTest extends TestCase {
	
   UserStory story;
   CriterioAceptacion criterio;
   Tarea tarea1,tarea2;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public UserStoryTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() 
	{
	    return new TestSuite( UserStoryTest.class );
	}
	
	public void  setUp() 
	{
		story = new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null);
		criterio = new CriterioAceptacion("criterio1");
		tarea1 = new Tarea();
		tarea2 = new Tarea();
	}
	
	/**
	 * Verifico que se asignen bien los atributos con el constructor completo
	 */
	public void testStory() 
	{
	   
	   List<CriterioAceptacion> criterios = new ArrayList<CriterioAceptacion>();
	   List<Tarea> tareas = new ArrayList<Tarea>();
	   tareas.add(tarea1);
	   criterios.add(criterio);
	   
	   assertTrue(tarea1.getEstado() == Estado.ToDo);
	   //assertTrue(tarea1.getId() == 0);
	   
	 //tarea.setEstado(Estado.Done);
	   tarea1.avanzarEstado();
	   
	   //tarea1.setId(1);
	   
	   assertTrue(criterio.getDescripcion() == "criterio1");
      assertTrue(criterio.getId() == 0);
      criterio.setDescripcion("d2");
      criterio.setId(1);
	   
		assertTrue(story.getAutor().equals("Autor1"));
		assertTrue(story.getTitulo().equals("Titulo1"));
		assertTrue(story.getDetalle().equals("Detalle1"));
      assertTrue(story.getResponsable().equals("Responsable1"));
      assertTrue(story.getStoryPoints() == 40);
      assertTrue(story.getHorasEstimadas() == 10);
      assertTrue(story.getIteracion() == 1);
      assertTrue(story.getEstado().equals(Estado.ToDo));
      assertTrue(story.getCriterios().size() == 0);
      assertTrue(story.getTareas().size() == 0);
      story.getFechaDone();
      
      story.setAutor("au1");
      story.setCriterios(criterios);
      story.setDetalle("d1");
      story.setEstado(Estado.Doing);
      story.setHorasEstimadas(11);
      story.setIteracion(2);
      story.setResponsable("r1");    
      story.setTareas(tareas);
      story.setTitulo("t1");
      story.setStoryPoints(11);
      story.setFecha(null);

   }
	
	public void testStoryNoTerminada()
	{
	   List<CriterioAceptacion> criterios = new ArrayList<CriterioAceptacion>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      tareas.add(tarea1);
      criterios.add(criterio);
      story.setTareas(tareas);
      story.setCriterios(criterios);
      assertTrue(story.getEstado().equals(Estado.ToDo));
      assertTrue(!story.estaTerminada());
           
	}
	
	public void testStoryTerminadaPorFinalizacionDeTareas()
   {
      List<CriterioAceptacion> criterios = new ArrayList<CriterioAceptacion>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      tareas.add(tarea1);
      tareas.add(tarea2);
      criterios.add(criterio);
      story.setTareas(tareas);
      story.setCriterios(criterios);
      assertTrue(story.getEstado().equals(Estado.ToDo));
      assertTrue(!story.estaTerminada());
      assertTrue(story.getEstado().equals(Estado.ToDo));
      tarea1.avanzarEstado();
      tarea1.avanzarEstado();
      assertTrue(!story.estaTerminada());
      assertEquals(story.getEstado(), Estado.ToDo);
      tarea2.avanzarEstado();
      tarea2.avanzarEstado();
      assertTrue(story.estaTerminada());
      assertEquals(story.getEstado(), Estado.Done);
           
   }
	
	public void testStoryTerminadaPorFinalizacionDeTareasCaso2()
   {
      List<CriterioAceptacion> criterios = new ArrayList<CriterioAceptacion>();
      List<Tarea> tareas = new ArrayList<Tarea>();
      tareas.add(tarea1);
      tareas.add(tarea2);
      criterios.add(criterio);
      story.setTareas(tareas);
      story.setCriterios(criterios);
      assertTrue(story.getEstado().equals(Estado.ToDo));
      assertTrue(!story.estaTerminada());
      assertTrue(story.getEstado().equals(Estado.ToDo));
      tarea2.avanzarEstado();
      tarea2.avanzarEstado();
      assertTrue(!story.estaTerminada());
      assertEquals(story.getEstado(), Estado.ToDo);
      tarea1.avanzarEstado();
      tarea1.avanzarEstado();
      assertTrue(story.estaTerminada());
      assertEquals(story.getEstado(), Estado.Done);
           
   }
		
}