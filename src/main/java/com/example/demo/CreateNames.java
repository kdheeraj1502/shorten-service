package com.example.demo;

public class CreateNames {

    public void createNewName(String input, int num[], int bigNum[]) {
        if(num[0] == 500) {
            return;
        }
        if(bigNum[0] == 500) {
            return;
        }
        num[0] += 1;
        bigNum[0] -= 1;
        System.out.println(input + bigNum[0]);
        createNewName(input, num, bigNum);
        System.out.println(input + num[0]);
        createNewName(input, num, bigNum);
    }



    public static void main(String args[]) {
        CreateNames createNames = new CreateNames();
        String name = "Dheeraj";
        int num[] = {0};
        int bigNum[] = {1001};

        createNames.createNewName(name, num, bigNum);


    }


}