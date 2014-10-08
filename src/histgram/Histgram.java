/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package histgram;

import java.util.ArrayList;

/**
 *
 * @author tucker.stone061
 */
public class Histgram implements Observable{
 
	//define a list of users, such as Mike, Bill, etc.
	private ArrayList<Observer> userList;
	private ArrayList<String> jobs;
 
	public Histgram(){
            userList = new ArrayList<Observer>();
            jobs = new ArrayList<String>();
	}
 
	@Override
	public void registerObserver(Observer o) {
            userList.add(o);
	}
 
	@Override
	public void removeObserver(Observer o) {}
 
	@Override
	public void notifyAllObservers() {
            for(Observer o: userList){
                    o.update(this);
            }
	}
 
	public void addJob(String job) {
            this.jobs.add(job);
            notifyAllObservers();
	}
 
	public ArrayList<String> getJobs() {
            return jobs;
	}
 
	public String toString(){
            return jobs.toString();
	}
}
