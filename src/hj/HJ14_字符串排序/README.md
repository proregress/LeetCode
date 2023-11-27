[题目](https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723)
### 1、此题注意nextInt()、next()、nextLine()的用法，很容易出错

Scanner sc = new Scanner(System.in)

一、next()、nextInt()、nextDouble()、nextFloat()是一类

即一定要读取到有效字符后才可以结束输入，对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，next()方法会自动将其去掉，只有在输入有效字符之后，next()方法才将其后输入的空格键、Tab键或Enter键等视为分隔符或结束符。

简单地说，next()查找并返回来自此扫描器的下一个完整标记。完整标记的前后是与分隔模式匹配的输入信息，所以next方法不能得到带空格的字符串。 

二、nextLine()是另一类。

nextLine()方法的结束符只是Enter键，即nextLine()方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的。

三、鉴于以上两种方法的区别，一定要注意next()类方法和nextLine()方法的连用。

问题：先写nextInt()，再写nextLine()，只能取到next()，nextLine()获取不到值。

原因：nextLine()接受了next()留下的\n。

```
解决方法：

①  在每一个 next()、nextDouble() 、 nextFloat()、nextInt() 等语句之后加一个nextLine()语句，将被next()去掉的Enter结束符过滤掉。

②  将nextInt()与next()搭配使用，因为它们属于同一类。不将nextInt()与nextLine()搭配使用即可避免问题的发生。
```
————————————————
版权声明：本文为CSDN博主「清韵凌波」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_40851797/article/details/98758188

### 2、  int n = sc.nextInt();//nextInt()执行后光标停在读取到的int之后，但本行并未结束，还有换行符没有读取。
#### 两种解决方法，1.使用nextInt之后使用nextLine手动换行。即在第十行后面加上一行：sr.nextLine();
#### 2后面读取数据保持跟nextInt一致，如使用next或其他如nextDouble等。

### 3、数组的排序方法：Arrays.sort()
        
；
