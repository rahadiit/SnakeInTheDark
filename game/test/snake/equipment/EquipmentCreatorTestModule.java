package snake.equipment;



/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class EquipmentCreatorTestModule 
{
	// Representação de como usar este componente para criação de equipamentos
	public static void main(String[] args) 
	{
		// instancia do objeto
		IEquipment equip = EquipmentCreator.createFactory("sensor").create(0, 0);
		
		System.out.println("Equipment name: " + equip.getName());
		System.out.println("Equipment description: " + equip.getDescription());
	}
}
