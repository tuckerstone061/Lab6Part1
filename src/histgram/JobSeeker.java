/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package histgram;

/**
 *
 * @author tucker.stone061
 */
public class JobSeeker implements Observer {
 
	private String name;
        private String [] columnNames;
        private int [] numbers;
 
	public JobSeeker(String name){
            this.name = name;
	}
        DrawHist hist = new DrawHist();
	@Override
	public void update(Observable s) {
            
            System.out.println(this.name + " got notified!");
            hist.showHistogram(numbers, columnNames);
            System.out.println(s);
	}
        public void setNumbers(int []nums) {
            numbers = new int[4];
            for (int i = 0; i < nums.length; i++)
            {
                numbers[i] = nums[i];
            }
        }
        public void setNames(String []names) {
            columnNames = new String[4];
            for (int i = 0; i < names.length; i++)
            {
                columnNames[i] = names[i];
            }
        }
        
        public void paint(){
            hist.paintComponenet(g);
        }
}
