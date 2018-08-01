package Facebook;

/**
 * @Author : Yutong Jin
 * @date : 8/1/18
 * @Description :
 */
public class _278_81 {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int pos = -1;
        while(start <= end){
            int mid = start +(end - start ) /2;
            if(isBadVersion(mid)){
                pos = mid;
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return pos;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
