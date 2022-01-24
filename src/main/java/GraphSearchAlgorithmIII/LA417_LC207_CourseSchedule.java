package GraphSearchAlgorithmIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LA417_LC207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            //  每一个course对应1个index(从0开始)
            //  每个ArrayList里面放的是这个course是哪些其他course的pre-req
            graph.add(new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            int x = preq[0], y = preq[1];
            graph.get(y).add(x);
            // get(y)就是把preq对应的course找到，然后加上x，就是y是x的prerequisite
        }
        return topologicalSort(graph);
    }

    private boolean topologicalSort(List<List<Integer>> graph) {
        int numCourses = graph.size();
        //  用来记录最终的顺序
        int[] topologicalOrder = new int[numCourses];
        //  用来表明对应course是几门课的preq, 比如incomingEdges[0] = 2
        //  表示course 0是两门课的preq
        int[] incomingEdges = new int[numCourses];
        // 如何得到incomingEdges的数，就是通过go through每个graph里面的list
        for (int i = 0; i < numCourses; i++) {
            for (int y : graph.get(i)) {
                incomingEdges[y]++; //  对应数字越大说明该课程需要的preq越多
            }
        }
        //  找到preq=0也就是不需要preq的course把它放在排序Order的第一位！
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                // queue.offer(incomingEdges[i]);
                //  错了！这里放的应该是i,对应表示的是那门课！
                queue.offer(i);
            }
        }
        int numExpanded = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topologicalOrder[numExpanded++] = curr;
            //  第一个没有req的course放进来，然后坐标继续右移
            //  放进第一个后，其他的所有的courses对应的incomingEdges value都要先-1
            //  因为前面这个放进去后，其他的preq都减少了1个
            for (int y : graph.get(curr)) {
                if (--incomingEdges[y] == 0) {
                    //  比如本例中的course 1&2，由于course0已经在output了
                    //  它们应该相应-1
                    queue.offer(y);
                }
            }

        }
        return numExpanded == numCourses ? true : false;
    }
}
