import com.techelevator.student.Student;

public class ScratchPad {

    private String name;



    // constructor class
    public ScratchPad() {

    }

    public ScratchPad(String n) {
        name = n;

    }

    public static void main(String[] args) {
//Static == attached to class but not an instance of a class


        System.out.println("Hello World");

        ScratchPad scratchPad1 = new ScratchPad();// new variable scratchpad1 of type ScratchPad:
        // assigning a new instance of ScratchPad by calling no-arg constructor ScratchPad
        ScratchPad scratchPad2 = new ScratchPad("Noble");

        System.out.println(scratchPad2);

        Student student1 = new Student("Steve");
        Student student2 = new Student("Jack");
        Student student3 = new Student("Nobes", "123JamesAve")

        System.out.println(student3.

    }


}
