import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1])
        );

        // Busy servers: [freeTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] result = new int[m];
        long time = 0;

        for (int i = 0; i < m; i++) {
            time = Math.max(time, (long) i);

            // Release servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                available.offer(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            // If all servers are busy, jump to earliest free time
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    available.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            // Assign task to the best available server
            int[] server = available.poll();

            result[i] = server[1];

            busy.offer(new long[]{
                time + tasks[i],
                server[0],
                server[1]
            });
        }

        return result;
    }
}