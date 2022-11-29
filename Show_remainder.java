package sem_project;

import java.io.FileNotFoundException;

//creating interface Today_remainder_show
interface Show_remainder {
    
    //method to be override by the class Implementation
    void showToday() throws FileNotFoundException;
    void showDate() throws FileNotFoundException;
}
