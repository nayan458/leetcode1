class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int friends = friendships.length;
        Map<Integer, Integer> hm = new HashMap<>();
        Set<Integer> sad_user = new HashSet<>();

        for(int[] friend: friendships){
            if(sad_user.contains(friend[0]) && sad_user.contains(friend[1])) continue;
            boolean happy = happyFriend(languages[friend[0] - 1], languages[friend[1] - 1]);
            if(!happy){
                sad_user.add(friend[0]);
                sad_user.add(friend[1]);
            }
        }

        for(Integer user: sad_user){
            for(int lang: languages[user - 1])
                hm.put(lang, hm.getOrDefault(lang,0)+1);
        }

        int mostSpokenLang = 0;
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            mostSpokenLang = Math.max(mostSpokenLang, e.getValue());
        }

        return sad_user.size() - mostSpokenLang;

        // for(int[] x_know_language: languages){
        //     for(int language: x_know_language){
        //         hm.put(language, hm.getOrDefault(language, 0) + 1);
        //     }
        // }

        // int most_spoken = 0;
        // for(Map.Entry<Integer, Integer> e : hm.entrySet()){
        //     int val = e.getValue();
        //     most_spoken = Math.max(most_spoken, val);
        //     if(most_spoken == friends)
        // }

        // return friends - most_spoken;
    }

    private boolean happyFriend(int[] lang1, int[] lang2){
        for(int elem: lang1){
            for(int elem2: lang2)
                if(elem == elem2) return true;
        }

        return false;
    }
}