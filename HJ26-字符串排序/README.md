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
