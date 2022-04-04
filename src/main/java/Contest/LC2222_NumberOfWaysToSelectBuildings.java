package Contest;

public class LC2222_NumberOfWaysToSelectBuildings {
    public long numberOfWays(String s) {
        long ans = 0;
        int len = s.length();

        long totZeros = 0;

        for(int i=0;i<len;i++){
            totZeros += s.charAt(i)=='0'?1:0;
        }

        //  本题的思路在于，如果当前是0的话，前面有多少个1，乘以后面有多少个1，相乘的话
        //  就能构成多少个不同位置组成的"101"
        //  同样的道理applies to 当前是1的情况
        //  但是要注意当前是0的话，到后面的数字时currZero要+1
        //  同样地，当前是1的话，到后面的数字时currOne要+1

        long totOnes = len - totZeros;

        long currZeros = s.charAt(0)=='0'?1:0;
        long currOnes = s.charAt(0)=='1'?1:0;

        for(int i=1;i<len;i++){
            if(s.charAt(i) == '0'){
                ans = ans + (currOnes * (totOnes-currOnes));
                currZeros++;
            }else{
                ans = ans + (currZeros * (totZeros-currZeros));
                currOnes++;
            }
        }
        return ans;
    }
}
