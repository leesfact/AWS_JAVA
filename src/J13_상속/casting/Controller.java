package J13_상속.casting;

import java.util.Scanner;

public class Controller {
	
	
	private View view;
	private Scanner sc;
	public Controller(View view) {
		this.view = view;
		sc = new Scanner(System.in);
	}
	
	
	public void run() {
		boolean flag = true;
		String select = null;
		
		while(flag) {
			view.show(); //MainView
			System.out.print("명령 입력: ");
			select = sc.nextLine();
			flag = view.menu(select);
			System.out.println("==============");
			
		}
	}

}
