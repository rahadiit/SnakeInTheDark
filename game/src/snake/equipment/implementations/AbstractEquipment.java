package snake.equipment.implementations;


import com.badlogic.gdx.graphics.g2d.Batch;

import snake.equipment.IEquipment;
import snake.map.IMapAccess;
import snake.visuals.enhanced.LightMapEntity;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                                  
 * Classe abstrata diretora de todos os equipamentos concretos
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public abstract class AbstractEquipment extends LightMapEntity implements IEquipment
{
	protected String name;
	protected String description;
	
	// Captar o nome do equipamento
	public String getName()
	{
		return name;
	}
	
	// para pegar uma pequena descrição do equipamento
	public String getDescription()
	{
		return description;
	}
	
	// Para se ativar no mapa o efeito do equipamento
	public abstract void activateOnMap(IMapAccess map);

	// Para se desenhar na tela (ele se chama sozinho)
	public abstract void draw (Batch batch, float parentAlpha);
	
	// Para se atualizar na lógica do jogo
	public abstract void act (float delta);
	
	// Métodos relacionados ao foco de luz (alguns equipments terão eles sobrescritos, outros não - usam esses da classe m�e mesmo -)
	// Se há ou não luz funcionando (just a test)
	@Override
	public boolean hasLights()
	{
		return false;
	}
	// Criação da luz (nunguém chama de fora, ele é um dos métodos que caracterizam o objeto)
	@Override
	public void createLights()
	{
	}
	// Especie de free na luz criada
	@Override
	public void disposeLights()
	{
	}
	
	// dispose dos equipamentos, s� falta o unload que eh sobreposto!
	@Override 
	public void dispose()
	{
		super.dispose();
		
		if(this.getParent() != null || this.getStage() != null)
		{
			this.remove();
		}
	}
	
	@Override
	public String getType() {
		return "equipment";
	}
	public abstract void setOnMap(boolean onMap);
	
	public abstract boolean getOnMap();

}
