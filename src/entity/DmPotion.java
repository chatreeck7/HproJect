package entity;

import entity.base.Interactable;
import scene.controller.GameSceneController;

public class DmPotion extends Item implements Interactable {

	public DmPotion() {
		// TODO Auto-generated constructor stub
	}

	public DmPotion(String name, int Label) {
		super("dmPotion", 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interact(char side) {
		// TODO Auto-generated method stub
		if(side == 'l') {
			GameSceneController.setCountPlayer1(GameSceneController.getCountPlayer1()+10);
			GameSceneController.updateCount(GameSceneController.getCountPlayer1(), GameSceneController.getCountPlayer2());
			return true;
		}else  if(side == 'r') {
			GameSceneController.setCountPlayer2(GameSceneController.getCountPlayer2()+10);
			GameSceneController.updateCount(GameSceneController.getCountPlayer1(), GameSceneController.getCountPlayer2());
			return true;
		}
		
		return false;
	}

}