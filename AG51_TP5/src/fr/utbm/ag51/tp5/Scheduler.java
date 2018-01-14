package fr.utbm.ag51.tp5;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Scheduler {
	 TreeMap<Integer,String> ABR;
	
	

	public Scheduler() {
		super();
		ABR =  new TreeMap<Integer,String>();
	}
	public void Init_Scheduler( int n)
	{
		Random r = new Random();
		int a= 0;
		for (int i = 0; i<n;i++)
		{
			String value = "Tache"+a;
			a++;
			ABR.put(r.nextInt(50 - 0 + 1) + 0, value);
		}
		
	}
	public void Add_Task( int n)
	{
			
			String value = "Tache"+(ABR.size()+1);
			ABR.put(n, value);
		
		
	}
	public void Schedule()
	
	{
		boolean a = false;

		a = this.delete_task(ABR.firstKey());
	}
	
	private boolean delete_task(int key)
	
	{
		this.ABR.remove(key);
		return false;
		
	}
	private boolean store_Node(int key, String value)
	{
		this.ABR.put(key, value);
		return false;
		
	}
	public void PrintScheduler()
	{
		System.out.println("Parcours de l'objet TreeMap : ");
	      Set<Entry<Integer, String>> setHm = ABR.entrySet();
	      Iterator<Entry<Integer, String>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Integer, String> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	      
	}

	public TreeMap<Integer, String> getABR() {
		return ABR;
	}

	public void setABR(TreeMap<Integer, String> aBR) {
		ABR = aBR;
	}
	

}
