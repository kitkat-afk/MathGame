/**The student class. This class contains all of the data for students, which is mostly the same as the abstract
 * Account class, but includes game features such as HP, character selection, and a recording of the answers
 * a student has submitted.
 *
 * @version 11.11.2019
 * @author Benjamin Williams
 */

public class Student extends Account_a {
    public int HP, ansCorrect, ansAttempt;

    //Note that difficulty is not saved by this class: this will be handled dynamically within the game itself.

    public Student(String n, String p)
    {
        super(n,p);
        ansCorrect = 0;
        ansAttempt = 0;
        HP = 100;
    }

    //Getter Methods

    public int getHP() {
        return HP;
    }

    public int getAnsAttempt() {
        return ansAttempt;
    }

    public int getAnsCorrect() {
        return ansCorrect;
    }


    //Setter Methods


    public void setAnsAttempt(int ansAttempt) {
        this.ansAttempt = ansAttempt;
    }

    public void setAnsCorrect(int ansCorrect) {
        this.ansCorrect = ansCorrect;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }



    @Override
    public String toString() {
        return (super.toString() + getHP() + "\n" + getAnsCorrect() + "\n" + getAnsAttempt());
    }

}
