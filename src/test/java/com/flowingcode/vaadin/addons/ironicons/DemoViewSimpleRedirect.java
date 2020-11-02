package com.flowingcode.vaadin.addons.ironicons;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("view")
@SuppressWarnings("serial")
public class DemoViewSimpleRedirect extends VerticalLayout implements BeforeEnterObserver {

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		event.forwardTo(DemoViewSingle.class);
	}
}