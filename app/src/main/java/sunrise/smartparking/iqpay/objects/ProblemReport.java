package sunrise.smartparking.iqpay.objects;

public class ProblemReport
{
    String stringProblemType;
    String stringProblemSubject;
    String stringProblemPriority;
    String stringProblemDetails;

    public ProblemReport(String stringProblemType, String stringProblemSubject, String stringProblemPriority, String stringProblemDetails)
    {
        this.stringProblemType = stringProblemType;
        this.stringProblemSubject = stringProblemSubject;
        this.stringProblemPriority = stringProblemPriority;
        this.stringProblemDetails = stringProblemDetails;
    }


    public String getStringProblemType()
    {
        return stringProblemType;
    }

    public void setStringProblemType(String stringProblemType)
    {
        this.stringProblemType = stringProblemType;
    }

    public String getStringProblemSubject()
    {
        return stringProblemSubject;
    }

    public void setStringProblemSubject(String stringProblemSubject)
    {
        this.stringProblemSubject = stringProblemSubject;
    }

    public String getStringProblemPriority()
    {
        return stringProblemPriority;
    }

    public void setStringProblemPriority(String stringProblemPriority)
    {
        this.stringProblemPriority = stringProblemPriority;
    }

    public String getStringProblemDetails()
    {
        return stringProblemDetails;
    }

    public void setStringProblemDetails(String stringProblemDetails)
    {
        this.stringProblemDetails = stringProblemDetails;
    }
}
