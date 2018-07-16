package NewSoftValley;

/**
 * @Author : Yutong Jin
 * @date : 7/13/18
 * @Description :
 */
public class longest_Mountain {
    public int longestMountain(int[] A) {
        boolean ascended= false;
        boolean decended = false;
        int res = 0 ;
        int start = 0;
        for(int i = 0 ; i < A.length - 1 ; i++){
            if(!decended && !ascended && A[i + 1] > A[i]){
                ascended = true;

            }
            else if(!decended && ascended && A[i + 1] < A[i]){
                decended = true;
            }
            else if( !decended && !ascended && A[i + 1] < A[i]){

                start = i + 1;

            }
            else if(decended && ascended && A[i + 1] < A[i]){
                //   res = Math.max(res,i - start + 2);

            }
            else if(!decended && ascended && A[i + 1] > A[i]){


            }
            else if(decended && ascended && A[i + 1] > A[i]){
                res = Math.max(res,i - start + 1);
                start = i ;
                ascended = true;
                decended = false;

            }
            else if(decended && !ascended){

            }
            else if(A[i + 1] == A[i]){
                if(decended && ascended){
                    res = Math.max(res,i - start + 1);
                    start = i + 1;
                    ascended = false;
                    decended = false;
                }
                else {
                    start = i + 1;
                    ascended = false;
                    decended = false;
                }
            }
            System.out.println(A[i] + " " + res + " " + start);
        }
        if(decended && ascended){
            res =  Math.max(res,A.length - start);
        }
        System.out.println(A[A.length - 1] + " " + res);

        return res;
    }
    public static void main(String []args){
        int [] a = new int []{875,884,239,731,723,685};
       System.out.println(new longest_Mountain().longestMountain(a));
    }
}
