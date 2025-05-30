package test0601.sortingAndSearching;

import java.util.*;

public class LocationSorter {
    // 5
    //2 7
    //1 3
    //1 2
    //2 5
    //3 6
    //--
    // 1 2
    //1 3
    //2 5
    //2 7
    //3 6

    static class Location implements Comparable<Location> {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location o) {
            // x가 같으면 y 비교, 아니면 x 비교
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            } else {
                return Integer.compare(this.x, o.x);
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static List<Location> solution(int n, List<Location> locations) {
        Collections.sort(locations);
        return locations;
    }

    static List<Location> solution2(int n, List<Location> locations) {
        locations.sort((a, b) -> {
            if(a.x == b.x) {
                return Integer.compare(a.y, b.y);
            } else {
                return Integer.compare(a.x, b.x);
            }
        });
        return locations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Location> locations = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            locations.add(new Location(x, y));
        }
        System.out.println(solution(n, locations));
    }
}
