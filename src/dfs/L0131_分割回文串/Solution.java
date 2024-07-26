package dfs.L0131_分割回文串;

import java.util.LinkedList;
import java.util.List;

/**
 * 【dfs分割字符子串】
 */
public class Solution {
    List<List<String>> result = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    public List<List<String>> partition(String s){
        dfs(s,0);
        return result;
    }
    public void dfs(String s, int i){
        if(i == s.length()){
            result.add(new LinkedList<>(track));
            return;
        }
        for(int j = i; j < s.length(); j++){
            String str = s.substring(i,j+1);
            if(!isPanlindrom(str)) continue; //判断是否是回文串，如果不是，向后继续加一个字符
            track.add(str);
            dfs(s,j+1);
            track.removeLast();
        }
    }
    public boolean isPanlindrom(String s){
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
