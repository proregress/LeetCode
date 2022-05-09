### 对map进行排序 
#### 1.不重写排序方法 
```
int i = 0;
while(max > 0){
    for(char c : map.keySet()){  //以alisia为例，map中存的是 a:2, l:1, i:2, s:1,max=2
        if(map.get(c) == max){
            result = result + max * (26 - i);
            i++;
        }
    }
    max--;
}
```
#### 2.重写排序方法
```
//把map放进ArrayList中
ArrayList<Map.Entry> list = new ArrayList<>(map.entrySet());
//Override 按照value值的从大到小排序
Collections.sort(list,new Comparator<Map.Entry>(){
  @Override
  public int compare(Map.Entry o1, Map.Entry o2){
      return (int)(o2.getValue()) - (int)(o1.getValue());  //需转成int，否则报错：error: bad operand types for binary operator '-'。。o2.getValue()返回的是Object类型
  }
});
```
