package com.fieldexpert.fbapi4j.demo;

import com.fieldexpert.fbapi4j.Configuration;
import com.fieldexpert.fbapi4j.Project;
import com.fieldexpert.fbapi4j.Session;

public class ProjectDemo {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration().configure();
		Session session = conf.buildSession();

		for (Project project : session.findAll(Project.class)) {
			System.out.println(project.getId() + " -> " + project.getName());
		}

		int projectId = 2;
		Project project = session.get(Project.class, projectId);
		System.out.println(project.getName());
		System.out.println(project.getCases().size());
		System.out.println(project.getAreas());

		System.out.println(session.get(Project.class, "Pizza2Go").getId());
		session.close();

		// This will throw an exception since there's no open session:
		System.out.println(project.getCases());
	}
}