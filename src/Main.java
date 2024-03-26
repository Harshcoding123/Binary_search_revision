import java.util.*;
public class Main {
    public static void chocolate_box(int a[]){ //only for two student
        int n= a.length;
        int p[]= new int [n];
        int s[]= new int[n];
        p[0] =a[0];
        for(int i=1;i<n;i++){
            p[i]= a[i]+p[i-1];
        }
        s[n-1]= a[n-1];
        for(int i=n-2;i>=0;i--){
            s[i]= a[i]+s[i+1];
        }
        int min= Integer.MIN_VALUE;int max=0;
        for(int i=0;i<n-1;i++){
            max= Math.max(p[i],s[i+1]);
            if(min<max) min =max;
        }
        System.out.println(min);
    }


    public static boolean find(int a[],int target){
        for(int i=0;i<a.length;i++){  //TC =O(N)
            if(a[i]==target) return true;
        }
        return false;
    }

    public static boolean Itra_binaryFind(int a[],int t){
        int st=0;int end= a.length-1;
        while(st<=end){
            int mid =st+(end-st)/2;
            if(a[mid]==t) return true;
            if(a[mid]>t) end= mid-1;
            else st= mid+1;
        }
        return false;
    }

    public static boolean Rec_binaryFind(int a[],int st,int end,int t){
        if(st>=end) return false;    //TC=O(LogN)
        int mid= st+(end-st)/2;
        if(a[mid]==t) return true;
        if(t<a[mid]) return Rec_binaryFind(a,st,mid-1,t);
        else  return Rec_binaryFind(a,mid+1,end,t);
    }
    public static int  Rec_FirstOccur(int a[],int st,int end,int t,int idx){
//        int idx =0;
        if(st>=end) return idx;
        int mid= st+(end-st)/2;

        if(a[mid]==t){
            idx=mid;

           return Rec_FirstOccur(a,st,mid-1,t,idx);
        }
        if(t<a[mid])
            return Rec_FirstOccur(a,st,mid-1,t,idx);
        else return Rec_FirstOccur(a,mid+1,end,t,idx);
    }
    public static int First_occur(int a[],int t){
        int idx=-1;
        int st= 0;int end= a.length-1;
        while(st<=end){
            int mid =st+(end-st)/2;
            if(a[mid]==t){
                idx =mid;
                end= mid-1;
            }
            if(t<a[mid]) {

                end= mid-1;
            }else{
                st= mid+1;
            }

        }
        return idx;
    }
    public static int Squareroot(int n){
        int st= 0;int end= n;
        int ans=-1;
        while(st<=end){
            int mid= st+(end-st)/2;
            int val= mid*mid;
            if(val==n) {
               return  mid;
            }else if(val<n){
                ans= mid;
                st= mid+1;
            }else {
                end= mid-1;
            }
        }
        return ans;
    }
    public static void rotated_array_min(int a[]){
        int st=0;int end=a.length-1;
        int n= a.length;int idx=0;
        while(st<=end){
            int mid =st+(end-st)/2;
            if(a[mid]<=a[n-1]){
                idx=mid;
                end= mid-1;
            }else{
                st= mid+1;
            }
        }
        System.out.println(idx);


    }
    public static int rotated_array_target(int a[],int t){
        int st=0;int end= a.length-1;int idx=-1;int n =a.length;
        while(st<=end){
            int mid= st+(end-st)/2;
            if(a[mid]==t){
                idx= mid;
                return idx;
            }

            if(a[mid]>a[n-1]){

                if(t>a[mid]) st= mid+1;
                else if(t<a[mid]&&t>a[n-1]){
                    end= mid-1;
                }else if(t<a[mid]&&t<=a[n-1]){
                    st= mid+1;
                }

            }else{

                if(t<a[mid]) end= mid-1;
                else if(t>a[mid]&&t<=a[n-1]) st =mid+1;
                else if(t>a[mid]&&t>a[n-1]) end= mid-1;
            }
        }
        return -1;
    }
    public static boolean array2d_target(int a[][],int n,int m,int t){
        int i=0;int j=m-1;int idx=0;
        while(i<n&&j>=0){
            if(a[i][j]==t){
                return true;
            }
            if(a[i][j]<t) i++;
            else j--;

        }
        return false;
    }
    public static int peakElement(int a[]){
        int st=0;int end=a.length-1;int idx=0;
        while(st<=end){
            int mid= st+(end-st)/2;
            if(( mid-1>=0&&mid+1<a.length&&a[mid]>a[mid-1]&&a[mid]>a[mid+1])||(mid==0)||(mid==a.length-1)) return mid;
            if(mid-1>=0&&a[mid]>a[mid-1]) st= mid+1;
            else if(mid-1>=0&&a[mid]<a[mid-1]) end= mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
       int a[]= {12,34,67,10};
       int a1[][] ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        System.out.println(find(a,133));
//        System.out.println(Rec_binaryFind(a,0,a.length-1,143));
//        System.out.println(Itra_binaryFind(a,133));
//        System.out.println(Rec_FirstOccur(a,0,a.length-1,5,0));
//        System.out.println(First_occur(a,5));
//        System.out.println(Squareroot(11));
//        rotated_array_min(a);
//        System.out.println(rotated_array_target(a,10));
//        System.out.println(array2d_target(a,3,4,300));
//        System.out.println(peakElement(a));
        chocolate_box(a);



    }
}