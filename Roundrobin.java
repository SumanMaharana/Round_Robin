import java.util.Scanner;
class Roundrobin
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,TQ,ct=0,temp,tbt=0;
		System.out.println("Enter Number of Process ::");
		n=sc.nextInt();
		System.out.println("Enter Time Quantum::");
		TQ=sc.nextInt();
		int PT[]=new int[n];
		int AT[]=new int[n];
		int BT[]=new int[n];
		int TBT[]=new int[n];
		int RT[]=new int[n];
		int CT[]=new int[n];
		int TAT[]=new int[n];
		int WT[]=new int[n];
		boolean done[]=new boolean[n];
		for(int i=0;i<n;i++)
		{
			PT[i]=i+1;
		}
		System.out.println("Enter Arrival Time of Process ::");
		for(int i=0;i<n;i++)
		{
			AT[i]=sc.nextInt();
		}
		System.out.println("Enter Burst Time of Process ::");
		for(int i=0;i<n;i++)
		{
			BT[i]=sc.nextInt();
			TBT[i]=BT[i];
			tbt+=BT[i];
		}
		System.out.println("sort  Process ::");
		for (int i = 0; i < n-1; i++)
        {
            int min_idx=i;
            for (int j=i+1;j<n;j++)
                if (AT[j]<AT[min_idx])
                    min_idx=j;
            temp=AT[min_idx];
            AT[min_idx]=AT[i];
            AT[i]=temp;
			temp=0;
			temp=BT[min_idx];
            BT[min_idx]=BT[i];
            BT[i]=temp;
			temp=0;
			temp=TBT[min_idx];
            TBT[min_idx]=TBT[i];
            TBT[i]=temp;
			temp=0;
			temp=PT[min_idx];
            PT[min_idx]=PT[i];
            PT[i]=temp;
			temp=0;
        }
		while(ct!=tbt)
		{
			for(int i=0;i<n;i++)
			{
				if (!done[i])
				{
					RT[i]=BT[i]-TQ;
					if (RT[i]<0)
					{
						ct+=BT[i];
						RT[i]=0;
						CT[i]=ct;
						done[i]=true;
					}
					else if (RT[i]>0)
					{
						ct+=BT[i]-RT[i];
					}
					else if(RT[i]==0)
					{
						ct+=BT[i];
						CT[i]=ct;
						done[i]=true;
					}
					BT[i]=RT[i];
				}
			}
		}
		System.out.println(" : :Turn Around Time for process : : ");
		for (int i=0;i<n;i++)
		{
			TAT[i]=CT[i]-AT[i];
			System.out.println("process"+PT[i]+" = "+TAT[i]);
		}
		System.out.println(" : :Waiting Time for process : : ");
		for (int i=0;i<n;i++)
		{
			WT[i]=TAT[i]-TBT[i];
			System.out.println("process"+PT[i]+" = "+WT[i]);
		}
	}
}