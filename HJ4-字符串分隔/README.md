[题目](//https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=undefined&tags=&title=)

### 1、思路
  （1）输入字符串大于8时，递归截取前8位输入，直至小于8位时进入循环补0
  
  
  （2）字符串小于8时直接跳到循环补0操作，补满至8位时打印输出
  
  
  （3）正好等于8位或为空字符串时，直接打印输出


### 2、字符串的增加
#### (1) 建立字符缓冲区
  ```StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
     sb.append(str);//字符串缓冲区的加入
     sb.append("0");//使用‘’或“”都可
     String str = sb.toString(); //别忘了toString（）
  ```
#### (2) str = str + "xxx";


### 3、str.substring()
#### - str.substring(i)意为截取从字符索引第i位到末尾的字符串
#### - str.substring(i,j)意为截取索引第i位到第（j-1）位字符串。包含i，不包含j


### 4、判断有无输入用sc.hasNextLine().接收字符串使用sc.nextLine()


### 5、hasNext()和hasNextLine() 
#### - hasNext()方法会判断接下来是否有非空字符.如果有,则返回true,否则返回false
#### - hasNextLine() 方法会根据行匹配模式去判断接下来是否有一行(包括空行),如果有,则返回true,否则返回false
