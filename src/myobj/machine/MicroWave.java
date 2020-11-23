package myobj.machine;

public class MicroWave implements Electronics {

	ElectricSource src;
	
	String name;
	int power;	
	
	public MicroWave(String name, int power) {
		this.name = name;
		this.power = power;
	}
	
	@Override
	public void setConnect(ElectricSource src) {
		this.src = src;
	}

	@Override
	public String execute() {
		
		if (src == null) {
			System.out.println("아직 연결된 전력이 없습니다.");
			return null;
		}
		
		cook();
		cook();
		cook();
		cook();
		cook();
		
		return "5번 요리함";
	}

	private void cook() {
		// microwave는 요리할때마다 연결된 전력원의 전력을 소비함
		src.consum(power);
	}
}











