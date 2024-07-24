package dfs.L0022_括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *   2 左括号和右括号的数量一定相等
 *   3 但是数量相等不一定是有效括号比如())()(
 *   4 但是如果先有左括号，才能有右括号+左右数量相等就一定是有效括号
 *   5 上一句话翻译后的具体操作就是如果有一个左括号就可以有一个右括号，有两个左就可以有两个右，但是有两个左不可以有三个右以此类推。
 *   6 上一句话的代码实现方法是记左的个数为left右为right,left/right初始值为n，有：left > 0 可以使用左括号，但是left < right，才可以使用右。left=right=0为结果。
 *
 *
 * @author xufan
 * @since 2024/07/24 10:10
 */
public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }

    public void dfs(int left, int right, String track){
        //左括号和右括号都使用完了，就是正确答案
        if(left == 0 && right == 0){
            result.add(track);
            return;
        }
        //如果左括号还有，就添加一个左括号
        if(left > 0){
            dfs(left-1, right, track + "(");
        }
        //如果剩余的left小于right，才可以使用right，因为括号要想有效一定是先放左后放右的
        if(left < right){
            dfs(left, right-1, track + ")");
        }
    }
}
