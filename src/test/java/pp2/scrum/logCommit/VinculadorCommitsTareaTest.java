package pp2.scrum.logCommit;

import junit.framework.TestCase;
import mockit.Mock;
import mockit.MockUp;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.logCommits.GestorConsultas;
import pp2.scrum.logCommits.InterpreteCommits;
import pp2.scrum.logCommits.VinculadorCommitsTarea;
import pp2.scrum.utils.Lector;

public class VinculadorCommitsTareaTest extends TestCase {

	private MockUp<GestorConsultas> gestorM;
	private Tarea tarea1;
	private Tarea tarea2;
	private Tarea tarea3;
	
    public VinculadorCommitsTareaTest(String name) {
        super(name);
        
    }

    protected void setUp() throws Exception {
        super.setUp();

        tarea1=new Tarea();
        tarea1.setId("1abcdef1");

        tarea2=new Tarea();
        tarea2.setId("2abcdef2");
        
        tarea3=new Tarea();
        tarea3.setId("3abcdef3");
		
        gestorM = new MockUp<GestorConsultas>(){

        	@Mock
        	public Tarea getTarea(String id){
        		if(id.equals("1abcdef1")){
        			return tarea1;
        		} 
        		if(id.equals("2abcdef2")){
        			return tarea2;
        		}
        		if(id.equals("3abcdef3")){
                    return tarea3;
        		} 
        		return null;
        	}
        
        };
    }

    public final void testVinculadorCommitsTarea() {
        String path="src/main/resources/file/ArchivoPrueba.txt";
        Lector lector=new Lector();
    	InterpreteCommits interprete=new InterpreteCommits(lector.leerArchivo(path));
    	System.out.println("Tarea:"+tarea1.getId()+" sin cambios, ¿tiene commits? "+(!tarea1.getCommits().isEmpty())+" estado: "+tarea1.getEstado());
        new VinculadorCommitsTarea(gestorM.getMockInstance(),interprete.getCommits());
    	System.out.println("Tarea:"+tarea1.getId()+" con cambios: commit:"+tarea1.getCommits().get(0)+" estado: "+tarea1.getEstado());
    }

}
