#### 判断字符串中是否包含数字的4种方法
```
// 判断字符串包含数字 方法一
    public static boolean testIsNumMethodOne(String str) {
        boolean flag = false;
        String numStr = "0123456789";
        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(i, i+1);
            if (numStr.contains(subStr)) {
                flag = true;
            }
        }
        return flag;
    }
    
    // 判断字符串包含数字 方法二
    public static boolean testIsNumMethodTwo(String str) {
        boolean flag = false;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            flag = true;
        }
        return flag;
    }
    
    // 判断字符串包含数字 方法三
    public static boolean testIsNumMethodThree(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 48 && c < 57) {
                flag = true;
            }
        }
        return flag;
    }
    
    // 判断字符串包含数字 方法四
    public static boolean testIsNumMethodFour(String str) {
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                flag = true;
            }
        }
        return flag;
    }
```
