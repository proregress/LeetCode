##### 1、判断字符是字母还是数字：
```
Character.isDigit(Char c) //是否是数字
Character.isLetter(Char c) //是否是字母
```

#### 2、ArrayList重写排序方法：
```
ArrayList<Character> letters = new ArrayList<>();
letters.sort(new Comparator<Character>(){
            public int compare(Character o1, Character o2){
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
```

#### 3、Collections.sort(List) 重写排序方法：


#### 4、
```
  Arrays.sort(char[])  
  Collections.sort(List) 
  list.sort()
  
  List.sort是在Java8中的，直接使用，重写compare()方法
  list.sort(new Comparator<String>(){
    //比较逻辑
  });

  Collections.sort(list) 是在Java8之前常用的，比较对象，需要对象重写compareTo方法
```
