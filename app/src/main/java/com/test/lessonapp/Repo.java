package com.test.lessonapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-12-05.
 */
class Repo implements Parcelable{

	int id;
	String name;
	String html_url;

	protected Repo(Parcel in) {
		id = in.readInt();
		name = in.readString();
		html_url = in.readString();
	}

	@NonNull
	@Override
	public String toString() {
		return String.format("%d %s %s", id, name, html_url);
	}

	public static final Creator<Repo> CREATOR = new Creator<Repo>() {
		@Override
		public Repo createFromParcel(Parcel in) {
			return new Repo(in);
		}

		@Override
		public Repo[] newArray(int size) {
			return new Repo[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(html_url);
	}
}
