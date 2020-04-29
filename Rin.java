public class Rin extends GameCharacter{
    public Rin(){
        super(35400,155,42,"Rin Hoshizora");
    }
    
    @Override
    public double getHealth()
    {
    	return health*1.1;//add 10% health
    }

    @Override
    public double normalPunch () {
        //Rin formula: basic power*weight*4+health/20
        return basicPower*weight*4+health/10;
    }

    @Override
    public double CA () {
        return basicPower*weight*8+health/5;
    }
    //CA formula : weight*basicPower*8+health/10;
}
