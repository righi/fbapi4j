package com.fieldexpert.fbapi4j.demo;

import java.io.File;
import java.util.Date;

import com.fieldexpert.fbapi4j.Case;
import com.fieldexpert.fbapi4j.Configuration;
import com.fieldexpert.fbapi4j.Session;

public class CaseDemo {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration().configure();
		Session session = conf.buildSession();

		// Begin Example #1
		String project = "Pizza2Go";
		String area = "Shopping Cart";
		String title = "Shopping Cart is Broken in IE4";
		String description = "The shopping cart looks all messed up when I try to order a pizza with Internet Explorer 4.0.";
		Case bug1 = new Case(project,area,title,description).attach(new File("test/ie_screenshot.png"));
		session.scout(bug1);

		// Begin Example #2
		Case bug2 = session.get(Case.class, 1190);
		session.reopen(bug2);
		// Or maybe you want to reactivate, like this: session.reactivate(bug2);
		bug2.setDescription("Add an Ajax lookup to the topping chooser.");
		bug2.setTags("DHTML", "Ajax");
		bug2.setHoursEstimate(2);
		bug2.setPriority(7);
		Case parent = session.get(Case.class, 1191);
		bug2.setParent(parent);
		bug2.setDueDate(new Date());
		bug2.setArea("Topping Chooser");
		bug2.attach(new File("test/flowchart.pdf"));
		bug2.setAssignedTo("Nathan Bowser");
		session.edit(bug2);
		// Or maybe you want to resolve, like this: session.resolve(bug2);
		
		session.close();
	}

}
