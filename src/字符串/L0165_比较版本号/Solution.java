package 字符串.L0165_比较版本号;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.max(split1.length, split2.length);
        for (int i = 0; i < len; i++) {
            int i1 = i >= split1.length ? 0 : Integer.valueOf(split1[i]);
            int i2 = i >= split2.length ? 0 : Integer.valueOf(split2[i]);
            if(i1 > i2){
                return 1;
            }else if(i1 < i2){
                return -1;
            }
        }
        return 0;
    }
}
