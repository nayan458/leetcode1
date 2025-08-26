class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max_dia = 0;
        int max_area = 0;

        for(int[] dimension: dimensions){
            int dia = (int)(Math.pow(dimension[0],2) + Math.pow(dimension[1],2));
            int area = dimension[0] * dimension[1];
            if(dia > max_dia){
                max_dia = dia;
                max_area = area;
            }
            if (dia == max_dia){
                max_area = Math.max(area, max_area);
            }
            System.out.println(dia + " " + area + "Current status: " + max_dia + " " + max_area);
        }
        return max_area;
    }
}