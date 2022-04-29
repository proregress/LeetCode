[题目](https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68)

###### 查了一些method

#### 思路：
1.用sc.next()或sc.nextInt()得到这4个关键词：n、n个单词、目标单词targetWord、k  

2.将n个单词放进数组中  

3.遍历存放了n个单词的数组，每个单词与targetWord相比较，长度不一致或两个单词相同时直接跳过（注：判断相同用.equals())  

4.其他单词和targetWord，用.toCharArray()转换成char[]数组，并用Arrays.sort(char[]) 进行升序排列  

5.比较两个升序排列后的char[]数组是否相同，用new String(sCharArr).equals(new String(targetCharArr))) （注意此处！ 还可以用Arrays.equals(sCharArr,targetCharArr)）  

6.相同则将这个单词使用add()方法加入到List中（建立List：List<String> broWordList = new ArrayList<>();  
  
7.全部加入后返回List.size()  
  
8.用Collections.sort(List)将List升序排列  
  
9.判断是否能取到k，能的话直接输出  

#### 注意：
```
  Arrays.sort(char[])  
  Collections.sort(List) 
  ```
  
  ```
  建立List：  List<String> broWordList = new ArrayList<>();
  建立Array： String[] arr = new String[n]；
  ```
  
  ```
  将String s转换成char[]数组：.toCharArray()
  String s = "someword";
  char[] sCharArr = s.toCharArray();
  ```
  
  ```
  比较两个升序排列后的char[]数组是否相同:
  new String(sCharArr).equals(new String(targetCharArr))) 
  或
  Arrays.equals(sCharArr,targetCharArr)）  
  ```
  
  
  
