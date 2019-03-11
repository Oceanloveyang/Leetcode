// Count the number of prime numbers less than a non-negative number, n.
//
// Example:
//
//
// Input: 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//


// class Solution {
//     public int countPrimes(int n) {
//         int ans=0;
//         if(n<=2){return 0;}
//         for(int i=2;i<n;i++){
//             if(judgePrime(i)){
//                 System.out.println(i);
//                 ans+=1;
//             }
//         }
//         return ans;
//     }
    
//     public boolean judgePrime(int n){
//         boolean res = true;
//         if(n==2){
//             return true;
//         }
//         int i=2;
//         while(i<=n/2){
//            if(n%i==0){
//                return false;
//            }else{
//                i++;
//            } 
//         }
//         return res;
//     }
// }
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
