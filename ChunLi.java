public class ChunLi extends GameCharacter
{
    public ChunLi(){
        super(30000,169,55,"ChunLi");
    }
    @Override
    public double normalPunch () {
    	//ChunLi formula: basic power*weight*1.5
        return weight*basicPower+0.5*height;
    }

    @Override
    public double CA () {
        return weight*basicPower+0.7*height;
    }
    //CA formula : weight*basicPower+0.7*height;
}
