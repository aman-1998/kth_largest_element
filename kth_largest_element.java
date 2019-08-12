import java.util.*;
import java.lang.*;
import java.io.*;

class KLE
{
	int heap_size;
	int max;
	KLE(int i)
	{
		heap_size=i;
	}
	int kth_largest_element(int[] A,int k)
	{
		A=build_heap(A);
		for(int i=1;i<=k;i++)
			A=delete_max(A);
		return max;
	}
	int[] build_heap(int[] A)
	{
		int i;
		for(i=heap_size/2;i>=1;i--)
			A=max_heapify(A,i);
		return A;
	}
	int[] max_heapify(int[] A,int i)
	{
		int l,r,largest,temp;
		l=2*i;
		r=2*i+1;
		if(l<=heap_size && A[l]>A[i])
			largest=l;
		else
			largest=i;
		if(r<=heap_size && A[r]>A[largest])
			largest=r;
		if(largest!=i)
		{
			temp=A[i];
			A[i]=A[largest];
			A[largest]=temp;
			A=max_heapify(A,largest);
		}
		return A;
	}
	int[] delete_max(int[] A)
	{
		max=A[1];
		A[1]=A[heap_size];
		A[heap_size]=max;
		heap_size--;
		A=max_heapify(A,1);
		return A;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;
		System.out.print("Enter no. of elements: ");
		n=in.nextInt();
		int[] A=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			System.out.print("Enter A["+i+"] : ");
			A[i]=in.nextInt();
		}
		System.out.print("\nArray: \n");
		for(int i=1;i<=n;i++)
			System.out.print(A[i]+" ");
		System.out.print("\nEnter the value of k : ");
		int k=in.nextInt();
		KLE x=new KLE(n);
		int m=x.kth_largest_element(A,k);
		System.out.println(k+"th largest element = "+m);
	}
}