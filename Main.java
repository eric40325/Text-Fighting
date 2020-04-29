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
		// �N����[�J����C��
		CharaterList.add(chunLi);
		CharaterList.add(ryu);
		CharaterList.add(rin);
		CharaterList.add(rem);
		CharaterList.add(kirito);
		System.out.println("Choose Player:");
		// �L�X��ܪ�����
		for(int i = 0;i<5;i++)
			System.out.println((i+1)+". "+CharaterList.get(i).getName());
		System.out.print("Choice: ");
		Scanner sc = new Scanner(System.in);
		// ��ܨ���
		int choice = sc.nextInt();
		GameCharacter player = CharaterList.get(choice-1);// �N��ܪ������player�O���U��,�������Ъ��Pı
		Random ran = new Random();
		int enemyDice = ran.nextInt(5);// ��@�ӼĤ訤��
		GameCharacter enemy = CharaterList.get(enemyDice);// �N�Ĥ訤���enemy�O���U��,�������Ъ��Pı
		System.out.println("--------------------------");
		System.out.println("<< "+enemy.getName()+" V.S. "+player.getName()+" >>\n");
		boolean turn = true;// �ΨӰO�����֧���
		double playerHealth = player.getHealth();
		double enemyHealth = enemy.getHealth();
		while(enemyHealth>0&&playerHealth>0)
		{
			Thread.sleep(ran.nextInt(500)+500);// �o��O���y�Ϊ��A���βz��~
			if(turn)
			{// �ڤ����
				int attactDice = ran.nextInt(2);// �o�O�@���Tgame,�ҥH�����覡�O��X�Ӫ�
				switch(attactDice)
				{// ���0���q��,���1��CA!
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
			{// ���Ĥ�
				int attactDice = ran.nextInt(2);
				switch(attactDice)
				{// ���0���q��,���1��CA!
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
