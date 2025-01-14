public class StudentAttendee extends Attendee //Allows creation of the object of a student attendee
{  
    //student attendee inherits all attendee attributes, but cannot have access to certain fields as interests
    public StudentAttendee(String fName,String lName,int age)
    {
        super(fName,lName,age);
    }
    @Override
    public void addInterest(String interest)
    {
        if(interest.equals("Vaccine Development")||interest.equals("Clinical Treatment"))
        {
            System.out.println("Restricted field for student");
        }
        else
        {
            super.addInterest(interest);
        }
    }
}
