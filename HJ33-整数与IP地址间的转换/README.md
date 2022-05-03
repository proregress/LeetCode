#### 1. int :  10进制与2、8、16进制之间的转换
|  10进制-->其他进制   | 对应的方法,参数：i(原10进制数据）,radix(进制，默认=10)  | 返回值 |
|  ----  | ----  | ----  |
| 10 --> 2进制  | String s = Integer.toBinaryString(int i);  | 一个二进制字符串 |
| 10 --> 8进制  | String s = Integer.toOctalString(int i);  | 一个八进制字符串 |
| 10 --> 16进制  | String s = Integer.toHexString(int i);  | 一个十六进制字符串 |
| 10 --> r进制  | String s = Integer.toString(int i，int radix);  | 一个r进制字符串 |

|  其他进制-->10进制   | 对应的方法,参数：s(原r进制的字符串）,radix(进制)  | 返回值 |
|  ----  | ----  | ----  |
| r进制 --> 10  | Integer i = Integer.parseInt(String s, int radix);  | Integer类型 |
| r进制 --> 10 | int i = Integer.valueOf(String s, int radix);  | int类型 |

#### 2. long :  10进制与2、8、16进制之间的转换
|  10进制-->其他进制   | 对应的方法,参数：l(原10进制数据） | 返回值 |
|  ----  | ----  | ----  |
| 10 --> 2进制  | String s = Long.toBinaryString(long l);  | 一个二进制字符串 |

|  其他进制-->10进制   | 对应的方法,参数：s(原r进制的字符串） | 返回值 |
|  ----  | ----  | ----  |
| 2进制 --> 10  | long l = Long.parseLong(String s, 2); | long类型 |

#### 3.字符串 <--> Integer
#### int --> String: 4种
```
String s = String.valueOf(int i);
String s = Integer.toString(int i);
String s = i + ""; //i为int类型， int+String型就是先将int型的i转为String型然后加上后面的空String
String s = i.toString(); //Integer i = new Integer(int n); i为Integer类型

效率排序：Integer.toString(int i）> String.valueOf(int i) > i+""
```
#### String --> int: 2种
```
int i = Integer.parseInt(String s);

```

#### 4.字符串 <--> Long
```
Long l = Long.valueOf(String s); //返回Long包装类
long l = Long.parseLong(String s); //返回long基本数据类型

String s = String.valueOf(long l);
String s = Long.toString(long);
```

#### 5.新建一个字符串
```
String str = "";
String str = new String();
```

#### 6.str1.split("\\.")
```
String str1 = "10.0.3.193";
String[] arr = str1.split("\\.");
```

