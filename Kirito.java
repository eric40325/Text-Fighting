import java.util.Random;

public class Kirito extends GameCharacter{
    public Kirito(){
        super(37000,172,59,"Kirito");
    }

    @Override
    public double getHealth()
    {
    	if(health <= 0)//87% chance lock health when going to die
    	{
    		Random ran = new Random();
    		int lockHealth = ran.nextInt(100);
    		if(lockHealth < 87)
    			return 1.0;
    	}
    	return health;
    }
    
    @Override
    public double normalPunch () {
        // formula: basic power*weight*2+487.63
        return basicPower*weight*2+487.63;
    }

    @Override
    public double CA () {
        return basicPower*weight*6+4876.3;
    }
    //CA formula : weight*basicPower*6+4876.3;
}
