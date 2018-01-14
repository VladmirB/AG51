package fr.utbm.ag51.tp5;

import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scheduler s = new Scheduler();
		int t = 5;
		s.Init_Scheduler(t);
		
		long debut1 = System.nanoTime();
		s.Add_Task(52);
		
		int t1 =  (int) ((int) System.nanoTime()-debut1);
		long debut2 = System.nanoTime();
		s.Schedule();
		int t2 =  (int) ((int) System.nanoTime()-debut2);
		
		System.out.println("Done");
		
		// Part 1  discrimination de la tache gourmande en temps d'execution

	}

}
