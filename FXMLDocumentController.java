/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Catfishstaples
 */
public class FXMLDocumentController implements Initializable {
    private static double current = 0;
    private static String calc_screen = "";
    private static int operation = 0;
    private static int temp_Op =0;
    private static String temp_screen = "";
    private static boolean equal = false;
    private static boolean dot = false;
    NumberFormat formatSN = new DecimalFormat("0.################E0");
    NumberFormat format = new DecimalFormat("#####################");
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        if(equal == true){
            clear();calc_screen = "1";printN();  
        }
        else{
        calc_screen += "1";printN();
        }
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "2";printN(); 
        }
        else{
        calc_screen += "2";printN();
        }
    }
    @FXML
    private void handleButtonAction3(ActionEvent event) {
        if(equal == true){
            clear();calc_screen = "3";printN(); 
        }
        else{
        calc_screen += "3";printN();
        }
    }
    @FXML
    private void handleButtonAction4(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "4";printN();
        }
        else{
        calc_screen += "4";printN();
        }
    }
    @FXML
    private void handleButtonAction5(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "5";printN(); 
        }
        else{
        calc_screen += "5";printN();
        }
    }
    @FXML
    private void handleButtonAction6(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "6";printN(); 
        }
        else{
        calc_screen += "6";printN();
        }
    }
    @FXML
    private void handleButtonAction7(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "7";printN();  
        }
        else{
        calc_screen += "7";printN();
        }
    }
    @FXML
    private void handleButtonAction8(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "8";printN();
        }
        else{
        calc_screen += "8";printN();
        }
    }
    @FXML
    private void handleButtonAction9(ActionEvent event) {
        if(equal == true){
            clear();calc_screen = "9";printN(); 
        }
        else{
        calc_screen += "9";printN();
        }
    }
    @FXML
    private void handleButtonAction0(ActionEvent event) {
        if(equal == true){
             clear();calc_screen = "0";printN();
        }
        else{
        calc_screen += "0";printN();
        }
    }
    @FXML
    private void handleButtonActionDot(ActionEvent event) {
        if(equal == true){
            clear();calc_screen = ".";printN();
        }
        else{
            if(dot == false){
                dot = true;calc_screen += ".";printN();
            }
        }
    }
     @FXML
    private void handleButtonActionAdd(ActionEvent event) {
        dot = false;equal = false;
        if(false == temp_screen.isEmpty()){
            orderEqual();
        }
        else{
            if(operation != 0){
                equal();
            }
            else{
                if(true == calc_screen.isEmpty()){
                    calc_screen += 0;
                }
                current = Double.valueOf(calc_screen);
            }
        }
        calc_screen = "";
        printO();
        operation = 1;
    }
     @FXML
    private void handleButtonActionSub(ActionEvent event) {
        dot = false;equal = false;
        if(false == temp_screen.isEmpty()){
            orderEqual();
        }
        else{
            if(operation != 0){
                equal();
            }
            else{
                if(true == calc_screen.isEmpty()){
                    calc_screen += 0;
                }
                current = Double.parseDouble(calc_screen);
            }
        }
        calc_screen = "";
        printO();
        operation = 2;
    }
    @FXML
    private void handleButtonActionMult(ActionEvent event) {
        dot = false;equal = false;
        if(operation == 1 || operation == 2){
            temp_screen = calc_screen;
            calc_screen = "";
            temp_Op = operation;
        }
        else if(operation == 3 || operation == 4){
            equal();
        }
        else{
            if(true == calc_screen.isEmpty()){
                calc_screen += 0;
            }
            current = Double.parseDouble(calc_screen);
        }
            calc_screen = "";
            printO();
            operation = 3;
    }
     @FXML
    private void handleButtonActionDivide(ActionEvent event) {
        dot = false;equal = false;
        if(operation == 1 || operation == 2){
            temp_screen = calc_screen;
            calc_screen = "";
            temp_Op = operation;
        }
        else if(operation == 3 || operation == 4){
            equal();
        }
        else{
            if(true == calc_screen.isEmpty()){
                calc_screen += 0;
            }
            current = Double.parseDouble(calc_screen);
        }
        calc_screen = "";
        printO();
        operation = 4;
    }
    @FXML
    private void handleButtonActionEqual(ActionEvent event) {
        if(false == temp_screen.isEmpty()){
            orderEqual();
        }
        switch(operation){
            case 1: current += Double.parseDouble(calc_screen);
                    break;
            case 2: current -= Double.parseDouble(calc_screen);
                    break;
            case 3: current *= Double.parseDouble(calc_screen);
                    break;
            case 4: current /= Double.parseDouble(calc_screen);
                    break;
        }
        dot = false;
        operation = 0;
        printO();
        calc_screen = "";
        equal = true;
        calc_screen += current;
    }
     @FXML
    private void handleButtonActionClear(ActionEvent event) {
        dot = false;operation = 0;current = 0;calc_screen = "";temp_Op = 0;temp_screen = "";
        printO();
    }
    private void clear(){
        dot = false;operation = 0;current = 0;calc_screen = "";temp_Op = 0;temp_screen = "";equal = false;
    }
    private void orderEqual(){
        double hold;
        switch(operation){
            case 3: hold = Double.parseDouble(temp_screen)*Double.parseDouble(calc_screen);
                calc_screen = "" + hold; temp_screen = ""; operation = temp_Op; break;
            case 4: hold = Double.parseDouble(temp_screen)/Double.parseDouble(calc_screen);
                calc_screen = "" + hold; temp_screen = ""; operation = temp_Op; break;
        }
        equal();
    }
    private void printN(){
        if(calc_screen.length() > 20){
            label.setText(formatSN.format(Double.parseDouble(calc_screen)));
        }
        else{label.setText(calc_screen);}
    }
    private void printO(){
        String temp = "" + current;
        if(temp.length() > 20){
            label.setText(formatSN.format(current));
        }
        else{label.setText(format.format(current));}
    }
    private void equal() {
        switch(operation){
            case 1: current += Double.parseDouble(calc_screen);
                    break;
            case 2: current -= Double.parseDouble(calc_screen);
                    break;
            case 3: current *= Double.parseDouble(calc_screen);
                    break;
            case 4: current /= Double.parseDouble(calc_screen);
                    break;
        }
        operation =0;
        printO();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
