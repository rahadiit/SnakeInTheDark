package snake.player;

import snake.equipment.EquipmentCreator;
import snake.equipment.IEquipment;
import snake.map.IMapAccess;

import java.util.ArrayList;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 *
 * 
 * @author Guilherme Higa & Agustina 
 */

public class Inventory {
	
	private IEquipment equipamentos[] = new IEquipment[3];
	private int qtdequipamentos[] = new int[3];
	
	public void addItem(IEquipment item){
		
		switch(item.getName().toLowerCase()){
		
		case "flashlight":
			if(equipamentos[0]==null)
				equipamentos[0] = item;
			qtdequipamentos[0]++;
			//System.out.println("lanterna");
		
		case "emp":
			if(equipamentos[1]==null)
				equipamentos[1] = item;
			qtdequipamentos[1]++;
			
		case "sensor":
			if(equipamentos[2]==null)
				equipamentos[2] = item;
			qtdequipamentos[2]++;					
		}
	}
	
	public void useItem(int item, IMapAccess access, float x, float y){
		if(qtdequipamentos[item]>0){
			equipamentos[item].activateOnMap(access);
			qtdequipamentos[item]--;
			if(qtdequipamentos[item]>0){
				switch(item){
					case 0:
						equipamentos[item] = EquipmentCreator.createFactory("flashlight").create(x, y, false, access);
						//System.out.println("lanterna");
						break;
					case 1:
						equipamentos[item] = EquipmentCreator.createFactory("emp").create(x, y, false, access);
						//System.out.println("emp");
						break;
					case 2:
						equipamentos[item] = EquipmentCreator.createFactory("trap").create(x, y, false, access);						
						//System.out.println("trap");
						break;
				}
			}			
		}
	}
}

