import java.util.Random;

public class Hero extends Thread{
	
	String name;
	int HP;
	int minDmg;
	int maxDmg;
	int criticalBonusPercent;
	int criticalChance;
	int attackSpeed;
	Hero target;	
	
	public Hero(String name, int hP, int minDmg, int maxDmg, int criticalBonusPercent, int criticalChance,
			int attackSpeed) {
		super();
		this.name = name;
		HP = hP;
		this.minDmg = minDmg;
		this.maxDmg = maxDmg;
		this.criticalBonusPercent = criticalBonusPercent;
		this.criticalChance = criticalChance;
		this.attackSpeed = attackSpeed;
	}

	@Override
	public void run() {		
		try{
			while(target.HP > 0 && HP > 0){		
				int dmg = calculateHit();
				target.HP -= dmg;
				
				System.out.println(name + " just hit " + target.name +
						" for " + dmg + " dmg");
				
				sleep(1000/attackSpeed);
			}		
			
			if(HP > 0)
				System.out.println(name + " is the winner!");
			else
				System.out.println("I will get you next time!!!!");
			
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			interrupt();
		}
	}
	
	int calculateHit(){
		Random rdm = new Random();
		int dmg = rdm.nextInt(maxDmg - minDmg);
		dmg += minDmg;
		
		int chance = rdm.nextInt(100);
		
		if(chance <= criticalChance)
			dmg *= criticalBonusPercent;
		
		return dmg;
	}
	
	

}
