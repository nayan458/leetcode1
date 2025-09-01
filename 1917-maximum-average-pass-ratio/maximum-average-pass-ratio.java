class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> heap = new PriorityQueue<>(
            (a,b) -> Double.compare(b[2],a[2])
        );
        double maxAverage = 0;
        int n = classes.length;
        
        for(int[] classInClasses: classes){
            double pass = classInClasses[0], totalStudent = classInClasses[1];
            double ratioDifference = ((pass + 1)/(totalStudent + 1)) - (pass/totalStudent);
            heap.add(new double[]{pass, totalStudent, ratioDifference});
        }

        while(extraStudents > 0){
            double[] updatedClass =  heap.poll();
            double pass = updatedClass[0] + 1, totalStudent = updatedClass[1] + 1;
            double newRatioDifference = ((pass + 1)/(totalStudent + 1)) - (pass/totalStudent);
            heap.add(new double[]{pass, totalStudent, newRatioDifference});
            extraStudents--;
        }

        while(!heap.isEmpty()){
            double[] classInClasses = heap.poll();
            double ratio = (classInClasses[0]/classInClasses[1]);
            maxAverage += ratio;
        }
        
        return maxAverage/n;
    }
}