//Finner alle primtall mindre enn N
import java.util.ArrayList;
class SieveOfEratosthenes{
    public static ArrayList<Integer> sieve(int n){
        if(n > Integer.MAX_VALUE-100){
            System.out.println("use sieveL with longvalue");
            return null;
        }
        boolean[] prime = new boolean[n+1];
        for(int i = 0; i <n;i++){
            prime[i] = true;
        }
        for(int p = 2; p*p <= n; p++){
            if(prime[p] == true){
                //Update all multiples of p
                for(int i = p*2; i <= n; i += p){
                    prime[i] = false;
                }
            }
        }
        //return all primes
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(prime[i] == true){
                primes.add(i);
            }
        }
        return primes;
    }

    /*public static ArrayList<Long> sieveL(long n){
        boolean[] prime = new boolean[n];
        for(long i = 0; i <n;i++){
            prime[i] = true;
        }
        //System.out.println(Math.sqrt(n));
        for(long p = 1; p*p <= n; p++){
            if(prime[p-1] == true){
                //Update all multiples of p
                for(long i = p*2; i <= n; i += p){
                    prime[i-1] = false;
                }
            }
        }
        //return all primes
        ArrayList<Long> primes = new ArrayList<>();
        for(long i = 2; i <= n; i++){
            if(prime[i-1] == true){
                primes.add(i);
            }
        }
        return primes;
    }*/

}
