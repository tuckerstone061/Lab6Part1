/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package histgram;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author tucker.stone061
 */
public class Main {
    public static void main(String[] args) {
        Histgram hh = new Histgram();
        JPanel frame = new JPanel();
        JobSeeker draw = new JobSeeker("HistDrawer");
        hh.registerObserver(draw);
        String [] names = {"Twenty","Thirty","Forty","Fifty"};
        int [] numbers = { 20, 30, 40, 50 };
        
        draw.setNames(names);
        draw.setNumbers(numbers);
        
        
       
    }
}