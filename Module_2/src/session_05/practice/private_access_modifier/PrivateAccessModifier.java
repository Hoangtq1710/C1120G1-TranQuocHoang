package session_05.practice.private_access_modifier;

public class PrivateAccessModifier {
    public static class A{

        public void msg(){System.out.println("Hello");}

    }


}
class B{

    public static void main(String args[]){

        PrivateAccessModifier.A obj = new PrivateAccessModifier.A();

        obj.msg();

    }

}