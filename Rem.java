public class Rem extends GameCharacter{
    public Rem(){
        super(36977,154,44,"Rem");
    }

    @Override
    public double getHealth()
    {
    	return health+(36977-health)*0.1;//add 10% gone health
    }

    @Override
    public double normalPunch () {
        //Rem formula: basic power*weight*3+(36977-health)/2
        return basicPower*weight*3+(36977-health)/2;
    }

    @Override
    public double CA () {
        return basicPower*weight*7+36977-health;
    }
    //CA formula : weight*basicPower*5+36977-health;
}
