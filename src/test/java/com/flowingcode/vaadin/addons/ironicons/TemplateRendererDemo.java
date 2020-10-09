package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TemplateRendererDemo extends VerticalLayout {

	public TemplateRendererDemo() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(100, "Lucas Kane", 68));
		personList.add(new Person(101, "Peter Buchanan", 38));
		personList.add(new Person(102, "Samuel Lee", 53));
		personList.add(new Person(103, "Anton Ross", 37));
		personList.add(new Person(104, "Aaron Atkinson", 18));
		personList.add(new Person(105, "Jack Woodward", 28));
		Grid<Person> grid = new Grid<>();
		grid.setItems(personList);

		grid.addColumn(TemplateRenderer.<Person>of(
				"<iron-icon icon='" + IronIcons.ADD_ALERT.getIconName() + "'></iron-icon>[[item.id]]")
				.withProperty("id", Person::getId)).setHeader("ID");
		grid.addColumn(TemplateRenderer.<Person>of(
				"<iron-icon icon='" + IronIcons.ACCESSIBILITY.getIconName() + "'></iron-icon>[[item.name]]")
				.withProperty("name", Person::getName)).setHeader("Name");
		grid.addColumn(TemplateRenderer
				.<Person>of(
						"<iron-icon icon='" + MapsIcons.ADD_LOCATION.getIconName() + "'></iron-icon>[[item.age]]")
				.withProperty("age", Person::getAge)).setHeader("Age");

		add(grid);
	}

	private class Person {
		int id;
		String name;
		int age;

		public Person(int id, String name, int age) {
			this.id = id;
			this.name = name;
			this.age = age;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setFirstName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
