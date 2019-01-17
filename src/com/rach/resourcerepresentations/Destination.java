package com.rach.resourcerepresentations;
import java.util.Objects;


    public class Destination {

    private String destID;

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;

    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }


    private Companion companion;

    private HolidayType holidayType;

    private  String location;

    public String getDestID() {
        return destID;
    }

    public void setDestID(String destID) {
        this.destID = destID;
    }

    public  String getLocation() {
        return location;
    }

    public  void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination that = (Destination) o;
        return getDestID() == that.getDestID() &&
                Objects.equals(getActivity(), that.getActivity()) &&
                Objects.equals(getCompanion(), that.getCompanion()) &&
                Objects.equals(getHolidayType(), that.getHolidayType()) &&
                Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDestID(), getActivity(), getCompanion(), getHolidayType(), getLocation());
    }

        @Override
        public String toString() {
            return "{" +
                    "\"destID\":\"" + destID + '\"' +
                    ", \"activity\":\"" + activity + '\"' +
                    ", \"companion\":\"" + companion + '\"' +
                    ", \"holidayType\":\"" + holidayType + '\"' +
                    ", \"location\":\"" + location + '\"' +
                    '}';
        }
    }
