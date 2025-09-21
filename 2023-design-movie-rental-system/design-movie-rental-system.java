import java.util.*;

public class MovieRentingSystem {
    // For each movie: available (unrented) set of (price, shop)
    private Map<Integer, TreeSet<ShopMovie>> unrented;
    // For all rented movies: set of (price, shop, movie)
    private TreeSet<Rented> rented;
    // Price lookup
    private Map<Pair, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        unrented = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();
        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];
            priceMap.put(new Pair(shop, movie), price);

            unrented.computeIfAbsent(movie, k -> new TreeSet<>())
                    .add(new ShopMovie(price, shop));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if (!unrented.containsKey(movie)) return ans;
        Iterator<ShopMovie> it = unrented.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            ShopMovie sm = it.next();
            ans.add(sm.shop);
            count++;
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(new Pair(shop, movie));
        // remove from unrented
        TreeSet<ShopMovie> avSet = unrented.get(movie);
        avSet.remove(new ShopMovie(price, shop));
        // add to rented
        rented.add(new Rented(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(new Pair(shop, movie));
        // remove from rented
        rented.remove(new Rented(price, shop, movie));
        // add back to unrented
        unrented.computeIfAbsent(movie, k -> new TreeSet<>())
                .add(new ShopMovie(price, shop));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<Rented> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Rented r = it.next();
            ans.add(Arrays.asList(r.shop, r.movie));
            count++;
        }
        return ans;
    }

    // Helpers

    private static class ShopMovie implements Comparable<ShopMovie> {
        int price;
        int shop;
        ShopMovie(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }
        @Override
        public int compareTo(ShopMovie o) {
            if (this.price != o.price) return Integer.compare(this.price, o.price);
            return Integer.compare(this.shop, o.shop);
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ShopMovie)) return false;
            ShopMovie o2 = (ShopMovie)o;
            return this.price == o2.price && this.shop == o2.shop;
        }
        @Override
        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }

    private static class Rented implements Comparable<Rented> {
        int price;
        int shop;
        int movie;
        Rented(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
        @Override
        public int compareTo(Rented o) {
            if (this.price != o.price) return Integer.compare(this.price, o.price);
            if (this.shop != o.shop) return Integer.compare(this.shop, o.shop);
            return Integer.compare(this.movie, o.movie);
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Rented)) return false;
            Rented o2 = (Rented)o;
            return this.price == o2.price && this.shop == o2.shop && this.movie == o2.movie;
        }
        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    private static class Pair {
        int shop, movie;
        Pair(int s, int m) { shop = s; movie = m; }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair)o;
            return this.shop == p.shop && this.movie == p.movie;
        }
        @Override
        public int hashCode() {
            return Objects.hash(shop, movie);
        }
    }
}
