#### 1. replace() 与 replaceAll()
#### - replaceAll用的是正则，replace用的是字符，二者都能替换**所有**匹配的字符
##### （1）String replace(char oldChar, char newChar)
  返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
##### （2）String replaceAll(String regex, String replacement)
  使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
```
String str = "hello.hello.hello";
System.out.println(str.replace(".","#"));       //hello#hello#hello
System.out.println(str.replaceAll(".","#"));    //#################
System.out.println(str.replaceAll("\\.","#"));  //hello#hello#hello
```

#### 2.匹配非字母的字符进行分割
##### (1)我的思路：将非字母字符全部替换成空格，再用空格分隔
##### (2)其他：正则表达式[^a-zA-Z]分割：String[] words = str.split("[^A-Za-z]");
