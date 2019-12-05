package com.test.lessonapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Part of LessonApp by OasisMediaSystems
 * 2017-2019
 * Created by dimabershadskiy on 2019-12-05.
 */
public interface GithubAPIService {

	@GET("users/{user}/repos")
	Call<ArrayList<Repo>> listRepos(@Path("user") String userName);
}
