package com.eazybytes;


import Level1.StackProblems;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String exp = "2+(5-3*6/2)";
        String exp2 = "2-3*5";
        StackProblems stp = new StackProblems();
        stp.solveInfix(exp);
        stp.infixToPostANDPre("a*(b-c)/d+e");
            //a*(b-c)/d+e
    }
}