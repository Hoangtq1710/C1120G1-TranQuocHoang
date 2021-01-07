package session_04.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant() {
        return this.b * this.b - (4 * this.a * this.c);
    }

    public static void main(String[] args) {
        System.out.println("Quadratic Equation");
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        double delta;
        double x1;
        double x2;
        System.out.print("Enter a : ");
        a = scanner.nextDouble();
        System.out.print("Enter b : ");
        b = scanner.nextDouble();
        System.out.print("Enter c : ");
        c = scanner.nextDouble();

        QuadraticEquation qe = new QuadraticEquation(a,b,c);
        delta = qe.getDiscriminant();
        if (delta < 0){
            System.out.println("The equation has no root");
        } else if (delta == 0) {
            System.out.println("The equation has 1 root is : "+Math.floor((-b/(2*a))*100)/100);
        } else {
            x1 = -b + Math.sqrt(delta) / (2*a);
            x1 = Math.floor(x1*100)/100;
            x2 = -b - Math.sqrt(delta) / (2*a);
            x2 = Math.floor(x2*100)/100;
            System.out.println("The equation has 2 roots is : "+x1+" and "+x2);
        }
    }
}