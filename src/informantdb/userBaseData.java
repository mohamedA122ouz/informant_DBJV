/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informantdb;
/**
 *
 * @author Student
 */
public class userBaseData {

    public User currentUser;
    public int pointer = 0;

    public int pointerIncreaser() {
        int holder = pointer;
        pointer += 20;
        return holder;
    }

    public userBaseData() {
        
    }
    public userBaseData(User input) {
        currentUser = input;
    }
}
