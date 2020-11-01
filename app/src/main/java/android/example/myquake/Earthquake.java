package android.example.myquake;

public class Earthquake {
    private double mag;
    private String location;
    private long mdate;
    private String mUrl;

    public Earthquake(double magnitude,String place, long date, String url){
        mag=magnitude;
        location=place;
        mdate =date;
        mUrl=url;
    }
    public double getMag(){return mag;}
    public String getPlace(){return location;}
    public long getDate(){return mdate;}
    public String getUrl() { return mUrl; }

}
