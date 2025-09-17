class FoodRatings {
    private Map<String, Integer> foodIndex;
    private Map<String, PriorityQueue<Map.Entry<String, Integer>>> cuisinesfood;
    private int[] ratings;
    private String[] cuisines;
    private Comparator<Map.Entry<String, Integer>> cmp = (a,b) -> {
        if(a.getValue().equals(b.getValue()))
            return a.getKey().compareTo(b.getKey());
        return Integer.compare(b.getValue(),a.getValue());
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodIndex = new HashMap<>();
        this.cuisinesfood = new HashMap<>();
        this.ratings = ratings;
        this.cuisines = cuisines;

        for(int i = 0; i < foods.length; i++){
            this.foodIndex.put(foods[i],i);
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            cuisinesfood
                .computeIfAbsent(cuisine, k -> new PriorityQueue<>(cmp))
                .add(Map.entry(food,rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        int idx_current_food = foodIndex.get(food);
        String cuisine = cuisines[idx_current_food];

        ratings[idx_current_food] = newRating;

        cuisinesfood
            .get(cuisine)
            .add(Map.entry(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Map.Entry<String, Integer>> pq = cuisinesfood.get(cuisine);
        
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> top = pq.peek();
            if(top.getValue().intValue() == getRating(top.getKey()))
                return top.getKey();
            pq.poll();
        }
        return "N/A";
    }

    private int getRating(String food){
        return ratings[foodIndex.get(food)];
    }
}

// class FoodRatings {
//     private Map<String, Integer> foodIndex;
//     private Map<String, String> cuisinesfood;
//     private int[] ratings;
//     private String[] cuisines;

//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         this.foodIndex = new HashMap<>();
//         this.cuisinesfood = new HashMap<>();
//         this.ratings = ratings;
//         this.cuisines = cuisines;

//         for(int i = 0; i < foods.length; i++){
//             this.foodIndex.put(foods[i],i);
//             changeRating(foods[i], ratings[i]);
//         }
//     }
    
//     public void changeRating(String food, int newRating) {
//         int idx_current_food = foodIndex.get(food);
//         ratings[idx_current_food] = newRating;
//         if("N/A".equals(highestRated(cuisines[idx_current_food]))){
//             cuisinesfood.put(cuisines[idx_current_food],food);
//             return;
//         }

//         int highestRating = ratings[foodIndex.get(highestRated(cuisines[idx_current_food]))];
//         String highestRatedFood = highestRated(cuisines[idx_current_food]);
//         if(!food.equals(highestRatedFood)){
//             if(newRating > highestRating)
//                 cuisinesfood.put(cuisines[idx_current_food],food);
//             else if(newRating == highestRating){
//                 if(food.compareTo(highestRatedFood) < 0)
//                     cuisinesfood.put(cuisines[idx_current_food],food);
//                 else
//                     return;
//             }
//         }
//     }
    
//     public String highestRated(String cuisine) {
//         return cuisinesfood.getOrDefault(cuisine,"N/A");
//     }
// }

// /**
//  * Your FoodRatings object will be instantiated and called as such:
//  * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
//  * obj.changeRating(food,newRating);
//  * String param_2 = obj.highestRated(cuisine);
//  */