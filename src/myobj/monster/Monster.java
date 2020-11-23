package myobj.monster;

import myobj.item.Gun;
import myobj.item.Sword;
import myobj.item.Weapon;

public class Monster {
	public String name;
	public int hp;
	
	public Monster() {
		name = "연습용 허수아비";
		hp = 99999;
	}
	
	// Weapon타입으로 업캐스팅된 Gun 인스턴스는
	// damage()를 사용할 때 Gun의 damage()를 사용한다
	public void attacked(Weapon weapon) {
		int dmg = weapon.damage();
		hp -= dmg;
		System.out.printf("%s에게 %d의 데미지!\n", name, dmg);
		System.out.printf("%s의 남은 체력 : %d\n", name, hp);
	}
	
	public static void main(String[] args) {
		Sword steel_sword = new Sword(30);
		
		Monster mon = new Monster();
		
		for (int i = 0; i < 10; ++i) {
			steel_sword.upgrade_weapon();
		}
		
		// mon.attacked(steel_sword);
		mon.attacked(steel_sword);
		mon.attacked(new Gun());
		mon.attacked(new Weapon(10));
	}
}














