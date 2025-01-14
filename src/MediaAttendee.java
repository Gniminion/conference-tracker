public class MediaAttendee extends Attendee //Allows creation of the object of a media attendee
{
    private String organization;
    //media attendee inherits all attendee attributes, but also requires associated organization

    public MediaAttendee(String fName,String lName,int age, String organization)
    {
        super(fName,lName,age);
        this.organization=organization;
    }

    public String getOrganization() 
    {
        return this.organization;
    }

    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }
}
