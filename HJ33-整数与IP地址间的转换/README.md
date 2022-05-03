0.将十进制整数转换成radix进制数，并以String类型输出
  ```
  String str = Integer.toString（int value，int radix's);
  ```

1.int: 十进制 ---> 二进制
  ```
  String str = Integer.toString(int i, 2);
  ```

2.int: 二进制 --->  十进制
  ```
  String str = Integer.valueOf(String s,2).toString();  //Integer.valueOf()返回Integer整型对象
  ```

4.long: 二进制 ---> 十进制
  ```
  long l = Long.parseLong(String s, 2);
  ```
  
5.long: 十进制 ---> 二进制
  ```
  String str = Long.toBinaryString(long l);
  ```
    
6.新建一个字符串
```
String str = "";
String str = new String();
```
