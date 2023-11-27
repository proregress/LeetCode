### char-String相互转化
1. String s = String.valueOf('c');   //效率最高
2. String s = String.valueOf(new char[]{'c'}):  //将一个char数组转换成String
3. String s = Character.toString('c'); //Character.toString(char)方法实际上直接返回String.valueOf(char)
4. String s = new Character('c').toString();
5. String s = "" + 'c'; //效率最低。字符串直接相加实际调用了如下方法：new StringBuilder().append("").append('c').toString();
6. String s = new String(new Char[]{'c'});
7. char[] a = String.toCharArray(); // 转换成char数组
8. char a = String.charAt(index); 
