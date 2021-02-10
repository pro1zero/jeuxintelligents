import java.util.*;

public class recorder {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
//        int l= scan.nextInt();
//        int k=scan.nextInt();
//        int[] s=new int[l];
//        int[] f=new int[l];
        String[] line1=scan.nextLine().split(" ");
        int l=Integer.parseInt(line1[0]);
        int k=Integer.parseInt(line1[1]);
        int[][] video=new int[l][2];
       for(int i=0;i<l;i++){
           String[] line=scan.nextLine().split(" ");
           int s=Integer.parseInt(line[0]);
           int f=Integer.parseInt(line[1]);
           video[i][0]=s;
           video[i][1]=f;

       }
        Arrays.sort(video, Comparator.comparing(a->a[1]));
       int count=recorder.countNumbers(video,k,l);
       System.out.println(count);

    }
    public static int countNumbers(int[][] video,int k,int l){

        if(k>video.length){
            return video.length;
        }
        int[] recorder_s=new int[k];
        int[] recorder_f=new int[k];
        recorder_s[0]=video[0][0];
        recorder_f[0]=video[0][1];
        int count=1;
        for(int i=1;i<l;i++){
            int mingap=Integer.MAX_VALUE;
            int cur=-1;
            for(int j=0;j<k;j++){
                int tempgap=0;
                if(recorder_f[j]>video[i][0]){
                    tempgap=recorder_f[j]-video[i][0];
                }
                else
                    tempgap=video[i][0]-recorder_f[j];
                if(video[i][0]>=recorder_f[j]&&tempgap<mingap){
                    mingap=tempgap;
                    cur=j;
                }
            }
            if(cur!=-1&&video[i][0]>=recorder_f[cur]){
                recorder_s[cur]=video[i][0];
                recorder_f[cur]=video[i][1];
                count++;
            }
        }
        return count;
    }





}