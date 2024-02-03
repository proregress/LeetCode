### **dp动态规划纲领**：

###1.一般形式：求最值，核心：穷举
举例：最长递增子序列，最小编辑距离


###2. 三要素: 
重叠子问题、最优子结构、状态转移方程
##### 2.1 由于：存在「重叠子问题」，如果暴力穷举的话效率会极其低下，所以需要「备忘录」或者「DP table」来优化穷举过程
##### 2.2 要符合「最优子结构」，子问题间必须互相独立。

###3. 思维框架：
明确「状态」 -> 定义 dp 数组/函数的含义 -> 明确「选择」-> 明确 base case。
##### 3.1 先确定「状态」，也就是原问题和子问题中变化的变量。由于硬币数量无限，所以唯一的状态就是目标金额amount。

##### 3.2 然后确定dp函数的定义：函数 dp(n)表示，当前的目标金额是n，至少需要dp(n)个硬币凑出该金额。

##### 3.3 然后确定「选择」并择优，也就是对于每个状态，可以做出什么选择改变当前状态。具体到这个问题，无论目标金额是多少，选择就是从面额列表coins中选择一个硬币，然后目标金额就会减少。

###4. dp代码框架
    # 备忘录
    memo = dict()
    
    def coinChange(List<int> coins, int amount):
        # 我们要求目标金额是 amount
        return dp(amount)

    # 定义：要凑出金额 n，至少要 dp(n) 个硬币
    def dp(n):
        # 查备忘录，避免重复计算
        if n in memo: return memo[n]
        
        # base case，显然目标金额为 0 时，所需硬币数量为 0；当目标金额小于 0 时，无解，返回 -1
        if n == 0: return 0
        if n < 0: return -1
        
        # 求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE
                
        # 做选择，需要硬币最少的那个结果就是答案
        for coin in coins:
            # 子问题无解，跳过
            if dp(n - coin) == -1: continue
            res = min(res, 1 + dp(n - coin))
        # 记入备忘录
        memo[n] = res if res != float('INF') else -1
        return memo[n]
