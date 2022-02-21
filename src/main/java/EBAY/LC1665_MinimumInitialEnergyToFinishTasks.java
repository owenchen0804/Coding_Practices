package EBAY;

// Sort by the difference mininum - actual and then process one by one.

// How to come up with intuition

// Observe the examples.
// The most important thing after receiving a problem is to understand it.
// Here understand means not only reading the text, but also going through the examples.
// One can find the pattern by observing 3 examples that the minimum energy is achieved
// in an order of increasing difference.

// Proof of why sort by difference

// Quick observation: order matters. Just read example 1 again if you're not sure.

// Suppose we are given two tasks, [a, a + c1] and [b, b + c2], where c1 < c2 and a, b are two arbitrary numbers. We have two possible ordering:
// Order 1: [a, a + c1], [b, b + c2]
// Order 2: [b, b + c2], [a, a + c1]

// Order 1 gives a result [a + b, max(a + b + c1, b + c2)], and order 2 [a + b, max(a + b + c2, a + c1)].
// Let m1 = max(a + b+ c1, b + c2), m2 = max(a + b + c2, a + c1). Since the final result depends
// on min(m1, m2), we should arrange in an order that results in a smaller minimum.

// We want to prove that [a, a + c1] should always come first.

// Obviously, a + b + c2 > a + c1 since c2 > c1.

// 证明过程！

//  order 2其实很明显, a + b + c2 永远大于 a + c1，因为c2 > c1，且b > 0 所以m2永远是 a + b + c2

// 对于m1来说，
// If a + b + c1 >= b + c2, we know m1 = a + b + c1 <= a + b + c2 = m2. So [a, a + c1] should come first.
// If a + b + c1 < b + c2, m1 = b + c2 < a + b + c2 = m2. Again, [a, a + c1] should come first.
// This completes the proof for the case c1 < c2. The case c1 > c2 can be proved similarly. The case c1 == c2 is trivial.

// So, in all cases, [a, a + c1] should always come first.

import java.util.Arrays;

public class LC1665_MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        int res = 0;
        Arrays.sort(tasks, (a1, a2) -> (a1[1] - a1[0]) - (a2[1] - a2[0]));
        for (int[] a : tasks) {
            res = Math.max(res + a[0], a[1]);
        }
        return res;
    }
}
