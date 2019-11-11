/**The student class. This class contains all of the data for students, which is mostly the same as the abstract
 * Account class, but includes game features such as HP, character selection, and a recording of the answers
 * a student has submitted.
 *
 * @version 25.10.2019
 * @author Benjamin Williams
 */

public class Student extends Account_a {
    public String character_type;
    public int HP, ansCorrect, ansAttempt;

    //Note that difficulty is not saved by this class: this will be handled dynamically within the game itself.

    public Student(String n, String u, String p)
    {
        super(n,u,p);
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

    public String getCharacter_type() {
        return character_type;
    }

    //Setter Methods


    public void setAnsAttempt(int ansAttempt) {
        this.ansAttempt = ansAttempt;
    }

    public void setAnsCorrect(int ansCorrect) {
        this.ansCorrect = ansCorrect;
    }

    //I don't expect us to need to use this, but in case a user decides to change their character type
    public void setCharacter_type(String character_type) {
        this.character_type = character_type;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }



    @Override
    public String toString() {
        return (super.toString() + getHP() + "\n" + getAnsCorrect() + "\n" + getAnsAttempt() + "\n" + getCharacter_type());
    }

}
