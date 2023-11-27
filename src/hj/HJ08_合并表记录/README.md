[题目](https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201)

##### 1、一些顺序验证： 
- Hashtable.keySet()-降序；
- TreeMap.keySet()-升序;
- HashMap.keySet()-乱序;
- LinkedHashMap.keySet() 原序

##### 2、2种判断map中是否包含key的方法：
  （1）map.put(key,map.getOrDefault(key,0) + value);//用map自带的getOrDefault方法,如果根据key没有值,就用默认的0表示方法的值,如果能根据key找到对应的值,那么直接赋值
  
  （2）containsKey()方法： if(map.containsKey(key))
        
