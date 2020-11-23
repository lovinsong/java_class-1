package myobj.item;

public class Gun extends Weapon {

	int magazine_size;
	
	public Gun() {
		super(50);	
		magazine_size = 100;
	}
	
	@Override
	public int damage() {	
		return attack * magazine_size;
	}
}
