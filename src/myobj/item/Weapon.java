package myobj.item;

public class Weapon {
	int attack;
	
	// 기본 생성자 잠금
	public Weapon(int attack) {
		this.attack = attack;
	}
	
	public int damage() {
		return attack;
	}
}
