package j26_스레드;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		LoopThread loopThread1 = new LoopThread("김상현");
		LoopThread loopThread2 = new LoopThread("강대협");
		LoopThread loopThread3 = new LoopThread("손지호");
		LoopThread loopThread4 = new LoopThread("김재영");
		
		loopThread1.setPriority(6);
		loopThread4.setPriority(7);
		System.out.println(loopThread1.getPriority());
		System.out.println(loopThread2.getPriority());
		System.out.println(loopThread3.getPriority());
		System.out.println(loopThread4.getPriority());
		
		loopThread1.start();  // start가 호출되면 LoopThread.run()이 실행된다.
		loopThread2.start();
		loopThread3.start();
		loopThread4.start();
		
		/*
		 * Thread 
		 * 숫자가 클 수록 우선순위가 높음
		 * 
		 */
		
	}

}
