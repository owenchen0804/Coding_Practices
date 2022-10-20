package DIYStructure;

public class LC362_DesignHitCounter {
    //  这道题的特殊性是all the calls are mono increasing
    //  就是说假设现在时间是timestamp = 100了，我并不会去getHits(99)，因为这样就不是顺序时间了
    //  time window = 300，也就是说当time stamp到301的时候，你可以getHits(301)但是不用也不能getHits(1)

    //  所以我们只需要两个int[] size = 300的数组分别记录对应的timestamp and hits就行了，可以通过mod来循环使用

    private int[] times;
    private int[] hits;

    public LC362_DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp) {
        //  循环利用数组，超过300的时候又可以重新cast到0-300的index
        //  比如timestamp = 300的时候 index = 0的位置就从原来的0写成了300了
        //  因为timestamp = 0的已经用不上了，我后面不会需要用到getHist(0)的
        int index = timestamp % 300;

        //  如果发现timestamp取余后得到的同一index居然有值，那么说明那个值是超过300的，过期了
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        }
        //  如果有的话，只是hits[]++
        else {
            hits[index]++;
        }
    }

    public int getHits(int timestamp) {
        //  每次都需要go over整个数组，看看timestamp和每一个times[i]存的那个最早记录的值是否差值小于300
        int total = 0;
        //  每一个times[i]都需要查看，因为你不知道它里面存的有没有差值小于300的
        //  也就是说有可能是times[index]的值已经过期了，但是没有update，所以要go through所有的timestamp[i]来check
        //  过期的就不算在300这个window内了

        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
