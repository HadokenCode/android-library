/* Copyright 2016 Urban Airship and Contributors */

package com.urbanairship.automation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class representing an automation action schedule - wraps {@link ActionScheduleInfo} with schedule
 * metadata.
 */
public class ActionSchedule implements Parcelable {

    public static final Creator<ActionSchedule> CREATOR = new Creator<ActionSchedule>() {
        @Override
        public ActionSchedule createFromParcel(Parcel in) {
            return new ActionSchedule(in);
        }

        @Override
        public ActionSchedule[] newArray(int size) {
            return new ActionSchedule[size];
        }
    };

    private final String id;
    private final ActionScheduleInfo info;
    private final int count;

    /**
     * Class constructor.
     *
     * @param id The schedule ID.
     * @param info The ActionScheduleInfo instance.
     * @param count The fulfillment count.
     */
    public ActionSchedule(String id, ActionScheduleInfo info, int count) {
        this.id = id;
        this.info = info;
        this.count = count;
    }

    protected ActionSchedule(Parcel in) {
        id = in.readString();
        info = in.readParcelable(ActionScheduleInfo.class.getClassLoader());
        count = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(info, flags);
        dest.writeInt(count);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Gets the ActionSchedule ID.
     *
     * @return The ActionSchedule ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the ActionScheduleInfo instance.
     *
     * @return The ActionScheduleInfo instance.
     */
    public ActionScheduleInfo getInfo() {
        return info;
    }

    /**
     * Gets the schedule fulfillment count.
     *
     * @return The schedule fulfillment count.
     */
    int getCount() {
        return count;
    }

}
