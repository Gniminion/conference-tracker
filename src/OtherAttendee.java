public class OtherAttendee extends Attendee //Allows creation of the object of an attendee that is not media or student
{
    private String organization;
    private String occupation;
    //other attendee inherits all attendee attributes, but also requires occupation and can have optional associated organization

    public OtherAttendee(String fName,String lName,int age,String occupation) 
    //Occupation required because "other" is neither student or media
    {
        super(fName,lName,age);
        this.occupation=occupation;
    }

    public String getOrganization() 
    {
        return this.organization;
    }

    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }

    public String getOccupation() 
    {
        return this.occupation;
    }

    public void setOccupation(String occupation) 
    {
        this.occupation = occupation;
    }
}
