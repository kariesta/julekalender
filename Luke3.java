import java.util.ArrayList;

public class Luke3{
    //Finn alle primtal til og med limit/2^23
    //loop gjennom 2^24 til limit
    //en variabel per plass, hvis for liten øk. bruk modulo primtall.size() for å unngå out of bound.
    //hvis lik øk men også lagre tallet.
    //print size of juletall

    private static ArrayList<Integer> primtall;
    private static ArrayList<Long> juletall;
    //kjør etones sil på tallene o til 2 147 483 647
    //loop gjennom primtallene og finn kombinasjoner på 24 tall som gir tall under 2147483647 og kombinasjoner på 23 som gir tall under dette. (23 primtall * 2 gir tall opp til max)

    ////loop gjennom tall 0 til 2 147 483 647. (dette +1 er halvparten av ønsket sum.)
    public static void main(String[] args) {
        //System.out.println(Long.MAX_VALUE);
        //største primtall i juletall faktorene er limit/2^23. finn prim tall opp til dette tallet.
        //generer juletall utifra disse tallene.
        long limit = 4294967296L;
        double sf = Integer.MAX_VALUE / Math.pow(2,22);
        int storstefaktor = (int) ++sf;
        System.out.println(storstefaktor);
        primtall = SieveOfEratosthenes.sieve(storstefaktor+10);
        System.out.println(primtall.toString());
        juletall = new ArrayList<>();
        juleteller();
        System.out.println(juletall.toString());
        //System.out.println(juletall.size());
    }

    public static void juleteller(){
        for (long i =(long) Math.pow(2,24); i < 4294967296L;i++){
            if(i%(long)50000000L == 0L){
                System.out.println(i);
            }
            if(primfaktorer(i,24)){
                juletall.add(i);
            }
        }
        //bla fra 2^24 til limit
        //for tallet. hvis delelig på primtall.get(i). så del, hvis ikke øk i. hvis, øk teller og sett rest = rest/primtall.get(i)
        //hvis teller == 24 && rest == 1 legg start tall i listen.
    }

    public static boolean primfaktorer(long start, int faktorer){
        long rest = start;
        int index = 0;
        while(faktorer > 0 && rest > 1L && index < primtall.size()){
            if(rest % (long) primtall.get(index) == 0L){
                rest /= (long) primtall.get(index);
                faktorer--;
            } else {
                index++;
            }
        }
        if(faktorer == 0 && rest == 1L){
            return true;
        } else{
            return false;
        }
    }


