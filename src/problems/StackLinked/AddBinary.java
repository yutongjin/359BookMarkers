package StackLinked;

public class AddBinary {

        public String addBinary(String a, String b) {
            char[] res = new char[Math.max(a.length(),b.length())+1];
            int count = 0;
            int p1 = a.length()-1;
            int p2 = b.length()-1;
            int p = res.length-1;
            while (p1 >= 0 || p2 >= 0)
            {

                if(p1 >= 0)
                { count += (a.charAt(p1) - '0');
                  p1--;
                    // digit+=(a.charAt(p1)-'0');
                    System.out.println(count);
                }
                if(p2 >= 0){
                    count =count+(b.charAt(p2) - '0');
                     p2--;
                    System.out.println(count);
                    //digit+=(b.charAt(p2)-'0');
                }
                res[p] = (char)((count%2) + '0');
                System.out.println(res[p]);
                count = count/2;
                p--;
                System.out.println(count);
            }

            if(count == 1) {
                res[0] = '1';
            return String.valueOf(res,0,res.length);
            }
            else return String.valueOf(res,1,res.length-1);
        }

}
