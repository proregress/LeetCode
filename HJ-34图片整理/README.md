#### Arrays.sort(strArr);
#### 内部将strArr排好序，不返回String，不能直接打印输出
```
System.out.println(Arrays.sort(strArr)); //报错
```
```
String str = Arrays.sort(strArr); //报错
```
```
正确
Arrays.sort(strArr); 
System.out.println(strArr);
```