    /*public static ArrayList<Long> juleteller(ArrayList<Integer> primtallene){
        ArrayList<Long> jt = new ArrayList<>();
        for(int i = 0; i < primtallene.size(); i++){
            long prod = (long) primtallene.get(i);

            for(int j = i; 1+j < primtallene.size(); j++){
                prod *= (long)primtallene.get(j);
                if(prod > 4294967296L){
                    System.out.println(i + " " + j);
                    prod /= (long) primtallene.get(j);
                    break;
                }

                for(int k = j; 2+k < primtallene.size(); k++){
                    prod *= (long) primtallene.get(k);
                    if(prod > 4294967296L){
                        System.out.println(i + " " + j + " " + k);
                        prod /= (long) primtallene.get(k);
                        break;
                    }

                    for(int l = k; 3+l < primtallene.size(); l++){
                        prod *= (long) primtallene.get(l);
                        if(prod > 4294967296L){
                            prod /= (long) primtallene.get(l);
                            break;
                        }

                        for(int m = l; 4+m < primtallene.size(); m++){
                            prod *= (long) primtallene.get(m);
                            if(prod > 4294967296L){
                                prod /= (long) primtallene.get(m);
                                break;
                            }
                            for(int n = m; 5+n < primtallene.size(); n++){
                                prod *= (long) primtallene.get(n);
                                if(prod > 4294967296L){
                                    prod /= (long) primtallene.get(n);
                                    break;
                                }

                                for(int o = n; 6+o < primtallene.size(); o++){
                                    prod *= (long) primtallene.get(o);
                                    if(prod > 4294967296L){
                                        prod /= (long) primtallene.get(o);
                                        break;
                                    }

                                    for(int p = o; 7+p < primtallene.size(); p++){
                                        prod *= (long) primtallene.get(p);
                                        if(prod > 4294967296L){
                                            prod /= (long) primtallene.get(p);
                                            break;
                                        }

                                        for(int q = p; 8+q < primtallene.size(); q++){
                                            prod *= (long) primtallene.get(q);
                                            if(prod > 4294967296L){
                                                prod /= (long) primtallene.get(q);
                                                break;
                                            }

                                            for(int r = q; 9+r < primtallene.size(); r++){
                                                prod *= (long) primtallene.get(r);
                                                if(prod > 4294967296L){
                                                    prod /= (long) primtallene.get(r);
                                                    break;
                                                }

                                                for(int s = r; 1+ s < primtallene.size(); s++){
                                                    prod *= (long) primtallene.get(s);
                                                    if(prod > 4294967296L){
                                                        prod /= (long) primtallene.get(s);
                                                        break;
                                                    }

                                                    for(int t = s; 1+ t < primtallene.size(); t++){
                                                        prod *= (long) primtallene.get(t);
                                                        if(prod > 4294967296L){
                                                            prod /= (long) primtallene.get(t);
                                                            break;
                                                        }

                                                        for(int u = t; 1+ u < primtallene.size(); u++){
                                                            prod *= (long) primtallene.get(u);
                                                            if(prod > 4294967296L){
                                                                prod /= (long) primtallene.get(u);
                                                                break;
                                                            }

                                                            for(int v = u; 1+ v < primtallene.size(); v++){
                                                                prod *= (long) primtallene.get(v);
                                                                if(prod > 4294967296L){
                                                                    prod /= (long) primtallene.get(v);
                                                                    break;
                                                                }

                                                                for(int w = v; 1+ w < primtallene.size(); w++){
                                                                    prod *= (long) primtallene.get(w);
                                                                    if(prod > 4294967296L){
                                                                        prod /= (long) primtallene.get(w);
                                                                        break;
                                                                    }

                                                                    for(int x = w; 1+ x < primtallene.size(); x++){
                                                                        prod *= (long) primtallene.get(x);
                                                                        if(prod > 4294967296L){
                                                                            prod /= (long) primtallene.get(x);
                                                                            break;
                                                                        }

                                                                        for(int y = x; 1+ y < primtallene.size(); y++){
                                                                            prod *= (long) primtallene.get(y);
                                                                            if(prod > 4294967296L){
                                                                                prod /= (long) primtallene.get(y);
                                                                                break;
                                                                            }

                                                                            for(int z = y; 1+ z < primtallene.size(); z++){
                                                                                prod *= (long) primtallene.get(z);
                                                                                if(prod > 4294967296L){
                                                                                    prod /= (long) primtallene.get(z);
                                                                                    break;
                                                                                }

                                                                                for(int a = z; 1+ a < primtallene.size(); a++){
                                                                                    prod *= (long) primtallene.get(a);
                                                                                    if(prod > 4294967296L){
                                                                                        prod /= (long) primtallene.get(a);
                                                                                        break;
                                                                                    }

                                                                                    for(int b = a; 1+ b < primtallene.size(); b++){
                                                                                        prod *= (long) primtallene.get(b);
                                                                                        if(prod > 4294967296L){
                                                                                            prod /= (long) primtallene.get(b);
                                                                                            break;
                                                                                        }

                                                                                        for(int c = b; 2+ c < primtallene.size(); c++){
                                                                                            prod *= (long) primtallene.get(c);
                                                                                            if(prod > 4294967296L){
                                                                                                prod /= (long) primtallene.get(c);
                                                                                                break;
                                                                                            }

                                                                                            for(int d = c; 2+ d < primtallene.size(); d++){
                                                                                                prod *= (long) primtallene.get(d);
                                                                                                if(prod > 4294967296L){
                                                                                                    prod /= (long) primtallene.get(d);
                                                                                                    break;
                                                                                                }

                                                                                                for(int e = d; 2+ e < primtallene.size(); e++){
                                                                                                    prod *= (long) primtallene.get(e);
                                                                                                    if(prod > 4294967296L){
                                                                                                        prod /= (long) primtallene.get(e);
                                                                                                        break;
                                                                                                    }

                                                                                                    for(int f = e; 2+ f < primtallene.size(); f++){
                                                                                                        prod *= (long) primtallene.get(f);
                                                                                                        System.out.println(primtallene.get(i)+"*"+primtallene.get(j)+"*"+primtallene.get(k)+"*"+primtallene.get(l)+"*"+primtallene.get(m)+"*"+primtallene.get(n)+"*"+primtallene.get(o)+"*"+primtallene.get(p)+"*"+primtallene.get(q)+"*"+primtallene.get(r)+"*"+primtallene.get(s)+"*"+primtallene.get(t)+"*"+primtallene.get(u)+"*"+primtallene.get(v)+"*"+primtallene.get(w)+"*"+primtallene.get(x)+"*"+primtallene.get(y)+"*"+primtallene.get(z)+"*"+primtallene.get(a)+"*"+primtallene.get(b)+"*"+primtallene.get(c)+"*"+primtallene.get(d)+"*"+primtallene.get(e)+"*"+primtallene.get(f)+"="+prod);
                                                                                                        System.out.println(prod);
                                                                                                        if(prod < 4294967296L){
                                                                                                            if(!jt.contains(prod)){
                                                                                                                jt.add(prod);
                                                                                                                //System.out.println(primtallene.get(i)+"*"+primtallene.get(j)+"*"+primtallene.get(k)+"*"+primtallene.get(l)+"*"+primtallene.get(m)+"*"+primtallene.get(n)+"*"+primtallene.get(o)+"*"+primtallene.get(p)+"*"+primtallene.get(q)+"*"+primtallene.get(r)+"*"+primtallene.get(s)+"*"+primtallene.get(t)+"*"+primtallene.get(u)+"*"+primtallene.get(v)+"*"+primtallene.get(w)+"*"+primtallene.get(x)+"*"+primtallene.get(y)+"*"+primtallene.get(z)+"*"+primtallene.get(a)+"*"+primtallene.get(b)+"*"+primtallene.get(c)+"*"+primtallene.get(d)+"*"+primtallene.get(e)+"*"+primtallene.get(f)+"="+prod);
                                                                                                            }
                                                                                                        } else{
                                                                                                            prod /= (long) primtallene.get(f);
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    prod /= (long) primtallene.get(e);
                                                                                                }
                                                                                                prod /= (long) primtallene.get(d);
                                                                                            }
                                                                                            prod /= (long) primtallene.get(c);
                                                                                        }
                                                                                        prod /= (long) primtallene.get(b);
                                                                                    }
                                                                                    prod /= (long) primtallene.get(a);
                                                                                }
                                                                                prod /= (long) primtallene.get(z);
                                                                            }
                                                                            prod /= (long) primtallene.get(y);
                                                                        }
                                                                        prod /= (long) primtallene.get(x);
                                                                    }
                                                                    prod /= (long) primtallene.get(w);
                                                                }
                                                                prod /= (long) primtallene.get(v);
                                                            }
                                                            prod /= (long) primtallene.get(u);
                                                        }
                                                        prod /= (long) primtallene.get(t);
                                                    }
                                                    prod /= (long) primtallene.get(s);
                                                }
                                                prod /= (long) primtallene.get(r);
                                            }
                                            prod /= (long) primtallene.get(q);
                                        }
                                        prod /= (long) primtallene.get(p);
                                    }
                                    prod /= (long) primtallene.get(o);
                                }
                                prod /= (long) primtallene.get(n);
                            }
                            prod /= (long) primtallene.get(m);
                        }
                        prod /= (long) primtallene.get(l);
                    }
                    prod /= (long) primtallene.get(k);
                }
                prod /= (long) primtallene.get(j);
            }
            prod /= (long) primtallene.get(i);
        }
        return jt;
    }

    public static ArrayList<Long> juleteller2(ArrayList<Integer> primtallene){
        ArrayList<Long> jt = new ArrayList<>();

        for(long i = Math.pow(2,24); i<4294967296L;i++){
            if(juletull(i)){
                jt.add(i);
            }
        }
        return jt;
    }

    public static boolean juletull(long tallet){
        int runde = 0;
        while(runde<24){
            for(int i = 0; i<primtall.size(); i++){
                if((tallet/(long)primtall.get(i))%1 == 0){
                    runde++;
                    tallet /= (long) primtall.get(i);
                }
            }
        }
    }/**/
}
