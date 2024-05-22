package array.L2225_找出输掉零场或一场比赛的玩家;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> loserMap = new HashMap<>();
        HashSet<Integer> winnerSet = new HashSet<>();
        ArrayList<Integer> losers = new ArrayList<>();

        for(int[] match : matches){
            int winner = match[0], loser = match[1];
            loserMap.put(loser, loserMap.getOrDefault(loser, 0) + 1);
            winnerSet.add(winner);
        }

        Set<Integer> loserSet = loserMap.keySet();
        for(int loser : loserSet){
            if(winnerSet.contains(loser)){
                winnerSet.remove(loser);
            }
            if(loserMap.get(loser) == 1){
                losers.add(loser);
            }
        }

        List<Integer> winners = winnerSet.stream().collect(Collectors.toList());
        Collections.sort(losers);
        Collections.sort(winners);
        res.add(winners);
        res.add(losers);

        return res;
    }
}
