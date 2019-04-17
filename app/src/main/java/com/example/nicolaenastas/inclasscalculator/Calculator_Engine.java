package com.example.nicolaenastas.inclasscalculator;

import java.text.DecimalFormat;

public class Calculator_Engine {
    private String details;
    private String  number;
    private double result;
    private String operation = "";
    private double memory = 0;
    DecimalFormat df = new DecimalFormat("###.######");
 //   private  boolean isDigit = details.matches("\\d{1}");

    public Calculator_Engine() {
        details = "Enter a Number";
        number = "0";
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void numberClicked(int number){
        if(details.contains("Enter a Number")){
            if(this.number.equals("0")){
                this.number = String.valueOf(number);
                details = String.valueOf(number);
            }else{
                this.number += String.valueOf(number);
                details += String.valueOf(number);
            }
        } else if(details.contains("=")){
            this.number = "0";
            details = "";
            if(this.number.equals("0")){
                this.number = String.valueOf(number);
                details += String.valueOf(number);
            }else{

                this.number += String.valueOf(number);
                details += String.valueOf(number);
            }
        } else{
            if(this.number.equals("0")){
                this.number = String.valueOf(number);
                if(!details.endsWith("0")){
                    details = String.valueOf(number);
                }

            }else{

                this.number += String.valueOf(number);
                details += String.valueOf(number);
            }
        }

    }
    public void decimal(String dot){
        if(!this.number.contains(dot)){
            if(!details.contains("=")) {
                    if (details.contains("Enter a Number")) {
                        details = "0";
                    } else if (details.endsWith(operation) && !operation.equals("")) {
                        number += "0";
                        details += "0";
                    } else if(number.equals("0") && details.equals("0")){

                    }
                    number += ".";

                    details += ".";
                }
            }
    }

    public  void onClickOperation(String oper){
        if(!number.endsWith(".")) {
            if (!details.equals("Enter a Number")) {
                if (Character.isDigit(details.charAt(details.length()-1))) {
                    if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                        onCLickEqual();

                        result = Double.parseDouble(number);
                        details = number + String.valueOf(oper);
                        number = "";
                        operation = oper;

                    } else if (operation.equals("%")) {
                        onClickModulo();
                        details = details.substring(0, details.indexOf("+"));
                    } else {
                        if (details.contains("=")) {
                            details = "";
                            result = Double.parseDouble(number);
                            details = number;
                        }
                        result = Double.parseDouble(number);
                        details += String.valueOf(oper);
                        number = "";
                        operation = oper;
                    }
                }
            }
        }

    }



    public  void onCLickEqual(){
        if(!number.endsWith(".")) {
            if (!number.equals("")) {
                if (operation.equals("+")) {
                    result = result + Double.parseDouble(number);
                    number = String.valueOf(df.format(result));
                    details += "=" + String.valueOf(df.format(result));
                    operation = "=";
                } else if (operation.equals("-")) {
                    result = result - Double.parseDouble(number);
                    number = String.valueOf(df.format(result));
                    details += "=" + String.valueOf(df.format(result));
                    operation = "=";
                } else if (operation.equals("*")) {
                    result = result * Double.parseDouble(number);
                    number = String.valueOf(df.format(result));
                    details += "=" + String.valueOf(df.format(result));
                    operation = "=";
                } else if (operation.equals("/")) {
                    if (number.equals("0")) {
                        result = 0;
                    } else {
                        result = result / Double.parseDouble(number);
                    }
                    number = String.valueOf(df.format(result));
                    details += "=" + String.valueOf(df.format(result));
                    operation = "=";

                }
            }
        }

    }

    public void onClickPlusMinus(){
        if(!number.equals("0")) {
            // if(Character.isDigit(details.charAt(0))) {
            if(details.matches("\\d{1}")){
                number = String.valueOf(df.format(Double.parseDouble(number) * -1));
                details = details.substring(0, details.indexOf(operation));
                details += operation + number;
            }else if (Character.isDigit(details.charAt(details.length() - 1))) {
                number = String.valueOf(df.format(Double.parseDouble(number) * -1));
                details = details.substring(0, details.indexOf(operation));
                details += operation + "(" + number + ")";
            }
        }

    }

    public  void onClickModulo(){
        if(!number.equals("0")) {
            if(operation.equals("+") || operation.equals("-")) {
                number = String.valueOf(Double.parseDouble(details.substring(0, details.indexOf(operation))) * Double.parseDouble(number) / 100);
                details = details.substring(0, details.indexOf(operation));
                details += operation + number;
            }else if(operation.equals("*") || operation.equals("/") ){
                number = String.valueOf(Double.parseDouble(number) / 100);
                details = details.substring(0, details.indexOf(operation));
                details += operation + number;
            }
            else{
                result = Double.parseDouble(number) / 100;
                number = String.valueOf(df.format(result));
                details = String.valueOf(df.format(result));
            }

        }
    }
    public  void onClickMemory(String type){
        if(type.equals("M+")){
            memory = memory + Double.parseDouble(number+".0");
        } else if(type.equals("M-")){
            memory = memory - Double.parseDouble(number);
        } else if(type.equals("MR")){
            number = String.valueOf(memory);
            details = String.valueOf(memory);
        }else{
            memory = 0;
        }

    }
    public  void clear(){
        details = "Enter a Number";
        number = "0";
        result = 0;
        operation = "";
    }
}
