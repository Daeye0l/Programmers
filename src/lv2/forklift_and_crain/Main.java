package lv2.forklift_and_crain;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] storage = new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = new String[] {"A", "BB", "A"};

        System.out.println(sol.solution(storage, requests));
    }
}
