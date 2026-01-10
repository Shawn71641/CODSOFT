import java.util.Scanner;
class Grade{
    public static void main(String[] args){
        
        try (Scanner ob1 = new Scanner(System.in)) {
            System.out.print("No. of Subjects: ");
            
            int subject = ob1.nextInt();
            
            int totalMarks = 0;
            for(int i=1;i<=subject;i++){
                
                System.out.println("Subject "+i+" mark:");
                int mark = ob1.nextInt();
                totalMarks += mark;
                
            }
            System.out.printf("Total:%d%n", totalMarks);
            float average = (float)totalMarks/subject;
            System.out.printf("Average:%f%n", average);
            
            String grade;
            
            if(average<100 && average>=90){
                grade = "A+";
            }
            else if(average<90 && average>=80){
                grade = "A";
            }
            else if(average<80 && average>=70){
                grade = "B";
            }
            else if(average<70 && average>=60){
                grade = "C";
            }
            else if(average<60 && average>=50){
                grade = "D";
            }
            else{
                grade = "Fail";
            }
            System.out.println("Grade:"+grade);
        }
    }
}