public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            // TODO error out
        }
        this.denominator = denominator;
        simplify();
    }
    public static int gcd(int a,int b){
        if(a>b){
            int temp=a;
            a=b;
            b=temp;
        }
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int n) {
        this.numerator = n;
        simplify();
    }


    public void setDenominator(int d) {
        if (d == 0){
            // TODO error out
            return;
        }
        this.denominator = d;
        this.simplify();
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }


    }

    private void simplify() {
        int a=this.numerator;
        int b=this.denominator;

        int gcd=gcd(a,b);
        this.numerator=(this.numerator/gcd);
        this.denominator=(this.denominator/gcd);
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        f1.numerator=(f1.numerator*f2.denominator);
        f2.numerator=(f2.numerator*f1.denominator);
        f1.denominator=(f1.denominator*f2.denominator);
        f2.denominator=f1.denominator;

        Fraction res=new Fraction((f1.numerator+f2.numerator),f1.denominator);
        res.simplify();
        return res;

    }

    public void add(Fraction f2) {
        this.numerator=this.numerator*f2.denominator+f2.numerator*this.denominator;
        this.denominator=this.denominator* f2.denominator;
        simplify();
    }

    public void multiply(Fraction f2) {
        this.numerator=(this.numerator*f2.numerator);
        this.denominator=(this.denominator*f2.denominator);
        this.simplify();
    }
    public static void main(String[] args){
        Fraction a=new Fraction(55,90);
        Fraction b=new Fraction(86,74);
        System.out.println(a.getNumerator()+" is numerator "+a.getDenominator()+" is denominator");
        System.out.println(b.getNumerator()+" is numerator "+b.getDenominator()+" is denominator");
//        Fraction.add(a,b).print();
        a.add(b);
        System.out.println(a.getNumerator()+" "+a.getDenominator());
    }
}
