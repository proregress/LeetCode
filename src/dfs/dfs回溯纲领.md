### **dfs / 回溯纲领**：

###1. 解决一个回溯问题，实际上就是一个决策树的遍历过程。
你只需要思考 3 个问题：

(1)**路径**：也就是已经做出的选择。

(2)**选择列表**：也就是你当前可以做的选择。

(3)**结束条件**：也就是到达决策树底层，无法再做选择的条件。

###2. 回溯代码的框架
路径：记录在track中

选择列表：nums 中不存在于 track 的那些元素

结束条件：未定

    List<> result = new LinkedList<>();
    void backtrack(选择列表nums, 路径track){
        if(满足结束条件){
            result.add(路径track)
            return;
        }

        for 选择 in 选择列表nums{
            做选择
            backtrack(选择列表nums, 路径track)
            撤销选择
        }
    }


