/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;
import loginregister.LoginRegister;
/**
 *
 * @author Noli
 */
public class Splash {
    public static void main(String[] args) {
        SplashScreen splashscreen = new SplashScreen();
        LoginRegister login_reg = new LoginRegister();
        splashscreen.setVisible(true);
        try{
            Thread.sleep(2500);
            login_reg.setVisible(true);
            splashscreen.setVisible(false);
        } catch (Exception e){
            
        }
        //splashscreen.loadingbar.setForeground(new Color(92,225,230)); 
        /*
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(45);
                splashscreen.loadingpercent.setText(Integer.toString(i) + "%");
                splashscreen.loadingbar.setValue(i);
                
                if (i == 100) {
                    Thread.sleep(1500);
                    login_reg.setVisible(true);
                    splashscreen.setVisible(false);
                }
            }
        } catch(Exception e){
            
        }
      */
    }
}


