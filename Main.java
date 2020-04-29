import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		ChunLi chunLi = new ChunLi();
		Ryu ryu = new Ryu();
		Rin rin = new Rin();
		Rem rem = new Rem();
		Kirito kirito = new Kirito();
		List<GameCharacter> CharaterList = new ArrayList<>();
		// 將角色加入角色列表
		CharaterList.add(chunLi);
		CharaterList.add(ryu);
		CharaterList.add(rin);
		CharaterList.add(rem);
		CharaterList.add(kirito);
		System.out.println("Choose Player:");
		// 印出選擇的角色
		for(int i = 0;i<5;i++)
			System.out.println((i+1)+". "+CharaterList.get(i).getName());
		System.out.print("Choice: ");
		Scanner sc = new Scanner(System.in);
		// 選擇角色
		int choice = sc.nextInt();
		GameCharacter player = CharaterList.get(choice-1);// 將選擇的角色用player記錄下來,類似指標的感覺
		Random ran = new Random();
		int enemyDice = ran.nextInt(5);// 骰一個敵方角色
		GameCharacter enemy = CharaterList.get(enemyDice);// 將敵方角色用enemy記錄下來,類似指標的感覺
		System.out.println("--------------------------");
		System.out.println("<< "+enemy.getName()+" V.S. "+player.getName()+" >>\n");
		boolean turn = true;// 用來記錄換誰攻擊
		double playerHealth = player.getHealth();
		double enemyHealth = enemy.getHealth();
		while(enemyHealth>0&&playerHealth>0)
		{
			Thread.sleep(ran.nextInt(500)+500);// 這行是停頓用的，不用理我~
			if(turn)
			{// 我方先攻
				int attactDice = ran.nextInt(2);// 這是一個糞game,所以攻擊方式是骰出來的
				switch(attactDice)
				{// 骰到0普通拳,骰到1放CA!
					case 0:
						System.out.println(player.getName()+" use normal punch!");
						enemy.setHealth(enemyHealth-player.normalPunch());
						enemyHealth = enemy.getHealth();
						System.out.println("Enemy HP: "+enemyHealth);
						break;
					case 1:
						System.out.println(player.getName()+" use CA!!!");
						enemy.setHealth(enemyHealth-player.CA());
						enemyHealth = enemy.getHealth();
						System.out.println("Enemy HP: "+enemyHealth);
						break;
					default:
						System.out.print("error");
						break;
				}
			}
			else
			{// 換敵方
				int attactDice = ran.nextInt(2);
				switch(attactDice)
				{// 骰到0普通拳,骰到1放CA!
					case 0:
						System.out.println(enemy.getName()+" use normal punch!");
						player.setHealth(playerHealth-enemy.normalPunch());
						playerHealth = player.getHealth();
						System.out.println("Player HP: "+playerHealth);
						break;
					case 1:
						System.out.println(enemy.getName()+" use CA!!!");
						player.setHealth(playerHealth-enemy.CA());
						playerHealth = player.getHealth();
						System.out.println("Player HP: "+playerHealth);
						break;
					default:
						System.out.print("error");
						break;
				}
			}
			System.out.print('\n');
			System.out.println("--------------------------");
			turn = !turn;
		}
		if(!turn)
			System.out.println("Player "+player.getName()+" Win!");
		else
			System.out.println("Enemy "+enemy.getName()+" Win!");
	}
}
