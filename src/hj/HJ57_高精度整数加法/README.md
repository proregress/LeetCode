#### 将char类型转换为int类型
##### 1. 获取字母d在字母表中的索引index
```
char ch = 'd';
int index = ch - 'a';
```

##### 2. 将char类型的两个数字5和3相加
```
char numChar = '3';  
int  intNum = numChar;  //此时intNum = 51，表示字符‘3’的Ascii码
```
```
//正确方法
char numChar1 = '3';  
char numChar2 = '5';
int sum = (numChar1 - '0') + (numChar2 - '0');
```
