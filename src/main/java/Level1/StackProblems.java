package Level1;

import java.util.Stack;

public class StackProblems {

    public static int predecence(char optr){
        if(optr == '+' || optr == '-'){
            return 1;
        }else if(optr == '*' || optr == '/'){
            return 2;
        }
        return -1;
    }

    public static int operation(int v1, int v2, char optor){
        if(optor == '+'){
            return v1+v2;
        }else if(optor == '-'){
            return v1-v2;
        }else if(optor == '*'){
            return v1*v2;
        }else if(optor == '/'){
            return v1/v2;
        }
        return 0;
    }

    public static void solveInfix(String exp){

        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optr = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '('){
                optr.push(ch);
            }

            else if(Character.isDigit(ch)){
                opnds.push(ch - '0'); //'5' - '0' = 5(diff and return ascii val)
            }

            else if(ch == ')'){
                while(optr.peek() != '('){
                    char operator = optr.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    int oprationRes = operation(v1,v2,operator);
                    opnds.push(oprationRes);
                }
                optr.pop();// for opening bracket
            }

            else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
                while(optr.size() > 0 && optr.peek() != '('
                        && predecence(ch) <= predecence(optr.peek())){
                    char operator = optr.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();
                    int oprationRes = operation(v1,v2,operator);
                    opnds.push(oprationRes);
                }
                optr.push(ch);
            }
        }
        while(optr.size() != 0){
            char operator = optr.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();
            int oprationRes = operation(v1,v2,operator);
            opnds.push(oprationRes);
        }
        System.out.println(opnds.peek());
    }

    public static void infixToPostANDPre(String str){
        //a*(b-c)/d+e

        // string str is infix and this function convert it to postfix and prefix
        Stack<String> preFix = new Stack<>();
        Stack<String> postFix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(operator.size()>0 && operator.peek() != '('
                        && predecence(ch) <= predecence(operator.peek()) ){
                    char op = operator.pop();
                    String v2Pre = preFix.pop();
                    String v1Pre = preFix.pop();
                    String v2Post = postFix.pop();
                    String v1Post = postFix.pop();
                    String preStr = ""+op+v1Pre+v2Pre;
                    String postStr = ""+v1Post+v2Post+op;
                    preFix.push(preStr);
                    postFix.push(postStr);
                }
                operator.push(ch);

            }else if(ch == '('){
                operator.push(ch);

            }else if(ch == ')'){

                while(operator.peek() != '(' ){
                    char op = operator.pop();
                    String v2Pre = preFix.pop();
                    String v1Pre = preFix.pop();
                    String v2Post = postFix.pop();
                    String v1Post = postFix.pop();
                    String preStr = ""+op+v1Pre+v2Pre;
                    String postStr = ""+v1Post+v2Post+op;
                    preFix.push(preStr);
                    postFix.push(postStr);
                }
                operator.pop();

            }else if(ch >= '0' && ch<= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
                // it will handle alphanumeric
                preFix.push(""+ch);
                postFix.push(""+ch);
            }
        }
        while(operator.size() != 0){
            char op = operator.pop();
            String v2Pre = preFix.pop();
            String v1Pre = preFix.pop();
            String v2Post = postFix.pop();
            String v1Post = postFix.pop();
            String preStr = ""+op+v1Pre+v2Pre;
            String postStr = ""+v1Post+v2Post+op;
            preFix.push(preStr);
            postFix.push(postStr);
        }
        System.out.println("prefix is "+preFix.peek());
        System.out.println("postfix is "+postFix.peek());
    }
}
